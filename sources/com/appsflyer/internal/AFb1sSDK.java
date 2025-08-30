package com.appsflyer.internal;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lcom/appsflyer/internal/AFb1sSDK;", "", "Lcom/appsflyer/internal/AFh1rSDK;", "values", "<init>", "(Lcom/appsflyer/internal/AFh1rSDK;)V", "", "afInfoLog", "()V", "getRevenue", "Lcom/appsflyer/internal/AFh1rSDK;", "AFAdRevenueData"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AFb1sSDK {
    @NotNull
    private final AFh1rSDK getRevenue;

    public AFb1sSDK(@NotNull AFh1rSDK aFh1rSDK) {
        Intrinsics.checkNotNullParameter(aFh1rSDK, "");
        this.getRevenue = aFh1rSDK;
    }

    public final void afInfoLog() {
        try {
            Map map = AFa1kSDK.i;
            Object obj = map.get(-496653013);
            if (obj == null) {
                obj = ((Class) AFa1kSDK.getCurrencyIso4217Code(87 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (28154 - TextUtils.indexOf("", '0', 0, 0)), 36 - Color.argb(0, 0, 0, 0))).getDeclaredConstructor((Class[]) null);
                map.put(-496653013, obj);
            }
            Object newInstance = ((Constructor) obj).newInstance((Object[]) null);
            Object[] objArr = {this.getRevenue};
            Object obj2 = map.get(-1581670163);
            if (obj2 == null) {
                obj2 = ((Class) AFa1kSDK.getCurrencyIso4217Code(87 - TextUtils.indexOf("", "", 0, 0), (char) (28155 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), 36 - (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("getRevenue", new Class[]{AFh1rSDK.class});
                map.put(-1581670163, obj2);
            }
            ((Method) obj2).invoke(newInstance, objArr);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
