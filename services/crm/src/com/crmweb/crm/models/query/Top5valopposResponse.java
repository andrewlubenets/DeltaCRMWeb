/*Copyright (c) 2018-2019 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.crmweb.crm.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class Top5valopposResponse implements Serializable {


    @ColumnAlias("totval")
    private String totval;

    @ColumnAlias("name")
    private String name;

    public String getTotval() {
        return this.totval;
    }

    public void setTotval(String totval) {
        this.totval = totval;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Top5valopposResponse)) return false;
        final Top5valopposResponse top5valopposResponse = (Top5valopposResponse) o;
        return Objects.equals(getTotval(), top5valopposResponse.getTotval()) &&
                Objects.equals(getName(), top5valopposResponse.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTotval(),
                getName());
    }
}