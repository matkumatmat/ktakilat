package androidx.core.content;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ UnusedAppRestrictionsBackportServiceConnection c;

    public /* synthetic */ a(UnusedAppRestrictionsBackportServiceConnection unusedAppRestrictionsBackportServiceConnection) {
        this.c = unusedAppRestrictionsBackportServiceConnection;
    }

    public final void run() {
        this.c.disconnectFromService();
    }
}
