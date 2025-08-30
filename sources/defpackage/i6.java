package defpackage;

import androidx.camera.core.ImageProxy;
import com.ktakilat.loan.normal_ui.EktpCameraActivity;

/* renamed from: i6  reason: default package */
public final /* synthetic */ class i6 implements Runnable {
    public final /* synthetic */ EktpCameraActivity c;
    public final /* synthetic */ ImageProxy d;
    public final /* synthetic */ double e;
    public final /* synthetic */ double f;

    public /* synthetic */ i6(EktpCameraActivity ektpCameraActivity, ImageProxy imageProxy, double d2, double d3) {
        this.c = ektpCameraActivity;
        this.d = imageProxy;
        this.e = d2;
        this.f = d3;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:1|2|3|(3:5|6|7)(1:10)|11|12|(1:18)(3:15|16|17)|19|20|21|22|25) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x00e6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r15 = this;
            r0 = 1
            androidx.camera.core.ImageProxy r1 = r15.d
            double r2 = r15.f
            int r4 = com.ktakilat.loan.normal_ui.EktpCameraActivity.x
            com.ktakilat.loan.normal_ui.EktpCameraActivity r4 = r15.c
            r4.getClass()
            android.graphics.Bitmap r12 = r1.toBitmap()     // Catch:{ Exception -> 0x002a }
            int r5 = r12.getWidth()     // Catch:{ Exception -> 0x002a }
            int r6 = r12.getHeight()     // Catch:{ Exception -> 0x002a }
            double r7 = (double) r6
            double r9 = (double) r5
            double r7 = r7 / r9
            double r13 = r15.e
            int r11 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r11 >= 0) goto L_0x002d
            int r2 = r6 * 251
            int r2 = r2 / 360
            int r3 = r2 * 375
            int r3 = r3 / 251
            goto L_0x0034
        L_0x002a:
            r0 = move-exception
            goto L_0x00f4
        L_0x002d:
            double r9 = r9 * r2
            int r3 = (int) r9     // Catch:{ Exception -> 0x002a }
            int r2 = r3 * 251
            int r2 = r2 / 375
        L_0x0034:
            double r7 = (double) r2     // Catch:{ Exception -> 0x002a }
            r9 = 4607857958744122982(0x3ff2666666666666, double:1.15)
            double r7 = r7 * r9
            int r2 = (int) r7     // Catch:{ Exception -> 0x002a }
            double r7 = (double) r3     // Catch:{ Exception -> 0x002a }
            double r7 = r7 * r9
            int r3 = (int) r7     // Catch:{ Exception -> 0x002a }
            android.graphics.Matrix r10 = new android.graphics.Matrix     // Catch:{ Exception -> 0x002a }
            r10.<init>()     // Catch:{ Exception -> 0x002a }
            r7 = 0
            r10.postRotate(r7)     // Catch:{ Exception -> 0x002a }
            r7 = 1000(0x3e8, float:1.401E-42)
            java.lang.String r13 = ""
            if (r2 < r7) goto L_0x00a3
            if (r3 < r7) goto L_0x00a3
            int r7 = r5 - r3
            int r7 = r7 / 2
            int r8 = r6 - r2
            int r8 = r8 / 2
            r9 = 0
            int r7 = java.lang.Math.max(r7, r9)     // Catch:{ Exception -> 0x002a }
            int r8 = java.lang.Math.max(r8, r9)     // Catch:{ Exception -> 0x002a }
            int r3 = java.lang.Math.min(r5, r3)     // Catch:{ Exception -> 0x002a }
            int r9 = java.lang.Math.min(r6, r2)     // Catch:{ Exception -> 0x002a }
            r11 = 1
            r5 = r12
            r6 = r7
            r7 = r8
            r8 = r3
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x002a }
            java.io.File r3 = r4.o     // Catch:{ Exception -> 0x002a }
            com.ktakilat.loan.normal_ui.EktpCameraActivity.D(r2, r3)     // Catch:{ Exception -> 0x002a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r3.<init>()     // Catch:{ Exception -> 0x002a }
            int r5 = r2.getWidth()     // Catch:{ Exception -> 0x002a }
            r3.append(r5)     // Catch:{ Exception -> 0x002a }
            r3.append(r13)     // Catch:{ Exception -> 0x002a }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x002a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r5.<init>()     // Catch:{ Exception -> 0x002a }
            int r2 = r2.getHeight()     // Catch:{ Exception -> 0x002a }
            r5.append(r2)     // Catch:{ Exception -> 0x002a }
            r5.append(r13)     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x002a }
            com.ktakilat.cbase.datacollect.KtaCollect.n_ektp_page_img_call(r3, r2)     // Catch:{ Exception -> 0x002a }
            goto L_0x00e1
        L_0x00a3:
            int r8 = r12.getWidth()     // Catch:{ Exception -> 0x002a }
            int r9 = r12.getHeight()     // Catch:{ Exception -> 0x002a }
            r11 = 1
            r6 = 0
            r7 = 0
            r5 = r12
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x002a }
            java.io.File r3 = r4.o     // Catch:{ Exception -> 0x002a }
            com.ktakilat.loan.normal_ui.EktpCameraActivity.D(r2, r3)     // Catch:{ Exception -> 0x002a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r2.<init>()     // Catch:{ Exception -> 0x002a }
            int r3 = r12.getWidth()     // Catch:{ Exception -> 0x002a }
            r2.append(r3)     // Catch:{ Exception -> 0x002a }
            r2.append(r13)     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x002a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r3.<init>()     // Catch:{ Exception -> 0x002a }
            int r5 = r12.getHeight()     // Catch:{ Exception -> 0x002a }
            r3.append(r5)     // Catch:{ Exception -> 0x002a }
            r3.append(r13)     // Catch:{ Exception -> 0x002a }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x002a }
            com.ktakilat.cbase.datacollect.KtaCollect.n_ektp_page_img_call(r2, r3)     // Catch:{ Exception -> 0x002a }
        L_0x00e1:
            java.io.File r2 = r4.p     // Catch:{ Exception -> 0x00e6 }
            com.ktakilat.loan.normal_ui.EktpCameraActivity.D(r12, r2)     // Catch:{ Exception -> 0x00e6 }
        L_0x00e6:
            r1.close()     // Catch:{ Exception -> 0x002a }
            r4.i = r0     // Catch:{ Exception -> 0x002a }
            j6 r1 = new j6     // Catch:{ Exception -> 0x002a }
            r1.<init>(r4, r0)     // Catch:{ Exception -> 0x002a }
            r4.runOnUiThread(r1)     // Catch:{ Exception -> 0x002a }
            goto L_0x0109
        L_0x00f4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "catch "
            r1.<init>(r2)
            java.lang.String r0 = com.ktakilat.cbase.utils.LogUtil.b(r0)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.ktakilat.cbase.datacollect.KtaCollect.n_ektp_page_error(r0)
        L_0x0109:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i6.run():void");
    }
}
