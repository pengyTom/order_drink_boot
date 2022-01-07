package com.zyx.order.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyx.order.entity.Customer;
import com.zyx.order.service.CustomerService;
import com.zyx.order.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户模块controller
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    private CustomerService customerService;
    @RequestMapping("/list")
    public String list(Model model, Page page)
    {
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Customer> list= customerService.list();
        int total = (int) new PageInfo<>(list).getTotal();
        page.setTotal(total);
        model.addAttribute("list",list);
        model.addAttribute("totals",total);
        return "cstpage/cst-list";
    }
    /**
     * 设置会员
     * @param id
     * @return
     */
    @RequestMapping("/shezhihuiyuan")
    @ResponseBody
    public String shezhihuiyuan(int id){
        customerService.shezhihuiyuan(id);
        return "success";
    }

    @RequestMapping("/del")
    public String del(int id)
    {
        customerService.del(id);
        return "redirect:list";
    }
}