package com.google.firebase.components;

import androidx.annotation.VisibleForTesting;
import com.google.firebase.inject.Provider;

public class Lazy<T> implements Provider<T> {
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    public Lazy(T t) {
        this.instance = t;
    }

    public T get() {
        T t = this.instance;
        T t2 = UNINITIALIZED;
        if (t == t2) {
            synchronized (this) {
                try {
                    t = this.instance;
                    if (t == t2) {
                        t = this.provider.get();
                        this.instance = t;
                        this.provider = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return t;
    }

    @VisibleForTesting
    public boolean isInitialized() {
        if (this.instance != UNINITIALIZED) {
            return true;
        }
        return false;
    }

    public Lazy(Provider<T> provider2) {
        this.provider = provider2;
    }
}
