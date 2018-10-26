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

import com.crmweb.crm.Contacts;


/**
 * ServiceImpl object for domain model class Contacts.
 *
 * @see Contacts
 */
@Service("crm.ContactsService")
@Validated
public class ContactsServiceImpl implements ContactsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactsServiceImpl.class);


    @Autowired
    @Qualifier("crm.ContactsDao")
    private WMGenericDao<Contacts, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Contacts, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "crmTransactionManager")
    @Override
    public Contacts create(Contacts contacts) {
        LOGGER.debug("Creating a new Contacts with information: {}", contacts);

        Contacts contactsCreated = this.wmGenericDao.create(contacts);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(contactsCreated);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Contacts getById(Integer contactsId) {
        LOGGER.debug("Finding Contacts by id: {}", contactsId);
        return this.wmGenericDao.findById(contactsId);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Contacts findById(Integer contactsId) {
        LOGGER.debug("Finding Contacts by id: {}", contactsId);
        try {
            return this.wmGenericDao.findById(contactsId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Contacts found with id: {}", contactsId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public List<Contacts> findByMultipleIds(List<Integer> contactsIds, boolean orderedReturn) {
        LOGGER.debug("Finding Contacts by ids: {}", contactsIds);

        return this.wmGenericDao.findByMultipleIds(contactsIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "crmTransactionManager")
    @Override
    public Contacts update(Contacts contacts) {
        LOGGER.debug("Updating Contacts with information: {}", contacts);

        this.wmGenericDao.update(contacts);
        this.wmGenericDao.refresh(contacts);

        return contacts;
    }

    @Transactional(value = "crmTransactionManager")
    @Override
    public Contacts delete(Integer contactsId) {
        LOGGER.debug("Deleting Contacts with id: {}", contactsId);
        Contacts deleted = this.wmGenericDao.findById(contactsId);
        if (deleted == null) {
            LOGGER.debug("No Contacts found with id: {}", contactsId);
            throw new EntityNotFoundException(String.valueOf(contactsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "crmTransactionManager")
    @Override
    public void delete(Contacts contacts) {
        LOGGER.debug("Deleting Contacts with {}", contacts);
        this.wmGenericDao.delete(contacts);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Page<Contacts> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Contacts");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager")
    @Override
    public Page<Contacts> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Contacts");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service crm for table Contacts to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "crmTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service crm for table Contacts to {} format", options.getExportType());
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