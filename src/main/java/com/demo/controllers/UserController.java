package com.demo.controllers;

import com.demo.database.data.TDemoRole;
import com.demo.database.data.TDemoUser;
import com.demo.services.IRoleService;
import com.demo.services.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
    @Resource
    private IRoleService iroleService;

    private TDemoRole role;

    @RequestMapping("/userquery.html")
    public String query(String susername, ModelMap model,  @RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo){
        try {
            Integer pageSize = 4; //每页大小
            //分页查询
            PageHelper.startPage(pageNo, pageSize);
            List<TDemoUser> list = iuserService.query();
            PageInfo<TDemoUser> pageInfo = new PageInfo<TDemoUser>(list);
            //封装数据模型
            /*model.addAttribute("list", list);*/
            model.addAttribute("pageInfo", pageInfo);
            return "admin/user/userlist";
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
    @RequestMapping("/oneuserquery.html")
    public String queryUser(@RequestParam("suserName") String susername, Model model, @RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo){
        try {
            Integer pageSize = 4; //每页大小
            //分页查询
            PageHelper.startPage(pageNo, pageSize);
            List<TDemoUser> list = iuserService.queryUser(susername);
            PageInfo<TDemoUser> pageInfo = new PageInfo<TDemoUser>(list);
            //封装数据模型
            model.addAttribute("pageInfo", pageInfo);
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
    public String addView(Model model) {
        try {
            //获得角色数据列表
            List<TDemoRole> roleList = iroleService.query();
            model.addAttribute("roleList", roleList);
            return "admin/user/useradd";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping("/useradd.html")
    public String add(TDemoUser user, Model model, @RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo) {
        try {
            Integer pageSize = 4; //每页大小
            //分页查询
            PageHelper.startPage(pageNo, pageSize);
            List list = iuserService.add(user);
            PageInfo<TDemoUser> pageInfo = new PageInfo<TDemoUser>(list);
            //封装数据模型
            model.addAttribute("pageInfo", pageInfo);
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
            role = user.getTdemoRole();
            //封装模型数据
            model.addAttribute("user", user);
            return "admin/user/userupdate";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("/userupdate.html")
    public String update(TDemoUser user, Model model, @RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo) {
        try {
            Integer pageSize = 4; //每页大小
            //分页查询
            PageHelper.startPage(pageNo, pageSize);
            user.setTdemoRole(role);
            List list = iuserService.update(user);
            PageInfo<TDemoUser> pageInfo = new PageInfo<>(list);
            //封装数据模型
            model.addAttribute("pageInfo", pageInfo);
            return "admin/user/userlist";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
    @RequestMapping("/userdelete.html")
    public String delete(@RequestParam("id") String id, Model model, @RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo) {
        try{
            Integer pageSize = 4; //每页大小
            //分页查询
            PageHelper.startPage(pageNo, pageSize);
            List list = iuserService.delete(id);
            PageInfo<TDemoUser> pageInfo = new PageInfo<TDemoUser>(list);
            //封装数据模型
            model.addAttribute("pageInfo", pageInfo);
            return "admin/user/userlist";
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
