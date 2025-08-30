package com.ktakilat.loan.global;

import android.text.TextUtils;
import com.appsflyer.AppsFlyerProperties;
import com.google.gson.reflect.TypeToken;
import com.ktakilat.cbase.cache.KvSave;
import com.ktakilat.cbase.utils.JsonUtil;
import com.ktakilat.cbase.utils.LogUtil;
import com.ktakilat.loan.http.collect.LocationInfo;
import com.ktakilat.loan.http.division.DivisionItem;
import com.ktakilat.loan.http.gesture.GestureConfigItem;
import com.ktakilat.loan.http.kta_face.FaceScenceItem;
import com.ktakilat.loan.http.user.UserInfo;
import java.util.List;
import okhttp3.HttpUrl;

public class AppKv {

    /* renamed from: a  reason: collision with root package name */
    public static volatile KvSave f494a;

    /* renamed from: com.ktakilat.loan.global.AppKv$1  reason: invalid class name */
    class AnonymousClass1 extends TypeToken<List<DivisionItem>> {
    }

    /* renamed from: com.ktakilat.loan.global.AppKv$2  reason: invalid class name */
    class AnonymousClass2 extends TypeToken<List<LocationInfo>> {
    }

    /* renamed from: com.ktakilat.loan.global.AppKv$3  reason: invalid class name */
    class AnonymousClass3 extends TypeToken<List<String>> {
    }

    /* renamed from: com.ktakilat.loan.global.AppKv$4  reason: invalid class name */
    class AnonymousClass4 extends TypeToken<List<GestureConfigItem>> {
    }

    /* renamed from: com.ktakilat.loan.global.AppKv$5  reason: invalid class name */
    class AnonymousClass5 extends TypeToken<List<String>> {
    }

    /* renamed from: com.ktakilat.loan.global.AppKv$6  reason: invalid class name */
    class AnonymousClass6 extends TypeToken<List<FaceScenceItem>> {
    }

    public static List a() {
        return JsonUtil.b(g().f465a.getString("auth_status", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI), new TypeToken());
    }

    public static String b() {
        return g().f465a.getString(AppsFlyerProperties.CHANNEL, "organic");
    }

    public static List c() {
        return JsonUtil.b(g().f465a.getString("face_scence", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI), new TypeToken());
    }

    public static String d() {
        return g().f465a.getString("gaid", "");
    }

    public static List e() {
        return JsonUtil.b(g().f465a.getString("gesture_config", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI), new TypeToken());
    }

    public static boolean f() {
        return g().f465a.getBoolean("has-login", false);
    }

    public static KvSave g() {
        if (f494a == null) {
            synchronized (AppKv.class) {
                try {
                    if (f494a == null) {
                        f494a = KvSave.a("app_kv_file", KvSave.PROGRESS_MODE.MULTI_PROGRESS_MODE);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f494a;
    }

    public static List h() {
        try {
            return JsonUtil.b(g().f465a.getString("location_list", (String) null), new TypeToken());
        } catch (Exception e) {
            LogUtil.a(e);
            return null;
        }
    }

    public static List i(int i, String str) {
        KvSave g = g();
        try {
            return JsonUtil.b(g.f465a.getString("region_info_" + str + "_" + i, (String) null), new TypeToken());
        } catch (Exception e) {
            LogUtil.a(e);
            return null;
        }
    }

    public static List j() {
        return JsonUtil.b(g().f465a.getString("support_login_type", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI), new TypeToken());
    }

    public static UserInfo k() {
        try {
            return (UserInfo) JsonUtil.c(g().f465a.getString("userInfo", (String) null), UserInfo.class);
        } catch (Exception e) {
            LogUtil.a(e);
            return null;
        }
    }

    public static void l(UserInfo userInfo) {
        if (userInfo != null && !TextUtils.isEmpty(userInfo.getMobileNo())) {
            g().b("last_login_mobile", userInfo.getMobileNo());
        }
        g().b("userInfo", JsonUtil.a(userInfo));
    }
}
