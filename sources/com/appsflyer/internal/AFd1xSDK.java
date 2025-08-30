package com.appsflyer.internal;

import androidx.annotation.WorkerThread;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface AFd1xSDK {
    @WorkerThread
    void getMediationNetwork(@NotNull byte[] bArr, @Nullable Map<String, String> map, int i);
}
