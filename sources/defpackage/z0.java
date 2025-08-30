package defpackage;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.JsonObject;
import com.ktakilat.cbase.weight.CommonWebView;
import com.ktakilat.loan.login_face.LoginFaceActivity;
import com.ktakilat.loan.utils.LivenessResult;
import com.ktakilat.loan.verify_face.BaseVerifyFaceActivity;
import com.ktakilat.loan.verify_face.a;
import com.ktakilat.loan.verify_otp.BaseVerifyOtpActivity;
import com.ktakilat.loan.verify_otp.BaseVerifyOtpSms;
import com.ktakilat.loan.web.CommonWebFragment;
import com.ktakilat.loan.webtool.JsMap;
import com.ktakilat.loan.weiget.GpsUtil;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.flow.internal.SafeCollector;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* renamed from: z0  reason: default package */
public final /* synthetic */ class z0 implements Function2 {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ z0(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final Object invoke(Object obj, Object obj2) {
        int i;
        boolean z = false;
        Job job = null;
        Object obj3 = this.d;
        switch (this.c) {
            case 0:
                LivenessResult livenessResult = (LivenessResult) obj;
                String str = (String) obj2;
                int i2 = BaseVerifyFaceActivity.s;
                BaseVerifyFaceActivity baseVerifyFaceActivity = (BaseVerifyFaceActivity) obj3;
                baseVerifyFaceActivity.getClass();
                baseVerifyFaceActivity.runOnUiThread(new a1(baseVerifyFaceActivity, 0));
                if (!(livenessResult == null || livenessResult.getCode() != 200 || livenessResult.getImage() == null || livenessResult.getLiveness_id() == null)) {
                    String image = livenessResult.getImage();
                    String liveness_id = livenessResult.getLiveness_id();
                    baseVerifyFaceActivity.runOnUiThread(new a1(baseVerifyFaceActivity, 2));
                    GpsUtil.b(baseVerifyFaceActivity, new a(baseVerifyFaceActivity, image, liveness_id));
                }
                return null;
            case 1:
                BaseVerifyOtpSms baseVerifyOtpSms = BaseVerifyOtpActivity.s;
                BaseVerifyOtpActivity baseVerifyOtpActivity = (BaseVerifyOtpActivity) obj3;
                baseVerifyOtpActivity.getClass();
                BaseVerifyOtpActivity.t = ((Boolean) obj).booleanValue();
                BaseVerifyOtpActivity.u = ((Boolean) obj2).booleanValue();
                baseVerifyOtpActivity.runOnUiThread(new x0(baseVerifyOtpActivity, 1));
                return null;
            case 2:
                LivenessResult livenessResult2 = (LivenessResult) obj;
                String str2 = (String) obj2;
                CommonWebView commonWebView = ((CommonWebFragment) obj3).e;
                JsonObject jsonObject = new JsonObject();
                if (livenessResult2 != null) {
                    jsonObject.addProperty("code", (Number) Integer.valueOf(livenessResult2.getCode()));
                    jsonObject.addProperty("liveness_id", livenessResult2.getLiveness_id());
                    jsonObject.addProperty(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, livenessResult2.getMessage());
                    jsonObject.addProperty("sequence_id", livenessResult2.getSequence_id());
                    jsonObject.addProperty(MessengerShareContentUtility.MEDIA_IMAGE, livenessResult2.getImage());
                }
                jsonObject.addProperty("error", str2);
                if (!(livenessResult2 == null || livenessResult2.getImage() == null || livenessResult2.getCode() != 200)) {
                    z = true;
                }
                jsonObject.addProperty("success", Boolean.valueOf(z));
                JsMap.a(commonWebView, "naviCallTdLivenessResult", jsonObject.toString());
                return null;
            case 3:
                LivenessResult livenessResult3 = (LivenessResult) obj;
                String str3 = (String) obj2;
                int i3 = LoginFaceActivity.r;
                LoginFaceActivity loginFaceActivity = (LoginFaceActivity) obj3;
                loginFaceActivity.getClass();
                if (livenessResult3 == null) {
                    loginFaceActivity.runOnUiThread(new zb(loginFaceActivity, 2));
                } else if (livenessResult3.getCode() == 200) {
                    loginFaceActivity.runOnUiThread(new ib(3, loginFaceActivity, livenessResult3));
                } else {
                    loginFaceActivity.runOnUiThread(new zb(loginFaceActivity, 1));
                }
                return null;
            default:
                int intValue = ((Integer) obj).intValue();
                CoroutineContext.Element element = (CoroutineContext.Element) obj2;
                CoroutineContext.Key key = element.getKey();
                CoroutineContext.Element element2 = ((SafeCollector) obj3).collectContext.get(key);
                if (key == Job.Key.c) {
                    Job job2 = (Job) element2;
                    Job job3 = (Job) element;
                    while (true) {
                        if (job3 != null) {
                            if (job3 != job2 && (job3 instanceof ScopeCoroutine)) {
                                ChildHandle childHandle = (ChildHandle) JobSupport.d.get((ScopeCoroutine) job3);
                                if (childHandle != null) {
                                    job3 = childHandle.getParent();
                                } else {
                                    job3 = null;
                                }
                            }
                        }
                    }
                    job = job3;
                    if (job == job2) {
                        if (job2 != null) {
                            intValue++;
                        }
                        i = intValue;
                    } else {
                        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + job + ", expected child of " + job2 + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
                    }
                } else if (element != element2) {
                    i = Integer.MIN_VALUE;
                } else {
                    i = intValue + 1;
                }
                return Integer.valueOf(i);
        }
    }
}
