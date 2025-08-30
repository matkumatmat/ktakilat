package com.baidu.idl.face.platform.model;

import android.graphics.Point;
import android.graphics.Rect;
import com.baidu.idl.main.facesdk.FaceInfo;
import com.baidu.idl.main.facesdk.model.BDFaceOcclusion;
import java.util.HashMap;

public class FaceExtInfo {
    private static int[] comp1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    private static int[] comp2 = {13, 14, 15, 16, 17, 18, 19, 20, 13, 21};
    private static int[] comp3 = {22, 23, 24, 25, 26, 27, 28, 29, 22};
    private static int[] comp4 = {30, 31, 32, 33, 34, 35, 36, 37, 30, 38};
    private static int[] comp5 = {39, 40, 41, 42, 43, 44, 45, 46, 39};
    private static int[] comp6 = {47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 47};
    private static int[] comp7 = {51, 57, 52};
    private static int[] comp8 = {58, 59, 60, 61, 62, 63, 64, 65, 58};
    private static int[] comp9 = {58, 66, 67, 68, 62, 69, 70, 71, 58};
    private static int nComponents = 9;
    private static int[] nPoints = {13, 10, 9, 10, 9, 11, 3, 9, 9};
    private HashMap<String, Point[]> facePointMap;
    private float mAngle;
    private float mBluriness;
    private float mCenterX;
    private float mCenterY;
    private int mFaceID;
    private float mHeight;
    private int mIllum;
    private float[] mLandmarks;
    private float mLeftEyeClose;
    private BDFaceOcclusion mOcclusion;
    private float mPitch;
    private float mRightEyeClose;
    private float mRoll;
    private float mScore;
    private float mWidth;
    private float mYaw;

    public FaceExtInfo() {
    }

    public void addFaceInfo(FaceInfo faceInfo) {
        this.mFaceID = faceInfo.faceID;
        this.mCenterX = faceInfo.centerX;
        this.mCenterY = faceInfo.centerY;
        this.mWidth = faceInfo.width;
        this.mHeight = faceInfo.height;
        this.mAngle = faceInfo.angle;
        this.mScore = faceInfo.score;
        this.mLandmarks = faceInfo.landmarks;
        this.mPitch = faceInfo.pitch;
        this.mRoll = faceInfo.roll;
        this.mYaw = faceInfo.yaw;
        this.mBluriness = faceInfo.bluriness;
        this.mIllum = faceInfo.illum;
        BDFaceOcclusion bDFaceOcclusion = faceInfo.occlusion;
        this.mOcclusion = bDFaceOcclusion;
        bDFaceOcclusion.leftEye = bDFaceOcclusion.leftEye;
        bDFaceOcclusion.rightEye = bDFaceOcclusion.rightEye;
        bDFaceOcclusion.nose = bDFaceOcclusion.nose;
        bDFaceOcclusion.mouth = bDFaceOcclusion.mouth;
        bDFaceOcclusion.leftCheek = bDFaceOcclusion.leftCheek;
        bDFaceOcclusion.rightCheek = bDFaceOcclusion.rightCheek;
        bDFaceOcclusion.chin = bDFaceOcclusion.chin;
        this.mLeftEyeClose = faceInfo.leftEyeclose;
        this.mRightEyeClose = faceInfo.rightEyeclose;
    }

    public float getBluriness() {
        return this.mBluriness;
    }

    public float getConfidence() {
        return this.mScore;
    }

    public int getFaceId() {
        return this.mFaceID;
    }

    public Rect getFaceRect() {
        float f = this.mCenterX;
        float f2 = this.mWidth;
        return new Rect((int) (f - (f2 / 2.0f)), (int) (this.mCenterY - (f2 / 2.0f)), (int) f2, (int) f2);
    }

    public int getFaceWidth() {
        return (int) this.mWidth;
    }

    public int getIllum() {
        return this.mIllum;
    }

    public int getLandmarksOutOfDetectCount(Rect rect) {
        if (this.mLandmarks.length != 144) {
            return 0;
        }
        int[][] iArr = {comp1, comp2, comp3, comp4, comp5, comp6, comp7, comp8, comp9};
        int i = 0;
        for (int i2 = 0; i2 < nComponents; i2++) {
            int i3 = 0;
            while (i3 < nPoints[i2] - 1) {
                float[] fArr = this.mLandmarks;
                int[] iArr2 = iArr[i2];
                int i4 = iArr2[i3];
                float f = fArr[i4 << 1];
                float f2 = fArr[(i4 << 1) + 1];
                i3++;
                int i5 = iArr2[i3];
                float[] fArr2 = {f, f2, fArr[i5 << 1], fArr[(i5 << 1) + 1]};
                if (!rect.contains((int) (fArr2[0] * 1.0f), (int) (fArr2[1] * 1.0f))) {
                    i++;
                }
                if (!rect.contains((int) (fArr2[2] * 1.0f), (int) (fArr2[3] * 1.0f))) {
                    i++;
                }
            }
        }
        return i;
    }

