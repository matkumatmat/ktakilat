package com.appsflyer.internal;

import android.adservices.measurement.MeasurementManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import bolts.MeasurementEvent;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFe1tSDK;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@RequiresApi(33)
@SourceDebugExtension({"SMAP\nRegisterTriggerTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RegisterTriggerTask.kt\ncom/appsflyer/internal/components/queue/tasks/RegisterTriggerTask\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,169:1\n215#2,2:170\n*S KotlinDebug\n*F\n+ 1 RegisterTriggerTask.kt\ncom/appsflyer/internal/components/queue/tasks/RegisterTriggerTask\n*L\n163#1:170,2\n*E\n"})
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BM\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0010H\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0014¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u00058\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0019\u001a\u00020\t8\u0006X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\u001c\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\u0015\u001a\u00020\u000b8\u0006X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010\u0017\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00020\u000f8\u0006X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010%\u001a\u00020\r8\u0006X\u0004¢\u0006\u0006\n\u0004\b+\u0010,"}, d2 = {"Lcom/appsflyer/internal/AFf1zSDK;", "Lcom/appsflyer/internal/AFe1sSDK;", "", "Lcom/appsflyer/internal/AFe1tSDK;", "p0", "Ljava/util/concurrent/Executor;", "p1", "Lcom/appsflyer/internal/AFc1pSDK;", "p2", "Lcom/appsflyer/internal/AFc1iSDK;", "p3", "Lcom/appsflyer/internal/AFg1qSDK;", "p4", "Lcom/appsflyer/internal/AFf1gSDK;", "p5", "Lkotlin/Function1;", "Lcom/appsflyer/internal/AFe1rSDK;", "p6", "<init>", "(Lcom/appsflyer/internal/AFe1tSDK;Ljava/util/concurrent/Executor;Lcom/appsflyer/internal/AFc1pSDK;Lcom/appsflyer/internal/AFc1iSDK;Lcom/appsflyer/internal/AFg1qSDK;Lcom/appsflyer/internal/AFf1gSDK;Lkotlin/jvm/functions/Function1;)V", "", "getMonetizationNetwork", "()J", "getCurrencyIso4217Code", "()Lcom/appsflyer/internal/AFe1rSDK;", "getRevenue", "()V", "", "getMediationNetwork", "()Z", "component1", "Ljava/util/concurrent/Executor;", "AFAdRevenueData", "component2", "Lcom/appsflyer/internal/AFc1iSDK;", "areAllFieldsValid", "Lcom/appsflyer/internal/AFe1tSDK;", "component4", "Lcom/appsflyer/internal/AFg1qSDK;", "component3", "Lcom/appsflyer/internal/AFc1pSDK;", "copydefault", "Lkotlin/jvm/functions/Function1;", "equals", "Lcom/appsflyer/internal/AFf1gSDK;"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AFf1zSDK extends AFe1sSDK<Unit> {
    @NotNull
    public AFe1tSDK areAllFieldsValid;
    @NotNull
    public Executor component1;
    @NotNull
    public AFc1iSDK component2;
    @NotNull
    public AFc1pSDK component3;
    @NotNull
    public AFg1qSDK component4;
    @NotNull
    public Function1<AFe1rSDK, Unit> copydefault;
    @NotNull
    public AFf1gSDK equals;

    public static final class AFa1vSDK implements OutcomeReceiver<Object, Exception> {
        private /* synthetic */ CountDownLatch AFAdRevenueData;
        private /* synthetic */ Ref.ObjectRef<AFe1rSDK> getCurrencyIso4217Code;
        private /* synthetic */ AFf1zSDK getMonetizationNetwork;

        public AFa1vSDK(Ref.ObjectRef<AFe1rSDK> objectRef, CountDownLatch countDownLatch, AFf1zSDK aFf1zSDK) {
            this.getCurrencyIso4217Code = objectRef;
            this.AFAdRevenueData = countDownLatch;
            this.getMonetizationNetwork = aFf1zSDK;
        }

        public final /* synthetic */ void onError(Throwable th) {
            Exception exc = (Exception) th;
            Intrinsics.checkNotNullParameter(exc, "");
            AFLogger.INSTANCE.e(AFg1cSDK.PRIVACY_SANDBOX, e.B("Error occurred: ", exc.getMessage()), exc, false, false, false, true);
            this.AFAdRevenueData.countDown();
        }

        public final void onResult(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "");
            this.getCurrencyIso4217Code.element = AFe1rSDK.SUCCESS;
            AFLogger.INSTANCE.d(AFg1cSDK.PRIVACY_SANDBOX, "Privacy Sandbox trigger has been registered successfully. ", true);
            this.AFAdRevenueData.countDown();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AFf1zSDK(@NotNull AFe1tSDK aFe1tSDK, @NotNull Executor executor, @NotNull AFc1pSDK aFc1pSDK, @NotNull AFc1iSDK aFc1iSDK, @NotNull AFg1qSDK aFg1qSDK, @NotNull AFf1gSDK aFf1gSDK, @NotNull Function1<? super AFe1rSDK, Unit> function1) {
        super(AFe1mSDK.REGISTER_TRIGGER, new AFe1mSDK[]{AFe1mSDK.RC_CDN, AFe1mSDK.FETCH_ADVERTISING_ID}, (String) null);
        Intrinsics.checkNotNullParameter(aFe1tSDK, "");
        Intrinsics.checkNotNullParameter(executor, "");
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(aFc1iSDK, "");
        Intrinsics.checkNotNullParameter(aFg1qSDK, "");
        Intrinsics.checkNotNullParameter(aFf1gSDK, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.areAllFieldsValid = aFe1tSDK;
        this.component1 = executor;
        this.component3 = aFc1pSDK;
        this.component2 = aFc1iSDK;
        this.component4 = aFg1qSDK;
        this.equals = aFf1gSDK;
        this.copydefault = function1;
        if (aFe1tSDK instanceof AFe1tSDK.AFa1tSDK) {
            this.getCurrencyIso4217Code.add(AFe1mSDK.CONVERSION);
        }
        if (this.areAllFieldsValid instanceof AFe1tSDK.AFa1uSDK) {
            this.AFAdRevenueData.add(AFe1mSDK.CONVERSION);
        }
        if (this.areAllFieldsValid instanceof AFe1tSDK.AFa1vSDK) {
            this.AFAdRevenueData.add(AFe1mSDK.INAPP);
        }
    }

    @NotNull
    @SuppressLint({"NewApi"})
    public final AFe1rSDK getCurrencyIso4217Code() {
        MeasurementManager c;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = AFe1rSDK.FAILURE;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            Context context = this.component2.getMonetizationNetwork;
            if (!(context == null || (c = kc.c(context.getSystemService(kc.o()))) == null)) {
                new AFj1fSDK(this.component3, (AFk1xSDK) null, 2, (DefaultConstructorMarker) null);
                Uri.Builder buildUpon = Uri.parse(AFj1fSDK.getCurrencyIso4217Code()).buildUpon();
                String AFAdRevenueData = this.component3.AFAdRevenueData();
                if (AFAdRevenueData == null) {
                    AFAdRevenueData = "";
                }
                Pair pair = new Pair(MeasurementEvent.MEASUREMENT_EVENT_NAME_KEY, this.areAllFieldsValid.getMediationNetwork);
                Pair pair2 = new Pair("app_id", this.component3.getRevenue.getMonetizationNetwork.getPackageName());
                Context context2 = this.component3.getRevenue.getMonetizationNetwork;
                LinkedHashMap f = MapsKt.f(pair, pair2, new Pair("app_version", AFj1iSDK.getMediationNetwork(context2, context2.getPackageName())), new Pair("sdk_version", AFc1pSDK.getMonetizationNetwork()), new Pair("api_version", AFc1pSDK.getMediationNetwork()), new Pair("timestamp", String.valueOf(this.component4.AFAdRevenueData())), new Pair("request_id", AFc1pSDK.getRevenue()), new Pair("gaid", AFAdRevenueData));
                String revenue = AFb1iSDK.getRevenue(this.component3.getMonetizationNetwork);
                if (revenue != null) {
                    f.put("appsflyer_id", revenue);
                }
                Long currencyIso4217Code = this.component4.getCurrencyIso4217Code();
                if (currencyIso4217Code != null) {
                    f.put("install_time", String.valueOf(currencyIso4217Code.longValue()));
                }
                AFe1tSDK aFe1tSDK = this.areAllFieldsValid;
                if (aFe1tSDK instanceof AFe1tSDK.AFa1vSDK) {
                    Float f2 = ((AFe1tSDK.AFa1vSDK) aFe1tSDK).getRevenue;
                    if (f2 != null) {
                        f.put("event_revenue", String.valueOf(f2.floatValue()));
                    }
                    Integer num = ((AFe1tSDK.AFa1vSDK) this.areAllFieldsValid).getCurrencyIso4217Code;
                    if (num != null) {
                        f.put("event_count", String.valueOf(num.intValue()));
                    }
                }
                for (Map.Entry entry : f.entrySet()) {
                    buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
                }
                Uri build = buildUpon.build();
                Intrinsics.checkNotNullExpressionValue(build, "");
                c.registerTrigger(build, this.component1, new AFa1vSDK(objectRef, countDownLatch, this));
            }
            countDownLatch.await(4, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            objectRef.element = AFe1rSDK.TIMEOUT;
        } catch (Throwable th) {
            Throwable th2 = th;
            AFLogger.INSTANCE.e(AFg1cSDK.PRIVACY_SANDBOX, e.B("Error occurred: ", th2.getMessage()), th2, false, false, false, true);
        }
        return (AFe1rSDK) objectRef.element;
    }

    public final boolean getMediationNetwork() {
        return false;
    }

    public final long getMonetizationNetwork() {
        return 20000;
    }

    public final void getRevenue() {
        super.getRevenue();
        AFe1rSDK aFe1rSDK = this.getMediationNetwork;
        if (aFe1rSDK != null) {
            this.copydefault.invoke(aFe1rSDK);
        }
    }
}
