package defpackage;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import coil3.EventListener;
import com.google.android.datatransport.Transformer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRegistrarProcessor;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.ktakilat.loan.normal_ui.GoogleMapActivity;
import com.ktakilat.loan.widgets.CityPickerActivity;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableBiConsumer;
import org.apache.commons.lang3.function.FailableBiFunction;
import org.apache.commons.lang3.function.FailableBiPredicate;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableDoubleConsumer;
import org.apache.commons.lang3.function.FailableDoubleFunction;
import org.apache.commons.lang3.function.FailableDoublePredicate;
import org.apache.commons.lang3.function.FailableDoubleToIntFunction;
import org.apache.commons.lang3.function.FailableDoubleToLongFunction;
import org.apache.commons.lang3.function.FailableDoubleUnaryOperator;
import org.apache.commons.lang3.function.FailableFunction;
import org.apache.commons.lang3.function.FailableIntConsumer;
import org.apache.commons.lang3.function.FailableIntFunction;
import org.apache.commons.lang3.function.FailableIntPredicate;
import org.apache.commons.lang3.function.FailableIntToDoubleFunction;
import org.apache.commons.lang3.function.FailableIntToLongFunction;
import org.apache.commons.lang3.function.FailableIntUnaryOperator;
import org.apache.commons.lang3.function.FailableLongConsumer;

/* renamed from: x2  reason: default package */
public final /* synthetic */ class x2 implements OnApplyWindowInsetsListener, GoogleMapActivity.LocationPermissionCallback, ComponentRegistrarProcessor, Transformer, EventListener.Factory, FailableConsumer, FailableBiConsumer, FailableBiFunction, FailableBiPredicate, FailableDoubleConsumer, FailableDoubleFunction, FailableDoublePredicate, FailableDoubleToIntFunction, FailableDoubleToLongFunction, FailableDoubleUnaryOperator, FailableFunction, FailableIntConsumer, FailableIntFunction, FailableIntPredicate, FailableIntToDoubleFunction, FailableIntToLongFunction, FailableIntUnaryOperator, FailableLongConsumer {
    public final /* synthetic */ int c;

    public /* synthetic */ x2(int i) {
        this.c = i;
    }

    public void accept(double d) {
        n7.c(d);
    }

    public /* synthetic */ FailableBiPredicate and(FailableBiPredicate failableBiPredicate) {
        int i = this.c;
        return l7.a(this, failableBiPredicate);
    }

    public /* synthetic */ FailableBiConsumer andThen(FailableBiConsumer failableBiConsumer) {
        return i7.a(this, failableBiConsumer);
    }

    public Object apply(double d) {
        return o7.a(d);
    }

    public double applyAsDouble(double d) {
        switch (this.c) {
            case 17:
                return u7.f(d);
            default:
                return u7.g(d);
        }
    }

    public int applyAsInt(double d) {
        return r7.a(d);
    }

    public int applyAsLong(double d) {
        return s7.a(d);
    }

    public /* synthetic */ FailableDoubleUnaryOperator compose(FailableDoubleUnaryOperator failableDoubleUnaryOperator) {
        int i = this.c;
        return u7.b(this, failableDoubleUnaryOperator);
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        int i = CityPickerActivity.g;
        Intrinsics.checkNotNullParameter(view, "v");
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        return WindowInsetsCompat.CONSUMED;
    }

    public /* synthetic */ FailableBiPredicate or(FailableBiPredicate failableBiPredicate) {
        int i = this.c;
        return l7.c(this, failableBiPredicate);
    }

    public List processRegistrar(ComponentRegistrar componentRegistrar) {
        return componentRegistrar.getComponents();
    }

    public boolean test(double d) {
        switch (this.c) {
            case 13:
                return q7.h(d);
            default:
                return q7.i(d);
        }
    }

    public void accept(int i) {
        x7.c(i);
    }

    public /* synthetic */ FailableDoublePredicate and(FailableDoublePredicate failableDoublePredicate) {
        int i = this.c;
        return q7.a(this, failableDoublePredicate);
    }

    public Object apply(int i) {
        return y7.a(i);
    }

    public double applyAsDouble(int i) {
        return b8.a(i);
    }

    public int applyAsInt(int i) {
        switch (this.c) {
            case 27:
                return e8.g(i);
            default:
                return e8.f(i);
        }
    }

    public long applyAsLong(int i) {
        return c8.a(i);
    }

    public /* synthetic */ FailableFunction compose(FailableFunction failableFunction) {
        int i = this.c;
        return w7.b(this, failableFunction);
    }

    public /* synthetic */ FailableDoublePredicate or(FailableDoublePredicate failableDoublePredicate) {
        int i = this.c;
        return q7.c(this, failableDoublePredicate);
    }

    public boolean test(int i) {
        switch (this.c) {
            case 23:
                return a8.h(i);
            default:
                return a8.i(i);
        }
    }

    public void accept(long j) {
        f8.c(j);
    }

    public /* synthetic */ FailableIntPredicate and(FailableIntPredicate failableIntPredicate) {
        int i = this.c;
        return a8.a(this, failableIntPredicate);
    }

    public /* synthetic */ FailableConsumer andThen(FailableConsumer failableConsumer) {
        int i = this.c;
        return m7.a(this, failableConsumer);
    }

    public Object apply(Object obj) {
        switch (this.c) {
            case 3:
                return DataTransportCrashlyticsReportSender.TRANSFORM.reportToJson((CrashlyticsReport) obj).getBytes(Charset.forName(CharEncoding.UTF_8));
            case 19:
                return w7.g(obj);
            default:
                return w7.f(obj);
        }
    }

    public /* synthetic */ FailableIntUnaryOperator compose(FailableIntUnaryOperator failableIntUnaryOperator) {
        int i = this.c;
        return e8.b(this, failableIntUnaryOperator);
    }

    public /* synthetic */ FailableIntPredicate or(FailableIntPredicate failableIntPredicate) {
        int i = this.c;
        return a8.c(this, failableIntPredicate);
    }

    public boolean test(Object obj, Object obj2) {
        switch (this.c) {
            case 8:
                return l7.h(obj, obj2);
            default:
                return l7.i(obj, obj2);
        }
    }

    public void accept(Object obj) {
        switch (this.c) {
            case 5:
                Failable.rethrow((Throwable) obj);
                return;
            default:
                m7.c(obj);
                return;
        }
    }

    public /* synthetic */ FailableDoubleConsumer andThen(FailableDoubleConsumer failableDoubleConsumer) {
        return n7.a(this, failableDoubleConsumer);
    }

    public Object apply(Object obj, Object obj2) {
        return j7.c(obj, obj2);
    }

    public void accept(Object obj, Object obj2) {
        i7.c(obj, obj2);
    }

    public /* synthetic */ FailableDoubleUnaryOperator andThen(FailableDoubleUnaryOperator failableDoubleUnaryOperator) {
        int i = this.c;
        return u7.a(this, failableDoubleUnaryOperator);
    }

    public /* synthetic */ FailableIntConsumer andThen(FailableIntConsumer failableIntConsumer) {
        return x7.a(this, failableIntConsumer);
    }

    public /* synthetic */ FailableIntUnaryOperator andThen(FailableIntUnaryOperator failableIntUnaryOperator) {
        int i = this.c;
        return e8.a(this, failableIntUnaryOperator);
    }

    public /* synthetic */ FailableLongConsumer andThen(FailableLongConsumer failableLongConsumer) {
        return f8.a(this, failableLongConsumer);
    }
}
