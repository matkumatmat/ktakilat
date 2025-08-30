package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 d;
    public final /* synthetic */ Callback e;
    public final /* synthetic */ Object f;

    public /* synthetic */ a(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 r1, Callback callback, Object obj, int i) {
        this.c = i;
        this.d = r1;
        this.e = callback;
        this.f = obj;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$onResponse$0(this.e, (Response) this.f);
                return;
            default:
                this.d.lambda$onFailure$1(this.e, (Throwable) this.f);
                return;
        }
    }
}
