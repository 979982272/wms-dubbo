package com.tudou.crm.purchase.purchaseApply.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tudou.system.platform.base.annotation.CreateFlag;
import com.tudou.system.platform.base.annotation.ModifyFlag;
import com.tudou.system.platform.base.annotation.NotEmpty;
import com.tudou.system.platform.base.entity.BaseEntity;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "crm_purchase_apply_part")
@CreateFlag
@ModifyFlag
public class PurchaseApplyPart extends BaseEntity{
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "UUID")
    private String id;

    /**
     * 采购订单号
     */
    @Column(name = "purchase_apply_id")
    @NotEmpty
    private String purchaseApplyId;

    /**
     * 产品编码
     */
    @Column(name = "goods_id")
    @NotEmpty
    private String goodsId;

    /**
     * 产品名称
     */
    @Column(name = "goods_name")
    @NotEmpty
    private String goodsName;

    /**
     * 单位编码
     */
    @Column(name = "goods_unit_id")
    @NotEmpty
    private String goodsUnitId;

    /**
     * 单位名称
     */
    @Column(name = "goods_unit_name")
    @NotEmpty
    private String goodsUnitName;

    /**
     * 规格型号
     */
    @Column(name = "goods_model")
    private String goodsModel;

    /**
     * 申请数量
     */
    @Column(name = "apply_amount")
    @NotEmpty
    private BigDecimal applyAmount;

    /**
     * 下推数量
     */
    @Column(name = "push_amount")
    private BigDecimal pushAmount;

    /**
     * 单位价格
     */
    @Column(name = "unit_price")
    @NotEmpty
    private BigDecimal unitPrice;

    /**
     * 含税单价
     */
    @Column(name = "unit_price_rate")
    @NotEmpty
    private BigDecimal unitPriceRate;

    @NotEmpty
    private BigDecimal rate;

    /**
     * 总价
     */
    @Column(name = "total_price")
    @NotEmpty
    private BigDecimal totalPrice;

    /**
     * 含税总价
     */
    @Column(name = "total_price_rate")
    @NotEmpty
    private BigDecimal totalPriceRate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除0：正常,1删除
     */
    @Column(name = "server_flag")
    private Integer serverFlag;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建人
     */
    @Column(name = "create_emp")
    private String createEmp;

    /**
     * 创建人编号
     */
    @Column(name = "create_emp_id")
    private String createEmpId;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 修改人
     */
    @Column(name = "modify_emp")
    private String modifyEmp;

    /**
     * 修改人编号
     */
    @Column(name = "modify_emp_id")
    private String modifyEmpId;

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取采购订单号
     *
     * @return purchase_apply_id - 采购订单号
     */
    public String getPurchaseApplyId() {
        return purchaseApplyId;
    }

    /**
     * 设置采购订单号
     *
     * @param purchaseApplyId 采购订单号
     */
    public void setPurchaseApplyId(String purchaseApplyId) {
        this.purchaseApplyId = purchaseApplyId == null ? null : purchaseApplyId.trim();
    }

    /**
     * 获取产品编码
     *
     * @return goods_id - 产品编码
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * 设置产品编码
     *
     * @param goodsId 产品编码
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /**
     * 获取产品名称
     *
     * @return goods_name - 产品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置产品名称
     *
     * @param goodsName 产品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * 获取单位编码
     *
     * @return goods_unit_id - 单位编码
     */
    public String getGoodsUnitId() {
        return goodsUnitId;
    }

    /**
     * 设置单位编码
     *
     * @param goodsUnitId 单位编码
     */
    public void setGoodsUnitId(String goodsUnitId) {
        this.goodsUnitId = goodsUnitId == null ? null : goodsUnitId.trim();
    }

    /**
     * 获取单位名称
     *
     * @return goods_unit_name - 单位名称
     */
    public String getGoodsUnitName() {
        return goodsUnitName;
    }

    /**
     * 设置单位名称
     *
     * @param goodsUnitName 单位名称
     */
    public void setGoodsUnitName(String goodsUnitName) {
        this.goodsUnitName = goodsUnitName == null ? null : goodsUnitName.trim();
    }

    /**
     * 获取规格型号
     *
     * @return goods_model - 规格型号
     */
    public String getGoodsModel() {
        return goodsModel;
    }

    /**
     * 设置规格型号
     *
     * @param goodsModel 规格型号
     */
    public void setGoodsModel(String goodsModel) {
        this.goodsModel = goodsModel == null ? null : goodsModel.trim();
    }

    /**
     * 获取申请数量
     *
     * @return apply_amount - 申请数量
     */
    public BigDecimal getApplyAmount() {
        return applyAmount;
    }

    /**
     * 设置申请数量
     *
     * @param applyAmount 申请数量
     */
    public void setApplyAmount(BigDecimal applyAmount) {
        this.applyAmount = applyAmount;
    }

    /**
     * 获取下推数量
     *
     * @return push_amount - 下推数量
     */
    public BigDecimal getPushAmount() {
        return pushAmount;
    }

    /**
     * 设置下推数量
     *
     * @param pushAmount 下推数量
     */
    public void setPushAmount(BigDecimal pushAmount) {
        this.pushAmount = pushAmount;
    }

    /**
     * 获取单位价格
     *
     * @return unit_price - 单位价格
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * 设置单位价格
     *
     * @param unitPrice 单位价格
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * 获取含税单价
     *
     * @return unit_price_rate - 含税单价
     */
    public BigDecimal getUnitPriceRate() {
        return unitPriceRate;
    }

    /**
     * 设置含税单价
     *
     * @param unitPriceRate 含税单价
     */
    public void setUnitPriceRate(BigDecimal unitPriceRate) {
        this.unitPriceRate = unitPriceRate;
    }

    /**
     * 获取总价
     *
     * @return total_price - 总价
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置总价
     *
     * @param totalPrice 总价
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 获取含税总价
     *
     * @return total_price_rate - 含税总价
     */
    public BigDecimal getTotalPriceRate() {
        return totalPriceRate;
    }

    /**
     * 设置含税总价
     *
     * @param totalPriceRate 含税总价
     */
    public void setTotalPriceRate(BigDecimal totalPriceRate) {
        this.totalPriceRate = totalPriceRate;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取是否删除0：正常,1删除
     *
     * @return server_flag - 是否删除0：正常,1删除
     */
    public Integer getServerFlag() {
        return serverFlag;
    }

    /**
     * 设置是否删除0：正常,1删除
     *
     * @param serverFlag 是否删除0：正常,1删除
     */
    public void setServerFlag(Integer serverFlag) {
        this.serverFlag = serverFlag;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建人
     *
     * @return create_emp - 创建人
     */
    public String getCreateEmp() {
        return createEmp;
    }

    /**
     * 设置创建人
     *
     * @param createEmp 创建人
     */
    public void setCreateEmp(String createEmp) {
        this.createEmp = createEmp == null ? null : createEmp.trim();
    }

    /**
     * 获取创建人编号
     *
     * @return create_emp_id - 创建人编号
     */
    public String getCreateEmpId() {
        return createEmpId;
    }

    /**
     * 设置创建人编号
     *
     * @param createEmpId 创建人编号
     */
    public void setCreateEmpId(String createEmpId) {
        this.createEmpId = createEmpId == null ? null : createEmpId.trim();
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取修改人
     *
     * @return modify_emp - 修改人
     */
    public String getModifyEmp() {
        return modifyEmp;
    }

    /**
     * 设置修改人
     *
     * @param modifyEmp 修改人
     */
    public void setModifyEmp(String modifyEmp) {
        this.modifyEmp = modifyEmp == null ? null : modifyEmp.trim();
    }

    /**
     * 获取修改人编号
     *
     * @return modify_emp_id - 修改人编号
     */
    public String getModifyEmpId() {
        return modifyEmpId;
    }

    /**
     * 设置修改人编号
     *
     * @param modifyEmpId 修改人编号
     */
    public void setModifyEmpId(String modifyEmpId) {
        this.modifyEmpId = modifyEmpId == null ? null : modifyEmpId.trim();
    }
}