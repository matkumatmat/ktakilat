package com.appsflyer.internal;

import java.util.TimerTask;

public final class AFe1pSDK extends TimerTask {
    private final Thread getMonetizationNetwork;

    public AFe1pSDK(Thread thread) {
        this.getMonetizationNetwork = thread;
    }

    public final void run() {
        this.getMonetizationNetwork.interrupt();
    }
}
