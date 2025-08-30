package coil3.intercept;

import coil3.EventListener;
import coil3.intercept.Interceptor;
import coil3.request.ImageRequest;
import coil3.size.Size;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/intercept/RealInterceptorChain;", "Lcoil3/intercept/Interceptor$Chain;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RealInterceptorChain implements Interceptor.Chain {

    /* renamed from: a  reason: collision with root package name */
    public final ImageRequest f109a;
    public final List b;
    public final int c;
    public final ImageRequest d;
    public final Size e;
    public final EventListener f;
    public final boolean g;

    public RealInterceptorChain(ImageRequest imageRequest, List list, int i, ImageRequest imageRequest2, Size size, EventListener eventListener, boolean z) {
        this.f109a = imageRequest;
        this.b = list;
        this.c = i;
        this.d = imageRequest2;
        this.e = size;
        this.f = eventListener;
        this.g = z;
    }

    public final ImageRequest a() {
        return this.d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(kotlin.coroutines.jvm.internal.ContinuationImpl r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof coil3.intercept.RealInterceptorChain$proceed$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            coil3.intercept.RealInterceptorChain$proceed$1 r0 = (coil3.intercept.RealInterceptorChain$proceed$1) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.g = r1
            goto L_0x0018
        L_0x0013:
            coil3.intercept.RealInterceptorChain$proceed$1 r0 = new coil3.intercept.RealInterceptorChain$proceed$1
            r0.<init>(r12, r13)
        L_0x0018:
            java.lang.Object r13 = r0.e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.g
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            coil3.intercept.Interceptor r1 = r0.d
            coil3.intercept.RealInterceptorChain r0 = r0.c
            kotlin.ResultKt.b(r13)
            goto L_0x0064
        L_0x002b:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0033:
            kotlin.ResultKt.b(r13)
            java.util.List r13 = r12.b
            int r2 = r12.c
            java.lang.Object r13 = r13.get(r2)
            coil3.intercept.Interceptor r13 = (coil3.intercept.Interceptor) r13
            int r7 = r2 + 1
            coil3.intercept.RealInterceptorChain r2 = new coil3.intercept.RealInterceptorChain
            coil3.request.ImageRequest r5 = r12.f109a
            coil3.EventListener r10 = r12.f
            java.util.List r6 = r12.b
            coil3.request.ImageRequest r8 = r12.d
            coil3.size.Size r9 = r12.e
            boolean r11 = r12.g
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            r0.c = r12
            r0.d = r13
            r0.g = r3
            java.lang.Object r0 = r13.a(r2, r0)
            if (r0 != r1) goto L_0x0061
            return r1
        L_0x0061:
            r1 = r13
            r13 = r0
            r0 = r12
        L_0x0064:
            coil3.request.ImageResult r13 = (coil3.request.ImageResult) r13
            coil3.request.ImageRequest r2 = r13.a()
            r0.getClass()
            android.content.Context r3 = r2.f137a
            coil3.request.ImageRequest r0 = r0.f109a
            android.content.Context r4 = r0.f137a
            java.lang.String r5 = "Interceptor '"
            if (r3 != r4) goto L_0x00db
            coil3.request.NullRequestData r3 = coil3.request.NullRequestData.f143a
            java.lang.Object r4 = r2.b
            if (r4 == r3) goto L_0x00c0
            coil3.target.ImageViewTarget r3 = r2.c
            coil3.target.ImageViewTarget r4 = r0.c
            if (r3 != r4) goto L_0x00a5
            coil3.size.SizeResolver r2 = r2.p
            coil3.size.SizeResolver r0 = r0.p
            if (r2 != r0) goto L_0x008a
            return r13
        L_0x008a:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r5)
            r13.append(r1)
            java.lang.String r0 = "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead."
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r13 = r13.toString()
            r0.<init>(r13)
            throw r0
        L_0x00a5:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r5)
            r13.append(r1)
            java.lang.String r0 = "' cannot modify the request's target."
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r13 = r13.toString()
            r0.<init>(r13)
            throw r0
        L_0x00c0:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r5)
            r13.append(r1)
            java.lang.String r0 = "' cannot set the request's data to null."
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r13 = r13.toString()
            r0.<init>(r13)
            throw r0
        L_0x00db:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r5)
            r13.append(r1)
            java.lang.String r0 = "' cannot modify the request's context."
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r13 = r13.toString()
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.intercept.RealInterceptorChain.b(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
