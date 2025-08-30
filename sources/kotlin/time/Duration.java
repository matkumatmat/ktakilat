package kotlin.time;

import androidx.core.location.LocationRequestCompat;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.http2.Http2Connection;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;

@JvmInline
@SinceKotlin(version = "1.6")
@SourceDebugExtension({"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1059:1\n38#1:1060\n38#1:1061\n38#1:1062\n38#1:1063\n38#1:1064\n501#1:1065\n518#1:1073\n170#2,6:1066\n1#3:1072\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n*L\n39#1:1060\n40#1:1061\n275#1:1062\n295#1:1063\n479#1:1064\n728#1:1065\n819#1:1073\n770#1:1066,6\n*E\n"})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b@\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003\u0001\u0004\u0001\u00020\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/time/Duration;", "", "d", "Companion", "rawValue", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@WasExperimental(markerClass = {ExperimentalTime.class})
public final class Duration implements Comparable<Duration> {
    @NotNull
    public static final Companion d = new Companion((DefaultConstructorMarker) null);
    public static final long e = DurationKt.a(4611686018427387903L);
    public static final long f = DurationKt.a(-4611686018427387903L);
    public final long c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        int i = DurationJvmKt.f757a;
    }

    public /* synthetic */ Duration(long j) {
        this.c = j;
    }

    public static final long b(long j, long j2) {
        long j3 = (long) 1000000;
        long j4 = j2 / j3;
        long j5 = j + j4;
        if (-4611686018426L > j5 || j5 >= 4611686018427L) {
            return DurationKt.a(RangesKt.a(j5, -4611686018427387903L, 4611686018427387903L));
        }
        return DurationKt.b((j5 * j3) + (j2 - (j4 * j3)));
    }

    public static final void c(int i, int i2, int i3, String str, StringBuilder sb) {
        sb.append(i);
        if (i2 != 0) {
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            String x = StringsKt.x(i3, String.valueOf(i2));
            int i4 = -1;
            int length = x.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (x.charAt(length) != '0') {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (i6 < 3) {
                sb.append(x, 0, i6);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            } else {
                sb.append(x, 0, ((i4 + 3) / 3) * 3);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            }
        }
        sb.append(str);
    }

    public static int d(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
            if (i < 0) {
                return -1;
            }
            return i == 0 ? 0 : 1;
        }
        int i2 = (((int) j) & 1) - (((int) j2) & 1);
        return j < 0 ? -i2 : i2;
    }

    public static final boolean e(long j) {
        if (j == e || j == f) {
            return true;
        }
        return false;
    }

    public static final long f(long j, long j2) {
        if (e(j)) {
            if (!e(j2) || (j2 ^ j) >= 0) {
                return j;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        } else if (e(j2)) {
            return j2;
        } else {
            int i = ((int) j) & 1;
            if (i == (((int) j2) & 1)) {
                long j3 = (j >> 1) + (j2 >> 1);
                if (i == 0) {
                    if (-4611686018426999999L > j3 || j3 >= 4611686018427000000L) {
                        return DurationKt.a(j3 / ((long) 1000000));
                    }
                    return DurationKt.b(j3);
                } else if (-4611686018426L > j3 || j3 >= 4611686018427L) {
                    return DurationKt.a(RangesKt.a(j3, -4611686018427387903L, 4611686018427387903L));
                } else {
                    return DurationKt.b(j3 * ((long) 1000000));
                }
            } else if (i == 1) {
                return b(j >> 1, j2 >> 1);
            } else {
                return b(j2 >> 1, j >> 1);
            }
        }
    }

    public static final long g(long j, DurationUnit durationUnit) {
        DurationUnit durationUnit2;
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        if (j == e) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        if (j == f) {
            return Long.MIN_VALUE;
        }
        long j2 = j >> 1;
        if ((((int) j) & 1) == 0) {
            durationUnit2 = DurationUnit.NANOSECONDS;
        } else {
            durationUnit2 = DurationUnit.MILLISECONDS;
        }
        return DurationUnitKt__DurationUnitJvmKt.a(j2, durationUnit2, durationUnit);
    }

    public static String h(long j) {
        boolean z;
        long j2;
        int i;
        int i2;
        int i3;
        long j3;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i5;
        int i6 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i6 == 0) {
            return "0s";
        }
        if (j == e) {
            return "Infinity";
        }
        if (j == f) {
            return "-Infinity";
        }
        if (i6 < 0) {
            z = true;
        } else {
            z = false;
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append('-');
        }
        if (i6 < 0) {
            j2 = i(j);
        } else {
            j2 = j;
        }
        long g = g(j2, DurationUnit.DAYS);
        if (e(j2)) {
            i = 0;
        } else {
            i = (int) (g(j2, DurationUnit.HOURS) % ((long) 24));
        }
        if (e(j2)) {
            i2 = 0;
        } else {
            i2 = (int) (g(j2, DurationUnit.MINUTES) % ((long) 60));
        }
        if (e(j2)) {
            i3 = 0;
        } else {
            i3 = (int) (g(j2, DurationUnit.SECONDS) % ((long) 60));
        }
        if (e(j2)) {
            i4 = 0;
        } else {
            if ((((int) j2) & 1) == 1) {
                j3 = ((j2 >> 1) % ((long) 1000)) * ((long) 1000000);
            } else {
                j3 = (j2 >> 1) % ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS);
            }
            i4 = (int) j3;
        }
        if (g != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (i != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (i2 != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (i3 == 0 && i4 == 0) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (z2) {
            sb.append(g);
            sb.append('d');
            i5 = 1;
        } else {
            i5 = 0;
        }
        if (z3 || (z2 && (z4 || z5))) {
            int i7 = i5 + 1;
            if (i5 > 0) {
                sb.append(' ');
            }
            sb.append(i);
            sb.append('h');
            i5 = i7;
        }
        if (z4 || (z5 && (z3 || z2))) {
            int i8 = i5 + 1;
            if (i5 > 0) {
                sb.append(' ');
            }
            sb.append(i2);
            sb.append('m');
            i5 = i8;
        }
        if (z5) {
            int i9 = i5 + 1;
            if (i5 > 0) {
                sb.append(' ');
            }
            if (i3 != 0 || z2 || z3 || z4) {
                c(i3, i4, 9, "s", sb);
            } else if (i4 >= 1000000) {
                c(i4 / 1000000, i4 % 1000000, 6, "ms", sb);
            } else if (i4 >= 1000) {
                c(i4 / 1000, i4 % 1000, 3, "us", sb);
            } else {
                sb.append(i4);
                sb.append("ns");
            }
            i5 = i9;
        }
        if (z && i5 > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }

    public static final long i(long j) {
        long j2 = ((-(j >> 1)) << 1) + ((long) (((int) j) & 1));
        int i = DurationJvmKt.f757a;
        return j2;
    }

    public final int compareTo(Object obj) {
        return d(this.c, ((Duration) obj).c);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Duration)) {
            return false;
        }
        if (this.c != ((Duration) obj).c) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long j = this.c;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return h(this.c);
    }
}
