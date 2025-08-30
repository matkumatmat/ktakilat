package com.baidu.idl.face.platform.strategy;

import android.graphics.Rect;
import android.util.Log;
import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.face.platform.LivenessTypeEnum;
import com.baidu.idl.face.platform.model.FaceExtInfo;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class LivenessStatusStrategy {
    private static final String TAG = "LivenessStatusStrategy";
    private volatile LivenessTypeEnum mCurrentLivenessTypeEnum;
    private long mFaceID;
    private long mLivenessDuration;
    private volatile int mLivenessIndex;
    private List<LivenessTypeEnum> mLivenessList;
    private HashMap<LivenessTypeEnum, Boolean> mLivenessStatusMap;
    private long mLivenessTimeDuration;
    private boolean mLivenessTimeoutFlag;
    private long mQualityDuration;

    /* renamed from: com.baidu.idl.face.platform.strategy.LivenessStatusStrategy$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.baidu.idl.face.platform.LivenessTypeEnum[] r0 = com.baidu.idl.face.platform.LivenessTypeEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum = r0
                com.baidu.idl.face.platform.LivenessTypeEnum r1 = com.baidu.idl.face.platform.LivenessTypeEnum.Eye     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.idl.face.platform.LivenessTypeEnum r1 = com.baidu.idl.face.platform.LivenessTypeEnum.Mouth     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.baidu.idl.face.platform.LivenessTypeEnum r1 = com.baidu.idl.face.platform.LivenessTypeEnum.HeadUp     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.baidu.idl.face.platform.LivenessTypeEnum r1 = com.baidu.idl.face.platform.LivenessTypeEnum.HeadDown     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum     // Catch:{ NoSuchFieldError -> 0x003e }
                com.baidu.idl.face.platform.LivenessTypeEnum r1 = com.baidu.idl.face.platform.LivenessTypeEnum.HeadLeft     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.baidu.idl.face.platform.LivenessTypeEnum r1 = com.baidu.idl.face.platform.LivenessTypeEnum.HeadRight     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.face.platform.strategy.LivenessStatusStrategy.AnonymousClass1.<clinit>():void");
        }
    }

    public LivenessStatusStrategy() {
        this.mLivenessIndex = 0;
        this.mLivenessTimeoutFlag = false;
        this.mCurrentLivenessTypeEnum = null;
        this.mFaceID = -1;
        this.mLivenessStatusMap = new HashMap<>();
        this.mQualityDuration = 0;
        this.mLivenessTimeDuration = 0;
        this.mLivenessIndex = 0;
        this.mLivenessDuration = 0;
    }

    private void clearLivenessStatus() {
        this.mLivenessStatusMap.clear();
        for (int i = 0; i < this.mLivenessList.size(); i++) {
            this.mLivenessStatusMap.put(this.mLivenessList.get(i), Boolean.FALSE);
        }
    }

    public int getCurrentLivenessCount() {
        return this.mLivenessIndex + 1;
    }

    public FaceStatusNewEnum getCurrentLivenessNewStatus() {
        if (this.mCurrentLivenessTypeEnum != null) {
            switch (AnonymousClass1.$SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum[this.mCurrentLivenessTypeEnum.ordinal()]) {
                case 1:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLiveEye;
                case 2:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLiveMouth;
                case 3:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLivePitchUp;
                case 4:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLivePitchDown;
                case 5:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLiveYawLeft;
                case 6:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLiveYawRight;
            }
        }
        return null;
    }

    public LivenessTypeEnum getCurrentLivenessType() {
        return this.mCurrentLivenessTypeEnum;
    }

    public boolean isCourseTimeout(FaceConfig faceConfig) {
        if (this.mLivenessDuration == 0) {
            this.mLivenessDuration = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() - this.mLivenessDuration > faceConfig.getTimeLivenessCourse()) {
            return true;
        }
        return false;
    }

    public boolean isCurrentLivenessSuccess() {
        boolean z;
        if (this.mLivenessStatusMap.containsKey(this.mCurrentLivenessTypeEnum)) {
            z = this.mLivenessStatusMap.get(this.mCurrentLivenessTypeEnum).booleanValue();
        } else {
            z = false;
        }
        if (z) {
            this.mLivenessTimeDuration = 0;
        }
        return z;
    }

    public boolean isExistNextLiveness() {
        if (this.mLivenessIndex + 1 < this.mLivenessList.size()) {
            return true;
        }
        return false;
    }

    public boolean isLivenessSuccess() {
        boolean z;
        Iterator<Map.Entry<LivenessTypeEnum, Boolean>> it = this.mLivenessStatusMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            Map.Entry next = it.next();
            if (!((Boolean) next.getValue()).booleanValue()) {
                ((LivenessTypeEnum) next.getKey()).name();
                z = false;
                break;
            }
        }
        if (z) {
            this.mLivenessTimeDuration = 0;
        }
        return z;
    }

    public boolean isTimeout() {
        return this.mLivenessTimeoutFlag;
    }

    public boolean nextLiveness() {
        if (this.mLivenessIndex + 1 >= this.mLivenessList.size()) {
            return false;
        }
        this.mLivenessIndex++;
        this.mCurrentLivenessTypeEnum = this.mLivenessList.get(this.mLivenessIndex);
        this.mLivenessDuration = 0;
        Log.e(TAG, "ext 开始下个活体验证 =" + this.mCurrentLivenessTypeEnum.name());
        return true;
    }

    public void processLiveness(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, Rect rect) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        if (this.mLivenessTimeDuration == 0) {
            this.mLivenessTimeDuration = System.currentTimeMillis();
        }
        FaceConfig faceConfig = FaceSDKManager.getInstance().getFaceConfig();
        long currentTimeMillis = System.currentTimeMillis() - this.mLivenessTimeDuration;
        long timeDetectModule = faceConfig.getTimeDetectModule();
        boolean z11 = true;
        if (currentTimeMillis > timeDetectModule) {
            this.mLivenessTimeoutFlag = true;
        } else if (faceExtInfo != null) {
            if (((long) faceExtInfo.getFaceId()) != this.mFaceID) {
                this.mFaceID = (long) faceExtInfo.getFaceId();
            }
            AtomicInteger atomicInteger = new AtomicInteger();
            switch (AnonymousClass1.$SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum[this.mCurrentLivenessTypeEnum.ordinal()]) {
                case 1:
                    int processLiveness = FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFace_ACTION_LIVE_BLINK, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    String str = TAG;
                    Log.e(str, "ext Eye err " + processLiveness + "exist " + atomicInteger);
                    break;
                case 2:
                    int processLiveness2 = FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_OPEN_MOUTH, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    String str2 = TAG;
                    Log.e(str2, "ext Mouth err " + processLiveness2 + "exist " + atomicInteger);
                    break;
                case 3:
                    int processLiveness3 = FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_LOOK_UP, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    String str3 = TAG;
                    Log.e(str3, "ext HeadUp err " + processLiveness3 + "exist " + atomicInteger);
                    break;
                case 4:
                    int processLiveness4 = FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_NOD, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    String str4 = TAG;
                    Log.e(str4, "ext HeadDown err " + processLiveness4 + "exist " + atomicInteger);
                    break;
                case 5:
                    int processLiveness5 = FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_TURN_LEFT, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    String str5 = TAG;
                    Log.e(str5, "ext HeadLeft err " + processLiveness5 + "exist " + atomicInteger);
                    break;
                case 6:
                    int processLiveness6 = FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_TURN_RIGHT, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    String str6 = TAG;
                    Log.e(str6, "ext HeadRight err " + processLiveness6 + "exist " + atomicInteger);
                    break;
            }
            List<LivenessTypeEnum> list = this.mLivenessList;
            LivenessTypeEnum livenessTypeEnum = LivenessTypeEnum.Eye;
            if (list.contains(livenessTypeEnum) && !this.mLivenessStatusMap.containsKey(livenessTypeEnum)) {
                HashMap<LivenessTypeEnum, Boolean> hashMap = this.mLivenessStatusMap;
                if (atomicInteger.get() == 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                hashMap.put(livenessTypeEnum, Boolean.valueOf(z10));
            } else if (this.mCurrentLivenessTypeEnum == livenessTypeEnum && atomicInteger.get() == 1) {
                HashMap<LivenessTypeEnum, Boolean> hashMap2 = this.mLivenessStatusMap;
                if (atomicInteger.get() == 1) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                hashMap2.put(livenessTypeEnum, Boolean.valueOf(z9));
            }
            List<LivenessTypeEnum> list2 = this.mLivenessList;
            LivenessTypeEnum livenessTypeEnum2 = LivenessTypeEnum.Mouth;
            if (list2.contains(livenessTypeEnum2) && !this.mLivenessStatusMap.containsKey(livenessTypeEnum2)) {
                HashMap<LivenessTypeEnum, Boolean> hashMap3 = this.mLivenessStatusMap;
                if (atomicInteger.get() == 1) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                hashMap3.put(livenessTypeEnum2, Boolean.valueOf(z8));
            } else if (this.mCurrentLivenessTypeEnum == livenessTypeEnum2 && atomicInteger.get() == 1) {
                HashMap<LivenessTypeEnum, Boolean> hashMap4 = this.mLivenessStatusMap;
                if (atomicInteger.get() == 1) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                hashMap4.put(livenessTypeEnum2, Boolean.valueOf(z7));
            }
            List<LivenessTypeEnum> list3 = this.mLivenessList;
            LivenessTypeEnum livenessTypeEnum3 = LivenessTypeEnum.HeadUp;
            if (list3.contains(livenessTypeEnum3) && !this.mLivenessStatusMap.containsKey(livenessTypeEnum3)) {
                HashMap<LivenessTypeEnum, Boolean> hashMap5 = this.mLivenessStatusMap;
                if (atomicInteger.get() == 1) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                hashMap5.put(livenessTypeEnum3, Boolean.valueOf(z6));
            } else if (this.mCurrentLivenessTypeEnum == livenessTypeEnum3 && atomicInteger.get() == 1) {
                HashMap<LivenessTypeEnum, Boolean> hashMap6 = this.mLivenessStatusMap;
                if (atomicInteger.get() == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                hashMap6.put(livenessTypeEnum3, Boolean.valueOf(z5));
            }
            List<LivenessTypeEnum> list4 = this.mLivenessList;
            LivenessTypeEnum livenessTypeEnum4 = LivenessTypeEnum.HeadDown;
            if (list4.contains(livenessTypeEnum4) && !this.mLivenessStatusMap.containsKey(livenessTypeEnum4)) {
                HashMap<LivenessTypeEnum, Boolean> hashMap7 = this.mLivenessStatusMap;
                if (atomicInteger.get() == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                hashMap7.put(livenessTypeEnum4, Boolean.valueOf(z4));
            } else if (this.mCurrentLivenessTypeEnum == livenessTypeEnum4 && atomicInteger.get() == 1) {
                HashMap<LivenessTypeEnum, Boolean> hashMap8 = this.mLivenessStatusMap;
                if (atomicInteger.get() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                hashMap8.put(livenessTypeEnum4, Boolean.valueOf(z3));
            }
            List<LivenessTypeEnum> list5 = this.mLivenessList;
            LivenessTypeEnum livenessTypeEnum5 = LivenessTypeEnum.HeadLeft;
            if (list5.contains(livenessTypeEnum5) && !this.mLivenessStatusMap.containsKey(livenessTypeEnum5)) {
                HashMap<LivenessTypeEnum, Boolean> hashMap9 = this.mLivenessStatusMap;
                if (atomicInteger.get() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                hashMap9.put(livenessTypeEnum5, Boolean.valueOf(z2));
            } else if (this.mCurrentLivenessTypeEnum == livenessTypeEnum5 && atomicInteger.get() == 1) {
                HashMap<LivenessTypeEnum, Boolean> hashMap10 = this.mLivenessStatusMap;
                if (atomicInteger.get() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                hashMap10.put(livenessTypeEnum5, Boolean.valueOf(z));
            }
            List<LivenessTypeEnum> list6 = this.mLivenessList;
            LivenessTypeEnum livenessTypeEnum6 = LivenessTypeEnum.HeadRight;
            if (list6.contains(livenessTypeEnum6) && !this.mLivenessStatusMap.containsKey(livenessTypeEnum6)) {
                HashMap<LivenessTypeEnum, Boolean> hashMap11 = this.mLivenessStatusMap;
                if (atomicInteger.get() != 1) {
                    z11 = false;
                }
                hashMap11.put(livenessTypeEnum6, Boolean.valueOf(z11));
            } else if (this.mCurrentLivenessTypeEnum == livenessTypeEnum6 && atomicInteger.get() == 1) {
                HashMap<LivenessTypeEnum, Boolean> hashMap12 = this.mLivenessStatusMap;
                if (atomicInteger.get() != 1) {
                    z11 = false;
                }
                hashMap12.put(livenessTypeEnum6, Boolean.valueOf(z11));
            }
        }
    }

    public void reset() {
        this.mLivenessIndex = 0;
        clearLivenessStatus();
        if (this.mLivenessList != null && this.mLivenessIndex < this.mLivenessList.size()) {
            this.mCurrentLivenessTypeEnum = this.mLivenessList.get(this.mLivenessIndex);
        }
        this.mLivenessDuration = 0;
        this.mLivenessTimeoutFlag = false;
        this.mLivenessTimeDuration = 0;
    }

    public void resetQualityTime() {
        this.mQualityDuration = System.currentTimeMillis();
    }

    public void resetState() {
        this.mLivenessDuration = 0;
    }

    public void setLivenessList(List<LivenessTypeEnum> list) {
        if (list != null && list.size() > 0) {
            this.mLivenessList = list;
            this.mCurrentLivenessTypeEnum = list.get(0);
            String str = TAG;
            Log.e(str, "mCurrentLivenessTypeEnum = " + this.mCurrentLivenessTypeEnum);
            clearLivenessStatus();
        }
    }

    public boolean showQualityTips() {
        if (System.currentTimeMillis() - this.mQualityDuration > 0) {
            return true;
        }
        return false;
    }

    public void startNextLiveness() {
        this.mLivenessIndex++;
        this.mCurrentLivenessTypeEnum = this.mLivenessList.get(this.mLivenessIndex);
        this.mLivenessDuration = 0;
    }
}
