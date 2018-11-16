/*Copyright (c) 2018-2019 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.crmweb.crm.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.ExportOptions;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import com.crmweb.crm.service.CrmQueryExecutorService;
import com.crmweb.crm.models.query.*;

@RestController(value = "Crm.QueryExecutionController")
@RequestMapping("/crm/queryExecutor")
@Api(value = "QueryExecutionController", description = "controller class for query execution")
public class QueryExecutionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryExecutionController.class);

    @Autowired
    private CrmQueryExecutorService queryService;

    @Autowired
	private ExportedFileManager exportedFileManager;

    @RequestMapping(value = "/queries/searchprojectopportunities", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "project and opportunities")
    public Page<SearchprojectopportunitiesResponse> executeSearchprojectopportunities(@RequestParam(value = "words") String words, Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: searchprojectopportunities");
        Page<SearchprojectopportunitiesResponse> _result = queryService.executeSearchprojectopportunities(words, pageable);
        LOGGER.debug("got the result for named query: searchprojectopportunities, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file url for query searchprojectopportunities")
    @RequestMapping(value = "/queries/searchprojectopportunities/export", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportSearchprojectopportunities(@RequestParam(value = "words") String words, @RequestBody ExportOptions exportOptions, Pageable pageable) {
        LOGGER.debug("Exporting named query: searchprojectopportunities");

        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = "searchprojectopportunities";
        }
        exportedFileName += exportOptions.getExportType().getExtension();

        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName,
                        outputStream -> queryService.exportSearchprojectopportunities(words,  exportOptions, pageable, outputStream));

        return new StringWrapper(exportedUrl);
    }

    @RequestMapping(value = "/queries/userthathasoppo2", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "user that has oppo 2")
    public Page<Userthathasoppo2Response> executeUserthathasoppo2(@RequestParam(value = "date1") String date1, @RequestParam(value = "date2") String date2, Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: userthathasoppo2");
        Page<Userthathasoppo2Response> _result = queryService.executeUserthathasoppo2(date1, date2, pageable);
        LOGGER.debug("got the result for named query: userthathasoppo2, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file url for query userthathasoppo2")
    @RequestMapping(value = "/queries/userthathasoppo2/export", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportUserthathasoppo2(@RequestParam(value = "date1") String date1, @RequestParam(value = "date2") String date2, @RequestBody ExportOptions exportOptions, Pageable pageable) {
        LOGGER.debug("Exporting named query: userthathasoppo2");

        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = "userthathasoppo2";
        }
        exportedFileName += exportOptions.getExportType().getExtension();

        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName,
                        outputStream -> queryService.exportUserthathasoppo2(date1, date2,  exportOptions, pageable, outputStream));

        return new StringWrapper(exportedUrl);
    }

    @RequestMapping(value = "/queries/userthathasOpenOpportunities", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Users that has open opportunities")
    public Page<UserthathasOpenOpportunitiesResponse> executeUserthathasOpenOpportunities(@RequestParam(value = "date1") String date1, @RequestParam(value = "date2") String date2, Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: userthathasOpenOpportunities");
        Page<UserthathasOpenOpportunitiesResponse> _result = queryService.executeUserthathasOpenOpportunities(date1, date2, pageable);
        LOGGER.debug("got the result for named query: userthathasOpenOpportunities, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file url for query userthathasOpenOpportunities")
    @RequestMapping(value = "/queries/userthathasOpenOpportunities/export", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportUserthathasOpenOpportunities(@RequestParam(value = "date1") String date1, @RequestParam(value = "date2") String date2, @RequestBody ExportOptions exportOptions, Pageable pageable) {
        LOGGER.debug("Exporting named query: userthathasOpenOpportunities");

        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = "userthathasOpenOpportunities";
        }
        exportedFileName += exportOptions.getExportType().getExtension();

        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName,
                        outputStream -> queryService.exportUserthathasOpenOpportunities(date1, date2,  exportOptions, pageable, outputStream));

        return new StringWrapper(exportedUrl);
    }

}