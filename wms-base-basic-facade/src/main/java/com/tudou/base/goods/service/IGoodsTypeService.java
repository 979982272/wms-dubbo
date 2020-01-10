package com.tudou.base.goods.service;

import com.tudou.system.platform.base.service.IBaseService;
import com.tudou.base.goods.entity.GoodsType;

import java.util.List;

public interface IGoodsTypeService extends IBaseService<GoodsType,String>{
    List<GoodsType> loadGoodsTypeDate(String id);
}
