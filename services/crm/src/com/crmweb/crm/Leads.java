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
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Leads generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`leads`")
public class Leads implements Serializable {

    private Integer id;
    private String salutation;
    private String firstname;
    private String lastname;
    private String jobtitle;
    private Integer organizationid;
    private Integer leadstatusid;
    private Integer userResponsibleid;
    private String emailaddress;
    private String phone;
    private String mobilephone;
    private String website;
    private String industry;
    private String numberEmployees;
    private Integer leadsourceid;
    private String address;
    private String city;
    private String state;
    private String country;
    private String notes;
    private LocalDateTime dateCreation;
    private LocalDateTime dateModification;
    private Integer createdby;
    private Integer modifyby;
    private LeadStatuses leadStatuses;
    private Organizations organizations;
    private LeadSources leadSources;
    private Users users;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`salutation`", nullable = true, length = 255)
    public String getSalutation() {
        return this.salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    @Column(name = "`firstname`", nullable = true, length = 255)
    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "`lastname`", nullable = true, length = 255)
    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "`jobtitle`", nullable = true, length = 255)
    public String getJobtitle() {
        return this.jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    @Column(name = "`organizationid`", nullable = true, scale = 0, precision = 10)
    public Integer getOrganizationid() {
        return this.organizationid;
    }

    public void setOrganizationid(Integer organizationid) {
        this.organizationid = organizationid;
    }

    @Column(name = "`leadstatusid`", nullable = true, scale = 0, precision = 10)
    public Integer getLeadstatusid() {
        return this.leadstatusid;
    }

    public void setLeadstatusid(Integer leadstatusid) {
        this.leadstatusid = leadstatusid;
    }

    @Column(name = "`user_responsibleid`", nullable = true, scale = 0, precision = 10)
    public Integer getUserResponsibleid() {
        return this.userResponsibleid;
    }

    public void setUserResponsibleid(Integer userResponsibleid) {
        this.userResponsibleid = userResponsibleid;
    }

    @Column(name = "`emailaddress`", nullable = true, length = 255)
    public String getEmailaddress() {
        return this.emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    @Column(name = "`phone`", nullable = true, length = 255)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "`mobilephone`", nullable = true, length = 255)
    public String getMobilephone() {
        return this.mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    @Column(name = "`website`", nullable = true, length = 255)
    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Column(name = "`industry`", nullable = true, length = 255)
    public String getIndustry() {
        return this.industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Column(name = "`number_employees`", nullable = true, length = 255)
    public String getNumberEmployees() {
        return this.numberEmployees;
    }

    public void setNumberEmployees(String numberEmployees) {
        this.numberEmployees = numberEmployees;
    }

    @Column(name = "`leadsourceid`", nullable = true, scale = 0, precision = 10)
    public Integer getLeadsourceid() {
        return this.leadsourceid;
    }

    public void setLeadsourceid(Integer leadsourceid) {
        this.leadsourceid = leadsourceid;
    }

    @Column(name = "`address`", nullable = true, length = 255)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "`city`", nullable = true, length = 255)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "`state`", nullable = true, length = 255)
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "`country`", nullable = true, length = 255)
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    @Column(name = "`date_modification`", nullable = true)
    public LocalDateTime getDateModification() {
        return this.dateModification;
    }

    public void setDateModification(LocalDateTime dateModification) {
        this.dateModification = dateModification;
    }

    @Column(name = "`createdby`", nullable = true, scale = 0, precision = 10)
    public Integer getCreatedby() {
        return this.createdby;
    }

    public void setCreatedby(Integer createdby) {
        this.createdby = createdby;
    }

    @Column(name = "`modifyby`", nullable = true, scale = 0, precision = 10)
    public Integer getModifyby() {
        return this.modifyby;
    }

    public void setModifyby(Integer modifyby) {
        this.modifyby = modifyby;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`leadstatusid`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`leads_ibfk_1`"))
    @Fetch(FetchMode.JOIN)
    public LeadStatuses getLeadStatuses() {
        return this.leadStatuses;
    }

    public void setLeadStatuses(LeadStatuses leadStatuses) {
        if(leadStatuses != null) {
            this.leadstatusid = leadStatuses.getId();
        }

        this.leadStatuses = leadStatuses;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`organizationid`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`leads_ibfk_4`"))
    @Fetch(FetchMode.JOIN)
    public Organizations getOrganizations() {
        return this.organizations;
    }

    public void setOrganizations(Organizations organizations) {
        if(organizations != null) {
            this.organizationid = organizations.getId();
        }

        this.organizations = organizations;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`leadsourceid`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`leads_ibfk_3`"))
    @Fetch(FetchMode.JOIN)
    public LeadSources getLeadSources() {
        return this.leadSources;
    }

    public void setLeadSources(LeadSources leadSources) {
        if(leadSources != null) {
            this.leadsourceid = leadSources.getId();
        }

        this.leadSources = leadSources;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`user_responsibleid`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`leads_ibfk_2`"))
    @Fetch(FetchMode.JOIN)
    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        if(users != null) {
            this.userResponsibleid = users.getId();
        }

        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Leads)) return false;
        final Leads leads = (Leads) o;
        return Objects.equals(getId(), leads.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}