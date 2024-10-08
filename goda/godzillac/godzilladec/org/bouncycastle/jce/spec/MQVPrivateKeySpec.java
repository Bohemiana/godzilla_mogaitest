/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package org.bouncycastle.jce.spec;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import org.bouncycastle.jce.interfaces.MQVPrivateKey;

public class MQVPrivateKeySpec
implements KeySpec,
MQVPrivateKey {
    private PrivateKey staticPrivateKey;
    private PrivateKey ephemeralPrivateKey;
    private PublicKey ephemeralPublicKey;

    public MQVPrivateKeySpec(PrivateKey privateKey, PrivateKey privateKey2) {
        this(privateKey, privateKey2, null);
    }

    public MQVPrivateKeySpec(PrivateKey privateKey, PrivateKey privateKey2, PublicKey publicKey) {
        this.staticPrivateKey = privateKey;
        this.ephemeralPrivateKey = privateKey2;
        this.ephemeralPublicKey = publicKey;
    }

    public PrivateKey getStaticPrivateKey() {
        return this.staticPrivateKey;
    }

    public PrivateKey getEphemeralPrivateKey() {
        return this.ephemeralPrivateKey;
    }

    public PublicKey getEphemeralPublicKey() {
        return this.ephemeralPublicKey;
    }

    public String getAlgorithm() {
        return "ECMQV";
    }

    public String getFormat() {
        return null;
    }

    public byte[] getEncoded() {
        return null;
    }
}

