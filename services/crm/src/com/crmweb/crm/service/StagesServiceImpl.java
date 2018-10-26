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
import com.crmweb.crm.Projects;
import com.crmweb.crm.Stages;


/**
 * ServiceImpl object for domain model class Stages.
 *
 * @see Stages
 */
@Service("crm.StagesService")
@Validated
public class StagesServiceImpl implements StagesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StagesServiceImpl.class);

    @Lazy
    @Autowired
    @Qualifier("crm.ProjectsService")
    private ProjectsService projectsService;

    @Lazy
    @Autowired
    @Qualifier("crm.OpportunitiesService")
    private OpportunitiesService opportunitiesService;

    @Autowired
    @Qualifier("crm.StagesDao")
    private WMGenericDao<Stages, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Stages, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "crmTransactionManager")
    @Override
    public Stages create(Stages stages) {
        LOGGER.debug("Creating a new Stages with information: {}", stages);

        Stages stagesCreated = this.wmGenericDao.create(stages);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(stagesCreated);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Stages getById(Integer stagesId) {
        LOGGER.debug("Finding Stages by id: {}", stagesId);
        return this.wmGenericDao.findById(stagesId);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Stages findById(Integer stagesId) {
        LOGGER.debug("Finding Stages by id: {}", stagesId);
        try {
            return this.wmGenericDao.findById(stagesId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Stages found with id: {}", stagesId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public List<Stages> findByMultipleIds(List<Integer> stagesIds, boolean orderedReturn) {
        LOGGER.debug("Finding Stages by ids: {}", stagesIds);

        return this.wmGenericDao.findByMultipleIds(stagesIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "crmTransactionManager")
    @Override
    public Stages update(Stages stages) {
        LOGGER.debug("Updating Stages with information: {}", stages);

        this.wmGenericDao.update(stages);
        this.wmGenericDao.refresh(stages);

        return stages;
    }

    @Transactional(value = "crmTransactionManager")
    @Override
    public Stages delete(Integer stagesId) {
        LOGGER.debug("Deleting Stages with id: {}", stagesId);
        Stages deleted = this.wmGenericDao.findById(stagesId);
        if (deleted == null) {
            LOGGER.debug("No Stages found with id: {}", stagesId);
            throw new EntityNotFoundException(String.valueOf(stagesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "crmTransactionManager")
    @Override
    public void delete(Stages stages) {
        LOGGER.debug("Deleting Stages with {}", stages);
        this.wmGenericDao.delete(stages);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Page<Stages> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Stages");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Page<Stages> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Stages");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service crm for table Stages to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service crm for table Stages to {} format", options.getExportType());
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
        queryBuilder.append("stages.id = '" + id + "'");

        return opportunitiesService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Page<Projects> findAssociatedProjectses(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated projectses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("stages.id = '" + id + "'");

        return projectsService.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service ProjectsService instance
     */
    protected void setProjectsService(ProjectsService service) {
        this.projectsService = service;
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