package io.reactivex.internal.util;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Predicate;

public class AppendOnlyLinkedArrayList<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f681a;
    public Object[] b;
    public int c;

    public interface NonThrowingPredicate<T> extends Predicate<T> {
    }

    public AppendOnlyLinkedArrayList() {
        Object[] objArr = new Object[5];
        this.f681a = objArr;
        this.b = objArr;
    }

    public final boolean a(FlowableSubscriber flowableSubscriber) {
        Object[] objArr;
        Object[] objArr2 = this.f681a;
        while (true) {
            int i = 0;
            if (objArr2 == null) {
                return false;
            }
            while (i < 4 && (objArr = objArr2[i]) != null) {
                if (NotificationLite.acceptFull((Object) objArr, flowableSubscriber)) {
                    return true;
                }
                i++;
            }
            objArr2 = objArr2[4];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.Object r4) {
        /*
            r3 = this;
            int r0 = r3.c
            r1 = 4
            if (r0 != r1) goto L_0x000f
            r0 = 5
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.Object[] r2 = r3.b
            r2[r1] = r0
            r3.b = r0
            r0 = 0
        L_0x000f:
            java.lang.Object[] r1 = r3.b
            r1[r0] = r4
            int r0 = r0 + 1
            r3.c = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.AppendOnlyLinkedArrayList.b(java.lang.Object):void");
    }

    public final void c(NonThrowingPredicate nonThrowingPredicate) {
        Object[] objArr;
        Object[] objArr2 = this.f681a;
        while (objArr2 != null) {
            int i = 0;
            while (i < 4 && (objArr = objArr2[i]) != null) {
                if (!nonThrowingPredicate.test(objArr)) {
                    i++;
                } else {
                    return;
                }
            }
            objArr2 = objArr2[4];
        }
    }
}
