package com.google.firebase.sessions;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a0\u0012,\u0012*\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0014\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00050\u0004H\u0016¨\u0006\t"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "()V", "getComponents", "", "Lcom/google/firebase/components/Component;", "", "kotlin.jvm.PlatformType", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Keep
public final class FirebaseSessionsRegistrar implements ComponentRegistrar {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String LIBRARY_NAME = "fire-sessions";
    @NotNull
    @Deprecated
    public static final String TAG = "FirebaseSessions";
    /* access modifiers changed from: private */
    @NotNull
    public static final Qualified<Context> appContext;
    /* access modifiers changed from: private */
    @NotNull
    public static final Qualified<CoroutineDispatcher> backgroundDispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public static final Qualified<CoroutineDispatcher> blockingDispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public static final Qualified<FirebaseApp> firebaseApp;
    /* access modifiers changed from: private */
    @NotNull
    public static final Qualified<FirebaseInstallationsApi> firebaseInstallationsApi;
    /* access modifiers changed from: private */
    @NotNull
    public static final Qualified<FirebaseSessionsComponent> firebaseSessionsComponent;
    /* access modifiers changed from: private */
    @NotNull
    public static final Qualified<TransportFactory> transportFactory;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001f\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\f\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\r0\r0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001f\u0010\u000f\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\r0\r0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u001f\u0010\u0011\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00120\u00120\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u001f\u0010\u0014\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00150\u00150\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000bR\u001f\u0010\u0017\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00180\u00180\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u001f\u0010\u001a\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u001b0\u001b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsRegistrar$Companion;", "", "()V", "LIBRARY_NAME", "", "TAG", "appContext", "Lcom/google/firebase/components/Qualified;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getAppContext", "()Lcom/google/firebase/components/Qualified;", "backgroundDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getBackgroundDispatcher", "blockingDispatcher", "getBlockingDispatcher", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "getFirebaseApp", "firebaseInstallationsApi", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "getFirebaseInstallationsApi", "firebaseSessionsComponent", "Lcom/google/firebase/sessions/FirebaseSessionsComponent;", "getFirebaseSessionsComponent", "transportFactory", "Lcom/google/android/datatransport/TransportFactory;", "getTransportFactory", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Qualified<Context> getAppContext() {
            return FirebaseSessionsRegistrar.appContext;
        }

        @NotNull
        public final Qualified<CoroutineDispatcher> getBackgroundDispatcher() {
            return FirebaseSessionsRegistrar.backgroundDispatcher;
        }

        @NotNull
        public final Qualified<CoroutineDispatcher> getBlockingDispatcher() {
            return FirebaseSessionsRegistrar.blockingDispatcher;
        }

        @NotNull
        public final Qualified<FirebaseApp> getFirebaseApp() {
            return FirebaseSessionsRegistrar.firebaseApp;
        }

        @NotNull
        public final Qualified<FirebaseInstallationsApi> getFirebaseInstallationsApi() {
            return FirebaseSessionsRegistrar.firebaseInstallationsApi;
        }

        @NotNull
        public final Qualified<FirebaseSessionsComponent> getFirebaseSessionsComponent() {
            return FirebaseSessionsRegistrar.firebaseSessionsComponent;
        }

        @NotNull
        public final Qualified<TransportFactory> getTransportFactory() {
            return FirebaseSessionsRegistrar.transportFactory;
        }

        private Companion() {
        }
    }

    static {
        Qualified<Context> unqualified = Qualified.unqualified(Context.class);
        Intrinsics.checkNotNullExpressionValue(unqualified, "unqualified(Context::class.java)");
        appContext = unqualified;
        Qualified<FirebaseApp> unqualified2 = Qualified.unqualified(FirebaseApp.class);
        Intrinsics.checkNotNullExpressionValue(unqualified2, "unqualified(FirebaseApp::class.java)");
        firebaseApp = unqualified2;
        Qualified<FirebaseInstallationsApi> unqualified3 = Qualified.unqualified(FirebaseInstallationsApi.class);
        Intrinsics.checkNotNullExpressionValue(unqualified3, "unqualified(FirebaseInstallationsApi::class.java)");
        firebaseInstallationsApi = unqualified3;
        Class<CoroutineDispatcher> cls = CoroutineDispatcher.class;
        Qualified<CoroutineDispatcher> qualified = Qualified.qualified(Background.class, cls);
        Intrinsics.checkNotNullExpressionValue(qualified, "qualified(Background::cl…neDispatcher::class.java)");
        backgroundDispatcher = qualified;
        Qualified<CoroutineDispatcher> qualified2 = Qualified.qualified(Blocking.class, cls);
        Intrinsics.checkNotNullExpressionValue(qualified2, "qualified(Blocking::clas…neDispatcher::class.java)");
        blockingDispatcher = qualified2;
        Qualified<TransportFactory> unqualified4 = Qualified.unqualified(TransportFactory.class);
        Intrinsics.checkNotNullExpressionValue(unqualified4, "unqualified(TransportFactory::class.java)");
        transportFactory = unqualified4;
        Qualified<FirebaseSessionsComponent> unqualified5 = Qualified.unqualified(FirebaseSessionsComponent.class);
        Intrinsics.checkNotNullExpressionValue(unqualified5, "unqualified(FirebaseSessionsComponent::class.java)");
        firebaseSessionsComponent = unqualified5;
        try {
            Companion.AnonymousClass1.INSTANCE.getClass();
        } catch (NoClassDefFoundError unused) {
            Log.w(TAG, "Your app is experiencing a known issue in the Android Gradle plugin, see https://issuetracker.google.com/328687152\n\nIt affects Java-only apps using AGP version 8.3.2 and under. To avoid the issue, either:\n\n1. Upgrade Android Gradle plugin to 8.4.0+\n   Follow the guide at https://developer.android.com/build/agp-upgrade-assistant\n\n2. Or, add the Kotlin plugin to your app\n   Follow the guide at https://developer.android.com/kotlin/add-kotlin\n\n3. Or, do the technical workaround described in https://issuetracker.google.com/issues/328687152#comment3");
        }
    }

    /* access modifiers changed from: private */
    public static final FirebaseSessions getComponents$lambda$0(ComponentContainer componentContainer) {
        return ((FirebaseSessionsComponent) componentContainer.get(firebaseSessionsComponent)).getFirebaseSessions();
    }

    /* access modifiers changed from: private */
    public static final FirebaseSessionsComponent getComponents$lambda$1(ComponentContainer componentContainer) {
        FirebaseSessionsComponent.Builder builder = DaggerFirebaseSessionsComponent.builder();
        Object obj = componentContainer.get(appContext);
        Intrinsics.checkNotNullExpressionValue(obj, "container[appContext]");
        FirebaseSessionsComponent.Builder appContext2 = builder.appContext((Context) obj);
        Object obj2 = componentContainer.get(backgroundDispatcher);
        Intrinsics.checkNotNullExpressionValue(obj2, "container[backgroundDispatcher]");
        FirebaseSessionsComponent.Builder backgroundDispatcher2 = appContext2.backgroundDispatcher((CoroutineContext) obj2);
        Object obj3 = componentContainer.get(blockingDispatcher);
        Intrinsics.checkNotNullExpressionValue(obj3, "container[blockingDispatcher]");
        FirebaseSessionsComponent.Builder blockingDispatcher2 = backgroundDispatcher2.blockingDispatcher((CoroutineContext) obj3);
        Object obj4 = componentContainer.get(firebaseApp);
        Intrinsics.checkNotNullExpressionValue(obj4, "container[firebaseApp]");
        FirebaseSessionsComponent.Builder firebaseApp2 = blockingDispatcher2.firebaseApp((FirebaseApp) obj4);
        Object obj5 = componentContainer.get(firebaseInstallationsApi);
        Intrinsics.checkNotNullExpressionValue(obj5, "container[firebaseInstallationsApi]");
        FirebaseSessionsComponent.Builder firebaseInstallationsApi2 = firebaseApp2.firebaseInstallationsApi((FirebaseInstallationsApi) obj5);
        Provider<TransportFactory> provider = componentContainer.getProvider(transportFactory);
        Intrinsics.checkNotNullExpressionValue(provider, "container.getProvider(transportFactory)");
        return firebaseInstallationsApi2.transportFactoryProvider(provider).build();
    }

    @NotNull
    public List<Component<? extends Object>> getComponents() {
        return CollectionsKt.t(Component.builder(FirebaseSessions.class).name(LIBRARY_NAME).add(Dependency.required((Qualified<?>) firebaseSessionsComponent)).factory(new d(8)).eagerInDefaultApp().build(), Component.builder(FirebaseSessionsComponent.class).name("fire-sessions-component").add(Dependency.required((Qualified<?>) appContext)).add(Dependency.required((Qualified<?>) backgroundDispatcher)).add(Dependency.required((Qualified<?>) blockingDispatcher)).add(Dependency.required((Qualified<?>) firebaseApp)).add(Dependency.required((Qualified<?>) firebaseInstallationsApi)).add(Dependency.requiredProvider((Qualified<?>) transportFactory)).factory(new d(9)).build(), LibraryVersionComponent.create(LIBRARY_NAME, BuildConfig.VERSION_NAME));
    }
}
