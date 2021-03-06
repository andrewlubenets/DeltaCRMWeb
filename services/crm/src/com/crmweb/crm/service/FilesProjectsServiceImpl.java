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

import com.crmweb.crm.FilesProjects;


/**
 * ServiceImpl object for domain model class FilesProjects.
 *
 * @see FilesProjects
 */
@Service("crm.FilesProjectsService")
@Validated
public class FilesProjectsServiceImpl implements FilesProjectsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilesProjectsServiceImpl.class);


    @Autowired
    @Qualifier("crm.FilesProjectsDao")
    private WMGenericDao<FilesProjects, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<FilesProjects, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "crmTransactionManager")
    @Override
    public FilesProjects create(FilesProjects filesProjects) {
        LOGGER.debug("Creating a new FilesProjects with information: {}", filesProjects);

        FilesProjects filesProjectsCreated = this.wmGenericDao.create(filesProjects);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(filesProjectsCreated);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public FilesProjects getById(Integer filesprojectsId) {
        LOGGER.debug("Finding FilesProjects by id: {}", filesprojectsId);
        return this.wmGenericDao.findById(filesprojectsId);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public FilesProjects findById(Integer filesprojectsId) {
        LOGGER.debug("Finding FilesProjects by id: {}", filesprojectsId);
        try {
            return this.wmGenericDao.findById(filesprojectsId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No FilesProjects found with id: {}", filesprojectsId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public List<FilesProjects> findByMultipleIds(List<Integer> filesprojectsIds, boolean orderedReturn) {
        LOGGER.debug("Finding FilesProjects by ids: {}", filesprojectsIds);

        return this.wmGenericDao.findByMultipleIds(filesprojectsIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "crmTransactionManager")
    @Override
    public FilesProjects update(FilesProjects filesProjects) {
        LOGGER.debug("Updating FilesProjects with information: {}", filesProjects);

        this.wmGenericDao.update(filesProjects);
        this.wmGenericDao.refresh(filesProjects);

        return filesProjects;
    }

    @Transactional(value = "crmTransactionManager")
    @Override
    public FilesProjects delete(Integer filesprojectsId) {
        LOGGER.debug("Deleting FilesProjects with id: {}", filesprojectsId);
        FilesProjects deleted = this.wmGenericDao.findById(filesprojectsId);
        if (deleted == null) {
            LOGGER.debug("No FilesProjects found with id: {}", filesprojectsId);
            throw new EntityNotFoundException(String.valueOf(filesprojectsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "crmTransactionManager")
    @Override
    public void delete(FilesProjects filesProjects) {
        LOGGER.debug("Deleting FilesProjects with {}", filesProjects);
        this.wmGenericDao.delete(filesProjects);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Page<FilesProjects> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all FilesProjects");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Page<FilesProjects> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all FilesProjects");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service crm for table FilesProjects to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service crm for table FilesProjects to {} format", options.getExportType());
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