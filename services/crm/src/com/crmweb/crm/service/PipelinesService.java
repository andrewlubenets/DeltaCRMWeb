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

import com.crmweb.crm.Opportunities;
import com.crmweb.crm.Pipelines;
import com.crmweb.crm.Stages;

/**
 * Service object for domain model class {@link Pipelines}.
 */
public interface PipelinesService {

    /**
     * Creates a new Pipelines. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Pipelines if any.
     *
     * @param pipelines Details of the Pipelines to be created; value cannot be null.
     * @return The newly created Pipelines.
     */
    Pipelines create(@Valid Pipelines pipelines);


	/**
     * Returns Pipelines by given id if exists.
     *
     * @param pipelinesId The id of the Pipelines to get; value cannot be null.
     * @return Pipelines associated with the given pipelinesId.
	 * @throws EntityNotFoundException If no Pipelines is found.
     */
    Pipelines getById(Integer pipelinesId);

    /**
     * Find and return the Pipelines by given id if exists, returns null otherwise.
     *
     * @param pipelinesId The id of the Pipelines to get; value cannot be null.
     * @return Pipelines associated with the given pipelinesId.
     */
    Pipelines findById(Integer pipelinesId);

	/**
     * Find and return the list of Pipelines by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param pipelinesIds The id's of the Pipelines to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Pipelines associated with the given pipelinesIds.
     */
    List<Pipelines> findByMultipleIds(List<Integer> pipelinesIds, boolean orderedReturn);


    /**
     * Updates the details of an existing Pipelines. It replaces all fields of the existing Pipelines with the given pipelines.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Pipelines if any.
     *
     * @param pipelines The details of the Pipelines to be updated; value cannot be null.
     * @return The updated Pipelines.
     * @throws EntityNotFoundException if no Pipelines is found with given input.
     */
    Pipelines update(@Valid Pipelines pipelines);

    /**
     * Deletes an existing Pipelines with the given id.
     *
     * @param pipelinesId The id of the Pipelines to be deleted; value cannot be null.
     * @return The deleted Pipelines.
     * @throws EntityNotFoundException if no Pipelines found with the given id.
     */
    Pipelines delete(Integer pipelinesId);

    /**
     * Deletes an existing Pipelines with the given object.
     *
     * @param pipelines The instance of the Pipelines to be deleted; value cannot be null.
     */
    void delete(Pipelines pipelines);

    /**
     * Find all Pipelines matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Pipelines.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Pipelines> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Pipelines matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Pipelines.
     *
     * @see Pageable
     * @see Page
     */
    Page<Pipelines> findAll(String query, Pageable pageable);

    /**
     * Exports all Pipelines matching the given input query to the given exportType format.
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
     * Exports all Pipelines matching the given input query to the given exportType format.
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
     * Retrieve the count of the Pipelines in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Pipelines.
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
     * Returns the associated opportunitieses for given Pipelines id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Opportunities instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Opportunities> findAssociatedOpportunitieses(Integer id, Pageable pageable);

    /*
     * Returns the associated stageses for given Pipelines id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Stages instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Stages> findAssociatedStageses(Integer id, Pageable pageable);

}