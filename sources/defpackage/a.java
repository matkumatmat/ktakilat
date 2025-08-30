package defpackage;

import android.widget.Toast;
import coil3.disk.DiskLruCache;
import com.ktakilat.loan.service.sms.SmsVerificationService;
import com.ktakilat.loan.verify_otp.BaseVerifyOtpActivity;
import com.ktakilat.loan.verify_otp.BaseVerifyOtpSms;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.AbstractCollection;
import kotlin.collections.AbstractMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KTypeProjection;
import kotlin.text.MatcherMatchResult$groups$1;
import kotlinx.coroutines.internal.ExceptionsConstructorKt;

/* renamed from: a  reason: default package */
public final /* synthetic */ class a implements Function1 {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ a(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final Object invoke(Object obj) {
        String str;
        Object obj2;
        boolean z = true;
        Throwable th = null;
        Object obj3 = this.d;
        switch (this.c) {
            case 0:
                if (obj == ((AbstractCollection) obj3)) {
                    return "(this Collection)";
                }
                return String.valueOf(obj);
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                AbstractMap.Companion companion = AbstractMap.e;
                Intrinsics.checkNotNullParameter(entry, "it");
                AbstractMap abstractMap = (AbstractMap) obj3;
                abstractMap.getClass();
                StringBuilder sb = new StringBuilder();
                Object key = entry.getKey();
                String str2 = "(this Map)";
                if (key == abstractMap) {
                    str = str2;
                } else {
                    str = String.valueOf(key);
                }
                sb.append(str);
                sb.append('=');
                Object value = entry.getValue();
                if (value != abstractMap) {
                    str2 = String.valueOf(value);
                }
                sb.append(str2);
                return sb.toString();
            case 2:
                String str3 = (String) obj;
                BaseVerifyOtpSms baseVerifyOtpSms = BaseVerifyOtpActivity.s;
                BaseVerifyOtpActivity baseVerifyOtpActivity = (BaseVerifyOtpActivity) obj3;
                baseVerifyOtpActivity.getClass();
                if (str3 != null) {
                    Toast.makeText(baseVerifyOtpActivity, str3, 0).show();
                }
                return null;
            case 3:
                IOException iOException = (IOException) obj;
                ((DiskLruCache) obj3).o = true;
                return Unit.f696a;
            case 4:
                Function1 function1 = (Function1) obj3;
                Throwable th2 = (Throwable) obj;
                int i = ExceptionsConstructorKt.f796a;
                try {
                    Result.Companion companion2 = Result.Companion;
                    Throwable th3 = (Throwable) function1.invoke(th2);
                    if (!Intrinsics.a(th2.getMessage(), th3.getMessage()) && !Intrinsics.a(th3.getMessage(), th2.toString())) {
                        th3 = null;
                    }
                    obj2 = Result.m16constructorimpl(th3);
                } catch (Throwable th4) {
                    Result.Companion companion3 = Result.Companion;
                    obj2 = Result.m16constructorimpl(ResultKt.a(th4));
                }
                if (!Result.m21isFailureimpl(obj2)) {
                    th = obj2;
                }
                return th;
            case 5:
                return ((MatcherMatchResult$groups$1) obj3).a(((Integer) obj).intValue());
            case 6:
                Intrinsics.checkNotNullParameter(obj, "it");
                return ((Function0) obj3).invoke();
            case 7:
                Ref.BooleanRef booleanRef = (Ref.BooleanRef) obj3;
                if (!booleanRef.element && Intrinsics.a(obj, (Object) null)) {
                    booleanRef.element = true;
                    z = false;
                }
                return Boolean.valueOf(z);
            case 8:
                Void voidR = (Void) obj;
                SmsVerificationService.SmsBrReceiver smsBrReceiver = ((SmsVerificationService) obj3).d;
                if (smsBrReceiver != null) {
                    smsBrReceiver.f543a.postDelayed(new ze(SmsVerificationService.this, 0), 65000);
                }
                return Unit.f696a;
            case 9:
                String str4 = (String) obj;
                Intrinsics.checkNotNullParameter(str4, "it");
                ((ArrayList) obj3).add(str4);
                return Unit.f696a;
            default:
                KTypeProjection kTypeProjection = (KTypeProjection) obj;
                TypeReference.Companion companion4 = TypeReference.e;
                Intrinsics.checkNotNullParameter(kTypeProjection, "it");
                ((TypeReference) obj3).getClass();
                kTypeProjection.getClass();
                return "*";
        }
    }
}
