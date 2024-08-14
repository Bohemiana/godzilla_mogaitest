/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package org.bouncycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.util.Arrays;

public class RainbowParameterSpec
implements AlgorithmParameterSpec {
    private static final int[] DEFAULT_VI = new int[]{6, 12, 17, 22, 33};
    private int[] vi;

    public RainbowParameterSpec() {
        this.vi = DEFAULT_VI;
    }

    public RainbowParameterSpec(int[] nArray) {
        this.vi = nArray;
        this.checkParams();
    }

    private void checkParams() {
        if (this.vi == null) {
            throw new IllegalArgumentException("no layers defined.");
        }
        if (this.vi.length > 1) {
            for (int i = 0; i < this.vi.length - 1; ++i) {
                if (this.vi[i] < this.vi[i + 1]) continue;
                throw new IllegalArgumentException("v[i] has to be smaller than v[i+1]");
            }
        } else {
            throw new IllegalArgumentException("Rainbow needs at least 1 layer, such that v1 < v2.");
        }
    }

    public int getNumOfLayers() {
        return this.vi.length - 1;
    }

    public int getDocumentLength() {
        return this.vi[this.vi.length - 1] - this.vi[0];
    }

    public int[] getVi() {
        return Arrays.clone(this.vi);
    }
}

