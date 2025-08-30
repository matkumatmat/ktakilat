package com.facebook.appevents.internal;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.math.BigDecimal;
import java.util.Currency;
import org.json.JSONException;
import org.json.JSONObject;

public class AutomaticAnalyticsLogger {
    private static final String INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
    /* access modifiers changed from: private */
    public static final String TAG = "com.facebook.appevents.internal.AutomaticAnalyticsLogger";
    /* access modifiers changed from: private */
    @Nullable
    public static Object inAppBillingObj;

    public static boolean isImplicitPurchaseLoggingEnabled() {
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if (appSettingsWithoutQuery != null && FacebookSdk.getAutoLogAppEventsEnabled() && appSettingsWithoutQuery.getIAPAutomaticLoggingEnabled()) {
            return true;
        }
        return false;
    }

    public static void logActivateAppEvent() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        boolean autoLogAppEventsEnabled = FacebookSdk.getAutoLogAppEventsEnabled();
        Validate.notNull(applicationContext, PlaceFields.CONTEXT);
        if (!autoLogAppEventsEnabled) {
            return;
        }
        if (applicationContext instanceof Application) {
            AppEventsLogger.activateApp((Application) applicationContext, applicationId);
        } else {
            Log.w(TAG, "Automatic logging of basic events will not happen, because FacebookSdk.getApplicationContext() returns object that is not instance of android.app.Application. Make sure you call FacebookSdk.sdkInitialize() from Application class and pass application context.");
        }
    }

    public static void logActivityTimeSpentEvent(String str, long j) {
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        Validate.notNull(applicationContext, PlaceFields.CONTEXT);
        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(applicationId, false);
        if (queryAppSettings != null && queryAppSettings.getAutomaticLoggingEnabled() && j > 0) {
            AppEventsLogger newLogger = AppEventsLogger.newLogger(applicationContext);
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence(Constants.AA_TIME_SPENT_SCREEN_PARAMETER_NAME, str);
            newLogger.logEvent(Constants.AA_TIME_SPENT_EVENT_NAME, (double) j, bundle);
        }
    }

    public static boolean logInAppPurchaseEvent(final Context context, int i, Intent intent) {
        if (intent == null || !isImplicitPurchaseLoggingEnabled()) {
            return false;
        }
        final String stringExtra = intent.getStringExtra(INAPP_PURCHASE_DATA);
        if (i == -1) {
            AnonymousClass1 r3 = new ServiceConnection() {
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    Object unused = AutomaticAnalyticsLogger.inAppBillingObj = InAppPurchaseEventManager.getServiceInterface(context, iBinder);
                    try {
                        JSONObject jSONObject = new JSONObject(stringExtra);
                        String string = jSONObject.getString("productId");
                        String purchaseDetails = InAppPurchaseEventManager.getPurchaseDetails(context, string, AutomaticAnalyticsLogger.inAppBillingObj, jSONObject.has("autoRenewing"));
                        if (purchaseDetails.equals("")) {
                            context.unbindService(this);
                            return;
                        }
                        JSONObject jSONObject2 = new JSONObject(purchaseDetails);
                        AppEventsLogger newLogger = AppEventsLogger.newLogger(context);
                        Bundle bundle = new Bundle(1);
                        bundle.putCharSequence(Constants.IAP_PRODUCT_ID, string);
                        bundle.putCharSequence(Constants.IAP_PURCHASE_TIME, jSONObject.getString("purchaseTime"));
                        bundle.putCharSequence(Constants.IAP_PURCHASE_STATE, jSONObject.getString("purchaseState"));
                        bundle.putCharSequence(Constants.IAP_PURCHASE_TOKEN, jSONObject.getString("purchaseToken"));
                        bundle.putCharSequence(Constants.IAP_PACKAGE_NAME, jSONObject.getString(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME));
                        bundle.putCharSequence(Constants.IAP_PRODUCT_TYPE, jSONObject2.getString("type"));
                        bundle.putCharSequence(Constants.IAP_PRODUCT_TITLE, jSONObject2.getString("title"));
                        bundle.putCharSequence(Constants.IAP_PRODUCT_DESCRIPTION, jSONObject2.getString("description"));
                        bundle.putCharSequence(Constants.IAP_SUBSCRIPTION_AUTORENEWING, Boolean.toString(jSONObject.optBoolean("autoRenewing", false)));
                        bundle.putCharSequence(Constants.IAP_SUBSCRIPTION_PERIOD, jSONObject2.optString("subscriptionPeriod"));
                        bundle.putCharSequence(Constants.IAP_FREE_TRIAL_PERIOD, jSONObject2.optString("freeTrialPeriod"));
                        bundle.putCharSequence(Constants.IAP_INTRO_PRICE_AMOUNT_MICROS, jSONObject2.optString("introductoryPriceAmountMicros"));
                        bundle.putCharSequence(Constants.IAP_INTRO_PRICE_CYCLES, jSONObject2.optString("introductoryPriceCycles"));
                        newLogger.logPurchaseImplicitly(new BigDecimal(((double) jSONObject2.getLong("price_amount_micros")) / 1000000.0d), Currency.getInstance(jSONObject2.getString("price_currency_code")), bundle);
                        context.unbindService(this);
                    } catch (JSONException e) {
                        Log.e(AutomaticAnalyticsLogger.TAG, "Error parsing in-app purchase data.", e);
                    } catch (Throwable th) {
                        context.unbindService(this);
                        throw th;
                    }
                }

                public void onServiceDisconnected(ComponentName componentName) {
                    Object unused = AutomaticAnalyticsLogger.inAppBillingObj = null;
                    Utility.logd(AutomaticAnalyticsLogger.TAG, "In-app billing service disconnected");
                }
            };
            Intent intent2 = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent2.setPackage("com.android.vending");
            context.bindService(intent2, r3, 1);
        }
        return true;
    }
}
