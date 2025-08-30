package io.reactivex.internal.util;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.subscribers.SerializedSubscriber;

public final class QueueDrainHelper {
    public static boolean a(boolean z, boolean z2, SerializedObserver serializedObserver, SimplePlainQueue simplePlainQueue, Disposable disposable, QueueDrainObserver queueDrainObserver) {
        if (queueDrainObserver.f) {
            simplePlainQueue.clear();
            disposable.dispose();
            return true;
        } else if (!z) {
            return false;
        } else {
            Throwable th = queueDrainObserver.i;
            if (th != null) {
                simplePlainQueue.clear();
                if (disposable != null) {
                    disposable.dispose();
                }
                serializedObserver.onError(th);
                return true;
            } else if (!z2) {
                return false;
            } else {
                if (disposable != null) {
                    disposable.dispose();
                }
                serializedObserver.onComplete();
                return true;
            }
        }
    }

    public static void b(MpscLinkedQueue mpscLinkedQueue, SerializedObserver serializedObserver, Disposable disposable, QueueDrainObserver queueDrainObserver) {
        boolean z;
        int i = 1;
        while (!a(queueDrainObserver.g, mpscLinkedQueue.isEmpty(), serializedObserver, mpscLinkedQueue, disposable, queueDrainObserver)) {
            while (true) {
                boolean z2 = queueDrainObserver.g;
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (!a(z2, z, serializedObserver, mpscLinkedQueue, disposable, queueDrainObserver)) {
                    if (z) {
                        i = queueDrainObserver.f(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        queueDrainObserver.a(serializedObserver, poll);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public static void c(MpscLinkedQueue mpscLinkedQueue, SerializedSubscriber serializedSubscriber, Disposable disposable, QueueDrainSubscriber queueDrainSubscriber) {
        boolean z;
        int i = 1;
        while (true) {
            boolean z2 = queueDrainSubscriber.i;
            Object poll = mpscLinkedQueue.poll();
            if (poll == null) {
                z = true;
            } else {
                z = false;
            }
            if (queueDrainSubscriber.g) {
                mpscLinkedQueue.clear();
                break;
            }
            if (z2) {
                Throwable th = queueDrainSubscriber.j;
                if (th == null) {
                    if (z) {
                        serializedSubscriber.onComplete();
                        break;
                    }
                } else {
                    mpscLinkedQueue.clear();
                    serializedSubscriber.onError(th);
                    break;
                }
            }
            if (z) {
                i = queueDrainSubscriber.f(-i);
                if (i == 0) {
                    return;
                }
            } else {
                long h = queueDrainSubscriber.h();
                if (h == 0) {
                    mpscLinkedQueue.clear();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    serializedSubscriber.onError(new MissingBackpressureException("Could not emit value due to lack of requests."));
                    return;
                } else if (queueDrainSubscriber.a(serializedSubscriber, poll) && h != LocationRequestCompat.PASSIVE_INTERVAL) {
                    queueDrainSubscriber.g();
                }
            }
        }
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
