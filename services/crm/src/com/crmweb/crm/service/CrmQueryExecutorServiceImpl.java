/*Copyright (c) 2018-2019 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.crmweb.crm.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.query.WMQueryExecutor;
import com.wavemaker.runtime.data.export.ExportOptions;
import com.wavemaker.runtime.data.model.QueryProcedureInput;

import com.crmweb.crm.models.query.*;

@Service
public class CrmQueryExecutorServiceImpl implements CrmQueryExecutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CrmQueryExecutorServiceImpl.class);

    @Autowired
    @Qualifier("crmWMQueryExecutor")
    private WMQueryExecutor queryExecutor;

    @Transactional(value = "crmTransactionManager", readOnly = true)
    @Override
    public Page<SearchprojectopportunitiesResponse> executeSearchprojectopportunities(String words, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("words", words);

        return queryExecutor.executeNamedQuery("searchprojectopportunities", params, SearchprojectopportunitiesResponse.class, pageable);
    }

    @Transactional(value = "crmTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSearchprojectopportunities(String words, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("words", words);

        QueryProcedureInput queryInput = new QueryProcedureInput("searchprojectopportunities", params, SearchprojectopportunitiesResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "crmTransactionManager", readOnly = true)
    @Override
    public Page<Userthathasoppo2Response> executeUserthathasoppo2(String date1, String date2, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("date1", date1);
        params.put("date2", date2);

        return queryExecutor.executeNamedQuery("userthathasoppo2", params, Userthathasoppo2Response.class, pageable);
    }

    @Transactional(value = "crmTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportUserthathasoppo2(String date1, String date2, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("date1", date1);
        params.put("date2", date2);

        QueryProcedureInput queryInput = new QueryProcedureInput("userthathasoppo2", params, Userthathasoppo2Response.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "crmTransactionManager", readOnly = true)
    @Override
    public Page<UserthathasOpenOpportunitiesResponse> executeUserthathasOpenOpportunities(String date1, String date2, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("date1", date1);
        params.put("date2", date2);

        return queryExecutor.executeNamedQuery("userthathasOpenOpportunities", params, UserthathasOpenOpportunitiesResponse.class, pageable);
    }

    @Transactional(value = "crmTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportUserthathasOpenOpportunities(String date1, String date2, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("date1", date1);
        params.put("date2", date2);

        QueryProcedureInput queryInput = new QueryProcedureInput("userthathasOpenOpportunities", params, UserthathasOpenOpportunitiesResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

}