package com.katkilat.baidu_face.manager;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Camera;
import android.media.AudioManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.ILivenessStrategy;
import com.baidu.idl.face.platform.LivenessTypeEnum;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.katkilat.baidu_face.FaceSDKResSettings;
import com.katkilat.baidu_face.R;
import com.katkilat.baidu_face.utils.CameraUtils;
import com.katkilat.baidu_face.utils.VolumeUtils;
import com.katkilat.baidu_face.widget.FaceDetectRoundView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/katkilat/baidu_face/manager/FacePointManager;", "", "Companion", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FacePointManager {
    public Companion.InitCall A;

    /* renamed from: a  reason: collision with root package name */
    public final Activity f459a;
    public FrameLayout b;
    public FaceDetectRoundView c;
    public RelativeLayout d;
    public SurfaceView e;
    public SurfaceHolder f;
    public ImageView g;
    public FacePointManager$initParams$1 h;
    public FacePointManager$initParams$2 i;
    public FacePointManager$initParams$3 j;
    public FaceConfig k;
    public ILivenessStrategy l;
    public final Rect m = new Rect();
    public int n;
    public volatile boolean o = true;
    public boolean p;
    public Camera q;
    public Camera.Parameters r;
    public int s;
    public int t;
    public int u;
    public int v;
    public VolumeUtils.Companion.VolumeReceiver w;
    public boolean x;
    public AnimationDrawable y;
    public LivenessTypeEnum z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/katkilat/baidu_face/manager/FacePointManager$Companion;", "", "InitCall", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/katkilat/baidu_face/manager/FacePointManager$Companion$InitCall;", "", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public interface InitCall {
            void a(String str);

            void b();

            void c(String str);

            void d(byte[] bArr);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f460a;
        public static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(51:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|(2:45|46)|47|49|50|51|52|53|54|55|56|57|58|59|60|61|63) */
        /* JADX WARNING: Can't wrap try/catch for region: R(52:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|(2:45|46)|47|49|50|51|52|53|54|55|56|57|58|59|60|61|63) */
        /* JADX WARNING: Can't wrap try/catch for region: R(53:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|(2:45|46)|47|49|50|51|52|53|54|55|56|57|58|59|60|61|63) */
        /* JADX WARNING: Can't wrap try/catch for region: R(54:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|(2:45|46)|47|49|50|51|52|53|54|55|56|57|58|59|60|61|63) */
        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|49|50|51|52|53|54|55|56|57|58|59|60|61|63) */
        /* JADX WARNING: Can't wrap try/catch for region: R(57:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|49|50|51|52|53|54|55|56|57|58|59|60|61|63) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00c5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00cd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00d5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00dd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00e5 */
        static {
            /*
                com.baidu.idl.face.platform.FaceStatusNewEnum[] r0 = com.baidu.idl.face.platform.FaceStatusNewEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.baidu.idl.face.platform.FaceStatusNewEnum r2 = com.baidu.idl.face.platform.FaceStatusNewEnum.OK     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.baidu.idl.face.platform.FaceStatusNewEnum r3 = com.baidu.idl.face.platform.FaceStatusNewEnum.FaceLivenessActionComplete     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.baidu.idl.face.platform.FaceStatusNewEnum r4 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodeTooClose     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                com.baidu.idl.face.platform.FaceStatusNewEnum r5 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodeTooFar     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r5 = 5
                com.baidu.idl.face.platform.FaceStatusNewEnum r6 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r0[r6] = r5     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                r6 = 6
                com.baidu.idl.face.platform.FaceStatusNewEnum r7 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodeNoFaceDetected     // Catch:{ NoSuchFieldError -> 0x003d }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r0[r7] = r6     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.baidu.idl.face.platform.FaceStatusNewEnum r7 = com.baidu.idl.face.platform.FaceStatusNewEnum.FaceLivenessActionTypeLiveEye     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r8 = 7
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.baidu.idl.face.platform.FaceStatusNewEnum r7 = com.baidu.idl.face.platform.FaceStatusNewEnum.FaceLivenessActionTypeLiveMouth     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r8 = 8
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.baidu.idl.face.platform.FaceStatusNewEnum r7 = com.baidu.idl.face.platform.FaceStatusNewEnum.FaceLivenessActionTypeLivePitchUp     // Catch:{ NoSuchFieldError -> 0x005a }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r8 = 9
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.baidu.idl.face.platform.FaceStatusNewEnum r7 = com.baidu.idl.face.platform.FaceStatusNewEnum.FaceLivenessActionTypeLivePitchDown     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r8 = 10
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.baidu.idl.face.platform.FaceStatusNewEnum r7 = com.baidu.idl.face.platform.FaceStatusNewEnum.FaceLivenessActionTypeLiveYawLeft     // Catch:{ NoSuchFieldError -> 0x006e }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r8 = 11
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.baidu.idl.face.platform.FaceStatusNewEnum r7 = com.baidu.idl.face.platform.FaceStatusNewEnum.FaceLivenessActionTypeLiveYawRight     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r8 = 12
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                com.baidu.idl.face.platform.FaceStatusNewEnum r7 = com.baidu.idl.face.platform.FaceStatusNewEnum.FaceLivenessActionTypeLiveYaw     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r8 = 13
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                com.baidu.idl.face.platform.FaceStatusNewEnum r7 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange     // Catch:{ NoSuchFieldError -> 0x008c }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r8 = 14
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                com.baidu.idl.face.platform.FaceStatusNewEnum r7 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r8 = 15
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                com.baidu.idl.face.platform.FaceStatusNewEnum r7 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r8 = 16
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                com.baidu.idl.face.platform.FaceStatusNewEnum r7 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r8 = 17
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                com.baidu.idl.face.platform.FaceStatusNewEnum r7 = com.baidu.idl.face.platform.FaceStatusNewEnum.FaceLivenessActionCodeTimeout     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r8 = 18
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                f460a = r0
                com.baidu.idl.face.platform.LivenessTypeEnum[] r0 = com.baidu.idl.face.platform.LivenessTypeEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.baidu.idl.face.platform.LivenessTypeEnum r7 = com.baidu.idl.face.platform.LivenessTypeEnum.Eye     // Catch:{ NoSuchFieldError -> 0x00c5 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c5 }
                r0[r7] = r1     // Catch:{ NoSuchFieldError -> 0x00c5 }
            L_0x00c5:
                com.baidu.idl.face.platform.LivenessTypeEnum r1 = com.baidu.idl.face.platform.LivenessTypeEnum.HeadLeft     // Catch:{ NoSuchFieldError -> 0x00cd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cd }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cd }
            L_0x00cd:
                com.baidu.idl.face.platform.LivenessTypeEnum r1 = com.baidu.idl.face.platform.LivenessTypeEnum.HeadRight     // Catch:{ NoSuchFieldError -> 0x00d5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d5 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00d5 }
            L_0x00d5:
                com.baidu.idl.face.platform.LivenessTypeEnum r1 = com.baidu.idl.face.platform.LivenessTypeEnum.HeadDown     // Catch:{ NoSuchFieldError -> 0x00dd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dd }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00dd }
            L_0x00dd:
                com.baidu.idl.face.platform.LivenessTypeEnum r1 = com.baidu.idl.face.platform.LivenessTypeEnum.HeadUp     // Catch:{ NoSuchFieldError -> 0x00e5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e5 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00e5 }
            L_0x00e5:
                com.baidu.idl.face.platform.LivenessTypeEnum r1 = com.baidu.idl.face.platform.LivenessTypeEnum.Mouth     // Catch:{ NoSuchFieldError -> 0x00ed }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ed }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x00ed }
            L_0x00ed:
                b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.katkilat.baidu_face.manager.FacePointManager.WhenMappings.<clinit>():void");
        }
    }

    public FacePointManager(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "mAct");
        this.f459a = activity;
    }

    public final View a(Companion.InitCall initCall) {
        this.A = initCall;
        View inflate = LayoutInflater.from(this.f459a).inflate(R.layout.view_face_point, (ViewGroup) null);
        inflate.findViewById(R.id.face_point_root_view);
        this.b = (FrameLayout) inflate.findViewById(R.id.surface_layout);
        this.c = (FaceDetectRoundView) inflate.findViewById(R.id.face_view);
        this.d = (RelativeLayout) inflate.findViewById(R.id.add_image_layout);
        return inflate;
    }

    public final void b() {
        this.x = false;
        e();
    }

    public final void c() {
        boolean z2;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f459a.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.n = displayMetrics.widthPixels;
        FaceSDKResSettings.a();
        this.k = FaceSDKManager.getInstance().getFaceConfig();
        Object systemService = this.f459a.getSystemService("audio");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        if (((AudioManager) systemService).getStreamVolume(3) > 0) {
            FaceConfig faceConfig = this.k;
            if (faceConfig != null) {
                z2 = faceConfig.isSound();
            } else {
                Intrinsics.k("mFaceConfig");
                throw null;
            }
        } else {
            z2 = false;
        }
        this.o = z2;
        this.h = new FacePointManager$initParams$1(this);
        this.i = new FacePointManager$initParams$2(this);
        this.j = new FacePointManager$initParams$3(this);
        SurfaceView surfaceView = new SurfaceView(this.f459a);
        this.e = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        this.f = holder;
        if (holder != null) {
            holder.setSizeFromLayout();
            SurfaceHolder surfaceHolder = this.f;
            if (surfaceHolder != null) {
                FacePointManager$initParams$1 facePointManager$initParams$1 = this.h;
                if (facePointManager$initParams$1 != null) {
                    surfaceHolder.addCallback(facePointManager$initParams$1);
                    SurfaceHolder surfaceHolder2 = this.f;
                    if (surfaceHolder2 != null) {
                        surfaceHolder2.setType(3);
                        float f2 = ((float) this.n) * 0.75f * 0.9f;
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) f2, (int) ((f2 * 640.0f) / 480.0f), 17);
                        SurfaceView surfaceView2 = this.e;
                        if (surfaceView2 != null) {
                            surfaceView2.setLayoutParams(layoutParams);
                            FrameLayout frameLayout = this.b;
                            if (frameLayout != null) {
                                SurfaceView surfaceView3 = this.e;
                                if (surfaceView3 != null) {
                                    frameLayout.addView(surfaceView3);
                                    FaceDetectRoundView faceDetectRoundView = this.c;
                                    if (faceDetectRoundView != null) {
                                        faceDetectRoundView.setIsActiveLive(true);
                                        FaceDetectRoundView faceDetectRoundView2 = this.c;
                                        if (faceDetectRoundView2 != null) {
                                            faceDetectRoundView2.post(new x0(this, 18));
                                        } else {
                                            Intrinsics.k("mFaceRoundView");
                                            throw null;
                                        }
                                    } else {
                                        Intrinsics.k("mFaceRoundView");
                                        throw null;
                                    }
                                } else {
                                    Intrinsics.k("mSurfaceView");
                                    throw null;
                                }
                            } else {
                                Intrinsics.k("mSurfaceLayout");
                                throw null;
                            }
                        } else {
                            Intrinsics.k("mSurfaceView");
                            throw null;
                        }
                    } else {
                        Intrinsics.k("mSurfaceHolder");
                        throw null;
                    }
                } else {
                    Intrinsics.k("mSurfaceCallback");
                    throw null;
                }
            } else {
                Intrinsics.k("mSurfaceHolder");
                throw null;
            }
        } else {
            Intrinsics.k("mSurfaceHolder");
            throw null;
        }
    }

    public final void d() {
        ILivenessStrategy iLivenessStrategy = this.l;
        if (iLivenessStrategy != null) {
            iLivenessStrategy.reset();
        }
        VolumeUtils.Companion.VolumeReceiver volumeReceiver = this.w;
        Activity activity = this.f459a;
        if (!(activity == null || volumeReceiver == null)) {
            try {
                activity.unregisterReceiver(volumeReceiver);
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        this.w = null;
        FaceDetectRoundView faceDetectRoundView = this.c;
        if (faceDetectRoundView != null) {
            FaceConfig faceConfig = this.k;
            if (faceConfig != null) {
                faceDetectRoundView.setProcessCount(0, faceConfig.getLivenessTypeList().size());
                f();
                if (this.l != null) {
                    this.l = null;
                }
                this.p = false;
                return;
            }
            Intrinsics.k("mFaceConfig");
            throw null;
        }
        Intrinsics.k("mFaceRoundView");
        throw null;
    }

    public final void e() {
        if (!this.x) {
            Activity activity = this.f459a;
            activity.setVolumeControlStream(3);
            this.w = VolumeUtils.Companion.a(activity, new FacePointManager$onResume$1(this));
            Companion.InitCall initCall = this.A;
            if (initCall != null) {
                initCall.c(activity.getString(R.string.detect_face_in));
            }
            g();
        }
    }

    public final void f() {
        try {
            SurfaceHolder surfaceHolder = this.f;
            if (surfaceHolder != null) {
                FacePointManager$initParams$1 facePointManager$initParams$1 = this.h;
                if (facePointManager$initParams$1 != null) {
                    surfaceHolder.removeCallback(facePointManager$initParams$1);
                    Camera camera = this.q;
                    if (camera != null) {
                        camera.setErrorCallback((Camera.ErrorCallback) null);
                    }
                    Camera camera2 = this.q;
                    if (camera2 != null) {
                        camera2.setPreviewCallback((Camera.PreviewCallback) null);
                    }
                    Camera camera3 = this.q;
                    if (camera3 != null) {
                        camera3.stopPreview();
                    }
                    CameraUtils.a(this.q);
                    this.q = null;
                    return;
                }
                Intrinsics.k("mSurfaceCallback");
                throw null;
            }
            Intrinsics.k("mSurfaceHolder");
            throw null;
        } catch (RuntimeException e2) {
            FirebaseCrashlytics.getInstance().recordException(e2);
        } catch (Exception e3) {
            FirebaseCrashlytics.getInstance().recordException(e3);
        } catch (Throwable th) {
            CameraUtils.a(this.q);
            this.q = null;
            throw th;
        }
    }

    /* JADX WARNING: type inference failed for: r2v6, types: [android.hardware.Camera$ErrorCallback, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x015f A[Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x016b A[Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0177 A[Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00eb A[Catch:{ Exception -> 0x00ef }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x012d A[Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x013f A[Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0148 A[Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0158 A[Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g() {
        /*
            r8 = this;
            android.hardware.Camera r0 = r8.q
            r1 = 0
            if (r0 == 0) goto L_0x000a
            r8.f()
            r8.q = r1
        L_0x000a:
            android.view.SurfaceView r0 = r8.e
            java.lang.String r2 = "mSurfaceView"
            if (r0 == 0) goto L_0x01a2
            android.view.SurfaceHolder r0 = r0.getHolder()
            java.lang.String r3 = "mSurfaceHolder"
            if (r0 == 0) goto L_0x003a
            android.view.SurfaceView r0 = r8.e
            if (r0 == 0) goto L_0x0036
            android.view.SurfaceHolder r0 = r0.getHolder()
            r8.f = r0
            if (r0 == 0) goto L_0x0032
            com.katkilat.baidu_face.manager.FacePointManager$initParams$1 r2 = r8.h
            if (r2 == 0) goto L_0x002c
            r0.addCallback(r2)
            goto L_0x003a
        L_0x002c:
            java.lang.String r0 = "mSurfaceCallback"
            kotlin.jvm.internal.Intrinsics.k(r0)
            throw r1
        L_0x0032:
            kotlin.jvm.internal.Intrinsics.k(r3)
            throw r1
        L_0x0036:
            kotlin.jvm.internal.Intrinsics.k(r2)
            throw r1
        L_0x003a:
            android.hardware.Camera r0 = r8.q
            r2 = 1
            r4 = 0
            if (r0 != 0) goto L_0x007b
            int r0 = android.hardware.Camera.getNumberOfCameras()     // Catch:{ Exception -> 0x006d }
            if (r0 != 0) goto L_0x0048
            r0 = r1
            goto L_0x006a
        L_0x0048:
            r5 = 0
        L_0x0049:
            if (r5 >= r0) goto L_0x005b
            android.hardware.Camera$CameraInfo r6 = new android.hardware.Camera$CameraInfo     // Catch:{ Exception -> 0x006d }
            r6.<init>()     // Catch:{ Exception -> 0x006d }
            android.hardware.Camera.getCameraInfo(r5, r6)     // Catch:{ Exception -> 0x006d }
            int r6 = r6.facing     // Catch:{ Exception -> 0x006d }
            if (r6 != r2) goto L_0x0058
            goto L_0x005b
        L_0x0058:
            int r5 = r5 + 1
            goto L_0x0049
        L_0x005b:
            if (r5 >= r0) goto L_0x0064
            android.hardware.Camera r0 = android.hardware.Camera.open(r5)     // Catch:{ Exception -> 0x006d }
            r8.s = r5     // Catch:{ Exception -> 0x006d }
            goto L_0x006a
        L_0x0064:
            android.hardware.Camera r0 = android.hardware.Camera.open(r4)     // Catch:{ Exception -> 0x006d }
            r8.s = r4     // Catch:{ Exception -> 0x006d }
        L_0x006a:
            r8.q = r0     // Catch:{ Exception -> 0x006d }
            goto L_0x007b
        L_0x006d:
            r0 = move-exception
            com.ktakilat.cbase.datacollect.KtaCollect.n_live_page_camera_init_fail()
            com.google.firebase.crashlytics.FirebaseCrashlytics r5 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            r5.recordException(r0)
            r0.printStackTrace()
        L_0x007b:
            android.hardware.Camera r0 = r8.q
            if (r0 != 0) goto L_0x0080
            return
        L_0x0080:
            android.hardware.Camera$Parameters r5 = r8.r
            if (r5 != 0) goto L_0x008a
            android.hardware.Camera$Parameters r0 = r0.getParameters()
            r8.r = r0
        L_0x008a:
            android.hardware.Camera$Parameters r0 = r8.r
            if (r0 == 0) goto L_0x0093
            r5 = 256(0x100, float:3.59E-43)
            r0.setPictureFormat(r5)
        L_0x0093:
            java.lang.String r0 = "window"
            android.app.Activity r5 = r8.f459a
            java.lang.Object r0 = r5.getSystemService(r0)
            java.lang.String r5 = "null cannot be cast to non-null type android.view.WindowManager"
            kotlin.jvm.internal.Intrinsics.d(r0, r5)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            int r0 = r0.getRotation()
            if (r0 == 0) goto L_0x00b4
            if (r0 == r2) goto L_0x00bc
            r5 = 2
            if (r0 == r5) goto L_0x00b9
            r5 = 3
            if (r0 == r5) goto L_0x00b6
        L_0x00b4:
            r0 = 0
            goto L_0x00be
        L_0x00b6:
            r0 = 270(0x10e, float:3.78E-43)
            goto L_0x00be
        L_0x00b9:
            r0 = 180(0xb4, float:2.52E-43)
            goto L_0x00be
        L_0x00bc:
            r0 = 90
        L_0x00be:
            int r5 = 360 - r0
            int r5 = r5 % 360
            boolean r6 = com.baidu.idl.face.platform.utils.APIUtils.hasGingerbread()
            if (r6 == 0) goto L_0x00e7
            android.hardware.Camera$CameraInfo r5 = new android.hardware.Camera$CameraInfo
            r5.<init>()
            int r6 = r8.s
            android.hardware.Camera.getCameraInfo(r6, r5)
            int r6 = r5.facing
            if (r6 != r2) goto L_0x00e0
            int r2 = r5.orientation
            int r2 = r2 + r0
            int r2 = r2 % 360
            int r0 = 360 - r2
            int r5 = r0 % 360
            goto L_0x00e7
        L_0x00e0:
            int r2 = r5.orientation
            int r2 = r2 - r0
            int r2 = r2 + 360
            int r5 = r2 % 360
        L_0x00e7:
            android.hardware.Camera r0 = r8.q     // Catch:{ Exception -> 0x00ef }
            if (r0 == 0) goto L_0x00f7
            r0.setDisplayOrientation(r5)     // Catch:{ Exception -> 0x00ef }
            goto L_0x00f7
        L_0x00ef:
            r0 = move-exception
            com.google.firebase.crashlytics.FirebaseCrashlytics r2 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            r2.recordException(r0)
        L_0x00f7:
            android.hardware.Camera$Parameters r0 = r8.r
            if (r0 == 0) goto L_0x0100
            java.lang.String r2 = "rotation"
            r0.set(r2, r5)
        L_0x0100:
            r8.v = r5
            android.hardware.Camera$Parameters r0 = r8.r
            android.graphics.Point r2 = new android.graphics.Point
            r6 = 640(0x280, float:8.97E-43)
            r7 = 480(0x1e0, float:6.73E-43)
            r2.<init>(r6, r7)
            android.graphics.Point r0 = com.katkilat.baidu_face.utils.CameraPreviewUtils.a(r0, r2)
            int r2 = r0.x
            r8.t = r2
            int r0 = r0.y
            r8.u = r0
            com.baidu.idl.face.platform.ILivenessStrategy r0 = r8.l
            if (r0 == 0) goto L_0x0120
            r0.setPreviewDegree(r5)
        L_0x0120:
            int r0 = r8.u
            int r2 = r8.t
            android.graphics.Rect r5 = r8.m
            r5.set(r4, r4, r0, r2)
            android.hardware.Camera$Parameters r0 = r8.r     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
            if (r0 == 0) goto L_0x013b
            int r2 = r8.t     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
            int r4 = r8.u     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
            r0.setPreviewSize(r2, r4)     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
            goto L_0x013b
        L_0x0135:
            r0 = move-exception
            goto L_0x017b
        L_0x0137:
            r0 = move-exception
            goto L_0x0188
        L_0x0139:
            r0 = move-exception
            goto L_0x0195
        L_0x013b:
            android.hardware.Camera r0 = r8.q     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
            if (r0 == 0) goto L_0x0144
            android.hardware.Camera$Parameters r2 = r8.r     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
            r0.setParameters(r2)     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
        L_0x0144:
            android.hardware.Camera r0 = r8.q     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
            if (r0 == 0) goto L_0x0154
            android.view.SurfaceHolder r2 = r8.f     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
            if (r2 == 0) goto L_0x0150
            r0.setPreviewDisplay(r2)     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
            goto L_0x0154
        L_0x0150:
            kotlin.jvm.internal.Intrinsics.k(r3)     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
            throw r1     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
        L_0x0154:
            android.hardware.Camera r0 = r8.q     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
            if (r0 == 0) goto L_0x015b
            r0.stopPreview()     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
        L_0x015b:
            android.hardware.Camera r0 = r8.q     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
            if (r0 == 0) goto L_0x0167
            com.katkilat.baidu_face.manager.FacePointManager$startPreview$1 r2 = new com.katkilat.baidu_face.manager.FacePointManager$startPreview$1     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
            r2.<init>()     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
            r0.setErrorCallback(r2)     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
        L_0x0167:
            android.hardware.Camera r0 = r8.q     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
            if (r0 == 0) goto L_0x0173
            com.katkilat.baidu_face.manager.FacePointManager$startPreview$2 r2 = new com.katkilat.baidu_face.manager.FacePointManager$startPreview$2     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
            r2.<init>(r8)     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
            r0.setPreviewCallback(r2)     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
        L_0x0173:
            android.hardware.Camera r0 = r8.q     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
            if (r0 == 0) goto L_0x01a1
            r0.startPreview()     // Catch:{ RuntimeException -> 0x0139, Exception -> 0x0137, all -> 0x0135 }
            goto L_0x01a1
        L_0x017b:
            r8.f()
            r8.q = r1
            com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            r1.recordException(r0)
            goto L_0x01a1
        L_0x0188:
            r8.f()
            r8.q = r1
            com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            r1.recordException(r0)
            goto L_0x01a1
        L_0x0195:
            r8.f()
            r8.q = r1
            com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            r1.recordException(r0)
        L_0x01a1:
            return
        L_0x01a2:
            kotlin.jvm.internal.Intrinsics.k(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.katkilat.baidu_face.manager.FacePointManager.g():void");
    }

    public final void h() {
        AnimationDrawable animationDrawable = this.y;
        if (animationDrawable != null) {
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
            this.y = null;
        }
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout == null) {
            Intrinsics.k("mAddIvLayout");
            throw null;
        } else if (relativeLayout.getVisibility() == 0) {
            RelativeLayout relativeLayout2 = this.d;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(4);
            } else {
                Intrinsics.k("mAddIvLayout");
                throw null;
            }
        }
    }
}
