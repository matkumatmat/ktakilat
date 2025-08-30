package com.ktakilat.loan.http.kta_face;

public class FaceEnableResp {
    private boolean faceLoginEnable = false;
    private boolean faceLoginHasBeenSet = false;
    private boolean identityVerified = false;
    private boolean versionSupportedOn = false;

    public boolean isFaceLoginEnable() {
        return this.faceLoginEnable;
    }

    public boolean isFaceLoginHasBeenSet() {
        return this.faceLoginHasBeenSet;
    }

    public boolean isIdentityVerified() {
        return this.identityVerified;
    }

    public boolean isVersionSupportedOn() {
        return this.versionSupportedOn;
    }

    public void setFaceLoginEnable(boolean z) {
        this.faceLoginEnable = z;
    }

    public void setFaceLoginHasBeenSet(boolean z) {
        this.faceLoginHasBeenSet = z;
    }

    public void setIdentityVerified(boolean z) {
        this.identityVerified = z;
    }

    public void setVersionSupportedOn(boolean z) {
        this.versionSupportedOn = z;
    }
}
