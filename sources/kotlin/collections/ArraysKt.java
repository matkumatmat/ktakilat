package kotlin.collections;

import com.appsflyer.internal.AFc1tSDK;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"kotlin/collections/ArraysKt__ArraysJVMKt", "kotlin/collections/ArraysKt__ArraysKt", "kotlin/collections/ArraysKt___ArraysJvmKt", "kotlin/collections/ArraysKt___ArraysKt"}, k = 4, mv = {2, 1, 0}, xi = 49)
public final class ArraysKt extends ArraysKt___ArraysKt {
    public static Set A(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        int length = objArr.length;
        if (length == 0) {
            return EmptySet.INSTANCE;
        }
        if (length != 1) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.c(objArr.length));
            Intrinsics.checkNotNullParameter(objArr, "<this>");
            Intrinsics.checkNotNullParameter(linkedHashSet, "destination");
            for (Object add : objArr) {
                linkedHashSet.add(add);
            }
            return linkedHashSet;
        }
        Set singleton = Collections.singleton(objArr[0]);
        Intrinsics.checkNotNullExpressionValue(singleton, "singleton(...)");
        return singleton;
    }

    public static List c(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        List asList = Arrays.asList(objArr);
        Intrinsics.checkNotNullExpressionValue(asList, "asList(...)");
        return asList;
    }

    public static boolean d(byte b) {
        Intrinsics.checkNotNullParameter((Object) null, "<this>");
        q(b);
        throw null;
    }

    public static boolean e(int i) {
        Intrinsics.checkNotNullParameter((Object) null, "<this>");
        r(i);
        throw null;
    }

    public static boolean f(long j) {
        Intrinsics.checkNotNullParameter((Object) null, "<this>");
        s(j);
        throw null;
    }

    public static boolean g(short s) {
        Intrinsics.checkNotNullParameter((Object) null, "<this>");
        t(s);
        throw null;
    }

    public static boolean h(Object[] objArr, Object obj) {
        int i;
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        if (obj != null) {
            int length = objArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (obj.equals(objArr[i2])) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
        } else {
            int length2 = objArr.length;
            i = 0;
            while (true) {
                if (i >= length2) {
                    break;
                } else if (objArr[i] == null) {
                    break;
                } else {
                    i++;
                }
            }
        }
        i = -1;
        if (i >= 0) {
            return true;
        }
        return false;
    }

    public static void i(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(bArr2, "destination");
        System.arraycopy(bArr, i2, bArr2, i, i3 - i2);
    }

    public static void j(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(objArr2, "destination");
        System.arraycopy(objArr, i2, objArr2, i, i3 - i2);
    }

    public static byte[] k(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        ArraysKt__ArraysJVMKt.a(i2, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static Object[] l(int i, int i2, Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        ArraysKt__ArraysJVMKt.a(i2, objArr.length);
        Object[] copyOfRange = Arrays.copyOfRange(objArr, i, i2);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static void m(Object[] objArr, Symbol symbol, int i, int i2) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Arrays.fill(objArr, i, i2, symbol);
    }

    public static void n(int i, int[] iArr) {
        int length = iArr.length;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Arrays.fill(iArr, 0, length, i);
    }

    public static ArrayList p(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(arrayList, "destination");
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static int q(byte b) {
        Intrinsics.checkNotNullParameter((Object) null, "<this>");
        throw null;
    }

    public static int r(int i) {
        Intrinsics.checkNotNullParameter((Object) null, "<this>");
        throw null;
    }

    public static int s(long j) {
        Intrinsics.checkNotNullParameter((Object) null, "<this>");
        throw null;
    }

    public static int t(short s) {
        Intrinsics.checkNotNullParameter((Object) null, "<this>");
        throw null;
    }

    public static String v(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(", ", "separator");
        Intrinsics.checkNotNullParameter("", "prefix");
        Intrinsics.checkNotNullParameter("", "postfix");
        Intrinsics.checkNotNullParameter("...", "truncated");
        StringBuilder sb = new StringBuilder();
        ArraysKt___ArraysKt.b(objArr, sb, ", ", "", "", -1, "...", (Function1) null);
        return sb.toString();
    }

    public static char w(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static List x(Object[] objArr, AFc1tSDK.AnonymousClass1 r4) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(r4, "comparator");
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(r4, "comparator");
        if (objArr.length != 0) {
            objArr = Arrays.copyOf(objArr, objArr.length);
            Intrinsics.checkNotNullExpressionValue(objArr, "copyOf(...)");
            Intrinsics.checkNotNullParameter(objArr, "<this>");
            Intrinsics.checkNotNullParameter(r4, "comparator");
            if (objArr.length > 1) {
                Arrays.sort(objArr, r4);
            }
        }
        return c(objArr);
    }

    public static List y(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        int length = objArr.length;
        if (length == 0) {
            return EmptyList.INSTANCE;
        }
        if (length != 1) {
            return z(objArr);
        }
        return CollectionsKt.s(objArr[0]);
    }

    public static ArrayList z(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        return new ArrayList(new ArrayAsCollection(objArr, false));
    }
}
