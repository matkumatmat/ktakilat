package com.chuckerteam.chucker.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/chuckerteam/chucker/api/ExportFormat;", "", "", "c", "Ljava/lang/String;", "getExtension", "()Ljava/lang/String;", "extension", "LOG", "HAR", "com.github.ChuckerTeam.Chucker.library-no-op"}, k = 1, mv = {2, 0, 0}, xi = 48)
public enum ExportFormat {
    LOG("txt"),
    HAR("har");
    
    public final String c;

    static {
        ExportFormat[] exportFormatArr;
        e = EnumEntriesKt.a(exportFormatArr);
    }

    /* access modifiers changed from: public */
    ExportFormat(String str) {
        this.c = str;
    }

    @NotNull
    public static EnumEntries<ExportFormat> getEntries() {
        return e;
    }

    @NotNull
    public final String getExtension() {
        return this.c;
    }
}
