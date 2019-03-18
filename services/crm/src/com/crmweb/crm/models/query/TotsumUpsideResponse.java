/*Copyright (c) 2018-2019 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.crmweb.crm.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class TotsumUpsideResponse implements Serializable {


    @ColumnAlias("totupside")
    private BigInteger totupside;

    public BigInteger getTotupside() {
        return this.totupside;
    }

    public void setTotupside(BigInteger totupside) {
        this.totupside = totupside;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TotsumUpsideResponse)) return false;
        final TotsumUpsideResponse totsumUpsideResponse = (TotsumUpsideResponse) o;
        return Objects.equals(getTotupside(), totsumUpsideResponse.getTotupside());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTotupside());
    }
}