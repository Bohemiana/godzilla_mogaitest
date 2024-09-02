/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class XMSSMTKeyParams
extends ASN1Object {
    private final ASN1Integer version;
    private final int height;
    private final int layers;
    private final AlgorithmIdentifier treeDigest;

    public XMSSMTKeyParams(int n, int n2, AlgorithmIdentifier algorithmIdentifier) {
        this.version = new ASN1Integer(0L);
        this.height = n;
        this.layers = n2;
        this.treeDigest = algorithmIdentifier;
    }

    private XMSSMTKeyParams(ASN1Sequence aSN1Sequence) {
        this.version = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        this.height = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1)).getValue().intValue();
        this.layers = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(2)).getValue().intValue();
        this.treeDigest = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(3));
    }

    public static XMSSMTKeyParams getInstance(Object object) {
        if (object instanceof XMSSMTKeyParams) {
            return (XMSSMTKeyParams)object;
        }
        if (object != null) {
            return new XMSSMTKeyParams(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    public int getHeight() {
        return this.height;
    }

    public int getLayers() {
        return this.layers;
    }

    public AlgorithmIdentifier getTreeDigest() {
        return this.treeDigest;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.version);
        aSN1EncodableVector.add(new ASN1Integer(this.height));
        aSN1EncodableVector.add(new ASN1Integer(this.layers));
        aSN1EncodableVector.add(this.treeDigest);
        return new DERSequence(aSN1EncodableVector);
    }
}

