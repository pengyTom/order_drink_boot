package com.zyx.order.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyx.order.entity.Permission;
import com.zyx.order.service.PermissionService;
import com.zyx.order.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限模块controller
 */
@Controller
@RequestMapping("/config")
public class PermissionController {
    @Resource
    PermissionService permissionService;

    /**
     * 添加权限页面
     * @return 权限
     */

    @RequestMapping("/adminPerAddUI")
    public String addUI(){
        return "syspage/admin-permission-add";
    }

    /**
     * 权限列表
     * @param model
     * @param page
     * @return
     */
    @RequestMapping("/listPermission")
    public String list(Model model, Page page){
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Permission> ps= permissionService.list();
        int total = (int) new PageInfo<>(ps).getTotal();
        page.setTotal(total);

        model.addAttribute("ps", ps);
        model.addAttribute("perCount",ps.size());
        return "syspage/admin-permission";
    }

    @RequestMapping("/editPermission")
    public String list(Model model,long id){
        Permission permission =permissionService.get(id);
        model.addAttribute("permission", permission);
        return "syspage/admin-permission-edit";
    }

    @RequestMapping("/updatePermission")
    public String update(Permission permission){
        permissionService.update(permission);
        return "redirect:listPermission";
    }
 
    @RequestMapping("/addPermission")
    public String list(Permission permission){
        permissionService.add(permission);
        return "redirect:listPermission";
    }

    @RequestMapping("/deletePermission")
    public String delete(Model model,long id){
        permissionService.delete(id);
        return "redirect:listPermission";
    }   
 
}