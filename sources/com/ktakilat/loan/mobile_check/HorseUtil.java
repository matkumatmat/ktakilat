package com.ktakilat.loan.mobile_check;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.ktakilat.cbase.cache.KvSave;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.http.ResponseCodeDeal;
import com.ktakilat.cbase.weight.DanaDialog;
import com.ktakilat.loan.R;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.op_horse.OpHorseRaceLampConfigResp;
import com.ktakilat.loan.login_face.BaseLoginActivity;
import com.trello.rxlifecycle2.LifecycleTransformer;
import java.util.List;

public class HorseUtil {

    /* renamed from: com.ktakilat.loan.mobile_check.HorseUtil$2  reason: invalid class name */
    class AnonymousClass2 implements DanaDialog.OnClickListener {
        public final void a(DanaDialog danaDialog) {
            danaDialog.dismiss();
        }

        public final void b(DanaDialog danaDialog) {
            danaDialog.dismiss();
        }
    }

    public static boolean a(Activity activity) {
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return false;
        }
        return true;
    }

    public static void b(final BaseLoginActivity baseLoginActivity, String str, final TextView textView) {
        if (a(baseLoginActivity) && textView != null) {
            if (a(baseLoginActivity)) {
                baseLoginActivity.n();
            }
            AppHttp.listValidOpHorseRaceLampByNoUser((LifecycleTransformer<BaseResponse<List<OpHorseRaceLampConfigResp>>>) null, str).subscribe(new ApiObserver<BaseResponse<List<OpHorseRaceLampConfigResp>>>() {
                public final void a(BaseResponse baseResponse) {
                    BaseLoginActivity baseLoginActivity = BaseLoginActivity.this;
                    if (HorseUtil.a(baseLoginActivity)) {
                        if (HorseUtil.a(baseLoginActivity)) {
                            baseLoginActivity.u();
                        }
                        ResponseCodeDeal.a(baseResponse);
                    }
                }

                /* JADX WARNING: type inference failed for: r5v5, types: [com.ktakilat.cbase.weight.DanaDialog$OnClickListener, java.lang.Object] */
                public final void b(BaseResponse baseResponse) {
                    TextView textView;
                    BaseLoginActivity baseLoginActivity = BaseLoginActivity.this;
                    if (HorseUtil.a(baseLoginActivity)) {
                        if (HorseUtil.a(baseLoginActivity)) {
                            baseLoginActivity.u();
                        }
                        List<OpHorseRaceLampConfigResp> list = (List) baseResponse.getData();
                        if (HorseUtil.a(baseLoginActivity) && (textView = textView) != null) {
                            if (list == null || list.isEmpty()) {
                                textView.setVisibility(4);
                                textView.setText("");
                                return;
                            }
                            StringBuilder sb = new StringBuilder();
                            for (OpHorseRaceLampConfigResp opHorseRaceLampConfigResp : list) {
                                sb.append(opHorseRaceLampConfigResp.getContent());
                                sb.append("\t\t\t");
                                String content = opHorseRaceLampConfigResp.getContent();
                                Long id = opHorseRaceLampConfigResp.getId();
                                if (HorseUtil.a(baseLoginActivity) && id != null) {
                                    String str = "NoticeHint_A" + id;
                                    if (TextUtils.isEmpty(AppKv.g().f465a.getString(e.B("h5", str), (String) null))) {
                                        DanaDialog danaDialog = new DanaDialog(baseLoginActivity);
                                        danaDialog.l = "";
                                        danaDialog.o = true;
                                        danaDialog.k = content;
                                        danaDialog.n = baseLoginActivity.getString(R.string.ok);
                                        danaDialog.q = new Object();
                                        if (HorseUtil.a(baseLoginActivity)) {
                                            KvSave g = AppKv.g();
                                            g.b("h5" + ("NoticeHint_A" + id), AppEventsConstants.EVENT_PARAM_VALUE_YES);
                                            danaDialog.show();
                                        }
                                    }
                                }
                            }
                            textView.setText(sb.toString());
                            textView.setVisibility(0);
                        }
                    }
                }
            });
        }
    }
}
