/*Copyright (c) 2018-2019 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.crmweb.crm.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.export.ExportOptions;

import com.crmweb.crm.models.query.*;

public interface CrmQueryExecutorService {

    Page<WonvstargetResponse> executeWonvstarget(Pageable pageable);

    void exportWonvstarget(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<TotdeltaResponse> executeTotdelta(Pageable pageable);

    void exportTotdelta(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<TotcommitResponse> executeTotcommit(Pageable pageable);

    void exportTotcommit(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<GetproductfromuseridResponse> executeGetproductfromuserid(String iduser, Pageable pageable);

    void exportGetproductfromuserid(String iduser, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<Top5valopposResponse> executeTop5valoppos(Pageable pageable);

    void exportTop5valoppos(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<UserthathasOpenOpportunitiesResponse> executeUserthathasOpenOpportunities(String date1, String date2, Pageable pageable);

    void exportUserthathasOpenOpportunities(String date1, String date2, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<ProjectcountusersandproductsResponse> executeProjectcountusersandproducts(Pageable pageable);

    void exportProjectcountusersandproducts(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<TotsumUpsideResponse> executeTotsumUpside(Pageable pageable);

    void exportTotsumUpside(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<UsersSumOpportunityTotalResponse> executeUsers_sum_opportunity_total(Pageable pageable);

    void exportUsers_sum_opportunity_total(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<TotsumoppoResponse> executeTotsumoppo(Pageable pageable);

    void exportTotsumoppo(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<Top5usersMoreOppoResponse> executeTop5usersMoreOppo(Pageable pageable);

    void exportTop5usersMoreOppo(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<TotalhwswVsDeltaResponse> executeTotalhwsw_vs_delta(Pageable pageable);

    void exportTotalhwsw_vs_delta(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<TotalProductCategoriesResponse> executeTotal_product_categories(Pageable pageable);

    void exportTotal_product_categories(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<SearchprojectopportunitiesResponse> executeSearchprojectopportunities(String words, Pageable pageable);

    void exportSearchprojectopportunities(String words, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

    Page<Userthathasoppo2Response> executeUserthathasoppo2(String date1, String date2, Pageable pageable);

    void exportUserthathasoppo2(String date1, String date2, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

}