package com.ktakilat.cbase.http.phone;

import java.io.Serializable;

public class BatteryStatusInfo implements Serializable {
    private static final long serialVersionUID = -7837971844095439894L;
    public int batteryTemperature;
    public boolean isAcCharge;
    public boolean isCharging;
    public boolean isUsbCharge;
    public int level;
    public int scale;
}
