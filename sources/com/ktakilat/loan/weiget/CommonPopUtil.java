package com.ktakilat.loan.weiget;

import android.content.Intent;
import android.text.TextUtils;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.pop.FetchItem;
import com.ktakilat.loan.web.CommonWebPopActivity;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringEscapeUtils;

public class CommonPopUtil {

    /* renamed from: a  reason: collision with root package name */
    public final BaseActivity f583a;

    public interface CheckCallback {
        void a(int i);
    }

    public enum PageType {
        OpenScreen("OpenScreen"),
        LoginGesture("LoginGesture"),
        LoginFace("LoginFace"),
        LoginPwd("LoginPwd"),
        LoginOtp("LoginOtp"),
        Registration("Registration"),
        Settings("Settings"),
        OnlineService("OnlineService");
        
        public final String c;

        /* access modifiers changed from: public */
        PageType(String str) {
            this.c = str;
        }

        public String getValue() {
            return this.c;
        }
    }

    public CommonPopUtil(BaseActivity baseActivity) {
        this.f583a = baseActivity;
    }

    public static void a(CommonPopUtil commonPopUtil, ArrayList arrayList, CheckCallback checkCallback) {
        if (commonPopUtil.c()) {
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!TextUtils.isEmpty(str)) {
                    i++;
                    int i2 = CommonWebPopActivity.l;
                    BaseActivity baseActivity = commonPopUtil.f583a;
                    Intent intent = new Intent(baseActivity, CommonWebPopActivity.class);
                    intent.putExtra("htmlCode", str);
                    baseActivity.startActivityForResult(intent, 11000);
                }
            }
            if (checkCallback != null) {
                checkCallback.a(i);
            }
        }
    }

    public final void b(PageType pageType, final CheckCallback checkCallback) {
        if (c() && c()) {
            if (c()) {
                this.f583a.n();
            }
            AppHttp.popFetch(RxLifecycle.a(this.f583a.c, ActivityEvent.DESTROY), pageType).subscribe(new ApiObserver<BaseResponse<List<FetchItem>>>() {
                public final void a(BaseResponse baseResponse) {
                    CommonPopUtil commonPopUtil = CommonPopUtil.this;
                    if (commonPopUtil.c()) {
                        if (commonPopUtil.c()) {
                            commonPopUtil.f583a.u();
                        }
                        CheckCallback checkCallback = checkCallback;
                        if (checkCallback != null) {
                            checkCallback.a(0);
                        }
                    }
                }

                public final void b(BaseResponse baseResponse) {
                    CommonPopUtil commonPopUtil = CommonPopUtil.this;
                    if (commonPopUtil.c()) {
                        ArrayList arrayList = new ArrayList(0);
                        if (baseResponse.getData() != null && !((List) baseResponse.getData()).isEmpty()) {
                            for (FetchItem fetchItem : (List) baseResponse.getData()) {
                                if (!TextUtils.isEmpty(fetchItem.getPopUpsCode()) && fetchItem.getTempType() == 1 && fetchItem.getTriggerMethod() == 1) {
                                    arrayList.add(fetchItem.getPopUpsCode());
                                }
                            }
                        }
                        boolean isEmpty = arrayList.isEmpty();
                        CheckCallback checkCallback = checkCallback;
                        if (isEmpty) {
                            if (checkCallback != null) {
                                checkCallback.a(0);
                            }
                        } else if (commonPopUtil.c()) {
                            int size = arrayList.size();
                            if (size != 0) {
                                if (commonPopUtil.c()) {
                                    commonPopUtil.f583a.n();
                                }
                                ArrayList arrayList2 = new ArrayList(0);
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    String str = (String) it.next();
                                    if (!commonPopUtil.c()) {
                                        break;
                                    }
                                    AppHttp.renderHtml(RxLifecycle.a(commonPopUtil.f583a.c, ActivityEvent.DESTROY), str).subscribe(new ApiObserver<BaseResponse<String>>(arrayList2, size, checkCallback) {
                                        public final /* synthetic */ ArrayList c;
                                        public final /* synthetic */ int d;
                                        public final /* synthetic */ CheckCallback e;

                                        {
                                            this.c = r2;
                                            this.d = r3;
                                            this.e = r4;
                                        }

                                        public final void a(BaseResponse baseResponse) {
                                            ArrayList arrayList = this.c;
                                            arrayList.add((Object) null);
                                            CommonPopUtil commonPopUtil = CommonPopUtil.this;
                                            if (commonPopUtil.c() && arrayList.size() >= this.d) {
                                                if (commonPopUtil.c()) {
                                                    commonPopUtil.f583a.u();
                                                }
                                                CommonPopUtil.a(commonPopUtil, arrayList, this.e);
                                            }
                                        }

                                        public final void b(BaseResponse baseResponse) {
                                            String unescapeJava = StringEscapeUtils.unescapeJava((String) baseResponse.getData());
                                            if (unescapeJava.startsWith("\"")) {
                                                unescapeJava = unescapeJava.replaceFirst("\"", "");
                                            }
                                            if (unescapeJava.endsWith("\"")) {
                                                unescapeJava = unescapeJava.substring(0, unescapeJava.length() - 1);
                                            }
                                            ArrayList arrayList = this.c;
                                            arrayList.add(unescapeJava);
                                            CommonPopUtil commonPopUtil = CommonPopUtil.this;
                                            if (commonPopUtil.c() && arrayList.size() >= this.d) {
                                                if (commonPopUtil.c()) {
                                                    commonPopUtil.f583a.u();
                                                }
                                                CommonPopUtil.a(commonPopUtil, arrayList, this.e);
                                            }
                                        }
                                    });
                                }
                            } else if (checkCallback != null) {
                                checkCallback.a(0);
                            }
                        }
                        if (commonPopUtil.c()) {
                            commonPopUtil.f583a.u();
                        }
                    }
                }
            });
        }
    }

    public final boolean c() {
        BaseActivity baseActivity = this.f583a;
        if (baseActivity == null || baseActivity.isFinishing() || baseActivity.isDestroyed()) {
            return false;
        }
        return true;
    }
}
