/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.ocsp.OCSPResponseStatus;
import org.bouncycastle.asn1.ocsp.ResponseBytes;

public class OCSPResponse
extends ASN1Object {
    OCSPResponseStatus responseStatus;
    ResponseBytes responseBytes;

    public OCSPResponse(OCSPResponseStatus oCSPResponseStatus, ResponseBytes responseBytes) {
        this.responseStatus = oCSPResponseStatus;
        this.responseBytes = responseBytes;
    }

    private OCSPResponse(ASN1Sequence aSN1Sequence) {
        this.responseStatus = OCSPResponseStatus.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() == 2) {
            this.responseBytes = ResponseBytes.getInstance((ASN1TaggedObject)aSN1Sequence.getObjectAt(1), true);
        }
    }

    public static OCSPResponse getInstance(ASN1TaggedObject aSN1TaggedObject, boolean bl) {
        return OCSPResponse.getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, bl));
    }

    public static OCSPResponse getInstance(Object object) {
        if (object instanceof OCSPResponse) {
            return (OCSPResponse)object;
        }
        if (object != null) {
            return new OCSPResponse(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    public OCSPResponseStatus getResponseStatus() {
        return this.responseStatus;
    }

    public ResponseBytes getResponseBytes() {
        return this.responseBytes;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.responseStatus);
        if (this.responseBytes != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, this.responseBytes));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}

