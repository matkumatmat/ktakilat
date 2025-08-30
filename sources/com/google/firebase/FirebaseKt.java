package com.google.firebase;

import android.content.Context;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.components.Component;
import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\rH\b\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u001a\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006\u001a\"\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"app", "Lcom/google/firebase/FirebaseApp;", "Lcom/google/firebase/Firebase;", "getApp", "(Lcom/google/firebase/Firebase;)Lcom/google/firebase/FirebaseApp;", "options", "Lcom/google/firebase/FirebaseOptions;", "getOptions", "(Lcom/google/firebase/Firebase;)Lcom/google/firebase/FirebaseOptions;", "coroutineDispatcher", "Lcom/google/firebase/components/Component;", "Lkotlinx/coroutines/CoroutineDispatcher;", "T", "", "name", "", "initialize", "context", "Landroid/content/Context;", "com.google.firebase-firebase-common"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FirebaseKt {
    @NotNull
    public static final FirebaseApp app(@NotNull Firebase firebase2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        FirebaseApp instance = FirebaseApp.getInstance(str);
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(name)");
        return instance;
    }

    private static final <T extends Annotation> Component<CoroutineDispatcher> coroutineDispatcher() {
        Intrinsics.j();
        throw null;
    }

    @NotNull
    public static final FirebaseApp getApp(@NotNull Firebase firebase2) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        FirebaseApp instance = FirebaseApp.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    @NotNull
    public static final FirebaseOptions getOptions(@NotNull Firebase firebase2) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        FirebaseOptions options = getApp(Firebase.INSTANCE).getOptions();
        Intrinsics.checkNotNullExpressionValue(options, "Firebase.app.options");
        return options;
    }

    @Nullable
    public static final FirebaseApp initialize(@NotNull Firebase firebase2, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
        return FirebaseApp.initializeApp(context);
    }

    @NotNull
    public static final FirebaseApp initialize(@NotNull Firebase firebase2, @NotNull Context context, @NotNull FirebaseOptions firebaseOptions) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
        Intrinsics.checkNotNullParameter(firebaseOptions, "options");
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, firebaseOptions);
        Intrinsics.checkNotNullExpressionValue(initializeApp, "initializeApp(context, options)");
        return initializeApp;
    }

    @NotNull
    public static final FirebaseApp initialize(@NotNull Firebase firebase2, @NotNull Context context, @NotNull FirebaseOptions firebaseOptions, @NotNull String str) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
        Intrinsics.checkNotNullParameter(firebaseOptions, "options");
        Intrinsics.checkNotNullParameter(str, "name");
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, firebaseOptions, str);
        Intrinsics.checkNotNullExpressionValue(initializeApp, "initializeApp(context, options, name)");
        return initializeApp;
    }
}
