package com.baidu.idl.main.facesdk;

import com.baidu.idl.main.facesdk.model.BDFaceOcclusion;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;

public class FaceInfo {
    public int age;
    public float angle;
    public float bluriness;
    public float centerX;
    public float centerY;
    public BDFaceSDKCommon.BDFaceEmotionEnum emotionSeven;
    public BDFaceSDKCommon.BDFaceEmotion emotionThree;
    public int faceID;
    public BDFaceSDKCommon.BDFaceGender gender;
    public BDFaceSDKCommon.BDFaceGlasses glasses;
    public float height;
    public int illum;
    public float[] landmarks;
    public float leftEyeclose;
    public float mouthclose;
    public BDFaceOcclusion occlusion;
    public float pitch;
    public BDFaceSDKCommon.BDFaceRace race;
    public float rightEyeclose;
    public float roll;
    public float score;
    public float width;
    public float yaw;

    public FaceInfo(int i, float[] fArr, float[] fArr2) {
        this.faceID = i;
        if (fArr != null && fArr.length == 6) {
            this.centerX = fArr[0];
            this.centerY = fArr[1];
            this.width = fArr[2];
            this.height = fArr[3];
            this.angle = fArr[4];
            this.score = fArr[5];
        }
        this.landmarks = fArr2;
    }

    public FaceInfo(int i, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, int[] iArr, float[] fArr5) {
        float[] fArr6 = fArr;
        float[] fArr7 = fArr3;
        float[] fArr8 = fArr4;
        int[] iArr2 = iArr;
        float[] fArr9 = fArr5;
        this.faceID = i;
        if (fArr6 != null && fArr6.length == 6) {
            this.centerX = fArr6[0];
            this.centerY = fArr6[1];
            this.width = fArr6[2];
            this.height = fArr6[3];
            this.angle = fArr6[4];
            this.score = fArr6[5];
        }
        this.landmarks = fArr2;
        if (fArr7 != null && fArr7.length == 3) {
            this.yaw = fArr7[0];
            this.roll = fArr7[1];
            this.pitch = fArr7[2];
        }
        if (fArr8 != null && fArr8.length == 9) {
            this.occlusion = new BDFaceOcclusion(fArr8[0], fArr8[1], fArr8[2], fArr8[3], fArr8[4], fArr8[5], fArr8[6]);
            this.illum = (int) fArr8[7];
            this.bluriness = fArr8[8];
        }
        if (iArr2 != null && iArr2.length == 6) {
            this.age = iArr2[0];
            this.race = BDFaceSDKCommon.BDFaceRace.values()[iArr2[1]];
            this.emotionThree = BDFaceSDKCommon.BDFaceEmotion.values()[iArr2[2]];
            this.glasses = BDFaceSDKCommon.BDFaceGlasses.values()[iArr2[3]];
            this.gender = BDFaceSDKCommon.BDFaceGender.values()[iArr2[4]];
            this.emotionSeven = BDFaceSDKCommon.BDFaceEmotionEnum.values()[iArr2[5]];
        }
        if (fArr9 != null && fArr9.length == 3) {
            this.leftEyeclose = fArr9[0];
            this.rightEyeclose = fArr9[1];
            this.mouthclose = fArr9[2];
        }
    }

    public FaceInfo(int i, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5) {
        float[] fArr6 = fArr;
        float[] fArr7 = fArr3;
        float[] fArr8 = fArr4;
        float[] fArr9 = fArr5;
        this.faceID = i;
        if (fArr6 != null && fArr6.length == 6) {
            this.centerX = fArr6[0];
            this.centerY = fArr6[1];
            this.width = fArr6[2];
            this.height = fArr6[3];
            this.angle = fArr6[4];
            this.score = fArr6[5];
        }
        this.landmarks = fArr2;
        if (fArr7 != null && fArr7.length == 3) {
            this.yaw = fArr7[0];
            this.roll = fArr7[1];
            this.pitch = fArr7[2];
        }
        if (fArr8 != null && fArr8.length == 9) {
            this.occlusion = new BDFaceOcclusion(fArr8[0], fArr8[1], fArr8[2], fArr8[3], fArr8[4], fArr8[5], fArr8[6]);
            this.illum = (int) fArr8[7];
            this.bluriness = fArr8[8];
        }
        if (fArr9 != null && fArr9.length == 3) {
            this.leftEyeclose = fArr9[0];
            this.rightEyeclose = fArr9[1];
            this.mouthclose = fArr9[2];
        }
    }
}
