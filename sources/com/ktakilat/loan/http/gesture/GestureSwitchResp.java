package com.ktakilat.loan.http.gesture;

public class GestureSwitchResp {
    public boolean hasGesture = false;
    public Boolean isGestureEnabled = Boolean.FALSE;
    public boolean masterSwitchOn = false;
    public boolean versionSupportedOn = false;

    public Boolean getGestureEnabled() {
        return this.isGestureEnabled;
    }

    public boolean isHasGesture() {
        return this.hasGesture;
    }

    public boolean isMasterSwitchOn() {
        return this.masterSwitchOn;
    }

    public boolean isVersionSupportedOn() {
        return this.versionSupportedOn;
    }

    public void setGestureEnabled(Boolean bool) {
        this.isGestureEnabled = bool;
    }

    public void setHasGesture(boolean z) {
        this.hasGesture = z;
    }

    public void setMasterSwitchOn(boolean z) {
        this.masterSwitchOn = z;
    }

    public void setVersionSupportedOn(boolean z) {
        this.versionSupportedOn = z;
    }
}
