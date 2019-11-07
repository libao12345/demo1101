package com.demo.controllers;

import com.demo.database.data.TDemoUser;
import com.demo.services.IUserService;
import com.sun.deploy.util.SessionState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 登录控制器
 * @author Libao
 * @version 1.0.0
 * @createTime 2019年11月06日 19:18：12
 */
@Controller
@SessionAttributes("userInfo")
public class LoginController {

    @Resource
    private IUserService iuserService;

    /**
     * 登录
     * @param userName
     * @param password
     * @param model
     * @return
     */
    @RequestMapping("/login.html")
    public String login(@RequestParam("userName") String userName, @RequestParam("password") String password, Model model) {
        try {
            List<TDemoUser> list = iuserService.queryUser(userName);
            for(TDemoUser user : list) {
                if(userName.equals(user.getUserName()) && password.equals(user.getUserPassword())) {
                    //缓存用户数据
                    TDemoUser u = new TDemoUser();
                    u.setUserName(userName);
                    //缓存用户数据到session中
                    model.addAttribute("userInfo", u);
                    return "index";
                }
            }
            model.addAttribute("error","用户名或密码错误");
            return "login";
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 退出登录
     * @param session
     * @param sessionStatus
     * @return
     */
    @RequestMapping("/logout.html")
    public String logout(HttpSession session, SessionStatus sessionStatus){
        try {
            session.invalidate();
            sessionStatus.setComplete();
            return "login";
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
