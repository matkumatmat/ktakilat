package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: z8  reason: default package */
public final /* synthetic */ class z8 implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f371a;

    public /* synthetic */ z8(String str) {
        this.f371a = str;
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(this.f371a);
    }
}
