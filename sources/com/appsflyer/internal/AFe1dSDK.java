package com.appsflyer.internal;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.exceptions.HttpException;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import com.appsflyer.internal.components.queue.exceptions.CreateHttpCallException;
import java.io.IOException;
import org.apache.commons.lang3.time.DateUtils;

public abstract class AFe1dSDK<Result> extends AFe1sSDK<AFd1aSDK<Result>> {
    protected final AFd1pSDK areAllFieldsValid;
    @Nullable
    public AFd1aSDK<Result> component1;
    private AFc1vSDK component2;
    public final AFf1gSDK component3;
    protected final AFd1oSDK component4;
    @Nullable
    private String hashCode;

    private AFe1dSDK(@NonNull AFe1mSDK aFe1mSDK, @NonNull AFe1mSDK[] aFe1mSDKArr, @NonNull AFd1oSDK aFd1oSDK, @NonNull AFf1gSDK aFf1gSDK, @NonNull AFd1pSDK aFd1pSDK, @NonNull AFc1vSDK aFc1vSDK, @Nullable String str) {
        super(aFe1mSDK, aFe1mSDKArr, str);
        this.component4 = aFd1oSDK;
        this.component3 = aFf1gSDK;
        this.areAllFieldsValid = aFd1pSDK;
        this.component2 = aFc1vSDK;
    }

    public final void AFAdRevenueData() {
        String mediationNetwork;
        super.AFAdRevenueData();
        if (copydefault() && (mediationNetwork = this.component3.getMediationNetwork()) != null && !mediationNetwork.trim().isEmpty()) {
            AFd1nSDK revenue = getRevenue(mediationNetwork);
            if (revenue != null) {
                getCurrencyIso4217Code(revenue.getRevenue);
            } else {
                AFLogger.INSTANCE.e(AFg1cSDK.HTTP_CLIENT, "Failed to create a cached HTTP call", new CreateHttpCallException("createHttpCall returned null"), false, false);
            }
        }
    }

    public boolean a_() {
        return true;
    }

    @Nullable
    public abstract AppsFlyerRequestListener component3();

    public abstract boolean copydefault();

    @CallSuper
    @NonNull
    public AFe1rSDK getCurrencyIso4217Code() throws Exception {
        if (!a_() || !this.component3.AFAdRevenueData()) {
            String mediationNetwork = this.component3.getMediationNetwork();
            if (mediationNetwork == null || mediationNetwork.trim().isEmpty()) {
                AppsFlyerRequestListener component32 = component3();
                if (component32 != null) {
                    component32.onError(41, "No dev key");
                }
                throw new AFe1nSDK();
            }
            AFd1nSDK revenue = getRevenue(mediationNetwork);
            if (revenue == null) {
                AFLogger.INSTANCE.e(AFg1cSDK.HTTP_CLIENT, "Failed to create a cached HTTP call", new CreateHttpCallException("createHttpCall returned null"), false, false);
                return AFe1rSDK.FAILURE;
            }
            if (copydefault()) {
                getCurrencyIso4217Code(revenue.getRevenue);
            }
            AFd1aSDK<Result> mediationNetwork2 = revenue.getMediationNetwork();
            this.component1 = mediationNetwork2;
            this.areAllFieldsValid.getRevenue(revenue.getRevenue.getMonetizationNetwork, mediationNetwork2.getStatusCode(), mediationNetwork2.getBody().toString());
            AppsFlyerRequestListener component33 = component3();
            if (component33 != null) {
                if (mediationNetwork2.isSuccessful()) {
                    component33.onSuccess();
                } else {
                    StringBuilder sb = new StringBuilder("Status code failure ");
                    sb.append(mediationNetwork2.getStatusCode());
                    component33.onError(50, sb.toString());
                }
            }
            if (mediationNetwork2.isSuccessful()) {
                return AFe1rSDK.SUCCESS;
            }
            return AFe1rSDK.FAILURE;
        }
        AppsFlyerRequestListener component34 = component3();
        if (component34 != null) {
            component34.onError(11, "Skipping event because 'isStopped' is true");
        }
        throw new AFe1oSDK();
    }

    public boolean getMediationNetwork() {
        if (component4() instanceof AFe1oSDK) {
            return false;
        }
        if (this.getMediationNetwork == AFe1rSDK.TIMEOUT) {
            return true;
        }
        Throwable component42 = component4();
        if (!(component42 instanceof IOException) || (component42 instanceof ParsingException)) {
            return false;
        }
        return true;
    }

    public long getMonetizationNetwork() {
        return DateUtils.MILLIS_PER_MINUTE;
    }

    @WorkerThread
    @Nullable
    public abstract AFd1nSDK<Result> getRevenue(@NonNull String str);

    @CallSuper
    public void getRevenue() {
        String str;
        if (this.getMediationNetwork == AFe1rSDK.SUCCESS) {
            String str2 = this.hashCode;
            if (str2 != null) {
                this.component2.AFAdRevenueData(str2);
            }
        } else if (!getMediationNetwork() && (str = this.hashCode) != null) {
            this.component2.AFAdRevenueData(str);
        }
    }

    public AFe1dSDK(@NonNull AFe1mSDK aFe1mSDK, @NonNull AFe1mSDK[] aFe1mSDKArr, @NonNull AFc1dSDK aFc1dSDK, @Nullable String str) {
        this(aFe1mSDK, aFe1mSDKArr, aFc1dSDK.getCurrencyIso4217Code(), aFc1dSDK.registerClient(), aFc1dSDK.copy(), aFc1dSDK.AFInAppEventParameterName(), str);
    }

    public AFe1dSDK(@NonNull AFe1mSDK aFe1mSDK, @NonNull AFe1mSDK[] aFe1mSDKArr, @NonNull AFc1dSDK aFc1dSDK, @Nullable String str, @Nullable String str2) {
        this(aFe1mSDK, aFe1mSDKArr, aFc1dSDK.getCurrencyIso4217Code(), aFc1dSDK.registerClient(), aFc1dSDK.copy(), aFc1dSDK.AFInAppEventParameterName(), str);
        this.hashCode = str2;
    }

    @CallSuper
    public final void getCurrencyIso4217Code(Throwable th) {
        boolean z = !(th instanceof HttpException);
        if (th instanceof AFe1oSDK) {
            AFLogger.INSTANCE.e(AFg1cSDK.HTTP_CLIENT, "AppsFlyer SDK is stopped: the request was not sent to the server", th, true, false);
        } else {
            AFLogger aFLogger = AFLogger.INSTANCE;
            AFg1cSDK aFg1cSDK = AFg1cSDK.HTTP_CLIENT;
            aFLogger.e(aFg1cSDK, "Error while sending request to server: ".concat(String.valueOf(th)), th, false, false, z);
            aFLogger.w(aFg1cSDK, "Error while sending request to server: ".concat(String.valueOf(th)));
        }
        AppsFlyerRequestListener component32 = component3();
        if (component32 != null) {
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            component32.onError(40, message);
        }
    }

    @VisibleForTesting
    @WorkerThread
    private void getCurrencyIso4217Code(AFd1cSDK aFd1cSDK) {
        String str = this.hashCode;
        this.hashCode = this.component2.AFAdRevenueData(new AFc1rSDK(aFd1cSDK.getMonetizationNetwork, aFd1cSDK.getRevenue(), "6.17.0", this.getMonetizationNetwork));
        if (str != null) {
            this.component2.AFAdRevenueData(str);
        }
    }
}
