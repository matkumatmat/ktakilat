package androidx.privacysandbox.ads.adservices.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.RequiresOptIn;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/privacysandbox/ads/adservices/common/ExperimentalFeatures;", "", "Ext10OptIn", "Ext11OptIn", "Ext12OptIn", "Ext8OptIn", "RegisterSourceOptIn", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ExperimentalFeatures {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/privacysandbox/ads/adservices/common/ExperimentalFeatures$Ext10OptIn;", "", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @RequiresOptIn(level = RequiresOptIn.Level.WARNING, message = "The Ext10 API is experimental.")
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Ext10OptIn {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/privacysandbox/ads/adservices/common/ExperimentalFeatures$Ext11OptIn;", "", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @RequiresOptIn(level = RequiresOptIn.Level.WARNING, message = "The Ext11 API is experimental.")
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Ext11OptIn {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/privacysandbox/ads/adservices/common/ExperimentalFeatures$Ext12OptIn;", "", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @RequiresOptIn(level = RequiresOptIn.Level.WARNING, message = "The Ext12 API is experimental.")
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Ext12OptIn {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/privacysandbox/ads/adservices/common/ExperimentalFeatures$Ext8OptIn;", "", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @RequiresOptIn(level = RequiresOptIn.Level.WARNING, message = "The Ext8 API is experimental.")
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Ext8OptIn {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/privacysandbox/ads/adservices/common/ExperimentalFeatures$RegisterSourceOptIn;", "", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @RequiresOptIn(level = RequiresOptIn.Level.WARNING, message = "This API is experimental.")
    @Retention(RetentionPolicy.RUNTIME)
    public @interface RegisterSourceOptIn {
    }
}
