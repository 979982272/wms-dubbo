package com.tudou.base.emp.service;

import com.tudou.system.platform.base.service.IBaseService;
import com.tudou.base.emp.entity.EidpEmp;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.mgt.SecurityManager;

import java.util.List;

public interface IEidpEmpService extends IBaseService<EidpEmp, String> {

    String getCreateEidpEmpId();


    /**
     * 验证用户
     *
     * @param username
     * @return
     */
    int validByUser(String username);

    /**
     * 验证用户名，密码
     *
     * @param username
     * @param password
     * @return
     */
    List<EidpEmp> validByUserAndPassword(String username,String password);
}
