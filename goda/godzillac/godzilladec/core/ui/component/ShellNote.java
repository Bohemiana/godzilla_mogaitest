/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package core.ui.component;

import core.Db;
import core.annotation.DisplayName;
import core.shell.ShellEntity;
import core.ui.component.RTextArea;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.fife.ui.rtextarea.RTextScrollPane;
import util.Log;
import util.functions;

@DisplayName(DisplayName="\u7b14\u8bb0")
public class ShellNote
extends JPanel {
    private final ShellEntity shellEntity;
    private String noteData;
    private final String shellId;
    private final String lastNoteMd5;
    private final RTextArea textArea;
    private boolean state;

    public ShellNote(ShellEntity entity) {
        this.shellEntity = entity;
        this.shellId = this.shellEntity.getId();
        super.setLayout(new BorderLayout(1, 1));
        String noteData = Db.getShellNote(this.shellId);
        this.lastNoteMd5 = functions.md5(noteData);
        this.textArea = new RTextArea();
        this.textArea.setText(noteData);
        this.state = true;
        Thread thread = new Thread(new Runnable(){

            @Override
            public void run() {
                while (ShellNote.this.state) {
                    try {
                        Thread.sleep(3000L);
                        ShellNote.this.updateDbNote();
                    } catch (InterruptedException e) {
                        Log.error(e);
                    }
                }
            }
        });
        thread.start();
        RTextScrollPane scrollPane = new RTextScrollPane(this.textArea, true);
        scrollPane.setIconRowHeaderEnabled(true);
        scrollPane.getGutter().setBookmarkingEnabled(true);
        super.add(scrollPane);
        this.textArea.registerReplaceDialog();
    }

    public void updateDbNote() {
        String noteData = this.textArea.getText();
        String md5 = functions.md5(noteData);
        if (!this.lastNoteMd5.equals(md5)) {
            Db.updateShellNote(this.shellId, noteData);
        }
    }

    @Override
    public void disable() {
        this.state = false;
        super.disable();
    }
}

