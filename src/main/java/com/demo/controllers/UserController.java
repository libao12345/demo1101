package com.demo.controllers;

import com.demo.database.data.TDemoUser;
import com.demo.services.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Libao
 * @version 1.0.0
 * @createTime 2019年11月04日 11:11：23
 */
@Controller
public class UserController {

    @Resource
    private IUserService iuserService;

    @RequestMapping("/userquery.html")
    public String query(String susername, Model model){
        try {
            List<TDemoUser> list = iuserService.query();
            //封装数据模型
            model.addAttribute("list", list);
            return "admin/user/userlist";
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
    @RequestMapping("/oneuserquery.html")
    public String queryUser(@RequestParam("suserName") String susername, Model model){
        try {
            List<TDemoUser> list = iuserService.queryUser(susername);
            //封装数据模型
            model.addAttribute("list", list);
            return "admin/user/userlist";
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 显示添加视图页面
     * @return
     */
    @RequestMapping("/useraddview.html")
    public String addView() {
        return "admin/user/useradd";
    }

    @RequestMapping("/useradd.html")
    public String add(TDemoUser user, Model model) {
        try {
            List list = iuserService.add(user);
            //封装模型数据
            model.addAttribute("list", list);
            return "admin/user/userlist";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("/userupdateview.html")
    public String updateView(@RequestParam("id") String id, Model model) {
        try {
            TDemoUser user = iuserService.getById(id);
            //封装模型数据
            model.addAttribute("user", user);
            return "admin/user/userupdate";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("/userupdate.html")
    public String update(TDemoUser user, Model model) {
        try {
            List list = iuserService.update(user);
            //封装模型数据
            model.addAttribute("list", list);
            return "admin/user/userlist";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
    @RequestMapping("/userdelete.html")
    public String delete(@RequestParam("id") String id, Model model) {
        try{
            List list = iuserService.delete(id);
            model.addAttribute("list", list);
            return "admin/user/userlist";
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
