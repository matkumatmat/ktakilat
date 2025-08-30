package com.ktakilat.loan.http.op_horse;

import com.ktakilat.cbase.checkvalue.NotEmpty;
import com.ktakilat.cbase.checkvalue.NotNull;

public class OpHorseRaceLampConfigResp {
    @NotEmpty
    private String content;
    @NotNull
    private Long id;
    private String popUpsNotice;
    private String popUpsNoticeType;

    public String getContent() {
        return this.content;
    }

    public Long getId() {
        return this.id;
    }

    public String getPopUpsNotice() {
        return this.popUpsNotice;
    }

    public String getPopUpsNoticeType() {
        return this.popUpsNoticeType;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setPopUpsNotice(String str) {
        this.popUpsNotice = str;
    }

    public void setPopUpsNoticeType(String str) {
        this.popUpsNoticeType = str;
    }
}
