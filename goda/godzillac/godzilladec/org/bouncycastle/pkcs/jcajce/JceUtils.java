/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package org.bouncycastle.pkcs.jcajce;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.util.Integers;

class JceUtils {
    private static final Map PRFS = new HashMap();
    private static final Map PRFS_SALT = new HashMap();

    JceUtils() {
    }

    static String getAlgorithm(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (!PRFS.containsKey(aSN1ObjectIdentifier)) {
            throw new IllegalStateException("no prf for algorithm: " + aSN1ObjectIdentifier);
        }
        return (String)PRFS.get(aSN1ObjectIdentifier);
    }

    static int getSaltSize(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (!PRFS_SALT.containsKey(aSN1ObjectIdentifier)) {
            throw new IllegalStateException("no salt size for algorithm: " + aSN1ObjectIdentifier);
        }
        return (Integer)PRFS_SALT.get(aSN1ObjectIdentifier);
    }

    static {
        PRFS.put(PKCSObjectIdentifiers.id_hmacWithSHA1, "PBKDF2withHMACSHA1");
        PRFS.put(PKCSObjectIdentifiers.id_hmacWithSHA256, "PBKDF2withHMACSHA256");
        PRFS.put(PKCSObjectIdentifiers.id_hmacWithSHA512, "PBKDF2withHMACSHA512");
        PRFS.put(PKCSObjectIdentifiers.id_hmacWithSHA224, "PBKDF2withHMACSHA224");
        PRFS.put(PKCSObjectIdentifiers.id_hmacWithSHA384, "PBKDF2withHMACSHA384");
        PRFS.put(NISTObjectIdentifiers.id_hmacWithSHA3_224, "PBKDF2withHMACSHA3-224");
        PRFS.put(NISTObjectIdentifiers.id_hmacWithSHA3_256, "PBKDF2withHMACSHA3-256");
        PRFS.put(NISTObjectIdentifiers.id_hmacWithSHA3_384, "PBKDF2withHMACSHA3-384");
        PRFS.put(NISTObjectIdentifiers.id_hmacWithSHA3_512, "PBKDF2withHMACSHA3-512");
        PRFS.put(CryptoProObjectIdentifiers.gostR3411Hmac, "PBKDF2withHMACGOST3411");
        PRFS_SALT.put(PKCSObjectIdentifiers.id_hmacWithSHA1, Integers.valueOf(20));
        PRFS_SALT.put(PKCSObjectIdentifiers.id_hmacWithSHA256, Integers.valueOf(32));
        PRFS_SALT.put(PKCSObjectIdentifiers.id_hmacWithSHA512, Integers.valueOf(64));
        PRFS_SALT.put(PKCSObjectIdentifiers.id_hmacWithSHA224, Integers.valueOf(28));
        PRFS_SALT.put(PKCSObjectIdentifiers.id_hmacWithSHA384, Integers.valueOf(48));
        PRFS_SALT.put(NISTObjectIdentifiers.id_hmacWithSHA3_224, Integers.valueOf(28));
        PRFS_SALT.put(NISTObjectIdentifiers.id_hmacWithSHA3_256, Integers.valueOf(32));
        PRFS_SALT.put(NISTObjectIdentifiers.id_hmacWithSHA3_384, Integers.valueOf(48));
        PRFS_SALT.put(NISTObjectIdentifiers.id_hmacWithSHA3_512, Integers.valueOf(64));
        PRFS_SALT.put(CryptoProObjectIdentifiers.gostR3411Hmac, Integers.valueOf(32));
    }
}

