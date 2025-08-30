package coil3.network.okhttp;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import okhttp3.OkHttpClient;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$7 extends FunctionReferenceImpl implements Function0<OkHttpClient> {
    static {
        new OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$7();
    }

    public OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$7() {
        super(0, OkHttpClient.class, "<init>", "<init>()V", 0);
    }

    public final Object invoke() {
        return new OkHttpClient();
    }
}
