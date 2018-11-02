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

import com.crmweb.crm.Leads;
import com.crmweb.crm.Opportunities;
import com.crmweb.crm.Posts;
import com.crmweb.crm.Projects;
import com.crmweb.crm.Tasks;
import com.crmweb.crm.Userinfo;
import com.crmweb.crm.Users;
import com.crmweb.crm.service.UsersService;


/**
 * Controller object for domain model class Users.
 * @see Users
 */
@RestController("crm.UsersController")
@Api(value = "UsersController", description = "Exposes APIs to work with Users resource.")
@RequestMapping("/crm/Users")
public class UsersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

    @Autowired
	@Qualifier("crm.UsersService")
	private UsersService usersService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new Users instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Users createUsers(@RequestBody Users users) {
		LOGGER.debug("Create Users with information: {}" , users);

		users = usersService.create(users);
		LOGGER.debug("Created Users with information: {}" , users);

	    return users;
	}

    @ApiOperation(value = "Returns the Users instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Users getUsers(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting Users with id: {}" , id);

        Users foundUsers = usersService.getById(id);
        LOGGER.debug("Users details with id: {}" , foundUsers);

        return foundUsers;
    }

    @ApiOperation(value = "Updates the Users instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Users editUsers(@PathVariable("id") Integer id, @RequestBody Users users) {
        LOGGER.debug("Editing Users with id: {}" , users.getId());

        users.setId(id);
        users = usersService.update(users);
        LOGGER.debug("Users details with id: {}" , users);

        return users;
    }

    @ApiOperation(value = "Deletes the Users instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteUsers(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting Users with id: {}" , id);

        Users deletedUsers = usersService.delete(id);

        return deletedUsers != null;
    }

    /**
     * @deprecated Use {@link #findUsers(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Users instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Users> searchUsersByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Users list by query filter:{}", (Object) queryFilters);
        return usersService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Users instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Users> findUsers(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Users list by filter:", query);
        return usersService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Users instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Users> filterUsers(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Users list by filter", query);
        return usersService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportUsers(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return usersService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportUsersAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = Users.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> usersService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of Users instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countUsers( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Users");
		return usersService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getUsersAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return usersService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/leadses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the leadses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Leads> findAssociatedLeadses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated leadses");
        return usersService.findAssociatedLeadses(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/opportunitieses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the opportunitieses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Opportunities> findAssociatedOpportunitieses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated opportunitieses");
        return usersService.findAssociatedOpportunitieses(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/postses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the postses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Posts> findAssociatedPostses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated postses");
        return usersService.findAssociatedPostses(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/projectses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the projectses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Projects> findAssociatedProjectses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated projectses");
        return usersService.findAssociatedProjectses(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/taskses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the taskses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Tasks> findAssociatedTaskses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated taskses");
        return usersService.findAssociatedTaskses(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/userinfos", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the userinfos instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Userinfo> findAssociatedUserinfos(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated userinfos");
        return usersService.findAssociatedUserinfos(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service UsersService instance
	 */
	protected void setUsersService(UsersService service) {
		this.usersService = service;
	}

}