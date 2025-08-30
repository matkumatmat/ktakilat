package com.baidu.idl.face.platform;

import com.baidu.idl.face.platform.model.FaceExtInfo;

public interface ILivenessViewCallback {
    void animStop();

    void setCurrentLiveType(LivenessTypeEnum livenessTypeEnum);

    void setFaceInfo(FaceExtInfo faceExtInfo);

    void viewReset();
}
