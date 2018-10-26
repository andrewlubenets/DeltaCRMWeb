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

import com.crmweb.crm.FilesOpportunities;


/**
 * ServiceImpl object for domain model class FilesOpportunities.
 *
 * @see FilesOpportunities
 */
@Service("crm.FilesOpportunitiesService")
@Validated
public class FilesOpportunitiesServiceImpl implements FilesOpportunitiesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilesOpportunitiesServiceImpl.class);


    @Autowired
    @Qualifier("crm.FilesOpportunitiesDao")
    private WMGenericDao<FilesOpportunities, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<FilesOpportunities, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "crmTransactionManager")
    @Override
    public FilesOpportunities create(FilesOpportunities filesOpportunities) {
        LOGGER.debug("Creating a new FilesOpportunities with information: {}", filesOpportunities);

        FilesOpportunities filesOpportunitiesCreated = this.wmGenericDao.create(filesOpportunities);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(filesOpportunitiesCreated);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public FilesOpportunities getById(Integer filesopportunitiesId) {
        LOGGER.debug("Finding FilesOpportunities by id: {}", filesopportunitiesId);
        return this.wmGenericDao.findById(filesopportunitiesId);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public FilesOpportunities findById(Integer filesopportunitiesId) {
        LOGGER.debug("Finding FilesOpportunities by id: {}", filesopportunitiesId);
        try {
            return this.wmGenericDao.findById(filesopportunitiesId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No FilesOpportunities found with id: {}", filesopportunitiesId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public List<FilesOpportunities> findByMultipleIds(List<Integer> filesopportunitiesIds, boolean orderedReturn) {
        LOGGER.debug("Finding FilesOpportunities by ids: {}", filesopportunitiesIds);

        return this.wmGenericDao.findByMultipleIds(filesopportunitiesIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "crmTransactionManager")
    @Override
    public FilesOpportunities update(FilesOpportunities filesOpportunities) {
        LOGGER.debug("Updating FilesOpportunities with information: {}", filesOpportunities);

        this.wmGenericDao.update(filesOpportunities);
        this.wmGenericDao.refresh(filesOpportunities);

        return filesOpportunities;
    }

    @Transactional(value = "crmTransactionManager")
    @Override
    public FilesOpportunities delete(Integer filesopportunitiesId) {
        LOGGER.debug("Deleting FilesOpportunities with id: {}", filesopportunitiesId);
        FilesOpportunities deleted = this.wmGenericDao.findById(filesopportunitiesId);
        if (deleted == null) {
            LOGGER.debug("No FilesOpportunities found with id: {}", filesopportunitiesId);
            throw new EntityNotFoundException(String.valueOf(filesopportunitiesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "crmTransactionManager")
    @Override
    public void delete(FilesOpportunities filesOpportunities) {
        LOGGER.debug("Deleting FilesOpportunities with {}", filesOpportunities);
        this.wmGenericDao.delete(filesOpportunities);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Page<FilesOpportunities> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all FilesOpportunities");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Page<FilesOpportunities> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all FilesOpportunities");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service crm for table FilesOpportunities to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service crm for table FilesOpportunities to {} format", options.getExportType());
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