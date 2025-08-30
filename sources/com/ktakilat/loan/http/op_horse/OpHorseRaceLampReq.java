package com.ktakilat.loan.http.op_horse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OpHorseRaceLampReq {
    public List<String> positionList;

    public void addPosition(String... strArr) {
        if (this.positionList == null) {
            this.positionList = new ArrayList(0);
        }
        if (strArr != null && strArr.length > 0) {
            this.positionList.addAll(Arrays.asList(strArr));
        }
    }
}
