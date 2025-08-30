package com.google.firebase.perf.config;

import androidx.annotation.Nullable;

abstract class ConfigurationFlag<T> {
    public abstract T getDefault();

    public T getDefaultOnRcFetchFail() {
        return getDefault();
    }

    @Nullable
    public String getDeviceCacheFlag() {
        return null;
    }

    @Nullable
    public String getMetadataFlag() {
        return null;
    }

    @Nullable
    public String getRemoteConfigFlag() {
        return null;
    }
}
