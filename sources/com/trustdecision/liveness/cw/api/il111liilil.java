package com.trustdecision.liveness.cw.api;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1;
import com.trustdecision.liveness.cw.api.ui.TDH5LivenessActivity;
import org.json.JSONObject;

class il111liilil implements com.trustdecision.liveness.cw.api.il111liilil.il111liilil {
    final /* synthetic */ Context illill1ll1;

    public il111liilil(Context context) {
        this.illill1ll1 = context;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void illill1ll1(Context context, String str) {
        Intent intent = new Intent(context, TDH5LivenessActivity.class);
        intent.setFlags(268435456);
        intent.putExtra(illill1ll1.il11iii11l11i1("Dw0VJQcDMS0aGw=="), str);
        context.startActivity(intent);
    }

    public void onError(String str) {
        illill1ll1.illill1ll1 = false;
        String str2 = illill1ll1.i1lill1ii;
        illill1ll1.il111liilil(str2, str);
        illill1ll1.illill1ll1(str2, str);
    }

    public void onSuccess(String str) {
        illill1ll1.illill1ll1 = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(illill1ll1.il11iii11l11i1("GwcTFg=="), jSONObject.optString(illill1ll1.il11iii11l11i1("Cg0WAAEIGRsHExY=")));
            if (illill1ll1.il111liilil("441532", 116).equals(optString)) {
                String optString2 = jSONObject.optString(illill1ll1.il111liilil("03356b", 81));
                String unused = illill1ll1.iill11lliiil1l1i11l11 = jSONObject.optString(illill1ll1.il11iii11l11i1("Cw0GBgsIJR03Hhc="));
                String unused2 = illill1ll1.i11iliil1li1 = jSONObject.optString(illill1ll1.il111liilil("025e70507b", 38));
                if (TextUtils.isEmpty(illill1ll1.i11iliil1li1)) {
                    String illill1ll12 = illill1ll1.il111liilil("027870767b383222616c7a757a", 0);
                    String str2 = illill1ll1.i1i1l1lii;
                    illill1ll1.il111liilil(str2, illill1ll12);
                    illill1ll1.illill1ll1(str2, illill1ll12);
                    return;
                }
                com.trustdecision.liveness.cw.api.i11iliil1li1.il111liilil.illill1ll1((Runnable) new a(this.illill1ll1, optString2));
                return;
            }
            illill1ll1.illill1ll1(optString, jSONObject.optString(illill1ll1.il111liilil("1b507b5069566b", 59), jSONObject.optString(illill1ll1.il111liilil("043776256a245b1f5a094a", 67))), jSONObject.optString(illill1ll1.il11iii11l11i1("Cw0GBgsIJR03Hhc=")));
            illill1ll1.illill1ll1(optString, jSONObject.optString(illill1ll1.il111liilil("1b487b48694e6b", 35), jSONObject.optString(illill1ll1.il111liilil("045376416a405b7b5a6d4a", 39))));
        } catch (Throwable th) {
            String str3 = illill1ll1.l1li11i1ll;
            illill1ll1.il111liilil(str3, th.getMessage());
            illill1ll1.illill1ll1(str3, th.getMessage());
            th.printStackTrace();
        }
    }
}
