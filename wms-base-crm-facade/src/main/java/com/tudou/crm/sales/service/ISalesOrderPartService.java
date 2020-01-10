package com.tudou.crm.sales.service;

import com.tudou.system.platform.base.service.IBaseService;
import com.tudou.crm.sales.entity.SalesOrderPart;

import java.util.List;

public interface ISalesOrderPartService extends IBaseService<SalesOrderPart, String> {

    /**
     * 保存销售订单明细
     *
     * @param salesOrderParts
     * @param id
     * @throws Exception
     */
    void saveSalesOrderPart(List<SalesOrderPart> salesOrderParts, String id) throws Exception;

    /**
     * 通过销售单号查询明细
     *
     * @param id
     * @return
     */
    List<SalesOrderPart> findSalesOrderPartBySalesOrderId(String id);
}
