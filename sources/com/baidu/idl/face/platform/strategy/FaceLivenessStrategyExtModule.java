package com.baidu.idl.face.platform.strategy;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.face.platform.ILivenessStrategy;
import com.baidu.idl.face.platform.ILivenessStrategyCallback;
import com.baidu.idl.face.platform.ILivenessViewCallback;
import com.baidu.idl.face.platform.LivenessTypeEnum;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.baidu.idl.face.platform.common.LogHelper;
import com.baidu.idl.face.platform.common.SoundPoolHelper;
import com.baidu.idl.face.platform.decode.FaceModuleNew;
import com.baidu.idl.face.platform.manager.TimeManager;
import com.baidu.idl.face.platform.model.FaceExtInfo;
import com.baidu.idl.face.platform.model.FaceModel;
import com.baidu.idl.face.platform.model.ImageInfo;
import com.baidu.idl.main.facesdk.FaceInfo;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class FaceLivenessStrategyExtModule implements ILivenessStrategy {
    private static final String TAG = "FaceLivenessStrategyExtModule";
    private static volatile int mProcessCount;
    private Handler mAnimHandler;
    private HashMap<String, ImageInfo> mBase64ImageCropMap = new HashMap<>();
    private HashMap<String, ImageInfo> mBase64ImageSrcMap = new HashMap<>();
    private Context mContext;
    private int mCropCount;
    private Rect mDetectRect;
    private DetectStrategy mDetectStrategy;
    private FaceConfig mFaceConfig;
    private long mFaceID = -1;
    private FaceModuleNew mFaceModule;
    private ILivenessStrategyCallback mILivenessStrategyCallback;
    /* access modifiers changed from: private */
    public ILivenessViewCallback mILivenessViewCallback;
    private volatile boolean mIsCompletion;
    private volatile boolean mIsEnableSound = true;
    private boolean mIsFirstLivenessSuccessTipsed;
    private boolean mIsFirstTipsed;
    private volatile boolean mIsProcessing;
    private volatile LivenessStatus mLivenessStatus = LivenessStatus.LivenessCrop;
    /* access modifiers changed from: private */
    public LivenessStatusStrategy mLivenessStrategy;
    private long mNoFaceTime = 0;
    private int mPreviewDegree;
    private Rect mPreviewRect;
    private SoundPoolHelper mSoundPlayHelper = null;
    /* access modifiers changed from: private */
    public boolean mTipLiveTimeout;
    private Map<FaceStatusNewEnum, String> mTipsMap = new HashMap();

    /* renamed from: com.baidu.idl.face.platform.strategy.FaceLivenessStrategyExtModule$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum;
        static final /* synthetic */ int[] $SwitchMap$com$baidu$idl$face$platform$strategy$FaceLivenessStrategyExtModule$LivenessStatus;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|(2:5|6)|7|(3:9|10|12)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.baidu.idl.face.platform.strategy.FaceLivenessStrategyExtModule$LivenessStatus[] r0 = com.baidu.idl.face.platform.strategy.FaceLivenessStrategyExtModule.LivenessStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$baidu$idl$face$platform$strategy$FaceLivenessStrategyExtModule$LivenessStatus = r0
                r1 = 1
                com.baidu.idl.face.platform.strategy.FaceLivenessStrategyExtModule$LivenessStatus r2 = com.baidu.idl.face.platform.strategy.FaceLivenessStrategyExtModule.LivenessStatus.LivenessReady     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$baidu$idl$face$platform$strategy$FaceLivenessStrategyExtModule$LivenessStatus     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.idl.face.platform.strategy.FaceLivenessStrategyExtModule$LivenessStatus r2 = com.baidu.idl.face.platform.strategy.FaceLivenessStrategyExtModule.LivenessStatus.LivenessTips     // Catch:{ NoSuchFieldError -> 0x001d }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r3 = 2
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$baidu$idl$face$platform$strategy$FaceLivenessStrategyExtModule$LivenessStatus     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.baidu.idl.face.platform.strategy.FaceLivenessStrategyExtModule$LivenessStatus r2 = com.baidu.idl.face.platform.strategy.FaceLivenessStrategyExtModule.LivenessStatus.LivenessOK     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3 = 3
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.baidu.idl.face.platform.FaceStatusNewEnum[] r0 = com.baidu.idl.face.platform.FaceStatusNewEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum = r0
                com.baidu.idl.face.platform.FaceStatusNewEnum r2 = com.baidu.idl.face.platform.FaceStatusNewEnum.DetectRemindCodeNoFaceDetected     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.face.platform.strategy.FaceLivenessStrategyExtModule.AnonymousClass2.<clinit>():void");
        }
    }

    public enum LivenessStatus {
        LivenessReady,
        LivenessTips,
        LivenessOK,
        LivenessCourse,
        LivenessCrop
    }

    public FaceLivenessStrategyExtModule(Context context) {
        LogHelper.clear();
        LogHelper.addLog(ConstantHelper.LOG_CATE, "Baidu-IDL-FaceSDK4.1.5");
        LogHelper.addLog(ConstantHelper.LOG_OS, Integer.valueOf(Build.VERSION.SDK_INT));
        LogHelper.addLog("version", FaceEnvironment.SDK_VERSION);
        LogHelper.addLog(ConstantHelper.LOG_DE, Build.MODEL + StringUtils.SPACE + Build.MANUFACTURER);
        LogHelper.addLog(ConstantHelper.LOG_STM, Long.valueOf(System.currentTimeMillis()));
        this.mContext = context;
        this.mDetectStrategy = new DetectStrategy();
        this.mLivenessStrategy = new LivenessStatusStrategy();
        this.mFaceModule = new FaceModuleNew();
        this.mSoundPlayHelper = new SoundPoolHelper(context);
        this.mAnimHandler = new Handler(Looper.getMainLooper());
    }

    private boolean cropStrategy(BDFaceImageInstance bDFaceImageInstance, FaceExtInfo faceExtInfo, LivenessTypeEnum livenessTypeEnum, int i) {
        FaceStatusNewEnum cropStatus = this.mDetectStrategy.getCropStatus(faceExtInfo, this.mFaceConfig);
        if (cropStatus != FaceStatusNewEnum.OK) {
            ILivenessStrategyCallback iLivenessStrategyCallback = this.mILivenessStrategyCallback;
            if (iLivenessStrategyCallback != null) {
                iLivenessStrategyCallback.onLivenessCompletion(cropStatus, getStatusTextResId(cropStatus), (HashMap<String, ImageInfo>) null, (HashMap<String, ImageInfo>) null, 0);
            }
            return false;
        }
        float totalCropScore = this.mDetectStrategy.getTotalCropScore();
        this.mFaceModule.setFaceConfig(this.mFaceConfig);
        BDFaceImageInstance cropFace = FaceSDKManager.getInstance().cropFace(bDFaceImageInstance, faceExtInfo.getmLandmarks(), this.mFaceConfig.getCropHeight(), this.mFaceConfig.getCropWidth());
        if (cropFace == null) {
            return false;
        }
        saveCropImageInstance(faceExtInfo, cropFace, i, totalCropScore);
        cropFace.destory();
        saveSrcImageInstance(faceExtInfo, bDFaceImageInstance.getImage(), i, totalCropScore);
        return true;
    }

    private String getStatusTextResId(FaceStatusNewEnum faceStatusNewEnum) {
        try {
            if (this.mTipsMap.containsKey(faceStatusNewEnum)) {
                return this.mTipsMap.get(faceStatusNewEnum);
            }
            int tipsId = FaceEnvironment.getTipsId(faceStatusNewEnum);
            if (tipsId <= 0) {
                return "";
            }
            String string = this.mContext.getResources().getString(tipsId);
            this.mTipsMap.put(faceStatusNewEnum, string);
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    private void judgeLivenessTimeout() {
        if (this.mLivenessStrategy.isCourseTimeout(this.mFaceConfig) && !this.mTipLiveTimeout) {
            ILivenessViewCallback iLivenessViewCallback = this.mILivenessViewCallback;
            if (iLivenessViewCallback != null) {
                iLivenessViewCallback.setCurrentLiveType(this.mLivenessStrategy.getCurrentLivenessType());
            }
            processUICallback(FaceStatusNewEnum.FaceLivenessActionCodeTimeout, (FaceExtInfo) null);
            this.mAnimHandler.postDelayed(new Runnable() {
                public void run() {
                    FaceLivenessStrategyExtModule.this.mLivenessStrategy.resetState();
                    TimeManager.getInstance().setActiveAnimTime(0);
                    if (FaceLivenessStrategyExtModule.this.mILivenessViewCallback != null) {
                        FaceLivenessStrategyExtModule.this.mILivenessViewCallback.animStop();
                    }
                    boolean unused = FaceLivenessStrategyExtModule.this.mTipLiveTimeout = false;
                }
            }, (long) (TimeManager.getInstance().getActiveAnimTime() + 1000));
            this.mTipLiveTimeout = true;
        }
    }

    private void process(byte[] bArr) {
        if (mProcessCount <= 0) {
            mProcessCount++;
            processStrategy(bArr);
            mProcessCount--;
        }
    }

    private void processStrategy(byte[] bArr) {
        BDFaceImageInstance bDFaceImageInstance = new BDFaceImageInstance(bArr, this.mPreviewRect.width(), this.mPreviewRect.height(), BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_YUV_NV21, (float) (360 - this.mPreviewDegree), 1);
        processUIResult(setFaceModel(FaceSDKManager.getInstance().detect(bDFaceImageInstance)), bDFaceImageInstance);
    }

    private void processUICallback(FaceStatusNewEnum faceStatusNewEnum, FaceExtInfo faceExtInfo) {
        if (faceStatusNewEnum == FaceStatusNewEnum.DetectRemindCodeTimeout) {
            LogHelper.addLogWithKey(ConstantHelper.LOG_ETM, Long.valueOf(System.currentTimeMillis()));
        }
        if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
            Log.e(TAG, "processUICompletion");
            this.mIsProcessing = true;
            this.mIsCompletion = true;
            LogHelper.addLogWithKey(ConstantHelper.LOG_ETM, Long.valueOf(System.currentTimeMillis()));
            LogHelper.addLogWithKey(ConstantHelper.LOG_FINISH, 1);
            ILivenessStrategyCallback iLivenessStrategyCallback = this.mILivenessStrategyCallback;
            if (iLivenessStrategyCallback != null) {
                iLivenessStrategyCallback.onLivenessCompletion(faceStatusNewEnum, getStatusTextResId(faceStatusNewEnum), this.mBase64ImageCropMap, this.mBase64ImageSrcMap, this.mLivenessStrategy.getCurrentLivenessCount());
            }
        } else if (faceStatusNewEnum == FaceStatusNewEnum.FaceLivenessActionComplete) {
            ILivenessStrategyCallback iLivenessStrategyCallback2 = this.mILivenessStrategyCallback;
            if (iLivenessStrategyCallback2 != null) {
                iLivenessStrategyCallback2.onLivenessCompletion(faceStatusNewEnum, getStatusTextResId(faceStatusNewEnum), this.mBase64ImageCropMap, this.mBase64ImageSrcMap, this.mLivenessStrategy.getCurrentLivenessCount());
            }
        } else {
            ILivenessStrategyCallback iLivenessStrategyCallback3 = this.mILivenessStrategyCallback;
            if (iLivenessStrategyCallback3 != null) {
                iLivenessStrategyCallback3.onLivenessCompletion(faceStatusNewEnum, getStatusTextResId(faceStatusNewEnum), this.mBase64ImageCropMap, this.mBase64ImageSrcMap, this.mLivenessStrategy.getCurrentLivenessCount() - 1);
            }
        }
    }

    private void processUIResult(FaceModel faceModel, BDFaceImageInstance bDFaceImageInstance) {
        if (bDFaceImageInstance != null) {
            if (this.mIsProcessing) {
                bDFaceImageInstance.destory();
            } else if (faceModel == null || faceModel.getFaceInfos() == null || faceModel.getFaceInfos().length == 0) {
                bDFaceImageInstance.destory();
                DetectStrategy detectStrategy = this.mDetectStrategy;
                if (detectStrategy != null) {
                    detectStrategy.reset();
                }
            } else {
                FaceStatusNewEnum faceModuleStateNew = faceModel.getFaceModuleStateNew();
                FaceExtInfo faceExtInfo = faceModel.getFaceInfos()[0];
                FaceStatusNewEnum faceStatusNewEnum = FaceStatusNewEnum.OK;
                if (faceModuleStateNew != faceStatusNewEnum) {
                    if (this.mDetectStrategy.isTimeout()) {
                        bDFaceImageInstance.destory();
                        this.mIsProcessing = true;
                        processUICallback(FaceStatusNewEnum.DetectRemindCodeTimeout, (FaceExtInfo) null);
                    } else if (AnonymousClass2.$SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[faceModuleStateNew.ordinal()] != 1) {
                        bDFaceImageInstance.destory();
                        processUITips(faceModuleStateNew, faceExtInfo);
                        this.mDetectStrategy.reset();
                        this.mLivenessStrategy.resetState();
                    } else {
                        if (this.mNoFaceTime == 0) {
                            this.mNoFaceTime = System.currentTimeMillis();
                        }
                        if (System.currentTimeMillis() - this.mNoFaceTime > this.mFaceConfig.getTimeDetectModule()) {
                            bDFaceImageInstance.destory();
                            this.mIsProcessing = true;
                            processUICallback(FaceStatusNewEnum.DetectRemindCodeTimeout, (FaceExtInfo) null);
                        } else if (!this.mIsFirstLivenessSuccessTipsed || this.mNoFaceTime == 0 || System.currentTimeMillis() - this.mNoFaceTime >= FaceEnvironment.TIME_DETECT_NO_FACE_CONTINUOUS) {
                            this.mIsFirstLivenessSuccessTipsed = false;
                            bDFaceImageInstance.destory();
                            this.mDetectStrategy.reset();
                            this.mLivenessStrategy.resetState();
                            processUITips(faceModuleStateNew, (FaceExtInfo) null);
                        } else {
                            bDFaceImageInstance.destory();
                        }
                    }
                } else if (faceExtInfo != null) {
                    ILivenessViewCallback iLivenessViewCallback = this.mILivenessViewCallback;
                    if (iLivenessViewCallback != null) {
                        iLivenessViewCallback.setFaceInfo(faceExtInfo);
                    }
                    LivenessStatus livenessStatus = this.mLivenessStatus;
                    LivenessStatus livenessStatus2 = LivenessStatus.LivenessCrop;
                    if (livenessStatus == livenessStatus2) {
                        if (this.mCropCount >= this.mFaceConfig.getCacheImageNum()) {
                            this.mLivenessStatus = LivenessStatus.LivenessReady;
                        } else if (cropStrategy(bDFaceImageInstance, faceExtInfo, this.mLivenessStrategy.getCurrentLivenessType(), this.mCropCount)) {
                            this.mCropCount++;
                        }
                    }
                    LivenessStatus livenessStatus3 = this.mLivenessStatus;
                    LivenessStatus livenessStatus4 = LivenessStatus.LivenessReady;
                    if (livenessStatus3 == livenessStatus4 || this.mLivenessStatus == LivenessStatus.LivenessTips) {
                        if (((long) faceExtInfo.getFaceId()) != this.mFaceID) {
                            this.mLivenessStrategy.reset();
                            FaceSDKManager.getInstance().clearActionHistory();
                            if (this.mFaceID != -1) {
                                this.mLivenessStatus = livenessStatus2;
                                this.mCropCount = 0;
                                HashMap<String, ImageInfo> hashMap = this.mBase64ImageCropMap;
                                if (hashMap != null) {
                                    hashMap.clear();
                                }
                                HashMap<String, ImageInfo> hashMap2 = this.mBase64ImageSrcMap;
                                if (hashMap2 != null) {
                                    hashMap2.clear();
                                }
                            }
                            ILivenessViewCallback iLivenessViewCallback2 = this.mILivenessViewCallback;
                            if (iLivenessViewCallback2 != null) {
                                iLivenessViewCallback2.viewReset();
                            }
                            this.mFaceID = (long) faceExtInfo.getFaceId();
                        }
                        this.mLivenessStrategy.processLiveness(faceExtInfo, bDFaceImageInstance, this.mPreviewRect);
                    }
                    this.mNoFaceTime = 0;
                    LogHelper.addLogWithKey(ConstantHelper.LOG_BTM, Long.valueOf(System.currentTimeMillis()));
                    Log.e(TAG, "switch start");
                    int i = AnonymousClass2.$SwitchMap$com$baidu$idl$face$platform$strategy$FaceLivenessStrategyExtModule$LivenessStatus[this.mLivenessStatus.ordinal()];
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3 && processUITips(FaceStatusNewEnum.FaceLivenessActionComplete, faceExtInfo)) {
                                if (!this.mIsFirstLivenessSuccessTipsed) {
                                    this.mIsFirstLivenessSuccessTipsed = true;
                                }
                                if (this.mLivenessStrategy.isExistNextLiveness()) {
                                    this.mLivenessStrategy.startNextLiveness();
                                    this.mLivenessStatus = livenessStatus4;
                                } else if (this.mLivenessStrategy.isLivenessSuccess()) {
                                    processUICallback(faceStatusNewEnum, faceExtInfo);
                                }
                            }
                        } else if (this.mLivenessStrategy.isCurrentLivenessSuccess()) {
                            this.mLivenessStatus = LivenessStatus.LivenessOK;
                        } else {
                            processUITips(this.mLivenessStrategy.getCurrentLivenessNewStatus(), faceExtInfo);
                            judgeLivenessTimeout();
                            if (this.mLivenessStrategy.isTimeout()) {
                                bDFaceImageInstance.destory();
                                this.mIsProcessing = true;
                                processUICallback(FaceStatusNewEnum.DetectRemindCodeTimeout, (FaceExtInfo) null);
                                return;
                            }
                        }
                    } else if (processUITips(this.mLivenessStrategy.getCurrentLivenessNewStatus(), faceExtInfo)) {
                        this.mLivenessStatus = LivenessStatus.LivenessTips;
                    }
                    bDFaceImageInstance.destory();
                }
            }
        }
    }

    private boolean processUITips(FaceStatusNewEnum faceStatusNewEnum, FaceExtInfo faceExtInfo) {
        if (faceStatusNewEnum == null) {
            return false;
        }
        this.mSoundPlayHelper.setEnableSound(this.mIsEnableSound);
        boolean playSound = this.mSoundPlayHelper.playSound(faceStatusNewEnum);
        if (!playSound) {
            return playSound;
        }
        LogHelper.addTipsLogWithKey(faceStatusNewEnum.name());
        processUICallback(faceStatusNewEnum, faceExtInfo);
        return playSound;
    }

    private void saveCropImageInstance(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, int i, float f) {
        ArrayList<ImageInfo> detectBestCropImageList = this.mFaceModule.getDetectBestCropImageList(faceExtInfo, bDFaceImageInstance);
        if (detectBestCropImageList != null && detectBestCropImageList.size() > 0) {
            HashMap<String, ImageInfo> hashMap = this.mBase64ImageCropMap;
            hashMap.put(ILivenessStrategyCallback.IMAGE_KEY_BEST_CROP_IMAGE + i + "_" + f, detectBestCropImageList.get(0));
        }
    }

    private void saveSrcImageInstance(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, int i, float f) {
        ArrayList<ImageInfo> detectBestSrcImageList = this.mFaceModule.getDetectBestSrcImageList(faceExtInfo, bDFaceImageInstance);
        if (detectBestSrcImageList != null && detectBestSrcImageList.size() > 0) {
            HashMap<String, ImageInfo> hashMap = this.mBase64ImageSrcMap;
            hashMap.put(ILivenessStrategyCallback.IMAGE_KEY_BEST_SRC_IMAGE + i + "_" + f, detectBestSrcImageList.get(0));
        }
    }

    private FaceModel setFaceModel(FaceInfo[] faceInfoArr) {
        FaceExtInfo[] faceExtInfo = this.mFaceModule.getFaceExtInfo(faceInfoArr);
        FaceModel faceModel = new FaceModel();
        faceModel.setFaceInfos(faceExtInfo);
        faceModel.setFaceModuleStateNew(this.mDetectStrategy.checkDetect(this.mDetectRect, faceExtInfo, this.mFaceConfig));
        faceModel.setFrameTime(System.currentTimeMillis());
        return faceModel;
    }

    public void livenessStrategy(byte[] bArr) {
        if (!this.mIsFirstTipsed) {
            this.mIsFirstTipsed = true;
            processUITips(FaceStatusNewEnum.DetectRemindCodeNoFaceDetected, (FaceExtInfo) null);
        } else if (!this.mIsProcessing) {
            process(bArr);
        }
    }

    public void reset() {
        FaceSDKManager.getInstance().clearActionHistory();
        LivenessStatusStrategy livenessStatusStrategy = this.mLivenessStrategy;
        if (livenessStatusStrategy != null) {
            livenessStatusStrategy.reset();
        }
        HashMap<String, ImageInfo> hashMap = this.mBase64ImageCropMap;
        if (hashMap != null) {
            hashMap.clear();
        }
        HashMap<String, ImageInfo> hashMap2 = this.mBase64ImageSrcMap;
        if (hashMap2 != null) {
            hashMap2.clear();
        }
        SoundPoolHelper soundPoolHelper = this.mSoundPlayHelper;
        if (soundPoolHelper != null) {
            soundPoolHelper.release();
        }
        Handler handler = this.mAnimHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.mAnimHandler = null;
        }
        this.mIsFirstTipsed = false;
        this.mIsProcessing = false;
    }

    public void setConfig(FaceConfig faceConfig) {
        this.mFaceConfig = faceConfig;
    }

    public void setILivenessViewCallback(ILivenessViewCallback iLivenessViewCallback) {
        this.mILivenessViewCallback = iLivenessViewCallback;
    }

    public void setLivenessStrategyConfig(List<LivenessTypeEnum> list, Rect rect, Rect rect2, ILivenessStrategyCallback iLivenessStrategyCallback) {
        this.mLivenessStrategy.setLivenessList(list);
        this.mPreviewRect = rect;
        this.mDetectRect = rect2;
        this.mILivenessStrategyCallback = iLivenessStrategyCallback;
    }

    public void setLivenessStrategySoundEnable(boolean z) {
        this.mIsEnableSound = z;
    }

    public void setPreviewDegree(int i) {
        this.mPreviewDegree = i;
    }
}
