/*Copyright (c) 2018-2019 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.crmweb.crm.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.crmweb.crm.Opportunities;
import com.crmweb.crm.Projects;
import com.crmweb.crm.service.OpportunitiesService;


/**
 * Controller object for domain model class Opportunities.
 * @see Opportunities
 */
@RestController("crm.OpportunitiesController")
@Api(value = "OpportunitiesController", description = "Exposes APIs to work with Opportunities resource.")
@RequestMapping("/crm/Opportunities")
public class OpportunitiesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpportunitiesController.class);

    @Autowired
	@Qualifier("crm.OpportunitiesService")
	private OpportunitiesService opportunitiesService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new Opportunities instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Opportunities createOpportunities(@RequestBody Opportunities opportunities) {
		LOGGER.debug("Create Opportunities with information: {}" , opportunities);

		opportunities = opportunitiesService.create(opportunities);
		LOGGER.debug("Created Opportunities with information: {}" , opportunities);

	    return opportunities;
	}

    @ApiOperation(value = "Returns the Opportunities instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Opportunities getOpportunities(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting Opportunities with id: {}" , id);

        Opportunities foundOpportunities = opportunitiesService.getById(id);
        LOGGER.debug("Opportunities details with id: {}" , foundOpportunities);

        return foundOpportunities;
    }

    @ApiOperation(value = "Updates the Opportunities instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Opportunities editOpportunities(@PathVariable("id") Integer id, @RequestBody Opportunities opportunities) {
        LOGGER.debug("Editing Opportunities with id: {}" , opportunities.getId());

        opportunities.setId(id);
        opportunities = opportunitiesService.update(opportunities);
        LOGGER.debug("Opportunities details with id: {}" , opportunities);

        return opportunities;
    }

    @ApiOperation(value = "Deletes the Opportunities instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteOpportunities(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting Opportunities with id: {}" , id);

        Opportunities deletedOpportunities = opportunitiesService.delete(id);

        return deletedOpportunities != null;
    }

    /**
     * @deprecated Use {@link #findOpportunities(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Opportunities instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Opportunities> searchOpportunitiesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Opportunities list by query filter:{}", (Object) queryFilters);
        return opportunitiesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Opportunities instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Opportunities> findOpportunities(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Opportunities list by filter:", query);
        return opportunitiesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Opportunities instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Opportunities> filterOpportunities(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Opportunities list by filter", query);
        return opportunitiesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportOpportunities(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return opportunitiesService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportOpportunitiesAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = Opportunities.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> opportunitiesService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of Opportunities instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countOpportunities( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Opportunities");
		return opportunitiesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getOpportunitiesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return opportunitiesService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/projectses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the projectses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Projects> findAssociatedProjectses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated projectses");
        return opportunitiesService.findAssociatedProjectses(id, pageable);
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