package com.tudou.base.menu.service;

import com.tudou.base.menu.entity.Items;
import com.tudou.extra.system.AuthInfo;
import com.tudou.system.platform.base.service.IBaseService;
import com.tudou.base.menu.entity.EidpMenu;

import java.util.List;

public interface IEidpMenuService extends IBaseService<EidpMenu, String> {

    /**
     * 查找出所有菜单/排序
     *
     * @throws Exception
     */
    List<Items> getMenus() throws Exception;

    /**
     * 获取用户菜单
     *
     * @return
     * @throws Exception
     */
    List<Items> getMenusByEmp(AuthInfo authInfo) throws Exception;
}
