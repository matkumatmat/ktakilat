package coil3.util;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcoil3/util/Logger;", "", "Level", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Logger {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcoil3/util/Logger$Level;", "", "Verbose", "Debug", "Info", "Warn", "Error", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public enum Level {
        ;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: coil3.util.Logger$Level[]} */
        /* JADX WARNING: type inference failed for: r5v0, types: [coil3.util.Logger$Level, java.lang.Enum] */
        /* JADX WARNING: type inference failed for: r6v1, types: [coil3.util.Logger$Level, java.lang.Enum] */
        /* JADX WARNING: type inference failed for: r7v1, types: [coil3.util.Logger$Level, java.lang.Enum] */
        /* JADX WARNING: type inference failed for: r8v1, types: [coil3.util.Logger$Level, java.lang.Enum] */
        /* JADX WARNING: type inference failed for: r9v1, types: [coil3.util.Logger$Level, java.lang.Enum] */
        /* JADX WARNING: Multi-variable type inference failed */
        static {
            /*
                r0 = 4
                r1 = 3
                r2 = 2
                r3 = 1
                r4 = 0
                coil3.util.Logger$Level r5 = new coil3.util.Logger$Level
                java.lang.String r6 = "Verbose"
                r5.<init>(r6, r4)
                Verbose = r5
                coil3.util.Logger$Level r6 = new coil3.util.Logger$Level
                java.lang.String r7 = "Debug"
                r6.<init>(r7, r3)
                Debug = r6
                coil3.util.Logger$Level r7 = new coil3.util.Logger$Level
                java.lang.String r8 = "Info"
                r7.<init>(r8, r2)
                Info = r7
                coil3.util.Logger$Level r8 = new coil3.util.Logger$Level
                java.lang.String r9 = "Warn"
                r8.<init>(r9, r1)
                Warn = r8
                coil3.util.Logger$Level r9 = new coil3.util.Logger$Level
                java.lang.String r10 = "Error"
                r9.<init>(r10, r0)
                Error = r9
                r10 = 5
                coil3.util.Logger$Level[] r10 = new coil3.util.Logger.Level[r10]
                r10[r4] = r5
                r10[r3] = r6
                r10[r2] = r7
                r10[r1] = r8
                r10[r0] = r9
                c = r10
                kotlin.enums.EnumEntries r0 = kotlin.enums.EnumEntriesKt.a(r10)
                d = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: coil3.util.Logger.Level.<clinit>():void");
        }

        @NotNull
        public static EnumEntries<Level> getEntries() {
            return d;
        }
    }
}
