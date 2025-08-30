package defpackage;

import com.google.android.material.color.utilities.DynamicColor;
import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.color.utilities.TemperatureCache;
import com.google.android.material.color.utilities.TonalPalette;
import java.util.List;
import java.util.function.Function;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.Streams;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableFunction;
import org.apache.commons.lang3.stream.Streams;

/* renamed from: z5  reason: default package */
public final /* synthetic */ class z5 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f370a;
    public final /* synthetic */ Object b;

    public /* synthetic */ z5(Object obj, int i) {
        this.f370a = i;
        this.b = obj;
    }

    public final Object apply(Object obj) {
        switch (this.f370a) {
            case 0:
                return DynamicColor.lambda$fromArgb$0((TonalPalette) this.b, (DynamicScheme) obj);
            case 1:
                return Double.valueOf(((Hct) this.b).getTone());
            case 2:
                return DynamicColor.lambda$getTone$11((DynamicColor) this.b, (DynamicScheme) obj);
            case 3:
                return Failable.apply((FailableFunction) this.b, obj);
            case 4:
                return Functions.apply((Functions.FailableFunction) this.b, obj);
            case 5:
                return ((Streams.ArrayCollector) this.b).lambda$finisher$1((List) obj);
            case 6:
                return ((Streams.ArrayCollector) this.b).lambda$finisher$1((List) obj);
            default:
                return ((TemperatureCache) this.b).lambda$getHctsByTemp$0((Hct) obj);
        }
    }
}
