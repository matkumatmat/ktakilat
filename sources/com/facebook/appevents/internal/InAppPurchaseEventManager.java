package com.facebook.appevents.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.facebook.internal.Utility;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class InAppPurchaseEventManager {
    private static final String DETAILS_LIST = "DETAILS_LIST";
    private static final String GET_INTERFACE_METHOD = "iap_get_interface";
    private static final String GET_SKU_DETAILS_METHOD = "iap_get_sku_details";
    private static final String IN_APP_BILLING_SERVICE = "com.android.vending.billing.IInAppBillingService";
    private static final String IN_APP_BILLING_SERVICE_STUB = "com.android.vending.billing.IInAppBillingService$Stub";
    private static final String ITEM_ID_LIST = "ITEM_ID_LIST";
    private static final String RESPONSE_CODE = "RESPONSE_CODE";
    private static final String TAG = InAppPurchaseEventManager.class.getCanonicalName();
    private static final HashMap<String, Class<?>> classMap = new HashMap<>();
    private static final HashMap<String, Method> methodMap = new HashMap<>();

    public static String getPurchaseDetails(Context context, String str, Object obj, boolean z) {
        String str2;
        String str3 = str;
        Object obj2 = obj;
        if (!(obj2 == null || str3 == "")) {
            try {
                HashMap<String, Method> hashMap = methodMap;
                Method method = hashMap.get(GET_SKU_DETAILS_METHOD);
                HashMap<String, Class<?>> hashMap2 = classMap;
                Class<?> cls = hashMap2.get(IN_APP_BILLING_SERVICE);
                if (method == null || cls == null) {
                    cls = context.getClassLoader().loadClass(IN_APP_BILLING_SERVICE);
                    Class<String> cls2 = String.class;
                    method = cls.getDeclaredMethod("getSkuDetails", new Class[]{Integer.TYPE, cls2, cls2, Bundle.class});
                    hashMap.put(GET_SKU_DETAILS_METHOD, method);
                    hashMap2.put(IN_APP_BILLING_SERVICE, cls);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(str3);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(ITEM_ID_LIST, arrayList);
                Object cast = cls.cast(obj2);
                String packageName = context.getPackageName();
                if (z) {
                    str2 = "subs";
                } else {
                    str2 = "inapp";
                }
                Bundle bundle2 = (Bundle) method.invoke(cast, new Object[]{3, packageName, str2, bundle});
                if (bundle2.getInt(RESPONSE_CODE) == 0) {
                    ArrayList<String> stringArrayList = bundle2.getStringArrayList(DETAILS_LIST);
                    if (stringArrayList.size() < 1) {
                        return "";
                    }
                    return stringArrayList.get(0);
                }
            } catch (ClassNotFoundException e) {
                Log.e(TAG, "com.android.vending.billing.IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to the project, and import the IInAppBillingService.aidl file into this package", e);
            } catch (NoSuchMethodException e2) {
                Log.e(TAG, "com.android.vending.billing.IInAppBillingService.getSkuDetails method is not available", e2);
            } catch (InvocationTargetException e3) {
                Log.e(TAG, "Invocation target exception in com.android.vending.billing.IInAppBillingService.getSkuDetails", e3);
            } catch (IllegalAccessException e4) {
                Log.e(TAG, "Illegal access to method com.android.vending.billing.IInAppBillingService.getSkuDetails", e4);
            }
        }
        return "";
    }

    public static Object getServiceInterface(Context context, IBinder iBinder) {
        try {
            HashMap<String, Method> hashMap = methodMap;
            Method method = hashMap.get(GET_INTERFACE_METHOD);
            if (method == null) {
                method = context.getClassLoader().loadClass(IN_APP_BILLING_SERVICE_STUB).getDeclaredMethod("asInterface", new Class[]{IBinder.class});
                hashMap.put(GET_INTERFACE_METHOD, method);
            }
            Object[] objArr = {iBinder};
            Utility.logd(TAG, "In-app billing service connected");
            return method.invoke((Object) null, objArr);
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "com.android.vending.billing.IInAppBillingService$Stub is not available, please add com.android.vending.billing.IInAppBillingService to the project.", e);
            return null;
        } catch (NoSuchMethodException e2) {
            Log.e(TAG, "com.android.vending.billing.IInAppBillingService$Stub.asInterface method not found", e2);
            return null;
        } catch (IllegalAccessException e3) {
            Log.e(TAG, "Illegal access to method com.android.vending.billing.IInAppBillingService$Stub.asInterface", e3);
            return null;
        } catch (InvocationTargetException e4) {
            Log.e(TAG, "Invocation target exception in com.android.vending.billing.IInAppBillingService$Stub.asInterface", e4);
            return null;
        }
    }
}
