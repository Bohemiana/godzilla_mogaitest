/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package org.bouncycastle.pkcs.jcajce;

import java.io.IOException;
import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.pkcs.PKCS12SafeBagBuilder;
import org.bouncycastle.pkcs.PKCSIOException;

public class JcaPKCS12SafeBagBuilder
extends PKCS12SafeBagBuilder {
    public JcaPKCS12SafeBagBuilder(X509Certificate x509Certificate) throws IOException {
        super(JcaPKCS12SafeBagBuilder.convertCert(x509Certificate));
    }

    private static Certificate convertCert(X509Certificate x509Certificate) throws IOException {
        try {
            return Certificate.getInstance(x509Certificate.getEncoded());
        } catch (CertificateEncodingException certificateEncodingException) {
            throw new PKCSIOException("cannot encode certificate: " + certificateEncodingException.getMessage(), certificateEncodingException);
        }
    }

    public JcaPKCS12SafeBagBuilder(PrivateKey privateKey, OutputEncryptor outputEncryptor) {
        super(PrivateKeyInfo.getInstance(privateKey.getEncoded()), outputEncryptor);
    }

    public JcaPKCS12SafeBagBuilder(PrivateKey privateKey) {
        super(PrivateKeyInfo.getInstance(privateKey.getEncoded()));
    }
}

