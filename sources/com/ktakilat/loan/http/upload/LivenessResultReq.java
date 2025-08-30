package com.ktakilat.loan.http.upload;

public class LivenessResultReq {
    Integer code;
    String image;
    String livenessId;
    String message;
    Double score;
    String sequenceId;

    public void setCode(Integer num) {
        this.code = num;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setLivenessId(String str) {
        this.livenessId = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setSequenceId(String str) {
        this.sequenceId = str;
    }
}
