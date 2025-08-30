package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

class ProgressNoopOutputStream extends OutputStream implements RequestOutputStream {
    private int batchMax;
    private final Handler callbackHandler;
    private GraphRequest currentRequest;
    private RequestProgress currentRequestProgress;
    private final Map<GraphRequest, RequestProgress> progressMap = new HashMap();

    public ProgressNoopOutputStream(Handler handler) {
        this.callbackHandler = handler;
    }

    public void addProgress(long j) {
        if (this.currentRequestProgress == null) {
            RequestProgress requestProgress = new RequestProgress(this.callbackHandler, this.currentRequest);
            this.currentRequestProgress = requestProgress;
            this.progressMap.put(this.currentRequest, requestProgress);
        }
        this.currentRequestProgress.addToMax(j);
        this.batchMax = (int) (((long) this.batchMax) + j);
    }

    public int getMaxProgress() {
        return this.batchMax;
    }

    public Map<GraphRequest, RequestProgress> getProgressMap() {
        return this.progressMap;
    }

    public void setCurrentRequest(GraphRequest graphRequest) {
        RequestProgress requestProgress;
        this.currentRequest = graphRequest;
        if (graphRequest != null) {
            requestProgress = this.progressMap.get(graphRequest);
        } else {
            requestProgress = null;
        }
        this.currentRequestProgress = requestProgress;
    }

    public void write(byte[] bArr) {
        addProgress((long) bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        addProgress((long) i2);
    }

    public void write(int i) {
        addProgress(1);
    }
}
