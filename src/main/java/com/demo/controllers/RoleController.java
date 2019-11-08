package com.demo.controllers;

import com.demo.database.data.TDemoRole;
import com.demo.services.IRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
 * @createTime 2019年11月07日 19:49：08
 */
@Controller
public class RoleController {

    @Resource
    private IRoleService iroleService;

    @RequestMapping("/rolequery.html")
    public String query(String susername, ModelMap model, @RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo){
        try {
            Integer pageSize = 4; //每页大小
            //分页查询
            PageHelper.startPage(pageNo, pageSize);
            List<TDemoRole> list = iroleService.query();
            PageInfo<TDemoRole> rolePageInfo = new PageInfo<>(list);
            //封装数据模型
            /*model.addAttribute("list", list);*/
            model.addAttribute("rolePageInfo", rolePageInfo);
            return "admin/role/rolelist";
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 查询角色信息
     * @param susername
     * @param model
     * @return
     */
    @RequestMapping("/onerolequery.html")
    public String queryRole(@RequestParam("sroleName") String susername, Model model,  @RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo){
        try {
            Integer pageSize = 4; //每页大小
            //分页查询
            PageHelper.startPage(pageNo, pageSize);
            List<TDemoRole> list = iroleService.queryRole(susername);
            PageInfo<TDemoRole> rolePageInfo = new PageInfo<>(list);
            //封装数据模型
            model.addAttribute("rolePageInfo", rolePageInfo);
            return "admin/role/rolelist";
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 显示添加视图页面
     * @return
     */
    @RequestMapping("/roleaddview.html")
    public String addView() {
        return "admin/role/roleadd";
    }

    @RequestMapping("/roleadd.html")
    public String add(TDemoRole role, Model model, @RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo) {
        try {
            Integer pageSize = 4; //每页大小
            //分页查询
            PageHelper.startPage(pageNo, pageSize);
            List list = iroleService.add(role);
            PageInfo<TDemoRole> rolePageInfo = new PageInfo<>(list);
            //封装数据模型
            model.addAttribute("rolePageInfo", rolePageInfo);
            return "admin/role/rolelist";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("/roleupdateview.html")
    public String updateView(@RequestParam("id") String id, Model model) {
        try {
            TDemoRole role = iroleService.getById(id);
            //封装模型数据
            model.addAttribute("role", role);
            return "admin/role/roleupdate";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("/roleupdate.html")
    public String update(TDemoRole role, Model model, @RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo) {
        try {
            Integer pageSize = 4; //每页大小
            //分页查询
            PageHelper.startPage(pageNo, pageSize);
            List list = iroleService.update(role);
            PageInfo<TDemoRole> rolePageInfo = new PageInfo<>(list);
            //封装数据模型
            model.addAttribute("rolePageInfo", rolePageInfo);
            return "admin/role/rolelist";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("/roledelete.html")
    public String delete(@RequestParam("id") String id, Model model, @RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo) {
        try{
            Integer pageSize = 4; //每页大小
            //分页查询
            PageHelper.startPage(pageNo, pageSize);
            List list = iroleService.delete(id);
            PageInfo<TDemoRole> rolePageInfo = new PageInfo<>(list);
            //封装数据模型
            model.addAttribute("rolePageInfo", rolePageInfo);
            return "admin/role/rolelist";
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

}
