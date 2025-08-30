package com.appsflyer.internal;

import com.appsflyer.internal.platform_extension.PluginInfo;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public interface AFi1lSDK {
    void AFAdRevenueData(@NotNull PluginInfo pluginInfo);

    @NotNull
    Map<String, Object> getMediationNetwork();
}
