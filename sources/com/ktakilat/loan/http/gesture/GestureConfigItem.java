package com.ktakilat.loan.http.gesture;

import com.ktakilat.cbase.checkvalue.NotEmpty;

public class GestureConfigItem {
    public boolean canDialog = false;
    public boolean canSet = false;
    public boolean canSkip = true;
    @NotEmpty
    public String scence;
}
