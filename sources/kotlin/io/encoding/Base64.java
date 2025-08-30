package kotlin.io.encoding;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.8")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0017\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/io/encoding/Base64;", "", "a", "PaddingOption", "Default", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@ExperimentalEncodingApi
public class Base64 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final Default f713a = new Default((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0000XT¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004¨\u0006\r"}, d2 = {"Lkotlin/io/encoding/Base64$Default;", "Lkotlin/io/encoding/Base64;", "", "bitsPerByte", "I", "bitsPerSymbol", "bytesPerGroup", "symbolsPerGroup", "", "padSymbol", "B", "mimeLineLength", "mimeGroupsPerLine", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Default extends Base64 {
        public Default(DefaultConstructorMarker defaultConstructorMarker) {
            super(false, false, PaddingOption.PRESENT);
        }
    }

    @SinceKotlin(version = "2.0")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/io/encoding/Base64$PaddingOption;", "", "PRESENT", "ABSENT", "PRESENT_OPTIONAL", "ABSENT_OPTIONAL", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum PaddingOption {
        ;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: kotlin.io.encoding.Base64$PaddingOption[]} */
        /* JADX WARNING: type inference failed for: r4v0, types: [kotlin.io.encoding.Base64$PaddingOption, java.lang.Enum] */
        /* JADX WARNING: type inference failed for: r5v1, types: [kotlin.io.encoding.Base64$PaddingOption, java.lang.Enum] */
        /* JADX WARNING: type inference failed for: r6v1, types: [kotlin.io.encoding.Base64$PaddingOption, java.lang.Enum] */
        /* JADX WARNING: type inference failed for: r7v1, types: [kotlin.io.encoding.Base64$PaddingOption, java.lang.Enum] */
        /* JADX WARNING: Multi-variable type inference failed */
        static {
            /*
                r0 = 3
                r1 = 2
                r2 = 1
                r3 = 0
                kotlin.io.encoding.Base64$PaddingOption r4 = new kotlin.io.encoding.Base64$PaddingOption
                java.lang.String r5 = "PRESENT"
                r4.<init>(r5, r3)
                PRESENT = r4
                kotlin.io.encoding.Base64$PaddingOption r5 = new kotlin.io.encoding.Base64$PaddingOption
                java.lang.String r6 = "ABSENT"
                r5.<init>(r6, r2)
                ABSENT = r5
                kotlin.io.encoding.Base64$PaddingOption r6 = new kotlin.io.encoding.Base64$PaddingOption
                java.lang.String r7 = "PRESENT_OPTIONAL"
                r6.<init>(r7, r1)
                PRESENT_OPTIONAL = r6
                kotlin.io.encoding.Base64$PaddingOption r7 = new kotlin.io.encoding.Base64$PaddingOption
                java.lang.String r8 = "ABSENT_OPTIONAL"
                r7.<init>(r8, r0)
                ABSENT_OPTIONAL = r7
                r8 = 4
                kotlin.io.encoding.Base64$PaddingOption[] r8 = new kotlin.io.encoding.Base64.PaddingOption[r8]
                r8[r3] = r4
                r8[r2] = r5
                r8[r1] = r6
                r8[r0] = r7
                c = r8
                kotlin.enums.EnumEntries r0 = kotlin.enums.EnumEntriesKt.a(r8)
                d = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.io.encoding.Base64.PaddingOption.<clinit>():void");
        }

        @NotNull
        public static EnumEntries<PaddingOption> getEntries() {
            return d;
        }
    }

    static {
        PaddingOption paddingOption = PaddingOption.PRESENT;
        new Base64(true, false, paddingOption);
        new Base64(false, true, paddingOption);
    }

    public Base64(boolean z, boolean z2, PaddingOption paddingOption) {
        if (z && z2) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }
}
