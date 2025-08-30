package defpackage;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import com.facebook.applinks.AppLinkData;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* renamed from: hh  reason: default package */
public abstract /* synthetic */ class hh {
    static {
        ViewModelProvider.Factory.Companion companion = ViewModelProvider.Factory.Companion;
    }

    public static ViewModel a(ViewModelProvider.Factory factory, Class cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        return ViewModelProviders.INSTANCE.unsupportedCreateViewModel$lifecycle_viewmodel_release();
    }

    public static ViewModel b(ViewModelProvider.Factory factory, Class cls, CreationExtras creationExtras) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        Intrinsics.checkNotNullParameter(creationExtras, AppLinkData.ARGUMENTS_EXTRAS_KEY);
        return factory.create(cls);
    }

    public static ViewModel c(ViewModelProvider.Factory factory, KClass kClass, CreationExtras creationExtras) {
        Intrinsics.checkNotNullParameter(kClass, "modelClass");
        Intrinsics.checkNotNullParameter(creationExtras, AppLinkData.ARGUMENTS_EXTRAS_KEY);
        return factory.create(JvmClassMappingKt.a(kClass), creationExtras);
    }

    public static ViewModelProvider.Factory d(ViewModelInitializer... viewModelInitializerArr) {
        return ViewModelProvider.Factory.Companion.from(viewModelInitializerArr);
    }
}
