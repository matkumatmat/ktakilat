package kotlin.text;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.9")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00022\u00020\u0001:\u0004\u0003\u0004\u0005\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/text/HexFormat;", "", "d", "BytesHexFormat", "NumberHexFormat", "Builder", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@ExperimentalStdlibApi
public final class HexFormat {
    @NotNull
    public static final Companion d = new Companion((DefaultConstructorMarker) null);
    public static final HexFormat e;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f747a;
    public final BytesHexFormat b;
    public final NumberHexFormat c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0001¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/text/HexFormat$Builder;", "", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        @PublishedApi
        public Builder() {
            HexFormat.d.getClass();
            HexFormat.e.getClass();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/text/HexFormat$BytesHexFormat;", "", "a", "Builder", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BytesHexFormat {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final Companion f748a = new Companion((DefaultConstructorMarker) null);
        public static final BytesHexFormat b;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/text/HexFormat$BytesHexFormat$Builder;", "", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Builder {
            public Builder() {
                Companion companion = BytesHexFormat.f748a;
                companion.getClass();
                BytesHexFormat bytesHexFormat = BytesHexFormat.b;
                bytesHexFormat.getClass();
                companion.getClass();
                bytesHexFormat.getClass();
                companion.getClass();
                bytesHexFormat.getClass();
                companion.getClass();
                bytesHexFormat.getClass();
                companion.getClass();
                bytesHexFormat.getClass();
                companion.getClass();
                bytesHexFormat.getClass();
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/text/HexFormat$BytesHexFormat$Companion;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARNING: type inference failed for: r0v1, types: [java.lang.Object, kotlin.text.HexFormat$BytesHexFormat] */
        static {
            Intrinsics.checkNotNullParameter("  ", "groupSeparator");
            Intrinsics.checkNotNullParameter("", "byteSeparator");
            Intrinsics.checkNotNullParameter("", "bytePrefix");
            Intrinsics.checkNotNullParameter("", "byteSuffix");
            ? obj = new Object();
            if (!HexFormatKt.a("  ") && !HexFormatKt.a("") && !HexFormatKt.a("")) {
                HexFormatKt.a("");
            }
            b = obj;
        }

        public final void a(StringBuilder sb, String str) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            Intrinsics.checkNotNullParameter(str, "indent");
            sb.append(str);
            sb.append("bytesPerLine = ");
            sb.append(Integer.MAX_VALUE);
            sb.append(",");
            sb.append(10);
            sb.append(str);
            sb.append("bytesPerGroup = ");
            sb.append(Integer.MAX_VALUE);
            sb.append(",");
            sb.append(10);
            sb.append(str);
            sb.append("groupSeparator = \"");
            sb.append("  ");
            sb.append("\",");
            sb.append(10);
            sb.append(str);
            sb.append("byteSeparator = \"");
            sb.append("");
            sb.append("\",");
            sb.append(10);
            sb.append(str);
            sb.append("bytePrefix = \"");
            sb.append("");
            sb.append("\",");
            sb.append(10);
            sb.append(str);
            sb.append("byteSuffix = \"");
            sb.append("");
            sb.append("\"");
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BytesHexFormat(\n");
            a(sb, "    ");
            sb.append(10);
            sb.append(")");
            return sb.toString();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/text/HexFormat$Companion;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/text/HexFormat$NumberHexFormat;", "", "a", "Builder", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NumberHexFormat {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final Companion f749a = new Companion((DefaultConstructorMarker) null);
        public static final NumberHexFormat b;

        @SourceDebugExtension({"SMAP\nHexFormat.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HexFormat.kt\nkotlin/text/HexFormat$NumberHexFormat$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,844:1\n1#2:845\n*E\n"})
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/text/HexFormat$NumberHexFormat$Builder;", "", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Builder {
            public Builder() {
                Companion companion = NumberHexFormat.f749a;
                companion.getClass();
                NumberHexFormat numberHexFormat = NumberHexFormat.b;
                numberHexFormat.getClass();
                companion.getClass();
                numberHexFormat.getClass();
                companion.getClass();
                numberHexFormat.getClass();
                companion.getClass();
                numberHexFormat.getClass();
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/text/HexFormat$NumberHexFormat$Companion;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARNING: type inference failed for: r0v1, types: [java.lang.Object, kotlin.text.HexFormat$NumberHexFormat] */
        static {
            Intrinsics.checkNotNullParameter("", "prefix");
            Intrinsics.checkNotNullParameter("", "suffix");
            ? obj = new Object();
            if (!HexFormatKt.a("")) {
                HexFormatKt.a("");
            }
            b = obj;
        }

        public final void a(StringBuilder sb, String str) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            Intrinsics.checkNotNullParameter(str, "indent");
            sb.append(str);
            sb.append("prefix = \"");
            sb.append("");
            sb.append("\",");
            sb.append(10);
            sb.append(str);
            sb.append("suffix = \"");
            sb.append("");
            sb.append("\",");
            sb.append(10);
            sb.append(str);
            sb.append("removeLeadingZeros = ");
            sb.append(false);
            sb.append(',');
            sb.append(10);
            sb.append(str);
            sb.append("minLength = ");
            sb.append(1);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NumberHexFormat(\n");
            a(sb, "    ");
            sb.append(10);
            sb.append(")");
            return sb.toString();
        }
    }

    static {
        BytesHexFormat.Companion companion = BytesHexFormat.f748a;
        companion.getClass();
        BytesHexFormat bytesHexFormat = BytesHexFormat.b;
        NumberHexFormat.Companion companion2 = NumberHexFormat.f749a;
        companion2.getClass();
        NumberHexFormat numberHexFormat = NumberHexFormat.b;
        e = new HexFormat(false, bytesHexFormat, numberHexFormat);
        companion.getClass();
        companion2.getClass();
        new HexFormat(true, bytesHexFormat, numberHexFormat);
    }

    public HexFormat(boolean z, BytesHexFormat bytesHexFormat, NumberHexFormat numberHexFormat) {
        Intrinsics.checkNotNullParameter(bytesHexFormat, "bytes");
        Intrinsics.checkNotNullParameter(numberHexFormat, "number");
        this.f747a = z;
        this.b = bytesHexFormat;
        this.c = numberHexFormat;
    }

    public final String toString() {
        StringBuilder v = ba.v("HexFormat(\n    upperCase = ");
        v.append(this.f747a);
        v.append(",\n    bytes = BytesHexFormat(\n");
        this.b.a(v, "        ");
        v.append(10);
        v.append("    ),");
        v.append(10);
        v.append("    number = NumberHexFormat(");
        v.append(10);
        this.c.a(v, "        ");
        v.append(10);
        v.append("    )");
        v.append(10);
        v.append(")");
        return v.toString();
    }
}
