package com.appsflyer.internal;

import com.appsflyer.AFLogger;

@Deprecated
public final class AFa1vSDK {
    private final AFa1ySDK AFAdRevenueData = new AFa1ySDK() {
        public final Class<?> getMonetizationNetwork(String str) throws ClassNotFoundException {
            return Class.forName(str);
        }
    };

    public interface AFa1ySDK {
        Class<?> getMonetizationNetwork(String str) throws ClassNotFoundException;
    }

    public enum AFa1zSDK {
        ADOBE_AIR("android_adobe_air", "com.appsflyer.adobeair.AppsFlyerExtension"),
        ADOBE_MOBILE_SDK("android_adobe_mobile", "com.appsflyer.adobeextension.AppsFlyerAdobeExtension"),
        COCOS2DX("android_cocos2dx", "org.cocos2dx.lib.Cocos2dxActivity"),
        CORDOVA("android_cordova", "com.appsflyer.cordova.plugin.AppsFlyerPlugin"),
        DEFAULT("android_native", "android_native"),
        FLUTTER("android_flutter", "com.appsflyer.appsflyersdk.AppsflyerSdkPlugin"),
        M_PARTICLE("android_mparticle", "com.mparticle.kits.AppsFlyerKit"),
        NATIVE_SCRIPT("android_native_script", "com.tns.NativeScriptActivity"),
        EXPO("android_expo", "expo.modules.devmenu.react.DevMenuAwareReactActivity"),
        REACT_NATIVE("android_reactNative", "com.appsflyer.reactnative.RNAppsFlyerModule"),
        UNITY("android_unity", "com.appsflyer.unity.AppsFlyerAndroidWrapper"),
        UNREAL_ENGINE("android_unreal", "com.epicgames.ue4.GameActivity"),
        XAMARIN("android_xamarin", "mono.android.Runtime"),
        CAPACITOR("android_capacitor", "capacitor.plugin.appsflyer.sdk.AppsFlyerPlugin");
        
        final String getCurrencyIso4217Code;
        final String getMonetizationNetwork;

        private AFa1zSDK(String str, String str2) {
            this.getCurrencyIso4217Code = str;
            this.getMonetizationNetwork = str2;
        }
    }

    private boolean AFAdRevenueData(String str) {
        try {
            this.AFAdRevenueData.getMonetizationNetwork(str);
            StringBuilder sb = new StringBuilder("Class: ");
            sb.append(str);
            sb.append(" is found.");
            AFLogger.afRDLog(sb.toString());
            return true;
        } catch (ClassNotFoundException e) {
            StringBuilder sb2 = new StringBuilder("Class: ");
            sb2.append(str);
            sb2.append(" is  not found. (Platform extension)");
            AFLogger.afErrorLogForExcManagerOnly(sb2.toString(), e, true);
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return false;
        }
    }

    public final String getMonetizationNetwork() {
        for (AFa1zSDK aFa1zSDK : AFa1zSDK.values()) {
            if (AFAdRevenueData(aFa1zSDK.getMonetizationNetwork)) {
                return aFa1zSDK.getCurrencyIso4217Code;
            }
        }
        return AFa1zSDK.DEFAULT.getCurrencyIso4217Code;
    }
}
