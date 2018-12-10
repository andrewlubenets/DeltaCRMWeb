/*Copyright (c) 2018-2019 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.crmweb.crm;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
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
 * Posts generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`posts`")
public class Posts implements Serializable {

    private Integer id;
    private String code;
    private String positionname;
    private String description;
    private Integer userid;
    private Integer supervisorpositionid;
    private Integer supervisionuserid;
    private Integer entityid;
    private Integer locationid;
    private Integer departmentid;
    private String typepost;
    private Integer weight;
    private String status;
    private Entities entities;
    private Users users;
    private Departments departments;
    private Locations locations;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`code`", nullable = true, length = 255)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "`positionname`", nullable = true, length = 255)
    public String getPositionname() {
        return this.positionname;
    }

    public void setPositionname(String positionname) {
        this.positionname = positionname;
    }

    @Column(name = "`description`", nullable = true, length = 255)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "`userid`", nullable = true, scale = 0, precision = 10)
    public Integer getUserid() {
        return this.userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Column(name = "`supervisorpositionid`", nullable = true, scale = 0, precision = 10)
    public Integer getSupervisorpositionid() {
        return this.supervisorpositionid;
    }

    public void setSupervisorpositionid(Integer supervisorpositionid) {
        this.supervisorpositionid = supervisorpositionid;
    }

    @Column(name = "`supervisionuserid`", nullable = true, scale = 0, precision = 10)
    public Integer getSupervisionuserid() {
        return this.supervisionuserid;
    }

    public void setSupervisionuserid(Integer supervisionuserid) {
        this.supervisionuserid = supervisionuserid;
    }

    @Column(name = "`entityid`", nullable = true, scale = 0, precision = 10)
    public Integer getEntityid() {
        return this.entityid;
    }

    public void setEntityid(Integer entityid) {
        this.entityid = entityid;
    }

    @Column(name = "`locationid`", nullable = true, scale = 0, precision = 10)
    public Integer getLocationid() {
        return this.locationid;
    }

    public void setLocationid(Integer locationid) {
        this.locationid = locationid;
    }

    @Column(name = "`departmentid`", nullable = true, scale = 0, precision = 10)
    public Integer getDepartmentid() {
        return this.departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    @Column(name = "`typepost`", nullable = true, length = 255)
    public String getTypepost() {
        return this.typepost;
    }

    public void setTypepost(String typepost) {
        this.typepost = typepost;
    }

    @Column(name = "`weight`", nullable = true, scale = 0, precision = 10)
    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Column(name = "`status`", nullable = true, length = 255)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`entityid`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`posts_ibfk_2`"))
    @Fetch(FetchMode.JOIN)
    public Entities getEntities() {
        return this.entities;
    }

    public void setEntities(Entities entities) {
        if(entities != null) {
            this.entityid = entities.getId();
        }

        this.entities = entities;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`userid`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`posts_ibfk_1`"))
    @Fetch(FetchMode.JOIN)
    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        if(users != null) {
            this.userid = users.getId();
        }

        this.users = users;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`departmentid`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`posts_ibfk_4`"))
    @Fetch(FetchMode.JOIN)
    public Departments getDepartments() {
        return this.departments;
    }

    public void setDepartments(Departments departments) {
        if(departments != null) {
            this.departmentid = departments.getId();
        }

        this.departments = departments;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`locationid`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`posts_ibfk_3`"))
    @Fetch(FetchMode.JOIN)
    public Locations getLocations() {
        return this.locations;
    }

    public void setLocations(Locations locations) {
        if(locations != null) {
            this.locationid = locations.getId();
        }

        this.locations = locations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Posts)) return false;
        final Posts posts = (Posts) o;
        return Objects.equals(getId(), posts.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}