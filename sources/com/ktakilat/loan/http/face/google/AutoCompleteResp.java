package com.ktakilat.loan.http.face.google;

import java.io.Serializable;
import java.util.List;

public class AutoCompleteResp implements Serializable {
    private static final long serialVersionUID = 4933316642401301981L;
    public List<AutoCompleteAddress> predictions;
    public String status;
}
