package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import java.text.SimpleDateFormat;
import java.util.Locale;

public final class AFf1tSDK extends AFf1rSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] AFInAppEventParameterName = {10790, 10789, 10800, 10806, 10786, 10791, 10805, 10788, 10810};
    private static int AFKeystoreWrapper = 1;
    private static int AFLogger;
    private static char registerClient = 8141;
    private final AFg1qSDK AFInAppEventType;
    private final AFc1pSDK copydefault;
    private final String equals;
    private final AFc1iSDK hashCode;

    public AFf1tSDK(@NonNull String str, @NonNull AFc1dSDK aFc1dSDK) {
        super(new AFg1wSDK(), aFc1dSDK, str);
        this.copydefault = aFc1dSDK.getRevenue();
        this.hashCode = aFc1dSDK.AFInAppEventType();
        this.equals = str;
        this.AFInAppEventType = aFc1dSDK.component3();
    }

    private static void a(byte b, String str, int i, Object[] objArr) {
        Object obj;
        int i2;
        int i3 = i;
        if (str != null) {
            obj = str.toCharArray();
        } else {
            obj = str;
        }
        char[] cArr = (char[]) obj;
        AFk1mSDK aFk1mSDK = new AFk1mSDK();
        char[] cArr2 = AFInAppEventParameterName;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i4 = 0; i4 < length; i4++) {
                cArr3[i4] = (char) ((int) (((long) cArr2[i4]) ^ -374623853307093042L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((int) (-374623853307093042L ^ ((long) registerClient)));
        char[] cArr4 = new char[i3];
        if (i3 % 2 != 0) {
            int i5 = $10 + 67;
            $11 = i5 % 128;
            if (i5 % 2 == 0) {
                i2 = i3 + 123;
                cArr4[i2] = (char) (cArr[i2] - b);
            } else {
                i2 = i3 - 1;
                cArr4[i2] = (char) (cArr[i2] - b);
            }
        } else {
            i2 = i3;
        }
        if (i2 > 1) {
            aFk1mSDK.AFAdRevenueData = 0;
            $11 = ($10 + 113) % 128;
            while (true) {
                int i6 = aFk1mSDK.AFAdRevenueData;
                if (i6 >= i2) {
                    break;
                }
                char c2 = cArr[i6];
                aFk1mSDK.getMonetizationNetwork = c2;
                char c3 = cArr[i6 + 1];
                aFk1mSDK.getCurrencyIso4217Code = c3;
                if (c2 == c3) {
                    cArr4[i6] = (char) (c2 - b);
                    cArr4[i6 + 1] = (char) (c3 - b);
                } else {
                    int i7 = c2 / c;
                    aFk1mSDK.getMediationNetwork = i7;
                    int i8 = c2 % c;
                    aFk1mSDK.component1 = i8;
                    int i9 = c3 / c;
                    aFk1mSDK.getRevenue = i9;
                    int i10 = c3 % c;
                    aFk1mSDK.component2 = i10;
                    if (i8 == i10) {
                        $11 = ($10 + 83) % 128;
                        int i11 = ((i7 + c) - 1) % c;
                        aFk1mSDK.getMediationNetwork = i11;
                        int i12 = ((i9 + c) - 1) % c;
                        aFk1mSDK.getRevenue = i12;
                        cArr4[i6] = cArr2[(i11 * c) + i8];
                        cArr4[i6 + 1] = cArr2[(i12 * c) + i10];
                    } else if (i7 == i9) {
                        int i13 = ((i8 + c) - 1) % c;
                        aFk1mSDK.component1 = i13;
                        int i14 = ((i10 + c) - 1) % c;
                        aFk1mSDK.component2 = i14;
                        cArr4[i6] = cArr2[(i7 * c) + i13];
                        cArr4[i6 + 1] = cArr2[(i9 * c) + i14];
                        $11 = ($10 + 69) % 128;
                    } else {
                        cArr4[i6] = cArr2[(i7 * c) + i10];
                        cArr4[i6 + 1] = cArr2[(i9 * c) + i8];
                    }
                }
                aFk1mSDK.AFAdRevenueData = i6 + 2;
            }
        }
        $10 = ($11 + 33) % 128;
        int i15 = 0;
        while (i15 < i3) {
            int i16 = $11 + 67;
            $10 = i16 % 128;
            if (i16 % 2 != 0) {
                cArr4[i15] = (char) (cArr4[i15] ^ 31812);
                i15 += 84;
            } else {
                cArr4[i15] = (char) (cArr4[i15] ^ 13722);
                i15++;
            }
        }
        objArr[0] = new String(cArr4);
    }

    private void copy() {
        AFc1qSDK aFc1qSDK;
        boolean z;
        int i = AFLogger + 101;
        AFKeystoreWrapper = i % 128;
        if (i % 2 == 0) {
            aFc1qSDK = this.copy;
            z = false;
        } else {
            aFc1qSDK = this.copy;
            z = true;
        }
        aFc1qSDK.getCurrencyIso4217Code("sentRegisterRequestToAF", z);
        AFLogger.afDebugLog("[register] Successfully registered for Uninstall Tracking");
        AFLogger = (AFKeystoreWrapper + 81) % 128;
    }

    public final void component3(AFh1rSDK aFh1rSDK) {
        int i = AFKeystoreWrapper + 111;
        AFLogger = i % 128;
        if (i % 2 == 0) {
            String AFAdRevenueData = this.copydefault.AFAdRevenueData();
            if (AFAdRevenueData != null) {
                AFLogger = (AFKeystoreWrapper + 103) % 128;
                aFh1rSDK.getMediationNetwork("advertiserId", AFAdRevenueData);
                return;
            }
            return;
        }
        this.copydefault.AFAdRevenueData();
        throw null;
    }

    public final boolean copydefault() {
        boolean z;
        int i = AFKeystoreWrapper + 95;
        int i2 = i % 128;
        AFLogger = i2;
        if (i % 2 != 0) {
            z = false;
        } else {
            z = true;
        }
        boolean z2 = !z;
        int i3 = i2 + 73;
        AFKeystoreWrapper = i3 % 128;
        if (i3 % 2 != 0) {
            return z2;
        }
        throw null;
    }

    public final void getCurrencyIso4217Code(AFh1rSDK aFh1rSDK) {
        AFLogger = (AFKeystoreWrapper + 1) % 128;
    }

    public final void getMediationNetwork(AFh1rSDK aFh1rSDK) {
        AFKeystoreWrapper = (AFLogger + 103) % 128;
    }

    public final void getMonetizationNetwork(AFh1rSDK aFh1rSDK) {
        int i = AFLogger + 21;
        AFKeystoreWrapper = i % 128;
        if (i % 2 == 0) {
            throw null;
        }
    }

    public final void getRevenue() {
        super.getRevenue();
        AFd1aSDK<Result> aFd1aSDK = this.component1;
        if (aFd1aSDK != null) {
            AFKeystoreWrapper = (AFLogger + 11) % 128;
            if (aFd1aSDK.isSuccessful()) {
                int i = AFLogger + 117;
                AFKeystoreWrapper = i % 128;
                if (i % 2 != 0) {
                    copy();
                } else {
                    copy();
                    throw null;
                }
            }
        }
    }

    public final void AFAdRevenueData(AFh1rSDK aFh1rSDK) {
        int i = AFKeystoreWrapper + 57;
        AFLogger = i % 128;
        if (i % 2 == 0) {
            super.AFAdRevenueData(aFh1rSDK);
            Context context = this.hashCode.getMonetizationNetwork;
            AFa1tSDK aFa1tSDK = (AFa1tSDK) AFa1tSDK.getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis());
            if (context == null) {
                throw new IllegalStateException("Context is not provided, can't send register request");
            } else if (!aFa1tSDK.getMediationNetwork()) {
                PackageManager packageManager = context.getPackageManager();
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                    aFh1rSDK.getMediationNetwork("app_version_code", Integer.toString(packageInfo.versionCode));
                    aFh1rSDK.getMediationNetwork("app_version_name", packageInfo.versionName);
                    aFh1rSDK.getMediationNetwork(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, packageManager.getApplicationLabel(packageInfo.applicationInfo).toString());
                    aFh1rSDK.getMediationNetwork("installDate", AFa1tSDK.getRevenue(new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US), packageInfo.firstInstallTime));
                    AFKeystoreWrapper = (AFLogger + 37) % 128;
                } catch (Throwable th) {
                    AFLogger.afErrorLog("Exception while collecting application version info.", th);
                }
                this.AFInAppEventType.AFAdRevenueData(aFh1rSDK.AFAdRevenueData);
                aFh1rSDK.AFAdRevenueData.remove("ivc");
                String revenue = AFa1tSDK.getRevenue();
                if (revenue != null) {
                    aFh1rSDK.getMediationNetwork("appUserId", revenue);
                }
                try {
                    aFh1rSDK.getMediationNetwork("model", Build.MODEL);
                    Object[] objArr = new Object[1];
                    a((byte) (124 - TextUtils.lastIndexOf("", '0', 0)), "\u0006\u0003\u0007\u0006㙻", 5 - TextUtils.indexOf("", "", 0), objArr);
                    aFh1rSDK.getMediationNetwork(((String) objArr[0]).intern(), Build.BRAND);
                } catch (Throwable th2) {
                    AFLogger.afErrorLog("Exception while collecting device brand and model.", th2);
                }
                if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
                    int i2 = AFKeystoreWrapper + 75;
                    AFLogger = i2 % 128;
                    if (i2 % 2 != 0) {
                        aFh1rSDK.getMediationNetwork(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
                        int i3 = 86 / 0;
                    } else {
                        aFh1rSDK.getMediationNetwork(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
                    }
                }
                AFb1mSDK k_ = AFb1jSDK.k_(context.getContentResolver());
                if (k_ != null) {
                    int i4 = AFLogger + 113;
                    AFKeystoreWrapper = i4 % 128;
                    if (i4 % 2 != 0) {
                        aFh1rSDK.getMediationNetwork("amazon_aid", k_.getMonetizationNetwork);
                        aFh1rSDK.getMediationNetwork("amazon_aid_limit", String.valueOf(k_.getMediationNetwork));
                    } else {
                        aFh1rSDK.getMediationNetwork("amazon_aid", k_.getMonetizationNetwork);
                        aFh1rSDK.getMediationNetwork("amazon_aid_limit", String.valueOf(k_.getMediationNetwork));
                        throw null;
                    }
                }
                aFh1rSDK.getMediationNetwork("devkey", this.component3.getMediationNetwork());
                aFh1rSDK.getMediationNetwork("uid", AFb1iSDK.getRevenue(this.copydefault.getMonetizationNetwork));
                aFh1rSDK.getMediationNetwork("af_gcm_token", this.equals);
                aFh1rSDK.getMediationNetwork("launch_counter", Integer.toString(this.copy.AFAdRevenueData("appsFlyerCount", 0)));
                aFh1rSDK.getMediationNetwork(ServerProtocol.DIALOG_PARAM_SDK_VERSION, Integer.toString(Build.VERSION.SDK_INT));
                String component2 = this.copydefault.component2();
                if (component2 != null) {
                    AFKeystoreWrapper = (AFLogger + 19) % 128;
                    aFh1rSDK.getMediationNetwork(AppsFlyerProperties.CHANNEL, component2);
                }
            } else {
                AFLogger.afInfoLog("CustomerUserId not set, Tracking is disabled", true);
                throw new IllegalStateException("CustomerUserId not set, register is not sent");
            }
        } else {
            super.AFAdRevenueData(aFh1rSDK);
            Context context2 = this.hashCode.getMonetizationNetwork;
            AFa1tSDK aFa1tSDK2 = (AFa1tSDK) AFa1tSDK.getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis());
            throw null;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object getRevenue(Object[] objArr) {
        AFf1tSDK aFf1tSDK = objArr[0];
        AFh1rSDK aFh1rSDK = objArr[1];
        int i = AFLogger + 53;
        AFKeystoreWrapper = i % 128;
        if (i % 2 != 0) {
            return null;
        }
        throw null;
    }

    public final void getRevenue(AFh1rSDK aFh1rSDK) {
        Object unused = getRevenue(new Object[]{this, aFh1rSDK});
    }
}
