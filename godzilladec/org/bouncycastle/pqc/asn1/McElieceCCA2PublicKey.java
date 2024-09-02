/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package org.bouncycastle.pqc.asn1;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class McElieceCCA2PublicKey
extends ASN1Object {
    private final int n;
    private final int t;
    private final GF2Matrix g;
    private final AlgorithmIdentifier digest;

    public McElieceCCA2PublicKey(int n, int n2, GF2Matrix gF2Matrix, AlgorithmIdentifier algorithmIdentifier) {
        this.n = n;
        this.t = n2;
        this.g = new GF2Matrix(gF2Matrix.getEncoded());
        this.digest = algorithmIdentifier;
    }

    private McElieceCCA2PublicKey(ASN1Sequence aSN1Sequence) {
        BigInteger bigInteger = ((ASN1Integer)aSN1Sequence.getObjectAt(0)).getValue();
        this.n = bigInteger.intValue();
        BigInteger bigInteger2 = ((ASN1Integer)aSN1Sequence.getObjectAt(1)).getValue();
        this.t = bigInteger2.intValue();
        this.g = new GF2Matrix(((ASN1OctetString)aSN1Sequence.getObjectAt(2)).getOctets());
        this.digest = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(3));
    }

    public int getN() {
        return this.n;
    }

    public int getT() {
        return this.t;
    }

    public GF2Matrix getG() {
        return this.g;
    }

    public AlgorithmIdentifier getDigest() {
        return this.digest;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer(this.n));
        aSN1EncodableVector.add(new ASN1Integer(this.t));
        aSN1EncodableVector.add(new DEROctetString(this.g.getEncoded()));
        aSN1EncodableVector.add(this.digest);
        return new DERSequence(aSN1EncodableVector);
    }

    public static McElieceCCA2PublicKey getInstance(Object object) {
        if (object instanceof McElieceCCA2PublicKey) {
            return (McElieceCCA2PublicKey)object;
        }
        if (object != null) {
            return new McElieceCCA2PublicKey(ASN1Sequence.getInstance(object));
        }
        return null;
    }
}

