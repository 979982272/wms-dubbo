package com.tudou.base.common.controller;

import com.tudou.base.emp.service.IEidpEmpService;
import com.tudou.system.platform.base.controller.BaseController;
import com.tudou.system.platform.base.model.StatusModel;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Resource
    private IEidpEmpService eidpEmpService;

    @Resource
    private SecurityManager securityManager;

    @RequestMapping(value = "valid", method = RequestMethod.POST)
    @ResponseBody
    public StatusModel valid(@RequestParam(value = "userName", required = true) String userName,
                             @RequestParam(value = "password", required = true) String password) {
        StatusModel statusModel = null;
        try {
            SecurityUtils.setSecurityManager(securityManager);
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
            subject.login(token);
            statusModel = new StatusModel(true, "登录成功!");
        } catch (UnknownAccountException e) {
            statusModel = new StatusModel(false, "该账号不存在!");
        } catch (IncorrectCredentialsException e) {
            statusModel = new StatusModel(false, "密码错误!");
        } catch (Exception e) {
            e.printStackTrace();
            statusModel = new StatusModel(false, e.getMessage());
        }
        return statusModel;
    }

}
