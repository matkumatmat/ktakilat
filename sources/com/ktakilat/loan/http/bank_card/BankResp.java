package com.ktakilat.loan.http.bank_card;

import com.ktakilat.cbase.checkvalue.NotEmpty;
import com.ktakilat.cbase.checkvalue.NotNull;
import java.io.Serializable;

public class BankResp implements Serializable {
    private static final long serialVersionUID = 4179087967652364106L;
    @NotEmpty
    private String code;
    @NotNull
    private Long id;
    private String isDisabled;
    private Integer isTop;
    @NotEmpty
    private String name;
    private String permataCode;
    private String permataName;

    public String getCode() {
        return this.code;
    }

    public long getId() {
        Long l = this.id;
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    public String getIsDisabled() {
        return this.isDisabled;
    }

    public int getIsTop() {
        Integer num = this.isTop;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getName() {
        return this.name;
    }

    public String getPermataCode() {
        return this.permataCode;
    }

    public String getPermataName() {
        return this.permataName;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setIsDisabled(String str) {
        this.isDisabled = str;
    }

    public void setIsTop(Integer num) {
        this.isTop = num;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPermataCode(String str) {
        this.permataCode = str;
    }

    public void setPermataName(String str) {
        this.permataName = str;
    }
}
