package com.trustdecision.android.bugly.l1l11i111l;

import java.io.File;
import java.util.Comparator;

class l1l11i111l implements Comparator<File> {
    /* renamed from: liii1l1lll1 */
    public int compare(File file, File file2) {
        int i = ((liii1l1lll1.llli1l111ilii1i(file.getName()) - liii1l1lll1.llli1l111ilii1i(file2.getName())) > 0 ? 1 : ((liii1l1lll1.llli1l111ilii1i(file.getName()) - liii1l1lll1.llli1l111ilii1i(file2.getName())) == 0 ? 0 : -1));
        if (i > 0) {
            return -1;
        }
        if (i == 0) {
            return 0;
        }
        return 1;
    }
}
