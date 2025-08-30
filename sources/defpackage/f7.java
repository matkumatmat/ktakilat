package defpackage;

import com.google.android.gms.maps.model.LatLng;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.utils.location.LocationUtils;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import org.apache.commons.lang3.function.FailableDoubleBinaryOperator;
import org.apache.commons.lang3.function.FailableDoubleSupplier;

/* renamed from: f7  reason: default package */
public final /* synthetic */ class f7 implements FailableDoubleSupplier, ObservableOnSubscribe {
    public final /* synthetic */ double c;
    public final /* synthetic */ double d;
    public final /* synthetic */ Object e;

    public /* synthetic */ f7(Object obj, double d2, double d3) {
        this.e = obj;
        this.c = d2;
        this.d = d3;
    }

    public void d(ObservableEmitter observableEmitter) {
        observableEmitter.onNext(LocationUtils.a((BaseActivity) this.e, new LatLng(this.c, this.d)));
        observableEmitter.onComplete();
    }

    public double getAsDouble() {
        return ((FailableDoubleBinaryOperator) this.e).applyAsDouble(this.c, this.d);
    }
}
