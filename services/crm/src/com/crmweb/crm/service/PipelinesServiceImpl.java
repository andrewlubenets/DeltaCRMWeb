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

import com.crmweb.crm.Opportunities;
import com.crmweb.crm.Pipelines;
import com.crmweb.crm.Stages;


/**
 * ServiceImpl object for domain model class Pipelines.
 *
 * @see Pipelines
 */
@Service("crm.PipelinesService")
@Validated
public class PipelinesServiceImpl implements PipelinesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PipelinesServiceImpl.class);

    @Lazy
    @Autowired
    @Qualifier("crm.StagesService")
    private StagesService stagesService;

    @Lazy
    @Autowired
    @Qualifier("crm.OpportunitiesService")
    private OpportunitiesService opportunitiesService;

    @Autowired
    @Qualifier("crm.PipelinesDao")
    private WMGenericDao<Pipelines, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Pipelines, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "crmTransactionManager")
    @Override
    public Pipelines create(Pipelines pipelines) {
        LOGGER.debug("Creating a new Pipelines with information: {}", pipelines);

        Pipelines pipelinesCreated = this.wmGenericDao.create(pipelines);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(pipelinesCreated);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Pipelines getById(Integer pipelinesId) {
        LOGGER.debug("Finding Pipelines by id: {}", pipelinesId);
        return this.wmGenericDao.findById(pipelinesId);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Pipelines findById(Integer pipelinesId) {
        LOGGER.debug("Finding Pipelines by id: {}", pipelinesId);
        try {
            return this.wmGenericDao.findById(pipelinesId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Pipelines found with id: {}", pipelinesId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public List<Pipelines> findByMultipleIds(List<Integer> pipelinesIds, boolean orderedReturn) {
        LOGGER.debug("Finding Pipelines by ids: {}", pipelinesIds);

        return this.wmGenericDao.findByMultipleIds(pipelinesIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "crmTransactionManager")
    @Override
    public Pipelines update(Pipelines pipelines) {
        LOGGER.debug("Updating Pipelines with information: {}", pipelines);

        this.wmGenericDao.update(pipelines);
        this.wmGenericDao.refresh(pipelines);

        return pipelines;
    }

    @Transactional(value = "crmTransactionManager")
    @Override
    public Pipelines delete(Integer pipelinesId) {
        LOGGER.debug("Deleting Pipelines with id: {}", pipelinesId);
        Pipelines deleted = this.wmGenericDao.findById(pipelinesId);
        if (deleted == null) {
            LOGGER.debug("No Pipelines found with id: {}", pipelinesId);
            throw new EntityNotFoundException(String.valueOf(pipelinesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "crmTransactionManager")
    @Override
    public void delete(Pipelines pipelines) {
        LOGGER.debug("Deleting Pipelines with {}", pipelines);
        this.wmGenericDao.delete(pipelines);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Page<Pipelines> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Pipelines");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Page<Pipelines> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Pipelines");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service crm for table Pipelines to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service crm for table Pipelines to {} format", options.getExportType());
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
    public Page<Opportunities> findAssociatedOpportunitieses(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated opportunitieses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("pipelines.id = '" + id + "'");

        return opportunitiesService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Page<Stages> findAssociatedStageses(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated stageses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("pipelines.id = '" + id + "'");

        return stagesService.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service StagesService instance
     */
    protected void setStagesService(StagesService service) {
        this.stagesService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service OpportunitiesService instance
     */
    protected void setOpportunitiesService(OpportunitiesService service) {
        this.opportunitiesService = service;
    }

}