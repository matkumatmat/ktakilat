package com.baidu.idl.main.facesdk;

import java.util.LinkedList;

public class FaceQueue {
    private int nThreads;
    /* access modifiers changed from: private */
    public LinkedList queue = null;
    private PoolWorker[] threads;

    public static class HolderClass {
        /* access modifiers changed from: private */
        public static final FaceQueue instance = new FaceQueue(1);

        private HolderClass() {
        }
    }

    public class PoolWorker extends Thread {
        private PoolWorker() {
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0007 */
        /* JADX WARNING: Removed duplicated region for block: B:2:0x0007 A[LOOP:1: B:2:0x0007->B:21:0x0007, LOOP_START, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r2 = this;
            L_0x0000:
                com.baidu.idl.main.facesdk.FaceQueue r0 = com.baidu.idl.main.facesdk.FaceQueue.this
                java.util.LinkedList r0 = r0.queue
                monitor-enter(r0)
            L_0x0007:
                com.baidu.idl.main.facesdk.FaceQueue r1 = com.baidu.idl.main.facesdk.FaceQueue.this     // Catch:{ all -> 0x001d }
                java.util.LinkedList r1 = r1.queue     // Catch:{ all -> 0x001d }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x001d }
                if (r1 == 0) goto L_0x001f
                com.baidu.idl.main.facesdk.FaceQueue r1 = com.baidu.idl.main.facesdk.FaceQueue.this     // Catch:{ InterruptedException -> 0x0007 }
                java.util.LinkedList r1 = r1.queue     // Catch:{ InterruptedException -> 0x0007 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0007 }
                goto L_0x0007
            L_0x001d:
                r1 = move-exception
                goto L_0x0035
            L_0x001f:
                com.baidu.idl.main.facesdk.FaceQueue r1 = com.baidu.idl.main.facesdk.FaceQueue.this     // Catch:{ all -> 0x001d }
                java.util.LinkedList r1 = r1.queue     // Catch:{ all -> 0x001d }
                java.lang.Object r1 = r1.removeFirst()     // Catch:{ all -> 0x001d }
                java.lang.Runnable r1 = (java.lang.Runnable) r1     // Catch:{ all -> 0x001d }
                monitor-exit(r0)     // Catch:{ all -> 0x001d }
                r1.run()     // Catch:{ RuntimeException -> 0x0030 }
                goto L_0x0000
            L_0x0030:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0000
            L_0x0035:
                monitor-exit(r0)     // Catch:{ all -> 0x001d }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.main.facesdk.FaceQueue.PoolWorker.run():void");
        }
    }

    public FaceQueue(int i) {
        this.nThreads = i;
        this.queue = new LinkedList();
        this.threads = new PoolWorker[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.threads[i2] = new PoolWorker();
            this.threads[i2].start();
        }
    }

    public static FaceQueue getInstance() {
        return HolderClass.instance;
    }

    public void execute(Runnable runnable) {
        synchronized (this.queue) {
            this.queue.addLast(runnable);
            this.queue.notify();
        }
    }
}
