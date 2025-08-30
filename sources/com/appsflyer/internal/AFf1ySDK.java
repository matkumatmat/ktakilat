package com.appsflyer.internal;

import android.graphics.Color;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.UUID;

public final class AFf1ySDK extends AFe1dSDK<Map<String, String>> {
    @Nullable
    public AFa1ySDK component2;
    private final AFd1oSDK copy;
    private String copydefault;
    private final boolean equals;
    private String hashCode;
    private final UUID registerClient;
    private String toString;

    public interface AFa1ySDK {
        void getRevenue(String str);

        void getRevenue(Map<String, String> map);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AFf1ySDK(@NonNull AFc1dSDK aFc1dSDK, @NonNull UUID uuid, @NonNull Uri uri) {
        super(AFe1mSDK.ONELINK, new AFe1mSDK[]{AFe1mSDK.RC_CDN}, aFc1dSDK, uuid.toString());
        boolean z = false;
        this.copy = aFc1dSDK.getCurrencyIso4217Code();
        this.registerClient = uuid;
        try {
            if (!AFk1ySDK.getMediationNetwork(uri.getHost()) && !AFk1ySDK.getMediationNetwork(uri.getPath())) {
                Object[] objArr = new Object[2];
                objArr[1] = aFc1dSDK.d();
                objArr[0] = uri;
                Map map = AFa1kSDK.i;
                Object obj = map.get(-1523018365);
                if (obj == null) {
                    obj = ((Class) AFa1kSDK.getCurrencyIso4217Code(Color.red(0), (char) (MotionEvent.axisFromString("") + 1), 37 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getDeclaredConstructor(new Class[]{Uri.class, AFa1oSDK.class});
                    map.put(-1523018365, obj);
                }
                Object newInstance = ((Constructor) obj).newInstance(objArr);
                Object obj2 = map.get(1191605722);
                if (obj2 == null) {
                    obj2 = ((Class) AFa1kSDK.getCurrencyIso4217Code(ViewConfiguration.getWindowTouchSlop() >> 8, (char) (1 - (SystemClock.elapsedRealtime() > 0 ? 1 : (SystemClock.elapsedRealtime() == 0 ? 0 : -1))), 37 - (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("getRevenue", (Class[]) null);
                    map.put(1191605722, obj2);
                }
                Object invoke = ((Method) obj2).invoke(newInstance, (Object[]) null);
                Object obj3 = map.get(1984406162);
                if (obj3 == null) {
                    obj3 = ((Class) AFa1kSDK.getCurrencyIso4217Code((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 37, (char) (44103 - (SystemClock.uptimeMillis() > 0 ? 1 : (SystemClock.uptimeMillis() == 0 ? 0 : -1))), KeyEvent.keyCodeFromString("") + 50)).getMethod("getRevenue", (Class[]) null);
                    map.put(1984406162, obj3);
                }
                boolean booleanValue = ((Boolean) ((Method) obj3).invoke(invoke, (Object[]) null)).booleanValue();
                Object obj4 = map.get(-1632086821);
                if (obj4 == null) {
                    obj4 = ((Class) AFa1kSDK.getCurrencyIso4217Code((ViewConfiguration.getKeyRepeatDelay() >> 16) + 37, (char) (44102 - View.MeasureSpec.makeMeasureSpec(0, 0)), 50 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("getMonetizationNetwork", (Class[]) null);
                    map.put(-1632086821, obj4);
                }
                z = ((Boolean) ((Method) obj4).invoke(invoke, (Object[]) null)).booleanValue();
                String[] split = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
                if (booleanValue && split.length == 3) {
                    this.hashCode = split[1];
                    this.toString = split[2];
                    this.copydefault = uri.toString();
                }
            }
        } catch (Exception e) {
            AFLogger.afErrorLogForExcManagerOnly("OneLinkValidator: reflection init failed", e);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
        this.equals = z;
    }

    public final boolean a_() {
        return false;
    }

    @Nullable
    public final AppsFlyerRequestListener component3() {
        return null;
    }

    public final boolean copy() {
        return this.equals;
    }

    public final boolean copydefault() {
        return false;
    }

    public final boolean equals() {
        if (TextUtils.isEmpty(this.hashCode) || TextUtils.isEmpty(this.toString) || this.hashCode.equals("app")) {
            return false;
        }
        return true;
    }

    public final boolean getMediationNetwork() {
        return false;
    }

    public final long getMonetizationNetwork() {
        return 3000;
    }

    public final void getRevenue() {
        AFd1aSDK<Result> aFd1aSDK;
        super.getRevenue();
        AFa1ySDK aFa1ySDK = this.component2;
        if (aFa1ySDK == null) {
            return;
        }
        if (this.getMediationNetwork != AFe1rSDK.SUCCESS || (aFd1aSDK = this.component1) == null) {
            Throwable component4 = component4();
            String str = "Can't get OneLink data";
            if (!(component4 instanceof ParsingException)) {
                String str2 = this.copydefault;
                if (str2 != null) {
                    str = str2;
                }
                aFa1ySDK.getRevenue(str);
            } else if (((ParsingException) component4).getRawResponse().isSuccessful()) {
                aFa1ySDK.getRevenue("Can't parse one link data");
            } else {
                String str3 = this.copydefault;
                if (str3 != null) {
                    str = str3;
                }
                aFa1ySDK.getRevenue(str);
            }
        } else {
            aFa1ySDK.getRevenue((Map<String, String>) (Map) aFd1aSDK.getBody());
        }
    }

    public final AFd1nSDK<Map<String, String>> getRevenue(@NonNull String str) {
        return this.copy.getRevenue(this.hashCode, this.toString, this.registerClient, str);
    }
}
