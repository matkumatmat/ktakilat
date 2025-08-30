package com.baidu.idl.face.platform.strategy;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.face.platform.IDetectStrategy;
import com.baidu.idl.face.platform.IDetectStrategyCallback;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.baidu.idl.face.platform.common.LogHelper;
import com.baidu.idl.face.platform.common.SoundPoolHelper;
import com.baidu.idl.face.platform.decode.FaceModuleNew;
import com.baidu.idl.face.platform.model.FaceExtInfo;
import com.baidu.idl.face.platform.model.FaceModel;
import com.baidu.idl.face.platform.model.ImageInfo;
import com.baidu.idl.main.facesdk.FaceInfo;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class FaceDetectStrategyExtModule implements IDetectStrategy {
    private static final String TAG = "com.baidu.idl.face.platform.strategy.FaceDetectStrategyExtModule";
    private static volatile int mProcessCount;
    private HashMap<String, ImageInfo> mBase64ImageCropMap = new HashMap<>();
    private HashMap<String, ImageInfo> mBase64ImageSrcMap = new HashMap<>();
    private Context mContext;
    private int mDegree;
    private int mDetectCount = 0;
    private Rect mDetectRect;
    private final DetectStrategy mDetectStrategy;
    private FaceConfig mFaceConfig;
    private final FaceModuleNew mFaceModule;
    private IDetectStrategyCallback mIDetectStrategyCallback;
    private volatile boolean mIsCompletion = false;
    private volatile boolean mIsEnableSound = true;
    private boolean mIsFirstTipsed = false;
    private volatile boolean mIsProcessing;
    private long mNoFaceTime = 0;
    private Rect mPreviewRect;
    private final SoundPoolHelper mSoundPlayHelper;
    private Map<FaceStatusNewEnum, String> mTipsMap = new HashMap();

    public FaceDetectStrategyExtModule(Context context) {
        LogHelper.clear();
        LogHelper.addLog(ConstantHelper.LOG_CATE, "Baidu-IDL-FaceSDK4.1.5");
        LogHelper.addLog(ConstantHelper.LOG_OS, Integer.valueOf(Build.VERSION.SDK_INT));
        LogHelper.addLog("version", FaceEnvironment.SDK_VERSION);
        LogHelper.addLog(ConstantHelper.LOG_DE, Build.MODEL + StringUtils.SPACE + Build.MANUFACTURER);
        LogHelper.addLog(ConstantHelper.LOG_STM, Long.valueOf(System.currentTimeMillis()));
        this.mContext = context;
        this.mDetectStrategy = new DetectStrategy();
        this.mSoundPlayHelper = new SoundPoolHelper(context);
        this.mFaceModule = new FaceModuleNew();
    }

    private boolean cropStrategy(BDFaceImageInstance bDFaceImageInstance, FaceExtInfo faceExtInfo, int i) {
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

    private void process(byte[] bArr) {
        if (mProcessCount <= 0) {
            mProcessCount++;
            processStrategy(bArr);
            mProcessCount--;
        }
    }

    private void processStrategy(byte[] bArr) {
        BDFaceImageInstance bDFaceImageInstance = new BDFaceImageInstance(bArr, this.mPreviewRect.width(), this.mPreviewRect.height(), BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_YUV_NV21, (float) (360 - this.mDegree), 1);
        processUIResult(setFaceModel(FaceSDKManager.getInstance().detect(bDFaceImageInstance), bDFaceImageInstance), bDFaceImageInstance);
    }

    private void processUICallback(FaceStatusNewEnum faceStatusNewEnum, FaceExtInfo faceExtInfo) {
        if (faceStatusNewEnum == FaceStatusNewEnum.DetectRemindCodeTimeout) {
            LogHelper.addLogWithKey(ConstantHelper.LOG_ETM, Long.valueOf(System.currentTimeMillis()));
        }
        IDetectStrategyCallback iDetectStrategyCallback = this.mIDetectStrategyCallback;
        if (iDetectStrategyCallback == null) {
            return;
        }
        if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
            this.mIsProcessing = true;
            this.mIsCompletion = true;
            LogHelper.addLogWithKey(ConstantHelper.LOG_ETM, Long.valueOf(System.currentTimeMillis()));
            LogHelper.addLogWithKey(ConstantHelper.LOG_FINISH, 1);
            this.mIDetectStrategyCallback.onDetectCompletion(faceStatusNewEnum, getStatusTextResId(faceStatusNewEnum), this.mBase64ImageCropMap, this.mBase64ImageSrcMap);
            return;
        }
        iDetectStrategyCallback.onDetectCompletion(faceStatusNewEnum, getStatusTextResId(faceStatusNewEnum), (HashMap<String, ImageInfo>) null, (HashMap<String, ImageInfo>) null);
    }

    private void processUIResult(FaceModel faceModel, BDFaceImageInstance bDFaceImageInstance) {
        FaceExtInfo faceExtInfo;
        if (bDFaceImageInstance != null) {
            if (this.mIsProcessing) {
                bDFaceImageInstance.destory();
                return;
            }
            if (faceModel == null || faceModel.getFaceInfos() == null || faceModel.getFaceInfos().length <= 0) {
                DetectStrategy detectStrategy = this.mDetectStrategy;
                if (detectStrategy != null) {
                    detectStrategy.reset();
                }
                faceExtInfo = null;
            } else {
                faceExtInfo = faceModel.getFaceInfos()[0];
                LogHelper.addLogWithKey(ConstantHelper.LOG_FTM, Long.valueOf(System.currentTimeMillis()));
            }
            if (faceExtInfo != null) {
                if (this.mDetectStrategy == null) {
                    bDFaceImageInstance.destory();
                } else if (this.mIsCompletion) {
                    processUITips(FaceStatusNewEnum.OK, faceExtInfo);
                    bDFaceImageInstance.destory();
                } else if (faceModel != null) {
                    FaceStatusNewEnum faceModuleStateNew = faceModel.getFaceModuleStateNew();
                    FaceStatusNewEnum faceStatusNewEnum = FaceStatusNewEnum.OK;
                    if (faceModuleStateNew == faceStatusNewEnum) {
                        LogHelper.addLogWithKey(ConstantHelper.LOG_BTM, Long.valueOf(System.currentTimeMillis()));
                        if (this.mDetectCount >= this.mFaceConfig.getCacheImageNum()) {
                            this.mIsCompletion = true;
                            processUITips(faceStatusNewEnum, faceExtInfo);
                        } else if (cropStrategy(bDFaceImageInstance, faceExtInfo, this.mDetectCount)) {
                            this.mDetectCount++;
                        }
                        bDFaceImageInstance.destory();
                    } else if (this.mDetectStrategy.isTimeout()) {
                        this.mIsProcessing = true;
                        bDFaceImageInstance.destory();
                        processUICallback(FaceStatusNewEnum.DetectRemindCodeTimeout, (FaceExtInfo) null);
                    } else {
                        processUITips(faceModuleStateNew, faceExtInfo);
                        bDFaceImageInstance.destory();
                    }
                }
            } else if (this.mDetectStrategy == null) {
                bDFaceImageInstance.destory();
            } else {
                if (faceModel == null || !(faceModel.getFaceModuleStateNew() == FaceStatusNewEnum.DetectRemindCodeNoFaceDetected || faceModel.getFaceModuleStateNew() == FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame)) {
                    this.mNoFaceTime = 0;
                } else {
                    this.mDetectStrategy.reset();
                    if (this.mNoFaceTime == 0) {
                        this.mNoFaceTime = System.currentTimeMillis();
                    } else if (System.currentTimeMillis() - this.mNoFaceTime > this.mFaceConfig.getTimeDetectModule()) {
                        this.mIsProcessing = true;
                        bDFaceImageInstance.destory();
                        processUICallback(FaceStatusNewEnum.DetectRemindCodeTimeout, (FaceExtInfo) null);
                        return;
                    }
                }
                if (this.mDetectStrategy.isTimeout()) {
                    bDFaceImageInstance.destory();
                    this.mIsProcessing = true;
                    processUICallback(FaceStatusNewEnum.DetectRemindCodeTimeout, (FaceExtInfo) null);
                    return;
                }
                processUITips(FaceStatusNewEnum.DetectRemindCodeNoFaceDetected, (FaceExtInfo) null);
                bDFaceImageInstance.destory();
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
            hashMap.put(IDetectStrategyCallback.IMAGE_KEY_BEST_CROP_IMAGE + i + "_" + f, detectBestCropImageList.get(0));
        }
    }

    private void saveSrcImageInstance(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, int i, float f) {
        ArrayList<ImageInfo> detectBestSrcImageList = this.mFaceModule.getDetectBestSrcImageList(faceExtInfo, bDFaceImageInstance);
        if (detectBestSrcImageList != null && detectBestSrcImageList.size() > 0) {
            HashMap<String, ImageInfo> hashMap = this.mBase64ImageSrcMap;
            hashMap.put(IDetectStrategyCallback.IMAGE_KEY_BEST_SRC_IMAGE + i + "_" + f, detectBestSrcImageList.get(0));
        }
    }

    private FaceModel setFaceModel(FaceInfo[] faceInfoArr, BDFaceImageInstance bDFaceImageInstance) {
        if (bDFaceImageInstance == null) {
            return null;
        }
        FaceModel faceModel = new FaceModel();
        FaceExtInfo[] faceExtInfo = this.mFaceModule.getFaceExtInfo(faceInfoArr);
        faceModel.setFaceModuleStateNew(this.mDetectStrategy.getDetectState(faceExtInfo, this.mDetectRect, false, this.mFaceConfig));
        faceModel.setFaceInfos(faceExtInfo);
        faceModel.setFrameTime(System.currentTimeMillis());
        return faceModel;
    }

    public void detectStrategy(byte[] bArr) {
        if (!this.mIsFirstTipsed) {
            this.mIsFirstTipsed = true;
            processUITips(FaceStatusNewEnum.DetectRemindCodeNoFaceDetected, (FaceExtInfo) null);
        } else if (!this.mIsProcessing) {
            process(bArr);
        }
    }

    public void reset() {
        this.mDetectCount = 0;
        SoundPoolHelper soundPoolHelper = this.mSoundPlayHelper;
        if (soundPoolHelper != null) {
            soundPoolHelper.release();
        }
        HashMap<String, ImageInfo> hashMap = this.mBase64ImageCropMap;
        if (hashMap != null) {
            hashMap.clear();
        }
        HashMap<String, ImageInfo> hashMap2 = this.mBase64ImageSrcMap;
        if (hashMap2 != null) {
            hashMap2.clear();
        }
        this.mIsFirstTipsed = false;
        this.mIsProcessing = false;
    }

    public void setConfigValue(FaceConfig faceConfig) {
        this.mFaceConfig = faceConfig;
    }

    public void setDetectStrategyConfig(Rect rect, Rect rect2, IDetectStrategyCallback iDetectStrategyCallback) {
        this.mPreviewRect = rect;
        this.mDetectRect = rect2;
        this.mIDetectStrategyCallback = iDetectStrategyCallback;
    }

    public void setDetectStrategySoundEnable(boolean z) {
        this.mIsEnableSound = z;
    }

    public void setPreviewDegree(int i) {
        this.mDegree = i;
    }
}
