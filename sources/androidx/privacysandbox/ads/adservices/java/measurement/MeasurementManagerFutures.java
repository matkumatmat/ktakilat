package androidx.privacysandbox.ads.adservices.java.measurement;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.measurement.DeletionRequest;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager;
import androidx.privacysandbox.ads.adservices.measurement.SourceRegistrationRequest;
import androidx.privacysandbox.ads.adservices.measurement.WebSourceRegistrationRequest;
import androidx.privacysandbox.ads.adservices.measurement.WebTriggerRegistrationRequest;
import com.facebook.places.model.PlaceFields;
import com.facebook.share.internal.ShareConstants;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H'J \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH'J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0012\u001a\u00020\fH'J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000f\u001a\u00020\u0014H'J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000f\u001a\u00020\u0016H'¨\u0006\u0019"}, d2 = {"Landroidx/privacysandbox/ads/adservices/java/measurement/MeasurementManagerFutures;", "", "()V", "deleteRegistrationsAsync", "Lcom/google/common/util/concurrent/ListenableFuture;", "", "deletionRequest", "Landroidx/privacysandbox/ads/adservices/measurement/DeletionRequest;", "getMeasurementApiStatusAsync", "", "registerSourceAsync", "attributionSource", "Landroid/net/Uri;", "inputEvent", "Landroid/view/InputEvent;", "request", "Landroidx/privacysandbox/ads/adservices/measurement/SourceRegistrationRequest;", "registerTriggerAsync", "trigger", "registerWebSourceAsync", "Landroidx/privacysandbox/ads/adservices/measurement/WebSourceRegistrationRequest;", "registerWebTriggerAsync", "Landroidx/privacysandbox/ads/adservices/measurement/WebTriggerRegistrationRequest;", "Api33Ext5JavaImpl", "Companion", "ads-adservices-java_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class MeasurementManagerFutures {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @SourceDebugExtension({"SMAP\nMeasurementManagerFutures.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MeasurementManagerFutures.kt\nandroidx/privacysandbox/ads/adservices/java/measurement/MeasurementManagerFutures$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,208:1\n1#2:209\n*E\n"})
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/privacysandbox/ads/adservices/java/measurement/MeasurementManagerFutures$Companion;", "", "()V", "from", "Landroidx/privacysandbox/ads/adservices/java/measurement/MeasurementManagerFutures;", "context", "Landroid/content/Context;", "ads-adservices-java_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final MeasurementManagerFutures from(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
            MeasurementManager obtain = MeasurementManager.Companion.obtain(context);
            if (obtain != null) {
                return new Api33Ext5JavaImpl(obtain);
            }
            return null;
        }

        private Companion() {
        }
    }

    @JvmStatic
    @Nullable
    public static final MeasurementManagerFutures from(@NotNull Context context) {
        return Companion.from(context);
    }

    @NotNull
    public abstract ListenableFuture<Unit> deleteRegistrationsAsync(@NotNull DeletionRequest deletionRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @NotNull
    public abstract ListenableFuture<Integer> getMeasurementApiStatusAsync();

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @NotNull
    public abstract ListenableFuture<Unit> registerSourceAsync(@NotNull Uri uri, @Nullable InputEvent inputEvent);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @NotNull
    @ExperimentalFeatures.RegisterSourceOptIn
    public abstract ListenableFuture<Unit> registerSourceAsync(@NotNull SourceRegistrationRequest sourceRegistrationRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @NotNull
    public abstract ListenableFuture<Unit> registerTriggerAsync(@NotNull Uri uri);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @NotNull
    public abstract ListenableFuture<Unit> registerWebSourceAsync(@NotNull WebSourceRegistrationRequest webSourceRegistrationRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @NotNull
    public abstract ListenableFuture<Unit> registerWebTriggerAsync(@NotNull WebTriggerRegistrationRequest webTriggerRegistrationRequest);

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0017J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H\u0017J \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0014\u001a\u00020\u000eH\u0017J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0011\u001a\u00020\u0016H\u0017J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0011\u001a\u00020\u0018H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/privacysandbox/ads/adservices/java/measurement/MeasurementManagerFutures$Api33Ext5JavaImpl;", "Landroidx/privacysandbox/ads/adservices/java/measurement/MeasurementManagerFutures;", "mMeasurementManager", "Landroidx/privacysandbox/ads/adservices/measurement/MeasurementManager;", "(Landroidx/privacysandbox/ads/adservices/measurement/MeasurementManager;)V", "deleteRegistrationsAsync", "Lcom/google/common/util/concurrent/ListenableFuture;", "", "deletionRequest", "Landroidx/privacysandbox/ads/adservices/measurement/DeletionRequest;", "getMeasurementApiStatusAsync", "", "registerSourceAsync", "attributionSource", "Landroid/net/Uri;", "inputEvent", "Landroid/view/InputEvent;", "request", "Landroidx/privacysandbox/ads/adservices/measurement/SourceRegistrationRequest;", "registerTriggerAsync", "trigger", "registerWebSourceAsync", "Landroidx/privacysandbox/ads/adservices/measurement/WebSourceRegistrationRequest;", "registerWebTriggerAsync", "Landroidx/privacysandbox/ads/adservices/measurement/WebTriggerRegistrationRequest;", "ads-adservices-java_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api33Ext5JavaImpl extends MeasurementManagerFutures {
        /* access modifiers changed from: private */
        @NotNull
        public final MeasurementManager mMeasurementManager;

        public Api33Ext5JavaImpl(@NotNull MeasurementManager measurementManager) {
            Intrinsics.checkNotNullParameter(measurementManager, "mMeasurementManager");
            this.mMeasurementManager = measurementManager;
        }

        @DoNotInline
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @NotNull
        public ListenableFuture<Unit> deleteRegistrationsAsync(@NotNull DeletionRequest deletionRequest) {
            Intrinsics.checkNotNullParameter(deletionRequest, "deletionRequest");
            return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.a(CoroutineScopeKt.a(Dispatchers.f767a), (MainCoroutineDispatcher) null, new MeasurementManagerFutures$Api33Ext5JavaImpl$deleteRegistrationsAsync$1(this, deletionRequest, (Continuation<? super MeasurementManagerFutures$Api33Ext5JavaImpl$deleteRegistrationsAsync$1>) null), 3), (Object) null, 1, (Object) null);
        }

        @DoNotInline
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @NotNull
        public ListenableFuture<Integer> getMeasurementApiStatusAsync() {
            return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.a(CoroutineScopeKt.a(Dispatchers.f767a), (MainCoroutineDispatcher) null, new MeasurementManagerFutures$Api33Ext5JavaImpl$getMeasurementApiStatusAsync$1(this, (Continuation<? super MeasurementManagerFutures$Api33Ext5JavaImpl$getMeasurementApiStatusAsync$1>) null), 3), (Object) null, 1, (Object) null);
        }

        @DoNotInline
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @NotNull
        public ListenableFuture<Unit> registerSourceAsync(@NotNull Uri uri, @Nullable InputEvent inputEvent) {
            Intrinsics.checkNotNullParameter(uri, "attributionSource");
            return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.a(CoroutineScopeKt.a(Dispatchers.f767a), (MainCoroutineDispatcher) null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1(this, uri, inputEvent, (Continuation<? super MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1>) null), 3), (Object) null, 1, (Object) null);
        }

        @DoNotInline
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @NotNull
        public ListenableFuture<Unit> registerTriggerAsync(@NotNull Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "trigger");
            return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.a(CoroutineScopeKt.a(Dispatchers.f767a), (MainCoroutineDispatcher) null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerTriggerAsync$1(this, uri, (Continuation<? super MeasurementManagerFutures$Api33Ext5JavaImpl$registerTriggerAsync$1>) null), 3), (Object) null, 1, (Object) null);
        }

        @DoNotInline
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @NotNull
        public ListenableFuture<Unit> registerWebSourceAsync(@NotNull WebSourceRegistrationRequest webSourceRegistrationRequest) {
            Intrinsics.checkNotNullParameter(webSourceRegistrationRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.a(CoroutineScopeKt.a(Dispatchers.f767a), (MainCoroutineDispatcher) null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebSourceAsync$1(this, webSourceRegistrationRequest, (Continuation<? super MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebSourceAsync$1>) null), 3), (Object) null, 1, (Object) null);
        }

        @DoNotInline
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @NotNull
        public ListenableFuture<Unit> registerWebTriggerAsync(@NotNull WebTriggerRegistrationRequest webTriggerRegistrationRequest) {
            Intrinsics.checkNotNullParameter(webTriggerRegistrationRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.a(CoroutineScopeKt.a(Dispatchers.f767a), (MainCoroutineDispatcher) null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebTriggerAsync$1(this, webTriggerRegistrationRequest, (Continuation<? super MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebTriggerAsync$1>) null), 3), (Object) null, 1, (Object) null);
        }

        @DoNotInline
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @NotNull
        @ExperimentalFeatures.RegisterSourceOptIn
        public ListenableFuture<Unit> registerSourceAsync(@NotNull SourceRegistrationRequest sourceRegistrationRequest) {
            Intrinsics.checkNotNullParameter(sourceRegistrationRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.a(CoroutineScopeKt.a(Dispatchers.f767a), (MainCoroutineDispatcher) null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$2(this, sourceRegistrationRequest, (Continuation<? super MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$2>) null), 3), (Object) null, 1, (Object) null);
        }
    }
}
