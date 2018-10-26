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
import org.springframework.context.annotation.Lazy;
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

import com.crmweb.crm.LeadSources;
import com.crmweb.crm.Leads;


/**
 * ServiceImpl object for domain model class LeadSources.
 *
 * @see LeadSources
 */
@Service("crm.LeadSourcesService")
@Validated
public class LeadSourcesServiceImpl implements LeadSourcesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeadSourcesServiceImpl.class);

    @Lazy
    @Autowired
    @Qualifier("crm.LeadsService")
    private LeadsService leadsService;

    @Autowired
    @Qualifier("crm.LeadSourcesDao")
    private WMGenericDao<LeadSources, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<LeadSources, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "crmTransactionManager")
    @Override
    public LeadSources create(LeadSources leadSources) {
        LOGGER.debug("Creating a new LeadSources with information: {}", leadSources);

        LeadSources leadSourcesCreated = this.wmGenericDao.create(leadSources);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(leadSourcesCreated);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public LeadSources getById(Integer leadsourcesId) {
        LOGGER.debug("Finding LeadSources by id: {}", leadsourcesId);
        return this.wmGenericDao.findById(leadsourcesId);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public LeadSources findById(Integer leadsourcesId) {
        LOGGER.debug("Finding LeadSources by id: {}", leadsourcesId);
        try {
            return this.wmGenericDao.findById(leadsourcesId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No LeadSources found with id: {}", leadsourcesId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public List<LeadSources> findByMultipleIds(List<Integer> leadsourcesIds, boolean orderedReturn) {
        LOGGER.debug("Finding LeadSources by ids: {}", leadsourcesIds);

        return this.wmGenericDao.findByMultipleIds(leadsourcesIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "crmTransactionManager")
    @Override
    public LeadSources update(LeadSources leadSources) {
        LOGGER.debug("Updating LeadSources with information: {}", leadSources);

        this.wmGenericDao.update(leadSources);
        this.wmGenericDao.refresh(leadSources);

        return leadSources;
    }

    @Transactional(value = "crmTransactionManager")
    @Override
    public LeadSources delete(Integer leadsourcesId) {
        LOGGER.debug("Deleting LeadSources with id: {}", leadsourcesId);
        LeadSources deleted = this.wmGenericDao.findById(leadsourcesId);
        if (deleted == null) {
            LOGGER.debug("No LeadSources found with id: {}", leadsourcesId);
            throw new EntityNotFoundException(String.valueOf(leadsourcesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "crmTransactionManager")
    @Override
    public void delete(LeadSources leadSources) {
        LOGGER.debug("Deleting LeadSources with {}", leadSources);
        this.wmGenericDao.delete(leadSources);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Page<LeadSources> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all LeadSources");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Page<LeadSources> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all LeadSources");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service crm for table LeadSources to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service crm for table LeadSources to {} format", options.getExportType());
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

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Page<Leads> findAssociatedLeadses(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated leadses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("leadSources.id = '" + id + "'");

        return leadsService.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service LeadsService instance
     */
    protected void setLeadsService(LeadsService service) {
        this.leadsService = service;
    }

}