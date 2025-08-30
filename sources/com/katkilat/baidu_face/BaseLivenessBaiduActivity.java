package com.katkilat.baidu_face;

import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.media.AudioManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.face.platform.ILivenessStrategy;
import com.baidu.idl.face.platform.ILivenessStrategyCallback;
import com.baidu.idl.face.platform.ILivenessViewCallback;
import com.baidu.idl.face.platform.LivenessTypeEnum;
import com.baidu.idl.face.platform.manager.TimeManager;
import com.baidu.idl.face.platform.model.FaceExtInfo;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.katkilat.baidu_face.databinding.ActivityLivenessBaiduBinding;
import com.katkilat.baidu_face.utils.CameraUtils;
import com.katkilat.baidu_face.utils.VolumeUtils;
import com.katkilat.baidu_face.widget.FaceDetectRoundView;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.utils.BarUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/katkilat/baidu_face/BaseLivenessBaiduActivity;", "Lcom/ktakilat/cbase/ui/BaseActivity;", "Landroid/view/SurfaceHolder$Callback;", "Landroid/hardware/Camera$PreviewCallback;", "Landroid/hardware/Camera$ErrorCallback;", "Lcom/katkilat/baidu_face/utils/VolumeUtils$VolumeCallback;", "Lcom/baidu/idl/face/platform/ILivenessStrategyCallback;", "Lcom/baidu/idl/face/platform/ILivenessViewCallback;", "<init>", "()V", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaseLivenessBaiduActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseLivenessBaiduActivity.kt\ncom/katkilat/baidu_face/BaseLivenessBaiduActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,596:1\n1863#2,2:597\n1863#2,2:599\n*S KotlinDebug\n*F\n+ 1 BaseLivenessBaiduActivity.kt\ncom/katkilat/baidu_face/BaseLivenessBaiduActivity\n*L\n559#1:597,2\n570#1:599,2\n*E\n"})
public class BaseLivenessBaiduActivity extends BaseActivity implements SurfaceHolder.Callback, Camera.PreviewCallback, Camera.ErrorCallback, VolumeUtils.VolumeCallback, ILivenessStrategyCallback, ILivenessViewCallback {
    public static final /* synthetic */ int E = 0;
    public boolean A;
    public BaseLivenessBaiduActivity B;
    public AnimationDrawable C;
    public LivenessTypeEnum D;
    public ActivityLivenessBaiduBinding i;
    public SurfaceView j;
    public SurfaceHolder k;
    public FaceDetectRoundView l;
    public ImageView m;
    public FaceConfig n;
    public ILivenessStrategy o;
    public final Rect p = new Rect();
    public int q;
    public volatile boolean r = true;
    public boolean s;
    public Camera t;
    public Camera.Parameters u;
    public int v;
    public int w;
    public int x;
    public int y;
    public VolumeUtils.Companion.VolumeReceiver z;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f453a;
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
                f453a = r0
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
            throw new UnsupportedOperationException("Method not decompiled: com.katkilat.baidu_face.BaseLivenessBaiduActivity.WhenMappings.<clinit>():void");
        }
    }

    public final void A() {
        try {
            SurfaceHolder surfaceHolder = this.k;
            if (surfaceHolder != null) {
                surfaceHolder.removeCallback(this);
                Camera camera = this.t;
                if (camera != null) {
                    camera.setErrorCallback((Camera.ErrorCallback) null);
                }
                Camera camera2 = this.t;
                if (camera2 != null) {
                    camera2.setPreviewCallback((Camera.PreviewCallback) null);
                }
                Camera camera3 = this.t;
                if (camera3 != null) {
                    camera3.stopPreview();
                }
                CameraUtils.a(this.t);
                this.t = null;
                return;
            }
            Intrinsics.k("mSurfaceHolder");
            throw null;
        } catch (RuntimeException e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
        } catch (Throwable th) {
            CameraUtils.a(this.t);
            this.t = null;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x015a A[Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0161 A[Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00df A[Catch:{ Exception -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0121 A[Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0133 A[Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x013c A[Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x014c A[Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0153 A[Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void B() {
        /*
            r8 = this;
            android.hardware.Camera r0 = r8.t
            r1 = 0
            if (r0 == 0) goto L_0x000a
            r8.A()
            r8.t = r1
        L_0x000a:
            android.view.SurfaceView r0 = r8.j
            java.lang.String r2 = "mSurfaceView"
            if (r0 == 0) goto L_0x0195
            android.view.SurfaceHolder r0 = r0.getHolder()
            java.lang.String r3 = "mSurfaceHolder"
            if (r0 == 0) goto L_0x0030
            android.view.SurfaceView r0 = r8.j
            if (r0 == 0) goto L_0x002c
            android.view.SurfaceHolder r0 = r0.getHolder()
            r8.k = r0
            if (r0 == 0) goto L_0x0028
            r0.addCallback(r8)
            goto L_0x0030
        L_0x0028:
            kotlin.jvm.internal.Intrinsics.k(r3)
            throw r1
        L_0x002c:
            kotlin.jvm.internal.Intrinsics.k(r2)
            throw r1
        L_0x0030:
            android.hardware.Camera r0 = r8.t
            r2 = 1
            r4 = 0
            if (r0 != 0) goto L_0x0071
            int r0 = android.hardware.Camera.getNumberOfCameras()     // Catch:{ Exception -> 0x0063 }
            if (r0 != 0) goto L_0x003e
            r0 = r1
            goto L_0x0060
        L_0x003e:
            r5 = 0
        L_0x003f:
            if (r5 >= r0) goto L_0x0051
            android.hardware.Camera$CameraInfo r6 = new android.hardware.Camera$CameraInfo     // Catch:{ Exception -> 0x0063 }
            r6.<init>()     // Catch:{ Exception -> 0x0063 }
            android.hardware.Camera.getCameraInfo(r5, r6)     // Catch:{ Exception -> 0x0063 }
            int r6 = r6.facing     // Catch:{ Exception -> 0x0063 }
            if (r6 != r2) goto L_0x004e
            goto L_0x0051
        L_0x004e:
            int r5 = r5 + 1
            goto L_0x003f
        L_0x0051:
            if (r5 >= r0) goto L_0x005a
            android.hardware.Camera r0 = android.hardware.Camera.open(r5)     // Catch:{ Exception -> 0x0063 }
            r8.v = r5     // Catch:{ Exception -> 0x0063 }
            goto L_0x0060
        L_0x005a:
            android.hardware.Camera r0 = android.hardware.Camera.open(r4)     // Catch:{ Exception -> 0x0063 }
            r8.v = r4     // Catch:{ Exception -> 0x0063 }
        L_0x0060:
            r8.t = r0     // Catch:{ Exception -> 0x0063 }
            goto L_0x0071
        L_0x0063:
            r0 = move-exception
            com.ktakilat.cbase.datacollect.KtaCollect.n_live_page_camera_init_fail()
            com.google.firebase.crashlytics.FirebaseCrashlytics r5 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            r5.recordException(r0)
            r0.printStackTrace()
        L_0x0071:
            android.hardware.Camera r0 = r8.t
            if (r0 != 0) goto L_0x0076
            return
        L_0x0076:
            android.hardware.Camera$Parameters r5 = r8.u
            if (r5 != 0) goto L_0x0080
            android.hardware.Camera$Parameters r0 = r0.getParameters()
            r8.u = r0
        L_0x0080:
            android.hardware.Camera$Parameters r0 = r8.u
            if (r0 == 0) goto L_0x0089
            r5 = 256(0x100, float:3.59E-43)
            r0.setPictureFormat(r5)
        L_0x0089:
            java.lang.String r0 = "window"
            java.lang.Object r0 = r8.getSystemService(r0)
            java.lang.String r5 = "null cannot be cast to non-null type android.view.WindowManager"
            kotlin.jvm.internal.Intrinsics.d(r0, r5)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            int r0 = r0.getRotation()
            if (r0 == 0) goto L_0x00a8
            if (r0 == r2) goto L_0x00b0
            r5 = 2
            if (r0 == r5) goto L_0x00ad
            r5 = 3
            if (r0 == r5) goto L_0x00aa
        L_0x00a8:
            r0 = 0
            goto L_0x00b2
        L_0x00aa:
            r0 = 270(0x10e, float:3.78E-43)
            goto L_0x00b2
        L_0x00ad:
            r0 = 180(0xb4, float:2.52E-43)
            goto L_0x00b2
        L_0x00b0:
            r0 = 90
        L_0x00b2:
            int r5 = 360 - r0
            int r5 = r5 % 360
            boolean r6 = com.baidu.idl.face.platform.utils.APIUtils.hasGingerbread()
            if (r6 == 0) goto L_0x00db
            android.hardware.Camera$CameraInfo r5 = new android.hardware.Camera$CameraInfo
            r5.<init>()
            int r6 = r8.v
            android.hardware.Camera.getCameraInfo(r6, r5)
            int r6 = r5.facing
            if (r6 != r2) goto L_0x00d4
            int r2 = r5.orientation
            int r2 = r2 + r0
            int r2 = r2 % 360
            int r0 = 360 - r2
            int r5 = r0 % 360
            goto L_0x00db
        L_0x00d4:
            int r2 = r5.orientation
            int r2 = r2 - r0
            int r2 = r2 + 360
            int r5 = r2 % 360
        L_0x00db:
            android.hardware.Camera r0 = r8.t     // Catch:{ Exception -> 0x00e3 }
            if (r0 == 0) goto L_0x00eb
            r0.setDisplayOrientation(r5)     // Catch:{ Exception -> 0x00e3 }
            goto L_0x00eb
        L_0x00e3:
            r0 = move-exception
            com.google.firebase.crashlytics.FirebaseCrashlytics r2 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            r2.recordException(r0)
        L_0x00eb:
            android.hardware.Camera$Parameters r0 = r8.u
            if (r0 == 0) goto L_0x00f4
            java.lang.String r2 = "rotation"
            r0.set(r2, r5)
        L_0x00f4:
            r8.y = r5
            android.hardware.Camera$Parameters r0 = r8.u
            android.graphics.Point r2 = new android.graphics.Point
            r6 = 640(0x280, float:8.97E-43)
            r7 = 480(0x1e0, float:6.73E-43)
            r2.<init>(r6, r7)
            android.graphics.Point r0 = com.katkilat.baidu_face.utils.CameraPreviewUtils.a(r0, r2)
            int r2 = r0.x
            r8.w = r2
            int r0 = r0.y
            r8.x = r0
            com.baidu.idl.face.platform.ILivenessStrategy r0 = r8.o
            if (r0 == 0) goto L_0x0114
            r0.setPreviewDegree(r5)
        L_0x0114:
            int r0 = r8.x
            int r2 = r8.w
            android.graphics.Rect r5 = r8.p
            r5.set(r4, r4, r0, r2)
            android.hardware.Camera$Parameters r0 = r8.u     // Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }
            if (r0 == 0) goto L_0x012f
            int r2 = r8.w     // Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }
            int r4 = r8.x     // Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }
            r0.setPreviewSize(r2, r4)     // Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }
            goto L_0x012f
        L_0x0129:
            r0 = move-exception
            goto L_0x0165
        L_0x012b:
            r0 = move-exception
            goto L_0x0175
        L_0x012d:
            r0 = move-exception
            goto L_0x0185
        L_0x012f:
            android.hardware.Camera r0 = r8.t     // Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }
            if (r0 == 0) goto L_0x0138
            android.hardware.Camera$Parameters r2 = r8.u     // Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }
            r0.setParameters(r2)     // Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }
        L_0x0138:
            android.hardware.Camera r0 = r8.t     // Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }
            if (r0 == 0) goto L_0x0148
            android.view.SurfaceHolder r2 = r8.k     // Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }
            if (r2 == 0) goto L_0x0144
            r0.setPreviewDisplay(r2)     // Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }
            goto L_0x0148
        L_0x0144:
            kotlin.jvm.internal.Intrinsics.k(r3)     // Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }
            throw r1     // Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }
        L_0x0148:
            android.hardware.Camera r0 = r8.t     // Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }
            if (r0 == 0) goto L_0x014f
            r0.stopPreview()     // Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }
        L_0x014f:
            android.hardware.Camera r0 = r8.t     // Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }
            if (r0 == 0) goto L_0x0156
            r0.setErrorCallback(r8)     // Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }
        L_0x0156:
            android.hardware.Camera r0 = r8.t     // Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }
            if (r0 == 0) goto L_0x015d
            r0.setPreviewCallback(r8)     // Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }
        L_0x015d:
            android.hardware.Camera r0 = r8.t     // Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }
            if (r0 == 0) goto L_0x0194
            r0.startPreview()     // Catch:{ RuntimeException -> 0x012d, Exception -> 0x012b, all -> 0x0129 }
            goto L_0x0194
        L_0x0165:
            r0.printStackTrace()
            r8.A()
            r8.t = r1
            com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            r1.recordException(r0)
            goto L_0x0194
        L_0x0175:
            r0.printStackTrace()
            r8.A()
            r8.t = r1
            com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            r1.recordException(r0)
            goto L_0x0194
        L_0x0185:
            r0.printStackTrace()
            r8.A()
            r8.t = r1
            com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            r1.recordException(r0)
        L_0x0194:
            return
        L_0x0195:
            kotlin.jvm.internal.Intrinsics.k(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.katkilat.baidu_face.BaseLivenessBaiduActivity.B():void");
    }

    public final void C() {
        AnimationDrawable animationDrawable = this.C;
        if (animationDrawable != null) {
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
            this.C = null;
        }
        if (z().addImageLayout.getVisibility() == 0) {
            z().addImageLayout.setVisibility(4);
        }
    }

    public final void animStop() {
        C();
    }

    public final void c() {
        boolean z2;
        int i2;
        try {
            AudioManager audioManager = (AudioManager) getSystemService("audio");
            if (audioManager != null) {
                if (audioManager.getStreamVolume(3) > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.r = z2;
                ImageView imageView = z().soundImage;
                if (this.r) {
                    i2 = R.mipmap.icon_titlebar_voice2;
                } else {
                    i2 = R.mipmap.icon_titlebar_voice1;
                }
                imageView.setImageResource(i2);
                ILivenessStrategy iLivenessStrategy = this.o;
                if (iLivenessStrategy != null) {
                    iLivenessStrategy.setLivenessStrategySoundEnable(this.r);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onCreate(Bundle bundle) {
        int i2;
        int i3;
        super.onCreate(bundle);
        Intrinsics.checkNotNullParameter(this, "activity");
        boolean z2 = false;
        try {
            i2 = Settings.System.getInt(getContentResolver(), "screen_brightness");
        } catch (Exception e) {
            e.printStackTrace();
            i2 = 0;
        }
        Intrinsics.checkNotNullParameter(this, "activity");
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.screenBrightness = ((float) (i2 + 100)) * 0.003921569f;
        getWindow().setAttributes(attributes);
        getWindow().addFlags(128);
        ActivityLivenessBaiduBinding inflate = ActivityLivenessBaiduBinding.inflate(LayoutInflater.from(this));
        Intrinsics.checkNotNullParameter(inflate, "<set-?>");
        this.i = inflate;
        setContentView((View) z().getRoot());
        v();
        this.B = this;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.q = displayMetrics.widthPixels;
        FaceSDKResSettings.a();
        this.n = FaceSDKManager.getInstance().getFaceConfig();
        Object systemService = getSystemService("audio");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        if (((AudioManager) systemService).getStreamVolume(3) > 0) {
            FaceConfig faceConfig = this.n;
            if (faceConfig != null) {
                z2 = faceConfig.isSound();
            } else {
                Intrinsics.k("mFaceConfig");
                throw null;
            }
        }
        this.r = z2;
        SurfaceView surfaceView = new SurfaceView(this);
        this.j = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        this.k = holder;
        if (holder != null) {
            holder.setSizeFromLayout();
            SurfaceHolder surfaceHolder = this.k;
            if (surfaceHolder != null) {
                surfaceHolder.addCallback(this);
                SurfaceHolder surfaceHolder2 = this.k;
                if (surfaceHolder2 != null) {
                    surfaceHolder2.setType(3);
                    float f = ((float) this.q) * 0.75f * 0.9f;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) f, (int) ((f * 640.0f) / 480.0f), 17);
                    SurfaceView surfaceView2 = this.j;
                    if (surfaceView2 != null) {
                        surfaceView2.setLayoutParams(layoutParams);
                        FrameLayout frameLayout = z().surfaceLayout;
                        SurfaceView surfaceView3 = this.j;
                        if (surfaceView3 != null) {
                            frameLayout.addView(surfaceView3);
                            z().titleInclude.backward.setOnClickListener(new w0(this, 0));
                            FaceDetectRoundView faceDetectRoundView = z().faceRound;
                            this.l = faceDetectRoundView;
                            if (faceDetectRoundView != null) {
                                faceDetectRoundView.setIsActiveLive(true);
                                ImageView imageView = z().soundImage;
                                if (this.r) {
                                    i3 = R.mipmap.icon_titlebar_voice2;
                                } else {
                                    i3 = R.drawable.collect_image_voice_selector;
                                }
                                imageView.setImageResource(i3);
                                z().soundImage.setOnClickListener(new w0(this, 1));
                                FaceDetectRoundView faceDetectRoundView2 = this.l;
                                if (faceDetectRoundView2 != null) {
                                    faceDetectRoundView2.post(new x0(this, 0));
                                } else {
                                    Intrinsics.k("mFaceDetectRoundView");
                                    throw null;
                                }
                            } else {
                                Intrinsics.k("mFaceDetectRoundView");
                                throw null;
                            }
                        } else {
                            Intrinsics.k("mSurfaceView");
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
                Intrinsics.k("mSurfaceHolder");
                throw null;
            }
        } else {
            Intrinsics.k("mSurfaceHolder");
            throw null;
        }
    }

    public final void onError(int i2, Camera camera) {
    }

    public void onLivenessCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap hashMap, HashMap hashMap2, int i2) {
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(faceStatusNewEnum, "status");
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        if (!this.s) {
            Drawable drawable = null;
            switch (WhenMappings.f453a[faceStatusNewEnum.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    z().topTipsTv.setText(str);
                    z().secondTipsTv.setText("");
                    FaceDetectRoundView faceDetectRoundView = this.l;
                    if (faceDetectRoundView != null) {
                        FaceConfig faceConfig = this.n;
                        if (faceConfig != null) {
                            faceDetectRoundView.setProcessCount(i2, faceConfig.getLivenessTypeList().size());
                            C();
                            break;
                        } else {
                            Intrinsics.k("mFaceConfig");
                            throw null;
                        }
                    } else {
                        Intrinsics.k("mFaceDetectRoundView");
                        throw null;
                    }
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    z().topTipsTv.setText(str);
                    z().secondTipsTv.setText("");
                    FaceDetectRoundView faceDetectRoundView2 = this.l;
                    if (faceDetectRoundView2 != null) {
                        FaceConfig faceConfig2 = this.n;
                        if (faceConfig2 != null) {
                            faceDetectRoundView2.setProcessCount(i2, faceConfig2.getLivenessTypeList().size());
                            break;
                        } else {
                            Intrinsics.k("mFaceConfig");
                            throw null;
                        }
                    } else {
                        Intrinsics.k("mFaceDetectRoundView");
                        throw null;
                    }
                case 14:
                case 15:
                case 16:
                case 17:
                    TextView textView = z().topTipsTv;
                    BaseLivenessBaiduActivity baseLivenessBaiduActivity = this.B;
                    if (baseLivenessBaiduActivity != null) {
                        textView.setText(baseLivenessBaiduActivity.getString(R.string.liveness_tip));
                        z().secondTipsTv.setText(str);
                        FaceDetectRoundView faceDetectRoundView3 = this.l;
                        if (faceDetectRoundView3 != null) {
                            FaceConfig faceConfig3 = this.n;
                            if (faceConfig3 != null) {
                                faceDetectRoundView3.setProcessCount(i2, faceConfig3.getLivenessTypeList().size());
                                break;
                            } else {
                                Intrinsics.k("mFaceConfig");
                                throw null;
                            }
                        } else {
                            Intrinsics.k("mFaceDetectRoundView");
                            throw null;
                        }
                    } else {
                        Intrinsics.k("mContext");
                        throw null;
                    }
                case 18:
                    FaceDetectRoundView faceDetectRoundView4 = this.l;
                    if (faceDetectRoundView4 != null) {
                        FaceConfig faceConfig4 = this.n;
                        if (faceConfig4 != null) {
                            faceDetectRoundView4.setProcessCount(i2, faceConfig4.getLivenessTypeList().size());
                            if (z().addImageLayout.getVisibility() == 4) {
                                z().addImageLayout.setVisibility(0);
                            }
                            LivenessTypeEnum livenessTypeEnum = this.D;
                            if (livenessTypeEnum != null) {
                                switch (WhenMappings.b[livenessTypeEnum.ordinal()]) {
                                    case 1:
                                        ImageView imageView = this.m;
                                        if (imageView != null) {
                                            imageView.setBackgroundResource(R.drawable.anim_eye);
                                            break;
                                        }
                                        break;
                                    case 2:
                                        ImageView imageView2 = this.m;
                                        if (imageView2 != null) {
                                            imageView2.setBackgroundResource(R.drawable.anim_left);
                                            break;
                                        }
                                        break;
                                    case 3:
                                        ImageView imageView3 = this.m;
                                        if (imageView3 != null) {
                                            imageView3.setBackgroundResource(R.drawable.anim_right);
                                            break;
                                        }
                                        break;
                                    case 4:
                                        ImageView imageView4 = this.m;
                                        if (imageView4 != null) {
                                            imageView4.setBackgroundResource(R.drawable.anim_down);
                                            break;
                                        }
                                        break;
                                    case 5:
                                        ImageView imageView5 = this.m;
                                        if (imageView5 != null) {
                                            imageView5.setBackgroundResource(R.drawable.anim_up);
                                            break;
                                        }
                                        break;
                                    case 6:
                                        ImageView imageView6 = this.m;
                                        if (imageView6 != null) {
                                            imageView6.setBackgroundResource(R.drawable.anim_mouth);
                                            break;
                                        }
                                        break;
                                }
                                ImageView imageView7 = this.m;
                                if (imageView7 != null) {
                                    drawable = imageView7.getBackground();
                                }
                                Intrinsics.d(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                                AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
                                this.C = animationDrawable;
                                animationDrawable.start();
                            }
                            AnimationDrawable animationDrawable2 = this.C;
                            if (animationDrawable2 != null) {
                                i3 = animationDrawable2.getNumberOfFrames();
                            } else {
                                i3 = 0;
                            }
                            int i5 = 0;
                            for (int i6 = 0; i6 < i3; i6++) {
                                AnimationDrawable animationDrawable3 = this.C;
                                if (animationDrawable3 != null) {
                                    i4 = animationDrawable3.getDuration(i6);
                                } else {
                                    i4 = 0;
                                }
                                i5 += i4;
                            }
                            TimeManager.getInstance().setActiveAnimTime(i5);
                            break;
                        } else {
                            Intrinsics.k("mFaceConfig");
                            throw null;
                        }
                    } else {
                        Intrinsics.k("mFaceDetectRoundView");
                        throw null;
                    }
                default:
                    TextView textView2 = z().topTipsTv;
                    BaseLivenessBaiduActivity baseLivenessBaiduActivity2 = this.B;
                    if (baseLivenessBaiduActivity2 != null) {
                        textView2.setText(baseLivenessBaiduActivity2.getString(R.string.liveness_tip));
                        z().secondTipsTv.setText(str);
                        FaceDetectRoundView faceDetectRoundView5 = this.l;
                        if (faceDetectRoundView5 != null) {
                            FaceConfig faceConfig5 = this.n;
                            if (faceConfig5 != null) {
                                faceDetectRoundView5.setProcessCount(i2, faceConfig5.getLivenessTypeList().size());
                                break;
                            } else {
                                Intrinsics.k("mFaceConfig");
                                throw null;
                            }
                        } else {
                            Intrinsics.k("mFaceDetectRoundView");
                            throw null;
                        }
                    } else {
                        Intrinsics.k("mContext");
                        throw null;
                    }
            }
            if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
                this.s = true;
            }
        }
    }

    public final void onPause() {
        ILivenessStrategy iLivenessStrategy = this.o;
        if (iLivenessStrategy != null) {
            iLivenessStrategy.reset();
        }
        VolumeUtils.Companion.VolumeReceiver volumeReceiver = this.z;
        if (volumeReceiver != null) {
            try {
                unregisterReceiver(volumeReceiver);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.z = null;
        FaceDetectRoundView faceDetectRoundView = this.l;
        if (faceDetectRoundView != null) {
            FaceConfig faceConfig = this.n;
            if (faceConfig != null) {
                faceDetectRoundView.setProcessCount(0, faceConfig.getLivenessTypeList().size());
                super.onPause();
                A();
                if (this.o != null) {
                    this.o = null;
                }
                this.s = false;
                return;
            }
            Intrinsics.k("mFaceConfig");
            throw null;
        }
        Intrinsics.k("mFaceDetectRoundView");
        throw null;
    }

    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        if (!this.s) {
            if (this.o == null) {
                ILivenessStrategy livenessStrategyModule = FaceSDKManager.getInstance().getLivenessStrategyModule(this);
                this.o = livenessStrategyModule;
                if (livenessStrategyModule != null) {
                    livenessStrategyModule.setPreviewDegree(this.y);
                }
                ILivenessStrategy iLivenessStrategy = this.o;
                if (iLivenessStrategy != null) {
                    iLivenessStrategy.setLivenessStrategySoundEnable(this.r);
                }
                int i2 = FaceDetectRoundView.t;
                Rect a2 = FaceDetectRoundView.Companion.a(this.q, this.x, this.w);
                ILivenessStrategy iLivenessStrategy2 = this.o;
                if (iLivenessStrategy2 != null) {
                    FaceConfig faceConfig = this.n;
                    if (faceConfig != null) {
                        iLivenessStrategy2.setLivenessStrategyConfig(faceConfig.getLivenessTypeList(), this.p, a2, this);
                    } else {
                        Intrinsics.k("mFaceConfig");
                        throw null;
                    }
                }
            }
            ILivenessStrategy iLivenessStrategy3 = this.o;
            if (iLivenessStrategy3 != null) {
                iLivenessStrategy3.livenessStrategy(bArr);
            }
        }
    }

    public final void onResume() {
        super.onResume();
        if (!this.A) {
            setVolumeControlStream(3);
            this.z = VolumeUtils.Companion.a(this, this);
            TextView textView = z().topTipsTv;
            BaseLivenessBaiduActivity baseLivenessBaiduActivity = this.B;
            if (baseLivenessBaiduActivity != null) {
                textView.setText(baseLivenessBaiduActivity.getString(R.string.detect_face_in));
                B();
                return;
            }
            Intrinsics.k("mContext");
            throw null;
        }
    }

    public final void setCurrentLiveType(LivenessTypeEnum livenessTypeEnum) {
        Intrinsics.checkNotNullParameter(livenessTypeEnum, "liveType");
        this.D = livenessTypeEnum;
    }

    public final void setFaceInfo(FaceExtInfo faceExtInfo) {
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(surfaceHolder, "holder");
        if (surfaceHolder.getSurface() != null) {
            B();
        }
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        Intrinsics.checkNotNullParameter(surfaceHolder, "holder");
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Intrinsics.checkNotNullParameter(surfaceHolder, "holder");
    }

    public final void v() {
        BarUtil.a(this, R.drawable.scaffold_white);
    }

    public final void viewReset() {
        FaceDetectRoundView faceDetectRoundView = this.l;
        if (faceDetectRoundView != null) {
            faceDetectRoundView.setProcessCount(0, 1);
        } else {
            Intrinsics.k("mFaceDetectRoundView");
            throw null;
        }
    }

    public final ActivityLivenessBaiduBinding z() {
        ActivityLivenessBaiduBinding activityLivenessBaiduBinding = this.i;
        if (activityLivenessBaiduBinding != null) {
            return activityLivenessBaiduBinding;
        }
        Intrinsics.k("binding");
        throw null;
    }
}
