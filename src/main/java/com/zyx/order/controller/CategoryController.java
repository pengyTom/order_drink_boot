package com.zyx.order.controller;

import com.zyx.order.entity.Category;
import com.zyx.order.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品分类模块controller
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Category> list = categoryService.list();
        model.addAttribute("list",list);
        model.addAttribute("size",list.size());
        return "productmodule/category-list";
    }

    @RequestMapping("/addCategory")
    public String add(@RequestParam(value = "name")String name){
        Category category = new Category();
        category.setName(name);
        categoryService.save(category);
        return "productmodule/category-list";
    }

    @RequestMapping("/delCategory")
    public String del(@RequestParam(value = "id")int id){
        categoryService.del(id);
        return "redirect:list";
    }

    @RequestMapping("/editCategory")
    public String edit(@RequestParam(value = "id")int id,Model model){
        Category category = categoryService.get(id);
        model.addAttribute("category",category);
        return "productmodule/category-edit";
    }

    @RequestMapping("/updateCategory")
    public String update(Category category,Model model){
        categoryService.update(category);
        return "redirect:list";
    }
}
