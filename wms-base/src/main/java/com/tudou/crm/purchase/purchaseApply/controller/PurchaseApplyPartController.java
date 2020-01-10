package com.tudou.crm.purchase.purchaseApply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.tudou.crm.purchase.purchaseApply.service.IPurchaseApplyPartService;
import org.springframework.ui.Model;
import com.tudou.system.platform.base.controller.BaseCurdController;
import com.tudou.crm.purchase.purchaseApply.entity.PurchaseApplyPart;
import com.tudou.system.platform.base.annotation.BaseResource;
import com.tudou.system.platform.base.model.StatusModel;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/crm/purchase/purchaseApplyPart")
public class PurchaseApplyPartController extends BaseCurdController<PurchaseApplyPart> {

    @Resource
    @BaseResource
    private IPurchaseApplyPartService purchaseApplyPartService;

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
     * 新增明细
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/{purchaseApplyId}/{vendorId}/addPurchaseApplyPart")
    public String addPurchaseApplyPart(Model model, @RequestParam(value = "id", required = false) String id,
                                       @PathVariable("purchaseApplyId") String purchaseApplyId,
                                       @PathVariable("vendorId") String vendorId) {
        model.addAttribute("id", id);
        model.addAttribute("purchaseApplyId", purchaseApplyId);
        return this.view("edit");
    }

    /**
     * 编辑明细
     * @param model
     * @param id
     * @param vendorId
     * @return
     */
    @RequestMapping(value = "/{vendorId}/edit", method = RequestMethod.GET)
    public String edit(Model model, @RequestParam(value = "id", required = false) String id, @PathVariable("vendorId") String vendorId) {
        model.addAttribute("id", id);
        model.addAttribute("vendorId", vendorId);
        return this.view("edit");
    }
}
