package com.appsflyer.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFb1zSDK;
import com.facebook.FacebookSdk;
import com.facebook.applinks.AppLinkData;
import com.facebook.share.internal.ShareConstants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AFa1bSDK implements AFa1aSDK {
    @Nullable
    Map<String, Object> AFAdRevenueData;
    private boolean getMediationNetwork;
    @NotNull
    private final AFc1iSDK getRevenue;

    public static final class AFa1zSDK implements AFb1zSDK.AFa1vSDK {
        private /* synthetic */ long AFAdRevenueData;
        private /* synthetic */ AFa1bSDK getRevenue;

        public AFa1zSDK(AFa1bSDK aFa1bSDK, long j) {
            this.getRevenue = aFa1bSDK;
            this.AFAdRevenueData = j;
        }

        public final void AFAdRevenueData(@Nullable String str) {
            Map<String, Object> map = this.getRevenue.AFAdRevenueData;
            if (map != null) {
                map.put("error", str);
            }
        }

        public final void getRevenue(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            Map<String, Object> map;
            if (str != null) {
                AFLogger.afInfoLog("Facebook Deferred AppLink data received: ".concat(str));
                Map<String, Object> map2 = this.getRevenue.AFAdRevenueData;
                if (map2 != null) {
                    map2.put("link", str);
                }
                if (!(str2 == null || (map = this.getRevenue.AFAdRevenueData) == null)) {
                    map.put("target_url", str2);
                }
                if (str3 != null) {
                    AFa1bSDK aFa1bSDK = this.getRevenue;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put(ShareConstants.PROMO_CODE, str3);
                    linkedHashMap.put(ShareConstants.DEEPLINK_CONTEXT, linkedHashMap2);
                    Map<String, Object> map3 = aFa1bSDK.AFAdRevenueData;
                    if (map3 != null) {
                        map3.put(AppLinkData.ARGUMENTS_EXTRAS_KEY, linkedHashMap);
                    }
                }
            } else {
                Map<String, Object> map4 = this.getRevenue.AFAdRevenueData;
                if (map4 != null) {
                    map4.put("link", "");
                }
            }
            String valueOf = String.valueOf(System.currentTimeMillis() - this.AFAdRevenueData);
            Map<String, Object> map5 = this.getRevenue.AFAdRevenueData;
            if (map5 != null) {
                map5.put("ttr", valueOf);
            }
        }
    }

    public AFa1bSDK(@NotNull AFc1iSDK aFc1iSDK) {
        Intrinsics.checkNotNullParameter(aFc1iSDK, "");
        this.getRevenue = aFc1iSDK;
    }

    private boolean AFAdRevenueData() {
        return this.getMediationNetwork;
    }

    public final void getCurrencyIso4217Code(boolean z) {
        this.getMediationNetwork = z;
    }

    @Nullable
    public final Map<String, Object> getMonetizationNetwork() {
        return this.AFAdRevenueData;
    }

    public final void getRevenue() {
        Context context;
        Class<Context> cls = Context.class;
        if (AFAdRevenueData() && (context = this.getRevenue.getMonetizationNetwork) != null) {
            this.AFAdRevenueData = new LinkedHashMap();
            AFa1zSDK aFa1zSDK = new AFa1zSDK(this, System.currentTimeMillis());
            Class<FacebookSdk> cls2 = FacebookSdk.class;
            try {
                String str = FacebookSdk.APPLICATION_ID_PROPERTY;
                cls2.getMethod("sdkInitialize", new Class[]{cls}).invoke((Object) null, new Object[]{context});
                Class<AppLinkData> cls3 = AppLinkData.class;
                Class<AppLinkData.CompletionHandler> cls4 = AppLinkData.CompletionHandler.class;
                Method method = cls3.getMethod("fetchDeferredAppLinkData", new Class[]{cls, String.class, cls4});
                AFb1zSDK.AnonymousClass1 r10 = new InvocationHandler(cls3, aFa1zSDK) {
                    private /* synthetic */ Class getMonetizationNetwork;
                    private /* synthetic */ AFa1vSDK getRevenue;

                    {
                        this.getMonetizationNetwork = r1;
                        this.getRevenue = r2;
                    }

                    public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                        String str;
                        String str2;
                        String str3;
                        Bundle bundle;
                        if (method.getName().equals("onDeferredAppLinkDataFetched")) {
                            Object obj2 = objArr[0];
                            if (obj2 != null) {
                                Bundle cast = Bundle.class.cast(this.getMonetizationNetwork.getMethod("getArgumentBundle", (Class[]) null).invoke(this.getMonetizationNetwork.cast(obj2), (Object[]) null));
                                if (cast != null) {
                                    str = cast.getString(AppLinkData.ARGUMENTS_NATIVE_URL);
                                    str3 = cast.getString("target_url");
                                    Bundle bundle2 = cast.getBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY);
                                    if (bundle2 == null || (bundle = bundle2.getBundle(ShareConstants.DEEPLINK_CONTEXT)) == null) {
                                        str2 = null;
                                    } else {
                                        str2 = bundle.getString(ShareConstants.PROMO_CODE);
                                    }
                                } else {
                                    str2 = null;
                                    str = null;
                                    str3 = null;
                                }
                                AFa1vSDK aFa1vSDK = this.getRevenue;
                                if (aFa1vSDK != null) {
                                    aFa1vSDK.getRevenue(str, str3, str2);
                                }
                            } else {
                                AFa1vSDK aFa1vSDK2 = this.getRevenue;
                                if (aFa1vSDK2 != null) {
                                    aFa1vSDK2.getRevenue((String) null, (String) null, (String) null);
                                }
                            }
                            return null;
                        }
                        AFa1vSDK aFa1vSDK3 = this.getRevenue;
                        if (aFa1vSDK3 != null) {
                            aFa1vSDK3.AFAdRevenueData("onDeferredAppLinkDataFetched invocation failed");
                        }
                        return null;
                    }
                };
                Object newProxyInstance = Proxy.newProxyInstance(cls4.getClassLoader(), new Class[]{cls4}, r10);
                String string = context.getString(context.getResources().getIdentifier("facebook_app_id", TypedValues.Custom.S_STRING, context.getPackageName()));
                if (TextUtils.isEmpty(string)) {
                    aFa1zSDK.AFAdRevenueData("Facebook app id not defined in resources");
                    return;
                }
                method.invoke((Object) null, new Object[]{context, string, newProxyInstance});
            } catch (NoSuchMethodException e) {
                AFLogger.afErrorLogForExcManagerOnly("FB method missing error", e);
                aFa1zSDK.AFAdRevenueData(e.toString());
            } catch (InvocationTargetException e2) {
                AFLogger.afErrorLogForExcManagerOnly("FB invocation error", e2);
                aFa1zSDK.AFAdRevenueData(e2.toString());
            } catch (ClassNotFoundException e3) {
                AFLogger.afErrorLogForExcManagerOnly("FB class missing error", e3);
                aFa1zSDK.AFAdRevenueData(e3.toString());
            } catch (IllegalAccessException e4) {
                AFLogger.afErrorLogForExcManagerOnly("FB illegal access", e4);
                aFa1zSDK.AFAdRevenueData(e4.toString());
            }
        }
    }

    public final boolean getCurrencyIso4217Code() {
        if (!AFAdRevenueData()) {
            return false;
        }
        Map<String, Object> map = this.AFAdRevenueData;
        return map == null || map.isEmpty();
    }
}
