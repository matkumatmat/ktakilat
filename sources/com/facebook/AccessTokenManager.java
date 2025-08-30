package com.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AccessTokenManager {
    public static final String ACTION_CURRENT_ACCESS_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED";
    public static final String EXTRA_NEW_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN";
    public static final String EXTRA_OLD_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN";
    private static final String ME_PERMISSIONS_GRAPH_PATH = "me/permissions";
    public static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
    public static final String TAG = "AccessTokenManager";
    private static final String TOKEN_EXTEND_GRAPH_PATH = "oauth/access_token";
    private static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
    private static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 86400;
    private static volatile AccessTokenManager instance;
    private final AccessTokenCache accessTokenCache;
    private AccessToken currentAccessToken;
    private Date lastAttemptedTokenExtendDate = new Date(0);
    private final LocalBroadcastManager localBroadcastManager;
    /* access modifiers changed from: private */
    public AtomicBoolean tokenRefreshInProgress = new AtomicBoolean(false);

    public static class RefreshResult {
        public String accessToken;
        public int expiresAt;

        private RefreshResult() {
        }
    }

    public AccessTokenManager(LocalBroadcastManager localBroadcastManager2, AccessTokenCache accessTokenCache2) {
        Validate.notNull(localBroadcastManager2, "localBroadcastManager");
        Validate.notNull(accessTokenCache2, "accessTokenCache");
        this.localBroadcastManager = localBroadcastManager2;
        this.accessTokenCache = accessTokenCache2;
    }

    private static GraphRequest createExtendAccessTokenRequest(AccessToken accessToken, GraphRequest.Callback callback) {
        return new GraphRequest(accessToken, TOKEN_EXTEND_GRAPH_PATH, e.c("grant_type", "fb_extend_sso_token"), HttpMethod.GET, callback);
    }

    private static GraphRequest createGrantedPermissionsRequest(AccessToken accessToken, GraphRequest.Callback callback) {
        return new GraphRequest(accessToken, ME_PERMISSIONS_GRAPH_PATH, new Bundle(), HttpMethod.GET, callback);
    }

    public static AccessTokenManager getInstance() {
        if (instance == null) {
            synchronized (AccessTokenManager.class) {
                try {
                    if (instance == null) {
                        instance = new AccessTokenManager(LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext()), new AccessTokenCache());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    /* access modifiers changed from: private */
    public void refreshCurrentAccessTokenImpl(AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        final AccessToken accessToken = this.currentAccessToken;
        if (accessToken == null) {
            if (accessTokenRefreshCallback != null) {
                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
            }
        } else if (this.tokenRefreshInProgress.compareAndSet(false, true)) {
            this.lastAttemptedTokenExtendDate = new Date();
            final HashSet hashSet = new HashSet();
            final HashSet hashSet2 = new HashSet();
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final RefreshResult refreshResult = new RefreshResult();
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch(createGrantedPermissionsRequest(accessToken, new GraphRequest.Callback() {
                public void onCompleted(GraphResponse graphResponse) {
                    JSONArray optJSONArray;
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("data")) != null) {
                        atomicBoolean.set(true);
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                String optString = optJSONObject.optString("permission");
                                String optString2 = optJSONObject.optString("status");
                                if (!Utility.isNullOrEmpty(optString) && !Utility.isNullOrEmpty(optString2)) {
                                    String lowerCase = optString2.toLowerCase(Locale.US);
                                    if (lowerCase.equals("granted")) {
                                        hashSet.add(optString);
                                    } else if (lowerCase.equals("declined")) {
                                        hashSet2.add(optString);
                                    } else {
                                        Log.w(AccessTokenManager.TAG, "Unexpected status: ".concat(lowerCase));
                                    }
                                }
                            }
                        }
                    }
                }
            }), createExtendAccessTokenRequest(accessToken, new GraphRequest.Callback() {
                public void onCompleted(GraphResponse graphResponse) {
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    if (jSONObject != null) {
                        refreshResult.accessToken = jSONObject.optString("access_token");
                        refreshResult.expiresAt = jSONObject.optInt("expires_at");
                    }
                }
            }));
            final AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback2 = accessTokenRefreshCallback;
            graphRequestBatch.addCallback(new GraphRequestBatch.Callback() {
                /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x0050=Splitter:B:19:0x0050, B:47:0x00dc=Splitter:B:47:0x00dc} */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onBatchCompleted(com.facebook.GraphRequestBatch r15) {
                    /*
                        r14 = this;
                        r15 = 0
                        r0 = 0
                        com.facebook.AccessTokenManager r1 = com.facebook.AccessTokenManager.getInstance()     // Catch:{ all -> 0x0043 }
                        com.facebook.AccessToken r1 = r1.getCurrentAccessToken()     // Catch:{ all -> 0x0043 }
                        if (r1 == 0) goto L_0x00dc
                        com.facebook.AccessTokenManager r1 = com.facebook.AccessTokenManager.getInstance()     // Catch:{ all -> 0x0043 }
                        com.facebook.AccessToken r1 = r1.getCurrentAccessToken()     // Catch:{ all -> 0x0043 }
                        java.lang.String r1 = r1.getUserId()     // Catch:{ all -> 0x0043 }
                        com.facebook.AccessToken r2 = r4     // Catch:{ all -> 0x0043 }
                        java.lang.String r2 = r2.getUserId()     // Catch:{ all -> 0x0043 }
                        if (r1 == r2) goto L_0x0022
                        goto L_0x00dc
                    L_0x0022:
                        java.util.concurrent.atomic.AtomicBoolean r1 = r6     // Catch:{ all -> 0x0043 }
                        boolean r1 = r1.get()     // Catch:{ all -> 0x0043 }
                        if (r1 != 0) goto L_0x0050
                        com.facebook.AccessTokenManager$RefreshResult r1 = r7     // Catch:{ all -> 0x0043 }
                        java.lang.String r2 = r1.accessToken     // Catch:{ all -> 0x0043 }
                        if (r2 != 0) goto L_0x0050
                        int r1 = r1.expiresAt     // Catch:{ all -> 0x0043 }
                        if (r1 != 0) goto L_0x0050
                        com.facebook.AccessToken$AccessTokenRefreshCallback r1 = r5     // Catch:{ all -> 0x0043 }
                        if (r1 == 0) goto L_0x0046
                        com.facebook.FacebookException r2 = new com.facebook.FacebookException     // Catch:{ all -> 0x0043 }
                        java.lang.String r3 = "Failed to refresh access token"
                        r2.<init>((java.lang.String) r3)     // Catch:{ all -> 0x0043 }
                        r1.OnTokenRefreshFailed(r2)     // Catch:{ all -> 0x0043 }
                        goto L_0x0046
                    L_0x0043:
                        r1 = move-exception
                        goto L_0x00f4
                    L_0x0046:
                        com.facebook.AccessTokenManager r0 = com.facebook.AccessTokenManager.this
                        java.util.concurrent.atomic.AtomicBoolean r0 = r0.tokenRefreshInProgress
                        r0.set(r15)
                        return
                    L_0x0050:
                        com.facebook.AccessToken r1 = new com.facebook.AccessToken     // Catch:{ all -> 0x0043 }
                        com.facebook.AccessTokenManager$RefreshResult r2 = r7     // Catch:{ all -> 0x0043 }
                        java.lang.String r2 = r2.accessToken     // Catch:{ all -> 0x0043 }
                        if (r2 == 0) goto L_0x005a
                    L_0x0058:
                        r3 = r2
                        goto L_0x0061
                    L_0x005a:
                        com.facebook.AccessToken r2 = r4     // Catch:{ all -> 0x0043 }
                        java.lang.String r2 = r2.getToken()     // Catch:{ all -> 0x0043 }
                        goto L_0x0058
                    L_0x0061:
                        com.facebook.AccessToken r2 = r4     // Catch:{ all -> 0x0043 }
                        java.lang.String r4 = r2.getApplicationId()     // Catch:{ all -> 0x0043 }
                        com.facebook.AccessToken r2 = r4     // Catch:{ all -> 0x0043 }
                        java.lang.String r5 = r2.getUserId()     // Catch:{ all -> 0x0043 }
                        java.util.concurrent.atomic.AtomicBoolean r2 = r6     // Catch:{ all -> 0x0043 }
                        boolean r2 = r2.get()     // Catch:{ all -> 0x0043 }
                        if (r2 == 0) goto L_0x0079
                        java.util.Set r2 = r8     // Catch:{ all -> 0x0043 }
                    L_0x0077:
                        r6 = r2
                        goto L_0x0080
                    L_0x0079:
                        com.facebook.AccessToken r2 = r4     // Catch:{ all -> 0x0043 }
                        java.util.Set r2 = r2.getPermissions()     // Catch:{ all -> 0x0043 }
                        goto L_0x0077
                    L_0x0080:
                        java.util.concurrent.atomic.AtomicBoolean r2 = r6     // Catch:{ all -> 0x0043 }
                        boolean r2 = r2.get()     // Catch:{ all -> 0x0043 }
                        if (r2 == 0) goto L_0x008c
                        java.util.Set r2 = r9     // Catch:{ all -> 0x0043 }
                    L_0x008a:
                        r7 = r2
                        goto L_0x0093
                    L_0x008c:
                        com.facebook.AccessToken r2 = r4     // Catch:{ all -> 0x0043 }
                        java.util.Set r2 = r2.getDeclinedPermissions()     // Catch:{ all -> 0x0043 }
                        goto L_0x008a
                    L_0x0093:
                        com.facebook.AccessToken r2 = r4     // Catch:{ all -> 0x0043 }
                        com.facebook.AccessTokenSource r8 = r2.getSource()     // Catch:{ all -> 0x0043 }
                        com.facebook.AccessTokenManager$RefreshResult r2 = r7     // Catch:{ all -> 0x0043 }
                        int r2 = r2.expiresAt     // Catch:{ all -> 0x0043 }
                        if (r2 == 0) goto L_0x00af
                        java.util.Date r2 = new java.util.Date     // Catch:{ all -> 0x0043 }
                        com.facebook.AccessTokenManager$RefreshResult r9 = r7     // Catch:{ all -> 0x0043 }
                        int r9 = r9.expiresAt     // Catch:{ all -> 0x0043 }
                        long r9 = (long) r9     // Catch:{ all -> 0x0043 }
                        r11 = 1000(0x3e8, double:4.94E-321)
                        long r9 = r9 * r11
                        r2.<init>(r9)     // Catch:{ all -> 0x0043 }
                    L_0x00ad:
                        r9 = r2
                        goto L_0x00b6
                    L_0x00af:
                        com.facebook.AccessToken r2 = r4     // Catch:{ all -> 0x0043 }
                        java.util.Date r2 = r2.getExpires()     // Catch:{ all -> 0x0043 }
                        goto L_0x00ad
                    L_0x00b6:
                        java.util.Date r10 = new java.util.Date     // Catch:{ all -> 0x0043 }
                        r10.<init>()     // Catch:{ all -> 0x0043 }
                        r2 = r1
                        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0043 }
                        com.facebook.AccessTokenManager r0 = com.facebook.AccessTokenManager.getInstance()     // Catch:{ all -> 0x00d7 }
                        r0.setCurrentAccessToken(r1)     // Catch:{ all -> 0x00d7 }
                        com.facebook.AccessTokenManager r0 = com.facebook.AccessTokenManager.this
                        java.util.concurrent.atomic.AtomicBoolean r0 = r0.tokenRefreshInProgress
                        r0.set(r15)
                        com.facebook.AccessToken$AccessTokenRefreshCallback r15 = r5
                        if (r15 == 0) goto L_0x00d6
                        r15.OnTokenRefreshed(r1)
                    L_0x00d6:
                        return
                    L_0x00d7:
                        r0 = move-exception
                        r13 = r1
                        r1 = r0
                        r0 = r13
                        goto L_0x00f4
                    L_0x00dc:
                        com.facebook.AccessToken$AccessTokenRefreshCallback r1 = r5     // Catch:{ all -> 0x0043 }
                        if (r1 == 0) goto L_0x00ea
                        com.facebook.FacebookException r2 = new com.facebook.FacebookException     // Catch:{ all -> 0x0043 }
                        java.lang.String r3 = "No current access token to refresh"
                        r2.<init>((java.lang.String) r3)     // Catch:{ all -> 0x0043 }
                        r1.OnTokenRefreshFailed(r2)     // Catch:{ all -> 0x0043 }
                    L_0x00ea:
                        com.facebook.AccessTokenManager r0 = com.facebook.AccessTokenManager.this
                        java.util.concurrent.atomic.AtomicBoolean r0 = r0.tokenRefreshInProgress
                        r0.set(r15)
                        return
                    L_0x00f4:
                        com.facebook.AccessTokenManager r2 = com.facebook.AccessTokenManager.this
                        java.util.concurrent.atomic.AtomicBoolean r2 = r2.tokenRefreshInProgress
                        r2.set(r15)
                        com.facebook.AccessToken$AccessTokenRefreshCallback r15 = r5
                        if (r15 == 0) goto L_0x0106
                        if (r0 == 0) goto L_0x0106
                        r15.OnTokenRefreshed(r0)
                    L_0x0106:
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.AccessTokenManager.AnonymousClass4.onBatchCompleted(com.facebook.GraphRequestBatch):void");
                }
            });
            graphRequestBatch.executeAsync();
        } else if (accessTokenRefreshCallback != null) {
            accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("Refresh already in progress"));
        }
    }

    private void sendCurrentAccessTokenChangedBroadcast(AccessToken accessToken, AccessToken accessToken2) {
        Intent intent = new Intent(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
        intent.putExtra(EXTRA_OLD_ACCESS_TOKEN, accessToken);
        intent.putExtra(EXTRA_NEW_ACCESS_TOKEN, accessToken2);
        this.localBroadcastManager.sendBroadcast(intent);
    }

    private boolean shouldExtendAccessToken() {
        if (this.currentAccessToken == null) {
            return false;
        }
        long time = new Date().getTime();
        if (!this.currentAccessToken.getSource().canExtendToken() || time - this.lastAttemptedTokenExtendDate.getTime() <= DateUtils.MILLIS_PER_HOUR || time - this.currentAccessToken.getLastRefresh().getTime() <= DateUtils.MILLIS_PER_DAY) {
            return false;
        }
        return true;
    }

    public void extendAccessTokenIfNeeded() {
        if (shouldExtendAccessToken()) {
            refreshCurrentAccessToken((AccessToken.AccessTokenRefreshCallback) null);
        }
    }

    public AccessToken getCurrentAccessToken() {
        return this.currentAccessToken;
    }

    public boolean loadCurrentAccessToken() {
        AccessToken load = this.accessTokenCache.load();
        if (load == null) {
            return false;
        }
        setCurrentAccessToken(load, false);
        return true;
    }

    public void refreshCurrentAccessToken(final AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    AccessTokenManager.this.refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
                }
            });
        }
    }

    public void setCurrentAccessToken(AccessToken accessToken) {
        setCurrentAccessToken(accessToken, true);
    }

    private void setCurrentAccessToken(AccessToken accessToken, boolean z) {
        AccessToken accessToken2 = this.currentAccessToken;
        this.currentAccessToken = accessToken;
        this.tokenRefreshInProgress.set(false);
        this.lastAttemptedTokenExtendDate = new Date(0);
        if (z) {
            if (accessToken != null) {
                this.accessTokenCache.save(accessToken);
            } else {
                this.accessTokenCache.clear();
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
        }
        if (!Utility.areObjectsEqual(accessToken2, accessToken)) {
            sendCurrentAccessTokenChangedBroadcast(accessToken2, accessToken);
        }
    }
}
