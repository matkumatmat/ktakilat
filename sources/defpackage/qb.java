package defpackage;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import java.lang.invoke.MethodHandles;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/* renamed from: qb  reason: default package */
public abstract /* synthetic */ class qb {
    public static /* synthetic */ NotificationChannel c() {
        return new NotificationChannel("channelId", "channelName", 3);
    }

    public static /* bridge */ /* synthetic */ NotificationChannel d(Object obj) {
        return (NotificationChannel) obj;
    }

    public static /* bridge */ /* synthetic */ NotificationChannelGroup e(Object obj) {
        return (NotificationChannelGroup) obj;
    }

    public static /* bridge */ /* synthetic */ Class f() {
        return MethodHandles.Lookup.class;
    }

    public static /* bridge */ /* synthetic */ MethodHandles.Lookup l(Object obj) {
        return (MethodHandles.Lookup) obj;
    }

    public static /* bridge */ /* synthetic */ Path n(Object obj) {
        return (Path) obj;
    }

    public static /* bridge */ /* synthetic */ BasicFileAttributes s(Object obj) {
        return (BasicFileAttributes) obj;
    }
}
