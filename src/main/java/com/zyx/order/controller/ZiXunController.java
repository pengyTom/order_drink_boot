package com.zyx.order.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyx.order.entity.ZiXun;
import com.zyx.order.service.ZiXunService;
import com.zyx.order.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/zixun")
public class ZiXunController {

    @Resource
    private ZiXunService ziXunService;

    @RequestMapping("/list")
    public String list(Page page, Model model){
        PageHelper.offsetPage(page.getStart(),page.getCount());//分页查询
        List<ZiXun> list = ziXunService.list1();
        int total = (int) new PageInfo<>(list).getTotal();//总条数
        page.setTotal(total);

        model.addAttribute("list",list);
        model.addAttribute("totals",total);
        return "cstpage/zixun-list";
    }

    /**
     * 审核
     * @param zid
     * @return
     */
    @RequestMapping("/zixunshenhe")
    @ResponseBody
    public String zixunshenhe(int zid){
        ziXunService.shenhe(zid);
        return "success";
    }

    @RequestMapping("/del")
    public String del(int id){
        ziXunService.del(id);
        return "redirect:list";
    }

}
