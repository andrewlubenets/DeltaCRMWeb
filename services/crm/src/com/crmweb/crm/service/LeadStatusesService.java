/*Copyright (c) 2018-2019 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.crmweb.crm.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.crmweb.crm.LeadStatuses;
import com.crmweb.crm.Leads;

/**
 * Service object for domain model class {@link LeadStatuses}.
 */
public interface LeadStatusesService {

    /**
     * Creates a new LeadStatuses. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on LeadStatuses if any.
     *
     * @param leadStatuses Details of the LeadStatuses to be created; value cannot be null.
     * @return The newly created LeadStatuses.
     */
    LeadStatuses create(@Valid LeadStatuses leadStatuses);


	/**
     * Returns LeadStatuses by given id if exists.
     *
     * @param leadstatusesId The id of the LeadStatuses to get; value cannot be null.
     * @return LeadStatuses associated with the given leadstatusesId.
	 * @throws EntityNotFoundException If no LeadStatuses is found.
     */
    LeadStatuses getById(Integer leadstatusesId);

    /**
     * Find and return the LeadStatuses by given id if exists, returns null otherwise.
     *
     * @param leadstatusesId The id of the LeadStatuses to get; value cannot be null.
     * @return LeadStatuses associated with the given leadstatusesId.
     */
    LeadStatuses findById(Integer leadstatusesId);

	/**
     * Find and return the list of LeadStatuses by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param leadstatusesIds The id's of the LeadStatuses to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return LeadStatuses associated with the given leadstatusesIds.
     */
    List<LeadStatuses> findByMultipleIds(List<Integer> leadstatusesIds, boolean orderedReturn);


    /**
     * Updates the details of an existing LeadStatuses. It replaces all fields of the existing LeadStatuses with the given leadStatuses.
     *
     * This method overrides the input field values using Server side or database managed properties defined on LeadStatuses if any.
     *
     * @param leadStatuses The details of the LeadStatuses to be updated; value cannot be null.
     * @return The updated LeadStatuses.
     * @throws EntityNotFoundException if no LeadStatuses is found with given input.
     */
    LeadStatuses update(@Valid LeadStatuses leadStatuses);

    /**
     * Deletes an existing LeadStatuses with the given id.
     *
     * @param leadstatusesId The id of the LeadStatuses to be deleted; value cannot be null.
     * @return The deleted LeadStatuses.
     * @throws EntityNotFoundException if no LeadStatuses found with the given id.
     */
    LeadStatuses delete(Integer leadstatusesId);

    /**
     * Deletes an existing LeadStatuses with the given object.
     *
     * @param leadStatuses The instance of the LeadStatuses to be deleted; value cannot be null.
     */
    void delete(LeadStatuses leadStatuses);

    /**
     * Find all LeadStatuses matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching LeadStatuses.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<LeadStatuses> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all LeadStatuses matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching LeadStatuses.
     *
     * @see Pageable
     * @see Page
     */
    Page<LeadStatuses> findAll(String query, Pageable pageable);

    /**
     * Exports all LeadStatuses matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
     */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

    /**
     * Exports all LeadStatuses matching the given input query to the given exportType format.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     * @see Pageable
     * @see OutputStream
     */
    void export(DataExportOptions options, Pageable pageable, OutputStream outputStream);

    /**
     * Retrieve the count of the LeadStatuses in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the LeadStatuses.
     */
    long count(String query);

    /**
     * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return Paginated data with included fields.
     *
     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
    Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);

    /*
     * Returns the associated leadses for given LeadStatuses id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Leads instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Leads> findAssociatedLeadses(Integer id, Pageable pageable);

}