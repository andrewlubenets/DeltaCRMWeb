/*Copyright (c) 2018-2019 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.crmweb.crm;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Organizations generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`organizations`")
public class Organizations implements Serializable {

    private Integer id;
    private String name;
    private String phone;
    private String fax;
    private String website;
    private String billingaddress;
    private String billingcity;
    private String billingstate;
    private String billingcountry;
    private String shippingaddress;
    private String shippingcity;
    private String shippingstate;
    private String shippingcountry;
    private String notes;
    private LocalDateTime dateCreation;
    private Integer createdby;
    private LocalDateTime dateModification;
    private Integer modifyby;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`name`", nullable = true, length = 255)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`phone`", nullable = true, length = 255)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "`fax`", nullable = true, length = 255)
    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Column(name = "`website`", nullable = true, length = 255)
    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Column(name = "`billingaddress`", nullable = true, length = 255)
    public String getBillingaddress() {
        return this.billingaddress;
    }

    public void setBillingaddress(String billingaddress) {
        this.billingaddress = billingaddress;
    }

    @Column(name = "`billingcity`", nullable = true, length = 255)
    public String getBillingcity() {
        return this.billingcity;
    }

    public void setBillingcity(String billingcity) {
        this.billingcity = billingcity;
    }

    @Column(name = "`billingstate`", nullable = true, length = 255)
    public String getBillingstate() {
        return this.billingstate;
    }

    public void setBillingstate(String billingstate) {
        this.billingstate = billingstate;
    }

    @Column(name = "`billingcountry`", nullable = true, length = 255)
    public String getBillingcountry() {
        return this.billingcountry;
    }

    public void setBillingcountry(String billingcountry) {
        this.billingcountry = billingcountry;
    }

    @Column(name = "`shippingaddress`", nullable = true, length = 255)
    public String getShippingaddress() {
        return this.shippingaddress;
    }

    public void setShippingaddress(String shippingaddress) {
        this.shippingaddress = shippingaddress;
    }

    @Column(name = "`shippingcity`", nullable = true, length = 255)
    public String getShippingcity() {
        return this.shippingcity;
    }

    public void setShippingcity(String shippingcity) {
        this.shippingcity = shippingcity;
    }

    @Column(name = "`shippingstate`", nullable = true, length = 255)
    public String getShippingstate() {
        return this.shippingstate;
    }

    public void setShippingstate(String shippingstate) {
        this.shippingstate = shippingstate;
    }

    @Column(name = "`shippingcountry`", nullable = true, length = 255)
    public String getShippingcountry() {
        return this.shippingcountry;
    }

    public void setShippingcountry(String shippingcountry) {
        this.shippingcountry = shippingcountry;
    }

    @Column(name = "`notes`", nullable = true, length = 255)
    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Column(name = "`date_creation`", nullable = true)
    public LocalDateTime getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Column(name = "`createdby`", nullable = true, scale = 0, precision = 10)
    public Integer getCreatedby() {
        return this.createdby;
    }

    public void setCreatedby(Integer createdby) {
        this.createdby = createdby;
    }

    @Column(name = "`date_modification`", nullable = true)
    public LocalDateTime getDateModification() {
        return this.dateModification;
    }

    public void setDateModification(LocalDateTime dateModification) {
        this.dateModification = dateModification;
    }

    @Column(name = "`modifyby`", nullable = true, scale = 0, precision = 10)
    public Integer getModifyby() {
        return this.modifyby;
    }

    public void setModifyby(Integer modifyby) {
        this.modifyby = modifyby;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organizations)) return false;
        final Organizations organizations = (Organizations) o;
        return Objects.equals(getId(), organizations.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}