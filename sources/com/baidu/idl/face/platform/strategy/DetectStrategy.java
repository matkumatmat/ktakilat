package com.baidu.idl.face.platform.strategy;

import android.graphics.Rect;
import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.face.platform.model.FaceExtInfo;

class DetectStrategy {
    private static final String TAG = "DetectStrategy";
    private FaceStatusNewEnum mCurrentFaceStatus;
    private long mDuration = 0;
    private boolean mTimeoutFlag = false;
    private float mTotalCropScore;

    /* renamed from: com.baidu.idl.face.platform.strategy.DetectStrategy$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.baidu.idl.face.platform.FaceStatusNewEnum[] r0 = com.baidu.idl.face.platform.FaceStatusNewEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum = r0
                com.baidu.idl.face.platform.FaceStatusNewEnum r1 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodePoorIllumination     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.idl.face.platform.FaceStatusNewEnum r1 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodeImageBlured     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.baidu.idl.face.platform.FaceStatusNewEnum r1 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodeOcclusionLeftEye     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.baidu.idl.face.platform.FaceStatusNewEnum r1 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodeOcclusionRightEye     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum     // Catch:{ NoSuchFieldError -> 0x003e }
                com.baidu.idl.face.platform.FaceStatusNewEnum r1 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodeOcclusionNose     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.baidu.idl.face.platform.FaceStatusNewEnum r1 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodeOcclusionMouth     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.baidu.idl.face.platform.FaceStatusNewEnum r1 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodeOcclusionLeftContour     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.baidu.idl.face.platform.FaceStatusNewEnum r1 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodeOcclusionRightContour     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum     // Catch:{ NoSuchFieldError -> 0x006c }
                com.baidu.idl.face.platform.FaceStatusNewEnum r1 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodeOcclusionChinContour     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.baidu.idl.face.platform.FaceStatusNewEnum r1 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodeTooFar     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.baidu.idl.face.platform.FaceStatusNewEnum r1 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodeTooClose     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.baidu.idl.face.platform.FaceStatusNewEnum r1 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodeNoFaceDetected     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum     // Catch:{ NoSuchFieldError -> 0x009c }
                com.baidu.idl.face.platform.FaceStatusNewEnum r1 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.baidu.idl.face.platform.FaceStatusNewEnum r1 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.baidu.idl.face.platform.FaceStatusNewEnum r1 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.baidu.idl.face.platform.FaceStatusNewEnum r1 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.face.platform.strategy.DetectStrategy.AnonymousClass1.<clinit>():void");
        }
    }

    private void checkTimeout(FaceStatusNewEnum faceStatusNewEnum, FaceConfig faceConfig) {
        if (faceConfig != null) {
            FaceStatusNewEnum faceStatusNewEnum2 = this.mCurrentFaceStatus;
            if (faceStatusNewEnum2 == null || faceStatusNewEnum2 != faceStatusNewEnum) {
                this.mCurrentFaceStatus = faceStatusNewEnum;
                this.mDuration = System.currentTimeMillis();
                this.mTimeoutFlag = false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mCurrentFaceStatus == faceStatusNewEnum && currentTimeMillis - this.mDuration > faceConfig.getTimeDetectModule()) {
                this.mTimeoutFlag = true;
            }
        }
    }

    private FaceStatusNewEnum getModuleState(FaceExtInfo[] faceExtInfoArr, Rect rect, boolean z, FaceConfig faceConfig) {
        FaceStatusNewEnum faceStatusNewEnum = FaceStatusNewEnum.OK;
        FaceExtInfo faceExtInfo = faceExtInfoArr[0];
        this.mTotalCropScore = 0.0f;
        if (!z) {
            if (faceExtInfo.getOcclusion().leftEye > faceConfig.getOcclusionLeftEyeValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionLeftEye;
            }
            this.mTotalCropScore = (1.0f - faceExtInfo.getOcclusion().leftEye) + this.mTotalCropScore;
            if (faceExtInfo.getOcclusion().rightEye > faceConfig.getOcclusionRightEyeValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionRightEye;
            }
            this.mTotalCropScore = (1.0f - faceExtInfo.getOcclusion().rightEye) + this.mTotalCropScore;
            if (faceExtInfo.getOcclusion().nose > faceConfig.getOcclusionNoseValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionNose;
            }
            this.mTotalCropScore = (1.0f - faceExtInfo.getOcclusion().nose) + this.mTotalCropScore;
            if (faceExtInfo.getOcclusion().mouth > faceConfig.getOcclusionMouthValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionMouth;
            }
            this.mTotalCropScore = (1.0f - faceExtInfo.getOcclusion().mouth) + this.mTotalCropScore;
            if (faceExtInfo.getOcclusion().leftCheek > faceConfig.getOcclusionLeftContourValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionLeftContour;
            }
            this.mTotalCropScore = (1.0f - faceExtInfo.getOcclusion().leftCheek) + this.mTotalCropScore;
            if (faceExtInfo.getOcclusion().rightCheek > faceConfig.getOcclusionRightContourValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionRightContour;
            }
            this.mTotalCropScore = (1.0f - faceExtInfo.getOcclusion().rightCheek) + this.mTotalCropScore;
            if (faceExtInfo.getOcclusion().chin > faceConfig.getOcclusionChinValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionChinContour;
            }
            this.mTotalCropScore = (1.0f - faceExtInfo.getOcclusion().chin) + this.mTotalCropScore;
        }
        if (((float) faceExtInfoArr[0].getFaceWidth()) < faceConfig.getFaceFarRatio() * ((float) rect.width())) {
            FaceStatusNewEnum faceStatusNewEnum2 = FaceStatusNewEnum.DetectRemindCodeTooFar;
            checkTimeout(faceStatusNewEnum2, faceConfig);
            return faceStatusNewEnum2;
        }
        if (((float) faceExtInfoArr[0].getFaceWidth()) > faceConfig.getFaceClosedRatio() * ((float) rect.width())) {
            FaceStatusNewEnum faceStatusNewEnum3 = FaceStatusNewEnum.DetectRemindCodeTooClose;
            checkTimeout(faceStatusNewEnum3, faceConfig);
            return faceStatusNewEnum3;
        } else if (faceExtInfo.getPitch() < ((float) ((-faceConfig.getHeadPitchValue()) - 2))) {
            return FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange;
        } else {
            if (faceExtInfo.getPitch() > ((float) (faceConfig.getHeadPitchValue() - 2))) {
                return FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange;
            }
            this.mTotalCropScore = ((45.0f - Math.abs(faceExtInfo.getPitch())) / 45.0f) + this.mTotalCropScore;
            if (faceExtInfo.getYaw() > ((float) faceConfig.getHeadYawValue())) {
                return FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange;
            }
            if (faceExtInfo.getYaw() < ((float) (-faceConfig.getHeadYawValue()))) {
                return FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange;
            }
            this.mTotalCropScore = ((45.0f - Math.abs(faceExtInfo.getYaw())) / 45.0f) + this.mTotalCropScore;
            if (faceExtInfo.getRoll() > ((float) faceConfig.getHeadRollValue())) {
                return FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange;
            }
            if (faceExtInfo.getRoll() < ((float) (-faceConfig.getHeadRollValue()))) {
                return FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange;
            }
            this.mTotalCropScore = ((45.0f - Math.abs(faceExtInfo.getRoll())) / 45.0f) + this.mTotalCropScore;
            if (faceExtInfo.getBluriness() > faceConfig.getBlurnessValue()) {
                return FaceStatusNewEnum.DetectRemindCodeImageBlured;
            }
            this.mTotalCropScore = (1.0f - faceExtInfo.getBluriness()) + this.mTotalCropScore;
            if (((float) faceExtInfo.getIllum()) < faceConfig.getBrightnessValue()) {
                return FaceStatusNewEnum.DetectRemindCodePoorIllumination;
            }
            if (((float) faceExtInfo.getIllum()) > faceConfig.getBrightnessMaxValue()) {
                return FaceStatusNewEnum.DetectRemindCodeMuchIllumination;
            }
            if (faceExtInfo.getLeftEyeClose() > faceConfig.getEyeClosedValue()) {
                return FaceStatusNewEnum.DetectRemindCodeLeftEyeClosed;
            }
            this.mTotalCropScore = (1.0f - faceExtInfo.getLeftEyeClose()) + this.mTotalCropScore;
            if (faceExtInfo.getRightEyeClose() > faceConfig.getEyeClosedValue()) {
                return FaceStatusNewEnum.DetectRemindCodeRightEyeClosed;
            }
            this.mTotalCropScore = (1.0f - faceExtInfo.getRightEyeClose()) + this.mTotalCropScore;
            return faceStatusNewEnum;
        }
    }

    private boolean isDefaultDetectStatus(FaceStatusNewEnum faceStatusNewEnum) {
        switch (AnonymousClass1.$SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[faceStatusNewEnum.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                return true;
            default:
                return false;
        }
    }

    public FaceStatusNewEnum checkDetect(Rect rect, FaceExtInfo[] faceExtInfoArr, FaceConfig faceConfig) {
        FaceExtInfo faceExtInfo;
        FaceStatusNewEnum faceStatusNewEnum = FaceStatusNewEnum.OK;
        if (faceExtInfoArr == null || faceExtInfoArr.length <= 0 || (faceExtInfo = faceExtInfoArr[0]) == null || faceConfig == null) {
            FaceStatusNewEnum faceStatusNewEnum2 = FaceStatusNewEnum.DetectRemindCodeNoFaceDetected;
            checkTimeout(faceStatusNewEnum2, faceConfig);
            return faceStatusNewEnum2;
        }
        if (((float) faceExtInfo.getFaceWidth()) > faceConfig.getFaceClosedRatio() * ((float) rect.width())) {
            FaceStatusNewEnum faceStatusNewEnum3 = FaceStatusNewEnum.DetectRemindCodeTooClose;
            checkTimeout(faceStatusNewEnum3, faceConfig);
            return faceStatusNewEnum3;
        }
        if (((float) faceExtInfoArr[0].getFaceWidth()) < faceConfig.getFaceFarRatio() * ((float) rect.width())) {
            FaceStatusNewEnum faceStatusNewEnum4 = FaceStatusNewEnum.DetectRemindCodeTooFar;
            checkTimeout(faceStatusNewEnum4, faceConfig);
            return faceStatusNewEnum4;
        } else if (faceExtInfoArr[0].getLandmarksOutOfDetectCount(rect) <= 10) {
            return faceStatusNewEnum;
        } else {
            FaceStatusNewEnum faceStatusNewEnum5 = FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame;
            checkTimeout(faceStatusNewEnum5, faceConfig);
            return faceStatusNewEnum5;
        }
    }

    public FaceStatusNewEnum getCropStatus(FaceExtInfo faceExtInfo, FaceConfig faceConfig) {
        if (faceExtInfo == null || faceConfig == null) {
            return FaceStatusNewEnum.DetectRemindCodeNoFaceDetected;
        }
        this.mTotalCropScore = 0.0f;
        if (faceExtInfo.getOcclusion().leftEye > faceConfig.getOcclusionLeftEyeValue()) {
            return FaceStatusNewEnum.DetectRemindCodeOcclusionLeftEye;
        }
        this.mTotalCropScore = (1.0f - faceExtInfo.getOcclusion().leftEye) + this.mTotalCropScore;
        if (faceExtInfo.getOcclusion().rightEye > faceConfig.getOcclusionRightEyeValue()) {
            return FaceStatusNewEnum.DetectRemindCodeOcclusionRightEye;
        }
        this.mTotalCropScore = (1.0f - faceExtInfo.getOcclusion().rightEye) + this.mTotalCropScore;
        if (faceExtInfo.getOcclusion().nose > faceConfig.getOcclusionNoseValue()) {
            return FaceStatusNewEnum.DetectRemindCodeOcclusionNose;
        }
        this.mTotalCropScore = (1.0f - faceExtInfo.getOcclusion().nose) + this.mTotalCropScore;
        if (faceExtInfo.getOcclusion().mouth > faceConfig.getOcclusionMouthValue()) {
            return FaceStatusNewEnum.DetectRemindCodeOcclusionMouth;
        }
        this.mTotalCropScore = (1.0f - faceExtInfo.getOcclusion().mouth) + this.mTotalCropScore;
        if (faceExtInfo.getOcclusion().leftCheek > faceConfig.getOcclusionLeftContourValue()) {
            return FaceStatusNewEnum.DetectRemindCodeOcclusionLeftContour;
        }
        this.mTotalCropScore = (1.0f - faceExtInfo.getOcclusion().leftCheek) + this.mTotalCropScore;
        if (faceExtInfo.getOcclusion().rightCheek > faceConfig.getOcclusionRightContourValue()) {
            return FaceStatusNewEnum.DetectRemindCodeOcclusionRightContour;
        }
        this.mTotalCropScore = (1.0f - faceExtInfo.getOcclusion().rightCheek) + this.mTotalCropScore;
        if (faceExtInfo.getOcclusion().chin > faceConfig.getOcclusionChinValue()) {
            return FaceStatusNewEnum.DetectRemindCodeOcclusionChinContour;
        }
        this.mTotalCropScore = (1.0f - faceExtInfo.getOcclusion().chin) + this.mTotalCropScore;
        if (faceExtInfo.getPitch() < ((float) ((-faceConfig.getHeadPitchValue()) - 2))) {
            return FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange;
        }
        if (faceExtInfo.getPitch() > ((float) (faceConfig.getHeadPitchValue() - 2))) {
            return FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange;
        }
        this.mTotalCropScore = ((45.0f - Math.abs(faceExtInfo.getPitch())) / 45.0f) + this.mTotalCropScore;
        if (faceExtInfo.getYaw() < ((float) (-faceConfig.getHeadYawValue()))) {
            return FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange;
        }
        if (faceExtInfo.getYaw() > ((float) faceConfig.getHeadYawValue())) {
            return FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange;
        }
        this.mTotalCropScore = ((45.0f - Math.abs(faceExtInfo.getYaw())) / 45.0f) + this.mTotalCropScore;
        if (faceExtInfo.getRoll() > ((float) faceConfig.getHeadRollValue())) {
            return FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange;
        }
        if (faceExtInfo.getRoll() < ((float) (-faceConfig.getHeadRollValue()))) {
            return FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange;
        }
        this.mTotalCropScore = ((45.0f - Math.abs(faceExtInfo.getRoll())) / 45.0f) + this.mTotalCropScore;
        if (faceExtInfo.getBluriness() > faceConfig.getBlurnessValue()) {
            return FaceStatusNewEnum.DetectRemindCodeImageBlured;
        }
        this.mTotalCropScore = (1.0f - faceExtInfo.getBluriness()) + this.mTotalCropScore;
        if (((float) faceExtInfo.getIllum()) < faceConfig.getBrightnessValue()) {
            return FaceStatusNewEnum.DetectRemindCodePoorIllumination;
        }
        if (((float) faceExtInfo.getIllum()) > faceConfig.getBrightnessMaxValue()) {
            return FaceStatusNewEnum.DetectRemindCodeMuchIllumination;
        }
        if (faceExtInfo.getLeftEyeClose() > faceConfig.getEyeClosedValue()) {
            return FaceStatusNewEnum.DetectRemindCodeLeftEyeClosed;
        }
        this.mTotalCropScore = (1.0f - faceExtInfo.getLeftEyeClose()) + this.mTotalCropScore;
        if (faceExtInfo.getRightEyeClose() > faceConfig.getEyeClosedValue()) {
            return FaceStatusNewEnum.DetectRemindCodeRightEyeClosed;
        }
        this.mTotalCropScore = (1.0f - faceExtInfo.getRightEyeClose()) + this.mTotalCropScore;
        return FaceStatusNewEnum.OK;
    }

    public FaceStatusNewEnum getDetectState(FaceExtInfo[] faceExtInfoArr, Rect rect, boolean z, FaceConfig faceConfig) {
        FaceExtInfo faceExtInfo;
        FaceStatusNewEnum faceStatusNewEnum = FaceStatusNewEnum.OK;
        if (faceExtInfoArr == null || faceExtInfoArr.length <= 0 || (faceExtInfo = faceExtInfoArr[0]) == null || faceConfig == null) {
            FaceStatusNewEnum faceStatusNewEnum2 = FaceStatusNewEnum.DetectRemindCodeNoFaceDetected;
            checkTimeout(faceStatusNewEnum2, faceConfig);
            return faceStatusNewEnum2;
        } else if (faceExtInfo.getLandmarksOutOfDetectCount(rect) <= 10) {
            return getModuleState(faceExtInfoArr, rect, z, faceConfig);
        } else {
            FaceStatusNewEnum faceStatusNewEnum3 = FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame;
            checkTimeout(faceStatusNewEnum3, faceConfig);
            return faceStatusNewEnum3;
        }
    }

    public float getTotalCropScore() {
        return this.mTotalCropScore;
    }

    public boolean isTimeout() {
        return this.mTimeoutFlag;
    }

    public void reset() {
        this.mDuration = 0;
        this.mTimeoutFlag = false;
        this.mCurrentFaceStatus = null;
        this.mTotalCropScore = 0.0f;
    }
}
