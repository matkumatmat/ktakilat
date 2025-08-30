package com.trustdecision.android.bugly;

import com.trustdecision.android.bugly.l1l11i111l.liii1l1lll1;
import java.io.File;

class l1ill1li1i implements Runnable {
    String l1l11i111l;
    File liii1l1lll1;

    public l1ill1li1i(File file, String str) {
        this.liii1l1lll1 = file;
        this.l1l11i111l = str;
    }

    public void run() {
        if (!liii1l1lll1.liii1l1lll1(this.liii1l1lll1.getAbsolutePath())) {
            if (com.trustdecision.android.bugly.llli1l111ilii1i.liii1l1lll1.l1l11i111l(this.l1l11i111l, liii1l1lll1.liii1l1lll1(this.liii1l1lll1))) {
                this.liii1l1lll1.delete();
            }
        } else if (com.trustdecision.android.bugly.liii1l1lll1.liii1l1lll1.l1l11i111l() || com.trustdecision.android.bugly.l1l11i111l.l1ill1li1i.liii1l1lll1(this.liii1l1lll1)) {
            if (com.trustdecision.android.bugly.llli1l111ilii1i.liii1l1lll1.liii1l1lll1(this.l1l11i111l, liii1l1lll1.l1l11i111l(this.liii1l1lll1))) {
                this.liii1l1lll1.delete();
            }
        } else {
            this.liii1l1lll1.delete();
        }
    }
}
