package com.tudou.base.menu.controller;

import com.tudou.base.menu.entity.Items;
import com.tudou.extra.system.UserInfoUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import com.tudou.base.menu.service.IEidpMenuService;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tudou.system.platform.base.controller.BaseCurdController;
import com.tudou.base.menu.entity.EidpMenu;
import com.tudou.system.platform.base.annotation.BaseResource;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tudou.system.platform.base.model.StatusModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/base/menu")
public class EidpMenuController extends BaseCurdController<EidpMenu> {

    @Resource
    @BaseResource
    private IEidpMenuService eidpMenuService;

    /**
     * 初始化
     *
     * @return
     */
    @RequestMapping(value = "/getDefaultInfo", method = RequestMethod.POST)
    @ResponseBody
    public StatusModel getDefaultInfo() {
        Map<String, Object> info = new HashMap<String, Object>();
        StatusModel statusModel = new StatusModel(true, info);
        return statusModel;
    }

    @RequestMapping(value = "getMenus", method = RequestMethod.POST)
    @ResponseBody
    public List<Items> getMenus() throws Exception {
        return eidpMenuService.getMenusByEmp(UserInfoUtil.getCurrentAuthInfo());
       // return eidpMenuService.getMenus();
    }
}
