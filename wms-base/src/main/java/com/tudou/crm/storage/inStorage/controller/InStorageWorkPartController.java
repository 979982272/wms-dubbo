package com.tudou.crm.storage.inStorage.controller;

import com.tudou.system.platform.base.model.DataSourceRequest;
import com.tudou.system.platform.base.model.DataSourceResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.tudou.crm.storage.inStorage.service.IInStorageWorkPartService;
import com.tudou.system.platform.base.controller.BaseCurdController;
import com.tudou.crm.storage.inStorage.entity.InStorageWorkPart;
import com.tudou.system.platform.base.annotation.BaseResource;
import com.tudou.system.platform.base.model.StatusModel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/crm/inStorage/inStorageWorkPart")
public class InStorageWorkPartController extends BaseCurdController<InStorageWorkPart> {

    @Resource
    @BaseResource
    private IInStorageWorkPartService inStorageWorkPartService;

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

    /**
     * 载入明细信息
     *
     * @param dataSourceRequest
     * @param request
     * @return
     */
    @RequestMapping(value = "loadDetailData")
    @ResponseBody
    public DataSourceResult loadDetailData(@RequestBody DataSourceRequest dataSourceRequest, HttpServletRequest request) {
        DataSourceResult dataSourceResult = new DataSourceResult();
        String id = request.getParameter("id");
        try {
            List<InStorageWorkPart> inStorageWorkParts = inStorageWorkPartService.findInStorageWorkPartByStorageId(id);
            dataSourceResult.setTotal(inStorageWorkParts.size());
            dataSourceResult.setData(inStorageWorkParts);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
        return dataSourceResult;
    }

    /**
     * 明细入库
     *
     * @return
     */
    @RequestMapping(value = "inStorageByPart", method = RequestMethod.POST)
    @ResponseBody
    public StatusModel inStorageByPart(@RequestParam(value = "id", required = true) String id,
                                       @RequestParam(value = "receivingAmount", required = true) BigDecimal receivingAmount) {
        try {
            inStorageWorkPartService.inStorageByPart(id, receivingAmount);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            e.printStackTrace();
            return new StatusModel(false, e.getMessage());
        }
        return new StatusModel(true, "入库成功！");
    }
}
