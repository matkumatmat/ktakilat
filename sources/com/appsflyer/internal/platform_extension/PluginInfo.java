package com.appsflyer.internal.platform_extension;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÇ\u0003¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006HÇ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ:\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006HÇ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0019\u0010\rR&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00068\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u00048\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010\r"}, d2 = {"Lcom/appsflyer/internal/platform_extension/PluginInfo;", "", "Lcom/appsflyer/internal/platform_extension/Plugin;", "plugin", "", "version", "", "additionalParams", "<init>", "(Lcom/appsflyer/internal/platform_extension/Plugin;Ljava/lang/String;Ljava/util/Map;)V", "component1", "()Lcom/appsflyer/internal/platform_extension/Plugin;", "component2", "()Ljava/lang/String;", "component3", "()Ljava/util/Map;", "copy", "(Lcom/appsflyer/internal/platform_extension/Plugin;Ljava/lang/String;Ljava/util/Map;)Lcom/appsflyer/internal/platform_extension/PluginInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/Map;", "getAdditionalParams", "Lcom/appsflyer/internal/platform_extension/Plugin;", "getPlugin", "Ljava/lang/String;", "getVersion"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PluginInfo {
    @NotNull
    private final Map<String, String> additionalParams;
    @NotNull
    private final Plugin plugin;
    @NotNull
    private final String version;

    @JvmOverloads
    public PluginInfo(@NotNull Plugin plugin2, @NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(plugin2, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.plugin = plugin2;
        this.version = str;
        this.additionalParams = map;
    }

    public static /* synthetic */ PluginInfo copy$default(PluginInfo pluginInfo, Plugin plugin2, String str, Map<String, String> map, int i, Object obj) {
        if ((i & 1) != 0) {
            plugin2 = pluginInfo.plugin;
        }
        if ((i & 2) != 0) {
            str = pluginInfo.version;
        }
        if ((i & 4) != 0) {
            map = pluginInfo.additionalParams;
        }
        return pluginInfo.copy(plugin2, str, map);
    }

    @NotNull
    public final Plugin component1() {
        return this.plugin;
    }

    @NotNull
    public final String component2() {
        return this.version;
    }

    @NotNull
    public final Map<String, String> component3() {
        return this.additionalParams;
    }

    @NotNull
    public final PluginInfo copy(@NotNull Plugin plugin2, @NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(plugin2, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(map, "");
        return new PluginInfo(plugin2, str, map);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PluginInfo)) {
            return false;
        }
        PluginInfo pluginInfo = (PluginInfo) obj;
        if (this.plugin == pluginInfo.plugin && Intrinsics.a(this.version, pluginInfo.version) && Intrinsics.a(this.additionalParams, pluginInfo.additionalParams)) {
            return true;
        }
        return false;
    }

    @NotNull
    @JvmName(name = "getAdditionalParams")
    public final Map<String, String> getAdditionalParams() {
        return this.additionalParams;
    }

    @NotNull
    @JvmName(name = "getPlugin")
    public final Plugin getPlugin() {
        return this.plugin;
    }

    @NotNull
    @JvmName(name = "getVersion")
    public final String getVersion() {
        return this.version;
    }

    public final int hashCode() {
        int hashCode = this.version.hashCode();
        return this.additionalParams.hashCode() + ((hashCode + (this.plugin.hashCode() * 31)) * 31);
    }

    @NotNull
    public final String toString() {
        Plugin plugin2 = this.plugin;
        String str = this.version;
        Map<String, String> map = this.additionalParams;
        return "PluginInfo(plugin=" + plugin2 + ", version=" + str + ", additionalParams=" + map + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PluginInfo(Plugin plugin2, String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(plugin2, str, (i & 4) != 0 ? MapsKt.b() : map);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PluginInfo(@NotNull Plugin plugin2, @NotNull String str) {
        this(plugin2, str, (Map) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(plugin2, "");
        Intrinsics.checkNotNullParameter(str, "");
    }
}
