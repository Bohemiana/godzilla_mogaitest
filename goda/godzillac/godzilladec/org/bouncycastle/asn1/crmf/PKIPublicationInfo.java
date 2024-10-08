/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.crmf.SinglePubInfo;

public class PKIPublicationInfo
extends ASN1Object {
    private ASN1Integer action;
    private ASN1Sequence pubInfos;

    private PKIPublicationInfo(ASN1Sequence aSN1Sequence) {
        this.action = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        this.pubInfos = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
    }

    public static PKIPublicationInfo getInstance(Object object) {
        if (object instanceof PKIPublicationInfo) {
            return (PKIPublicationInfo)object;
        }
        if (object != null) {
            return new PKIPublicationInfo(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    public ASN1Integer getAction() {
        return this.action;
    }

    public SinglePubInfo[] getPubInfos() {
        if (this.pubInfos == null) {
            return null;
        }
        SinglePubInfo[] singlePubInfoArray = new SinglePubInfo[this.pubInfos.size()];
        for (int i = 0; i != singlePubInfoArray.length; ++i) {
            singlePubInfoArray[i] = SinglePubInfo.getInstance(this.pubInfos.getObjectAt(i));
        }
        return singlePubInfoArray;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.action);
        aSN1EncodableVector.add(this.pubInfos);
        return new DERSequence(aSN1EncodableVector);
    }
}

