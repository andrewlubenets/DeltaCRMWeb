/*Copyright (c) 2018-2019 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.crmweb.crm.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class UserthathasOpenOpportunitiesResponse implements Serializable {


    @ColumnAlias("id")
    private Integer id;

    @ColumnAlias("firstname")
    private String firstname;

    @ColumnAlias("lastname")
    private String lastname;

    @ColumnAlias("email")
    private String email;

    @ColumnAlias("password")
    private String password;

    @ColumnAlias("date_creation")
    private LocalDateTime dateCreation;

    @ColumnAlias("role")
    private String role;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserthathasOpenOpportunitiesResponse)) return false;
        final UserthathasOpenOpportunitiesResponse userthathasOpenOpportunitiesResponse = (UserthathasOpenOpportunitiesResponse) o;
        return Objects.equals(getId(), userthathasOpenOpportunitiesResponse.getId()) &&
                Objects.equals(getFirstname(), userthathasOpenOpportunitiesResponse.getFirstname()) &&
                Objects.equals(getLastname(), userthathasOpenOpportunitiesResponse.getLastname()) &&
                Objects.equals(getEmail(), userthathasOpenOpportunitiesResponse.getEmail()) &&
                Objects.equals(getPassword(), userthathasOpenOpportunitiesResponse.getPassword()) &&
                Objects.equals(getDateCreation(), userthathasOpenOpportunitiesResponse.getDateCreation()) &&
                Objects.equals(getRole(), userthathasOpenOpportunitiesResponse.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getFirstname(),
                getLastname(),
                getEmail(),
                getPassword(),
                getDateCreation(),
                getRole());
    }
}