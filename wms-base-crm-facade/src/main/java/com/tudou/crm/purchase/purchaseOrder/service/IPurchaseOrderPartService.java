package com.tudou.crm.purchase.purchaseOrder.service;

import com.tudou.crm.purchase.purchaseOrder.entity.PurchaseOrderPart;
import com.tudou.system.platform.base.service.IBaseService;

import java.util.List;

public interface IPurchaseOrderPartService extends IBaseService<PurchaseOrderPart, String> {


    void savePurchaseApplyPart(List<PurchaseOrderPart> purchaseOrderParts, String id)throws Exception;

    /**
     * 通过采购订单号查询采购订单明细
     *
     * @param id
     * @return
     */
    List<PurchaseOrderPart> findPurchaseOrderPartByPurchaseId(String id);

    /**
     * 通过明细单号查询整个采购单明细
     *
     * @param id
     * @return
     */
    List<PurchaseOrderPart> findPurchaseOrderPartByPartId(String id);
}
