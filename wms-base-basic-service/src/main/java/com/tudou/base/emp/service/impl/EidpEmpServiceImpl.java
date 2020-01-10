package com.tudou.base.emp.service.impl;

import com.tudou.extra.system.AuthInfo;
import com.tudou.extra.system.UserInfoUtil;
import com.tudou.system.platform.base.encrypt.AESCoder;
import com.tudou.util.CommonUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.tudou.base.emp.service.IEidpEmpService;
import com.tudou.base.emp.mapper.EidpEmpMapper;
import com.tudou.system.platform.base.service.impl.BaseServiceImpl;
import com.tudou.base.emp.entity.EidpEmp;
import org.springframework.transaction.annotation.Transactional;
import com.tudou.system.platform.base.annotation.BaseResource;

import java.util.Date;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service("eidpEmpService")
public class EidpEmpServiceImpl extends BaseServiceImpl<EidpEmp, String> implements IEidpEmpService {

    @Resource
    @BaseResource
    private EidpEmpMapper eidpEmpMapper;

    @Override
    public List<EidpEmp> validByUserAndPassword(String username, String password) {
        return eidpEmpMapper.validByUserAndPassword(username, password);
    }

    @Override
    public int validByUser(String username) {
        return eidpEmpMapper.validByUser(username);
    }

    @Override
    public String getCreateEidpEmpId() {
        Integer count = eidpEmpMapper.getEidpMaxCount();
        if (null == count) {
            count = 0;
        }
        return CommonUtil.transIdByCount(count);
    }

    @Override
    public EidpEmp save(EidpEmp eidpEmp) throws Exception {
        valide(eidpEmp);
        List<EidpEmp> eidpEmps = eidpEmpMapper.findEidpEmpByName(eidpEmp.getUsername());
        if (CollectionUtils.isNotEmpty(eidpEmps)) {
            throw new Exception("存在相同的姓名!【" + eidpEmp.getUsername() + "】");
        }
        eidpEmp.setPassword(AESCoder.encrypt(eidpEmp.getPassword()));
        AuthInfo authInfo = UserInfoUtil.getCurrentAuthInfo();
        eidpEmp.setCreatetime(new Date());
        eidpEmp.setCreateEmpId(authInfo.getEmpId());
        eidpEmp.setCreateEmp(authInfo.getEmpName());
        super.save(eidpEmp);
        return eidpEmp;
    }

    @Override
    public void update(EidpEmp eidpEmp) throws Exception {
        valide(eidpEmp);
        List<EidpEmp> eidpEmps = eidpEmpMapper.findEidpEmpByNameAndNotId(eidpEmp.getUsername(), eidpEmp.getId());
        if (CollectionUtils.isNotEmpty(eidpEmps)) {
            throw new Exception("存在相同的姓名!【" + eidpEmp.getUsername() + "】");
        }
        eidpEmp.setPassword(AESCoder.encrypt(eidpEmp.getPassword()));
        AuthInfo authInfo = UserInfoUtil.getCurrentAuthInfo();
        eidpEmp.setModifytime(new Date());
        eidpEmp.setModifyEmpId(authInfo.getEmpId());
        eidpEmp.setModifyEmp(authInfo.getEmpName());
        eidpEmpMapper.updateByPrimaryKey(eidpEmp);
    }

    /**
     * 验证
     *
     * @param entity
     * @throws Exception
     */
    private void valide(EidpEmp entity) throws Exception {
        if (null == entity) {
            throw new Exception("需要保存的用户信息为空！");
        }
        if (StringUtils.isEmpty(entity.getId())) {
            throw new Exception("用户编号不能为空！");
        }
        if (StringUtils.isEmpty(entity.getUsername())) {
            throw new Exception("用户姓名不能为空！");
        }
        if (StringUtils.isEmpty(entity.getPassword())) {
            throw new Exception("用户密码不能为空！");
        }
    }


}