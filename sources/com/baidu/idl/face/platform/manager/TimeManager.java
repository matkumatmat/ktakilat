package com.baidu.idl.face.platform.manager;

public class TimeManager {
    private static TimeManager instance;
    private int mActiveAnimTime;

    private TimeManager() {
    }

    public static TimeManager getInstance() {
        if (instance == null) {
            synchronized (TimeManager.class) {
                try {
                    if (instance == null) {
                        instance = new TimeManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public int getActiveAnimTime() {
        return this.mActiveAnimTime;
    }

    public void setActiveAnimTime(int i) {
        this.mActiveAnimTime = i;
    }
}
