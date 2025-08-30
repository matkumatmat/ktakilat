package com.appsflyer.internal;

import androidx.annotation.Nullable;

public abstract class AFh1nSDK extends AFh1rSDK {
    private final boolean copy;
    private final boolean copydefault;

    public AFh1nSDK() {
        this((String) null, (Boolean) null, (Boolean) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AFh1nSDK(@Nullable String str, @Nullable Boolean bool, @Nullable Boolean bool2) {
        super(str, (String) null, Boolean.valueOf(bool2 != null ? bool2.booleanValue() : false));
        this.copy = bool != null ? bool.booleanValue() : true;
        this.copydefault = true;
    }
}
