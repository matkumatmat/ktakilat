package com.appsflyer.internal;

import com.appsflyer.internal.platform_extension.Plugin;
import com.appsflyer.internal.platform_extension.PluginInfo;
import com.facebook.applinks.AppLinkData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class AFi1mSDK implements AFi1lSDK {
    @NotNull
    private PluginInfo getCurrencyIso4217Code = new PluginInfo(Plugin.NATIVE, "6.17.0", (Map) null, 4, (DefaultConstructorMarker) null);

    public final void AFAdRevenueData(@NotNull PluginInfo pluginInfo) {
        Intrinsics.checkNotNullParameter(pluginInfo, "");
        this.getCurrencyIso4217Code = pluginInfo;
    }

    @NotNull
    public final Map<String, Object> getMediationNetwork() {
        LinkedHashMap f = MapsKt.f(new Pair("platform", this.getCurrencyIso4217Code.getPlugin().getPluginName()), new Pair("version", this.getCurrencyIso4217Code.getVersion()));
        if (!this.getCurrencyIso4217Code.getAdditionalParams().isEmpty()) {
            f.put(AppLinkData.ARGUMENTS_EXTRAS_KEY, this.getCurrencyIso4217Code.getAdditionalParams());
        }
        return f;
    }
}
