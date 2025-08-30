package com.ktakilat.loan.normal_ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.idl.face.platform.utils.BitmapUtils;
import com.google.common.util.concurrent.ListenableFuture;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.ui.BaseActivity;
import com.pendanaan.kta.databinding.ActivityEktpCameraBinding;
import java.io.File;

public class EktpCameraActivity extends BaseActivity {
    public static final /* synthetic */ int x = 0;
    public boolean i = false;
    public int j = 0;
    public int k = 0;
    public int l = 0;
    public int m = 0;
    public ActivityEktpCameraBinding n;
    public File o;
    public File p;
    public ListenableFuture q;
    public ProcessCameraProvider r;
    public Preview s;
    public ImageCapture t;
    public ImageAnalysis u;
    public CameraSelector v;
    public CameraControl w;

    public static void A(EktpCameraActivity ektpCameraActivity) {
        ektpCameraActivity.getClass();
        KtaCollect.n_ektp_page_clc_cancel();
        if (ektpCameraActivity.i) {
            ektpCameraActivity.i = false;
            ektpCameraActivity.C();
            ektpCameraActivity.n.ivOk.setVisibility(4);
            ektpCameraActivity.n.ivShutter.setVisibility(0);
            return;
        }
        super.onBackPressed();
    }

    public static void B(EktpCameraActivity ektpCameraActivity) {
        super.onBackPressed();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002d */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0041 A[SYNTHETIC, Splitter:B:19:0x0041] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void D(android.graphics.Bitmap r4, java.io.File r5) {
        /*
            r5.getPath()
            com.ktakilat.loan.KtakilatApplication r0 = com.ktakilat.loan.KtakilatApplication.m
            r0.getClass()
            com.ktakilat.loan.KtakilatApplication.j()
            boolean r0 = r5.exists()
            if (r0 != 0) goto L_0x0014
            r5.createNewFile()     // Catch:{ IOException -> 0x0014 }
        L_0x0014:
            r0 = 1000(0x3e8, float:1.401E-42)
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            byte[] r0 = com.ktakilat.cbase.utils.CompressUtil.a(r4, r0, r0, r1)     // Catch:{ Exception -> 0x002d }
            int r1 = r0.length     // Catch:{ Exception -> 0x002d }
            r3 = 0
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r0, r3, r1)     // Catch:{ Exception -> 0x002d }
            java.lang.String r1 = r5.getPath()     // Catch:{ Exception -> 0x002d }
            com.ktakilat.cbase.utils.ImageUtil.a(r0, r1)     // Catch:{ Exception -> 0x002d }
            goto L_0x003c
        L_0x002b:
            r4 = move-exception
            goto L_0x003f
        L_0x002d:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ all -> 0x002b }
            r0.<init>(r5)     // Catch:{ all -> 0x002b }
            android.graphics.Bitmap$CompressFormat r5 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x003d }
            r1 = 100
            r4.compress(r5, r1, r0)     // Catch:{ all -> 0x003d }
            r0.close()     // Catch:{ IOException -> 0x003c }
        L_0x003c:
            return
        L_0x003d:
            r4 = move-exception
            r2 = r0
        L_0x003f:
            if (r2 == 0) goto L_0x0044
            r2.close()     // Catch:{ IOException -> 0x0044 }
        L_0x0044:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.normal_ui.EktpCameraActivity.D(android.graphics.Bitmap, java.io.File):void");
    }

    public static void z(EktpCameraActivity ektpCameraActivity) {
        if (ektpCameraActivity.i) {
            KtaCollect.n_ektp_page_clc_confirm();
            ektpCameraActivity.setResult(-1, new Intent());
            super.onBackPressed();
        }
    }

    public final void C() {
        try {
            ProcessCameraProvider processCameraProvider = this.r;
            if (processCameraProvider != null) {
                this.w = processCameraProvider.bindToLifecycle((LifecycleOwner) this, this.v, this.t, this.u, this.s).getCameraControl();
            }
        } catch (Exception unused) {
            finish();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(5894);
        ActivityEktpCameraBinding inflate = ActivityEktpCameraBinding.inflate(getLayoutInflater());
        this.n = inflate;
        setContentView((View) inflate.getRoot());
        this.o = new File(getBaseContext().getCacheDir(), "ektp.jpg");
        File file = new File(getBaseContext().getCacheDir(), "ektp-full.jpg");
        this.p = file;
        try {
            if (file.exists()) {
                this.p.delete();
            }
        } catch (Throwable unused) {
        }
        if (getIntent() == null) {
            finish();
            return;
        }
        KtaCollect.n_ektp_page_exposure();
        this.j = getResources().getDisplayMetrics().widthPixels;
        this.k = getResources().getDisplayMetrics().heightPixels;
        int i2 = (this.j * 251) / BitmapUtils.ROTATE360;
        this.l = i2;
        this.m = (i2 * 376) / 251;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(this.l, this.m);
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        this.n.llCameraMask.setLayoutParams(layoutParams);
        this.q = ProcessCameraProvider.getInstance(this);
        this.s = new Preview.Builder().setTargetRotation(1).build();
        this.v = new CameraSelector.Builder().requireLensFacing(1).build();
        this.s.setSurfaceProvider(this.n.cameraxPreview.getSurfaceProvider());
        this.t = new ImageCapture.Builder().setTargetRotation(1).setFlashMode(0).setCaptureMode(0).build();
        this.u = new ImageAnalysis.Builder().setTargetRotation(1).build();
        this.q.addListener(new j6(this, 0), ContextCompat.getMainExecutor(this));
        this.n.ivShutter.setOnClickListener(new a(this, 0));
        this.n.ivCancle.setOnClickListener(new h6(this, 0));
        this.n.ivOk.setOnClickListener(new h6(this, 1));
        this.n.viewClickBack.setOnClickListener(new h6(this, 2));
    }

    public final void onDestroy() {
        KtaCollect.n_ektp_page_clc_back();
        super.onDestroy();
    }
}
