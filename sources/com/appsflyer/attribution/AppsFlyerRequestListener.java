package com.appsflyer.attribution;

import androidx.annotation.NonNull;

public interface AppsFlyerRequestListener {
    void onError(int i, @NonNull String str);

    void onSuccess();
}
