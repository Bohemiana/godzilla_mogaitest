/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package org.bouncycastle.asn1.est;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.est.AttrOrOID;
import org.bouncycastle.asn1.est.Utils;

public class CsrAttrs
extends ASN1Object {
    private final AttrOrOID[] attrOrOIDs;

    public static CsrAttrs getInstance(Object object) {
        if (object instanceof CsrAttrs) {
            return (CsrAttrs)object;
        }
        if (object != null) {
            return new CsrAttrs(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    public static CsrAttrs getInstance(ASN1TaggedObject aSN1TaggedObject, boolean bl) {
        return CsrAttrs.getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, bl));
    }

    public CsrAttrs(AttrOrOID attrOrOID) {
        this.attrOrOIDs = new AttrOrOID[]{attrOrOID};
    }

    public CsrAttrs(AttrOrOID[] attrOrOIDArray) {
        this.attrOrOIDs = Utils.clone(attrOrOIDArray);
    }

    private CsrAttrs(ASN1Sequence aSN1Sequence) {
        this.attrOrOIDs = new AttrOrOID[aSN1Sequence.size()];
        for (int i = 0; i != aSN1Sequence.size(); ++i) {
            this.attrOrOIDs[i] = AttrOrOID.getInstance(aSN1Sequence.getObjectAt(i));
        }
    }

    public AttrOrOID[] getAttrOrOIDs() {
        return Utils.clone(this.attrOrOIDs);
    }

    public int size() {
        return this.attrOrOIDs.length;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.attrOrOIDs);
    }
}

