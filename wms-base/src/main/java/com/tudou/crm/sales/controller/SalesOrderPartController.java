package com.tudou.crm.sales.controller;

import com.tudou.crm.sales.service.ISalesOrderPartService;
import com.tudou.system.platform.base.model.DataSourceRequest;
import com.tudou.system.platform.base.model.DataSourceResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.tudou.system.platform.base.controller.BaseCurdController;
import com.tudou.crm.sales.entity.SalesOrderPart;
import com.tudou.system.platform.base.annotation.BaseResource;
import com.tudou.system.platform.base.model.StatusModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/crm/sales/salesOrderPart")
public class SalesOrderPartController extends BaseCurdController<SalesOrderPart> {

    @Resource
    @BaseResource
    private ISalesOrderPartService salesOrderPartService;

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
     * 载入明细数据
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
            List<SalesOrderPart> salesOrderParts = salesOrderPartService.findSalesOrderPartBySalesOrderId(id);
            dataSourceResult.setTotal(salesOrderParts.size());
            dataSourceResult.setData(salesOrderParts);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
        return dataSourceResult;
    }

    /**
     * 新增明细
     *
     * @param model
     * @param
     * @return
     */
    @RequestMapping(value = "/{salesOrderId}/{warehouseId}/addSalesOrderPart")
    public String addSalesOrderPart(Model model,
                                    @PathVariable("salesOrderId") String salesOrderId,
                                    @PathVariable("warehouseId") String warehouseId, @RequestParam(value = "id", required = false) String id) {
        model.addAttribute("warehouseId", warehouseId);
        model.addAttribute("salesOrderId", salesOrderId);
        model.addAttribute("id", id);
        return this.view("edit");
    }
}
