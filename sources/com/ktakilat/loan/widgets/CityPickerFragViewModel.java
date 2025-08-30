package com.ktakilat.loan.widgets;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ktakilat/loan/widgets/CityPickerFragViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CityPickerFragViewModel extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f617a = LazyKt.b(new q0(2));
    public final Lazy b = LazyKt.b(new q0(3));
    public final Lazy c = LazyKt.b(new q0(4));
    public final Lazy d = LazyKt.b(new q0(5));

    public final MutableLiveData a() {
        return (MutableLiveData) this.c.getValue();
    }

    public final MutableLiveData b() {
        return (MutableLiveData) this.b.getValue();
    }
}
