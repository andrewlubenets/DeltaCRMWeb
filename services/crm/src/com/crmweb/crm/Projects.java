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
 * Projects generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`projects`")
public class Projects implements Serializable {

    private Integer id;
    private String name;
    private String description;
    private Integer categoryid;
    private Integer userresponsibleid;
    private Integer opportunityid;
    private LocalDateTime dateCreation;
    private Integer hasopportunities;
    private String stages;
    private Categories categories;
    private Opportunities opportunities;
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

    @Column(name = "`name`", nullable = true, length = 255)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`description`", nullable = true, length = 255)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "`categoryid`", nullable = true, scale = 0, precision = 10)
    public Integer getCategoryid() {
        return this.categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    @Column(name = "`userresponsibleid`", nullable = true, scale = 0, precision = 10)
    public Integer getUserresponsibleid() {
        return this.userresponsibleid;
    }

    public void setUserresponsibleid(Integer userresponsibleid) {
        this.userresponsibleid = userresponsibleid;
    }

    @Column(name = "`opportunityid`", nullable = true, scale = 0, precision = 10)
    public Integer getOpportunityid() {
        return this.opportunityid;
    }

    public void setOpportunityid(Integer opportunityid) {
        this.opportunityid = opportunityid;
    }

    @Column(name = "`date_creation`", nullable = true)
    public LocalDateTime getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Column(name = "`hasopportunities`", nullable = true, scale = 0, precision = 10)
    public Integer getHasopportunities() {
        return this.hasopportunities;
    }

    public void setHasopportunities(Integer hasopportunities) {
        this.hasopportunities = hasopportunities;
    }

    @Column(name = "`stages`", nullable = true, length = 255)
    public String getStages() {
        return this.stages;
    }

    public void setStages(String stages) {
        this.stages = stages;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`categoryid`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`projects_ibfk_1`"))
    @Fetch(FetchMode.JOIN)
    public Categories getCategories() {
        return this.categories;
    }

    public void setCategories(Categories categories) {
        if(categories != null) {
            this.categoryid = categories.getId();
        }

        this.categories = categories;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`opportunityid`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`projects_ibfk_5`"))
    @Fetch(FetchMode.JOIN)
    public Opportunities getOpportunities() {
        return this.opportunities;
    }

    public void setOpportunities(Opportunities opportunities) {
        if(opportunities != null) {
            this.opportunityid = opportunities.getId();
        }

        this.opportunities = opportunities;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`userresponsibleid`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`projects_ibfk_2`"))
    @Fetch(FetchMode.JOIN)
    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        if(users != null) {
            this.userresponsibleid = users.getId();
        }

        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Projects)) return false;
        final Projects projects = (Projects) o;
        return Objects.equals(getId(), projects.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}