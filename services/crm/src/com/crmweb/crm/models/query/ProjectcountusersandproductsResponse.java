/*Copyright (c) 2018-2019 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.crmweb.crm.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class ProjectcountusersandproductsResponse implements Serializable {


    @ColumnAlias("totprojects")
    private Long totprojects;

    @ColumnAlias("firstname")
    private String firstname;

    @ColumnAlias("lastname")
    private String lastname;

    public Long getTotprojects() {
        return this.totprojects;
    }

    public void setTotprojects(Long totprojects) {
        this.totprojects = totprojects;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectcountusersandproductsResponse)) return false;
        final ProjectcountusersandproductsResponse projectcountusersandproductsResponse = (ProjectcountusersandproductsResponse) o;
        return Objects.equals(getTotprojects(), projectcountusersandproductsResponse.getTotprojects()) &&
                Objects.equals(getFirstname(), projectcountusersandproductsResponse.getFirstname()) &&
                Objects.equals(getLastname(), projectcountusersandproductsResponse.getLastname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTotprojects(),
                getFirstname(),
                getLastname());
    }
}