/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cmp.CAKeyUpdAnnContent;
import org.bouncycastle.asn1.cmp.CMPCertificate;
import org.bouncycastle.asn1.cmp.CRLAnnContent;
import org.bouncycastle.asn1.cmp.CertConfirmContent;
import org.bouncycastle.asn1.cmp.CertRepMessage;
import org.bouncycastle.asn1.cmp.ErrorMsgContent;
import org.bouncycastle.asn1.cmp.GenMsgContent;
import org.bouncycastle.asn1.cmp.GenRepContent;
import org.bouncycastle.asn1.cmp.KeyRecRepContent;
import org.bouncycastle.asn1.cmp.PKIConfirmContent;
import org.bouncycastle.asn1.cmp.PKIMessages;
import org.bouncycastle.asn1.cmp.POPODecKeyChallContent;
import org.bouncycastle.asn1.cmp.POPODecKeyRespContent;
import org.bouncycastle.asn1.cmp.PollRepContent;
import org.bouncycastle.asn1.cmp.PollReqContent;
import org.bouncycastle.asn1.cmp.RevAnnContent;
import org.bouncycastle.asn1.cmp.RevRepContent;
import org.bouncycastle.asn1.cmp.RevReqContent;
import org.bouncycastle.asn1.crmf.CertReqMessages;
import org.bouncycastle.asn1.pkcs.CertificationRequest;

public class PKIBody
extends ASN1Object
implements ASN1Choice {
    public static final int TYPE_INIT_REQ = 0;
    public static final int TYPE_INIT_REP = 1;
    public static final int TYPE_CERT_REQ = 2;
    public static final int TYPE_CERT_REP = 3;
    public static final int TYPE_P10_CERT_REQ = 4;
    public static final int TYPE_POPO_CHALL = 5;
    public static final int TYPE_POPO_REP = 6;
    public static final int TYPE_KEY_UPDATE_REQ = 7;
    public static final int TYPE_KEY_UPDATE_REP = 8;
    public static final int TYPE_KEY_RECOVERY_REQ = 9;
    public static final int TYPE_KEY_RECOVERY_REP = 10;
    public static final int TYPE_REVOCATION_REQ = 11;
    public static final int TYPE_REVOCATION_REP = 12;
    public static final int TYPE_CROSS_CERT_REQ = 13;
    public static final int TYPE_CROSS_CERT_REP = 14;
    public static final int TYPE_CA_KEY_UPDATE_ANN = 15;
    public static final int TYPE_CERT_ANN = 16;
    public static final int TYPE_REVOCATION_ANN = 17;
    public static final int TYPE_CRL_ANN = 18;
    public static final int TYPE_CONFIRM = 19;
    public static final int TYPE_NESTED = 20;
    public static final int TYPE_GEN_MSG = 21;
    public static final int TYPE_GEN_REP = 22;
    public static final int TYPE_ERROR = 23;
    public static final int TYPE_CERT_CONFIRM = 24;
    public static final int TYPE_POLL_REQ = 25;
    public static final int TYPE_POLL_REP = 26;
    private int tagNo;
    private ASN1Encodable body;

    public static PKIBody getInstance(Object object) {
        if (object == null || object instanceof PKIBody) {
            return (PKIBody)object;
        }
        if (object instanceof ASN1TaggedObject) {
            return new PKIBody((ASN1TaggedObject)object);
        }
        throw new IllegalArgumentException("Invalid object: " + object.getClass().getName());
    }

    private PKIBody(ASN1TaggedObject aSN1TaggedObject) {
        this.tagNo = aSN1TaggedObject.getTagNo();
        this.body = PKIBody.getBodyForType(this.tagNo, aSN1TaggedObject.getObject());
    }

    public PKIBody(int n, ASN1Encodable aSN1Encodable) {
        this.tagNo = n;
        this.body = PKIBody.getBodyForType(n, aSN1Encodable);
    }

    private static ASN1Encodable getBodyForType(int n, ASN1Encodable aSN1Encodable) {
        switch (n) {
            case 0: {
                return CertReqMessages.getInstance(aSN1Encodable);
            }
            case 1: {
                return CertRepMessage.getInstance(aSN1Encodable);
            }
            case 2: {
                return CertReqMessages.getInstance(aSN1Encodable);
            }
            case 3: {
                return CertRepMessage.getInstance(aSN1Encodable);
            }
            case 4: {
                return CertificationRequest.getInstance(aSN1Encodable);
            }
            case 5: {
                return POPODecKeyChallContent.getInstance(aSN1Encodable);
            }
            case 6: {
                return POPODecKeyRespContent.getInstance(aSN1Encodable);
            }
            case 7: {
                return CertReqMessages.getInstance(aSN1Encodable);
            }
            case 8: {
                return CertRepMessage.getInstance(aSN1Encodable);
            }
            case 9: {
                return CertReqMessages.getInstance(aSN1Encodable);
            }
            case 10: {
                return KeyRecRepContent.getInstance(aSN1Encodable);
            }
            case 11: {
                return RevReqContent.getInstance(aSN1Encodable);
            }
            case 12: {
                return RevRepContent.getInstance(aSN1Encodable);
            }
            case 13: {
                return CertReqMessages.getInstance(aSN1Encodable);
            }
            case 14: {
                return CertRepMessage.getInstance(aSN1Encodable);
            }
            case 15: {
                return CAKeyUpdAnnContent.getInstance(aSN1Encodable);
            }
            case 16: {
                return CMPCertificate.getInstance(aSN1Encodable);
            }
            case 17: {
                return RevAnnContent.getInstance(aSN1Encodable);
            }
            case 18: {
                return CRLAnnContent.getInstance(aSN1Encodable);
            }
            case 19: {
                return PKIConfirmContent.getInstance(aSN1Encodable);
            }
            case 20: {
                return PKIMessages.getInstance(aSN1Encodable);
            }
            case 21: {
                return GenMsgContent.getInstance(aSN1Encodable);
            }
            case 22: {
                return GenRepContent.getInstance(aSN1Encodable);
            }
            case 23: {
                return ErrorMsgContent.getInstance(aSN1Encodable);
            }
            case 24: {
                return CertConfirmContent.getInstance(aSN1Encodable);
            }
            case 25: {
                return PollReqContent.getInstance(aSN1Encodable);
            }
            case 26: {
                return PollRepContent.getInstance(aSN1Encodable);
            }
        }
        throw new IllegalArgumentException("unknown tag number: " + n);
    }

    public int getType() {
        return this.tagNo;
    }

    public ASN1Encodable getContent() {
        return this.body;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(true, this.tagNo, this.body);
    }
}

