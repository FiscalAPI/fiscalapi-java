package com.fiscalapi.models;

import com.fiscalapi.common.BaseDto;

public class UserLookupDto extends BaseDto {
    private String tin;

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    private String legalName;
}
