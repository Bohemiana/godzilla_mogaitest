/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package org.bouncycastle.cert.jcajce;

import java.security.cert.X509Certificate;
import java.util.Date;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.X509v2CRLBuilder;

public class JcaX509v2CRLBuilder
extends X509v2CRLBuilder {
    public JcaX509v2CRLBuilder(X500Principal x500Principal, Date date) {
        super(X500Name.getInstance(x500Principal.getEncoded()), date);
    }

    public JcaX509v2CRLBuilder(X509Certificate x509Certificate, Date date) {
        this(x509Certificate.getSubjectX500Principal(), date);
    }
}

