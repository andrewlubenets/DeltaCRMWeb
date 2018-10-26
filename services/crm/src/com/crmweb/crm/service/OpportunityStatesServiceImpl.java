/*Copyright (c) 2018-2019 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.crmweb.crm.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.crmweb.crm.OpportunityStates;


/**
 * ServiceImpl object for domain model class OpportunityStates.
 *
 * @see OpportunityStates
 */
@Service("crm.OpportunityStatesService")
@Validated
public class OpportunityStatesServiceImpl implements OpportunityStatesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpportunityStatesServiceImpl.class);


    @Autowired
    @Qualifier("crm.OpportunityStatesDao")
    private WMGenericDao<OpportunityStates, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<OpportunityStates, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "crmTransactionManager")
    @Override
    public OpportunityStates create(OpportunityStates opportunityStates) {
        LOGGER.debug("Creating a new OpportunityStates with information: {}", opportunityStates);

        OpportunityStates opportunityStatesCreated = this.wmGenericDao.create(opportunityStates);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(opportunityStatesCreated);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public OpportunityStates getById(Integer opportunitystatesId) {
        LOGGER.debug("Finding OpportunityStates by id: {}", opportunitystatesId);
        return this.wmGenericDao.findById(opportunitystatesId);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public OpportunityStates findById(Integer opportunitystatesId) {
        LOGGER.debug("Finding OpportunityStates by id: {}", opportunitystatesId);
        try {
            return this.wmGenericDao.findById(opportunitystatesId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No OpportunityStates found with id: {}", opportunitystatesId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public List<OpportunityStates> findByMultipleIds(List<Integer> opportunitystatesIds, boolean orderedReturn) {
        LOGGER.debug("Finding OpportunityStates by ids: {}", opportunitystatesIds);

        return this.wmGenericDao.findByMultipleIds(opportunitystatesIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "crmTransactionManager")
    @Override
    public OpportunityStates update(OpportunityStates opportunityStates) {
        LOGGER.debug("Updating OpportunityStates with information: {}", opportunityStates);

        this.wmGenericDao.update(opportunityStates);
        this.wmGenericDao.refresh(opportunityStates);

        return opportunityStates;
    }

    @Transactional(value = "crmTransactionManager")
    @Override
    public OpportunityStates delete(Integer opportunitystatesId) {
        LOGGER.debug("Deleting OpportunityStates with id: {}", opportunitystatesId);
        OpportunityStates deleted = this.wmGenericDao.findById(opportunitystatesId);
        if (deleted == null) {
            LOGGER.debug("No OpportunityStates found with id: {}", opportunitystatesId);
            throw new EntityNotFoundException(String.valueOf(opportunitystatesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "crmTransactionManager")
    @Override
    public void delete(OpportunityStates opportunityStates) {
        LOGGER.debug("Deleting OpportunityStates with {}", opportunityStates);
        this.wmGenericDao.delete(opportunityStates);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Page<OpportunityStates> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all OpportunityStates");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Page<OpportunityStates> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all OpportunityStates");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service crm for table OpportunityStates to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service crm for table OpportunityStates to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}