package com.tudou.base.warehouse.service;

import com.tudou.system.platform.base.service.IBaseService;
import com.tudou.base.warehouse.entity.Warehouse;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

public interface IWarehouseService extends IBaseService<Warehouse,String>{
    /**
     * 通过仓库编码查询仓库名称
     *
     * @param warehouseId
     * @return
     */
    String findWarehouseNameById(String warehouseId);
}
