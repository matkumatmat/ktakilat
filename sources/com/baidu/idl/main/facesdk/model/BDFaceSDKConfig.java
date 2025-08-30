package com.baidu.idl.main.facesdk.model;

public class BDFaceSDKConfig {
    public float detectInterval = 0.0f;
    public boolean isAttribute = false;
    public boolean isCheckBlur = false;
    public boolean isCropFace = false;
    private boolean isEmotion = false;
    public boolean isEyeClose = false;
    public boolean isHeadPose = false;
    public boolean isIllumination = false;
    public boolean isMouthClose = false;
    public boolean isOcclusion = false;
    public int maxDetectNum = 10;
    public int minFaceSize = 0;
    public float notNIRFaceThreshold = 0.5f;
    public float notRGBFaceThreshold = 0.5f;
    public float scaleRatio = -1.0f;
    public float trackInterval = 500.0f;
}
