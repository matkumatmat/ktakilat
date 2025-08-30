package com.ktakilat.loan.new_pwd;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$factoryPromise$2"}, k = 3, mv = {2, 1, 0}, xi = 48)
public final class NewPasswordActivity$special$$inlined$viewModels$default$1 extends Lambda implements Function0<ViewModelProvider.Factory> {
    public final /* synthetic */ ComponentActivity c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewPasswordActivity$special$$inlined$viewModels$default$1(ComponentActivity componentActivity) {
        super(0);
        this.c = componentActivity;
    }

    public final ViewModelProvider.Factory invoke() {
        return this.c.getDefaultViewModelProviderFactory();
    }
}