    public float getLeftEyeClose() {
        return this.mLeftEyeClose;
    }

    public BDFaceOcclusion getOcclusion() {
        return this.mOcclusion;
    }

    public float getPitch() {
        return this.mPitch;
    }

    public void getRectPoints(int[] iArr) {
        int[] iArr2 = iArr;
        double d = (((double) this.mAngle) * 3.14159d) / 180.0d;
        double cos = Math.cos(d);
        double sin = Math.sin(d);
        float f = this.mWidth;
        int i = (int) ((((((double) f) * cos) / 2.0d) + ((double) this.mCenterX)) - ((((double) f) * sin) / 2.0d));
        double d2 = (cos * ((double) f)) / 2.0d;
        int i2 = (int) (d2 + ((sin * ((double) f)) / 2.0d) + ((double) this.mCenterY));
        double d3 = (((double) this.mAngle) * 3.14159d) / 180.0d;
        double cos2 = Math.cos(d3) * 0.5d;
        double sin2 = Math.sin(d3) * 0.5d;
        if (iArr2 == null || iArr2.length == 0) {
            iArr2 = new int[8];
        }
        double d4 = (double) i;
        float f2 = this.mWidth;
        int i3 = (int) ((d4 - (((double) f2) * sin2)) - (((double) f2) * cos2));
        iArr2[0] = i3;
        double d5 = (double) i2;
        int i4 = i;
        int i5 = (int) (((((double) f2) * cos2) + d5) - (((double) f2) * sin2));
        iArr2[1] = i5;
        int i6 = (int) (((((double) f2) * sin2) + d4) - (((double) f2) * cos2));
        iArr2[2] = i6;
        int i7 = (int) ((d5 - (cos2 * ((double) f2))) - (sin2 * ((double) f2)));
        iArr2[3] = i7;
        int i8 = i4 * 2;
        iArr2[4] = i8 - i3;
        int i9 = i2 * 2;
        iArr2[5] = i9 - i5;
        iArr2[6] = i8 - i6;
        iArr2[7] = i9 - i7;
    }

    public float getRightEyeClose() {
        return this.mRightEyeClose;
    }

    public float getRoll() {
        return this.mRoll;
    }

    public float getYaw() {
        return this.mYaw;
    }

    public float[] getmLandmarks() {
        return this.mLandmarks;
    }

    public boolean isOutofDetectRect(Rect rect) {
        return rect.contains(getFaceRect());
    }

    public void setLeftEyeClose(float f) {
        this.mLeftEyeClose = f;
    }

    public void setRightEyeClose(float f) {
        this.mRightEyeClose = f;
    }

    public FaceExtInfo(FaceInfo faceInfo) {
        this.mFaceID = faceInfo.faceID;
        this.mCenterX = faceInfo.centerX;
        this.mCenterY = faceInfo.centerY;
        this.mWidth = faceInfo.width;
        this.mHeight = faceInfo.height;
        this.mAngle = faceInfo.angle;
        this.mScore = faceInfo.score;
        this.mLandmarks = faceInfo.landmarks;
        this.mPitch = faceInfo.pitch;
        this.mRoll = faceInfo.roll;
        this.mYaw = faceInfo.yaw;
        this.mBluriness = faceInfo.bluriness;
        this.mIllum = faceInfo.illum;
        BDFaceOcclusion bDFaceOcclusion = faceInfo.occlusion;
        this.mOcclusion = bDFaceOcclusion;
        bDFaceOcclusion.leftEye = bDFaceOcclusion.leftEye;
        bDFaceOcclusion.rightEye = bDFaceOcclusion.rightEye;
        bDFaceOcclusion.nose = bDFaceOcclusion.nose;
        bDFaceOcclusion.mouth = bDFaceOcclusion.mouth;
        bDFaceOcclusion.leftCheek = bDFaceOcclusion.leftCheek;
        bDFaceOcclusion.rightCheek = bDFaceOcclusion.rightCheek;
        bDFaceOcclusion.chin = bDFaceOcclusion.chin;
        this.mLeftEyeClose = faceInfo.leftEyeclose;
        this.mRightEyeClose = faceInfo.rightEyeclose;
    }

    public Rect getFaceRect(float f, float f2, float f3) {
        float f4 = this.mCenterX * f;
        float f5 = this.mCenterY * f2;
        float f6 = this.mWidth;
        return new Rect((int) (f4 - (((f6 / 2.0f) * f) * f3)), (int) (f5 - (((f6 / 2.0f) * f2) * f3)), (int) (((f6 / 2.0f) * f * f3) + f4), (int) (((f6 / 2.0f) * f2 * f3) + f5));
    }
}
