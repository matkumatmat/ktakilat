package com.appsflyer.internal;

public enum AFe1mSDK {
    RC_CDN(1),
    FETCH_ADVERTISING_ID(1),
    LOAD_CACHE(2),
    CACHED_EVENT(2),
    CONVERSION(2),
    PLAY_INTEGRITY_API(2),
    REGISTER_TRIGGER(2),
    ONELINK(2),
    DLSDK(2),
    RESOLVE_ESP(2),
    ATTR(2),
    GCDSDK(3),
    REGISTER(4),
    LAUNCH(4),
    INAPP(4),
    MANUAL_PURCHASE_VALIDATION(4),
    PURCHASE_VALIDATE(4),
    SDK_SERVICES(4),
    IMPRESSIONS(4),
    ARS_VALIDATE(4),
    ADREVENUE(4);
    
    public final int w;

    private AFe1mSDK(int i) {
        this.w = i;
    }
}
