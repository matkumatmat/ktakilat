package com.chuckerteam.chucker.api;

import android.content.Context;
import com.facebook.places.model.PlaceFields;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/chuckerteam/chucker/api/RetentionManager;", "", "Period", "com.github.ChuckerTeam.Chucker.library-no-op"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RetentionManager {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/chuckerteam/chucker/api/RetentionManager$Period;", "", "ONE_HOUR", "ONE_DAY", "ONE_WEEK", "FOREVER", "com.github.ChuckerTeam.Chucker.library-no-op"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public enum Period {
        ;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.chuckerteam.chucker.api.RetentionManager$Period[]} */
        /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Enum, com.chuckerteam.chucker.api.RetentionManager$Period] */
        /* JADX WARNING: type inference failed for: r5v1, types: [java.lang.Enum, com.chuckerteam.chucker.api.RetentionManager$Period] */
        /* JADX WARNING: type inference failed for: r6v1, types: [java.lang.Enum, com.chuckerteam.chucker.api.RetentionManager$Period] */
        /* JADX WARNING: type inference failed for: r7v1, types: [java.lang.Enum, com.chuckerteam.chucker.api.RetentionManager$Period] */
        /* JADX WARNING: Multi-variable type inference failed */
        static {
            /*
                r0 = 3
                r1 = 2
                r2 = 1
                r3 = 0
                com.chuckerteam.chucker.api.RetentionManager$Period r4 = new com.chuckerteam.chucker.api.RetentionManager$Period
                java.lang.String r5 = "ONE_HOUR"
                r4.<init>(r5, r3)
                ONE_HOUR = r4
                com.chuckerteam.chucker.api.RetentionManager$Period r5 = new com.chuckerteam.chucker.api.RetentionManager$Period
                java.lang.String r6 = "ONE_DAY"
                r5.<init>(r6, r2)
                ONE_DAY = r5
                com.chuckerteam.chucker.api.RetentionManager$Period r6 = new com.chuckerteam.chucker.api.RetentionManager$Period
                java.lang.String r7 = "ONE_WEEK"
                r6.<init>(r7, r1)
                ONE_WEEK = r6
                com.chuckerteam.chucker.api.RetentionManager$Period r7 = new com.chuckerteam.chucker.api.RetentionManager$Period
                java.lang.String r8 = "FOREVER"
                r7.<init>(r8, r0)
                FOREVER = r7
                r8 = 4
                com.chuckerteam.chucker.api.RetentionManager$Period[] r8 = new com.chuckerteam.chucker.api.RetentionManager.Period[r8]
                r8[r3] = r4
                r8[r2] = r5
                r8[r1] = r6
                r8[r0] = r7
                c = r8
                kotlin.enums.EnumEntries r0 = kotlin.enums.EnumEntriesKt.a(r8)
                d = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chuckerteam.chucker.api.RetentionManager.Period.<clinit>():void");
        }

        @NotNull
        public static EnumEntries<Period> getEntries() {
            return d;
        }
    }

    @JvmOverloads
    public RetentionManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
        Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
    }
}
