/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package shells.plugins.java;

import core.annotation.PluginAnnotation;
import shells.plugins.generic.ShellcodeLoader;

@PluginAnnotation(payloadName="JavaDynamicPayload", Name="PetitPotam", DisplayName="PetitPotam")
public class PetitPotam
extends shells.plugins.generic.PetitPotam {
    @Override
    protected ShellcodeLoader getShellcodeLoader() {
        return (ShellcodeLoader)this.shellEntity.getFrame().getPlugin("ShellcodeLoader");
    }
}
