package com.dlj.controller;

import com.dlj.dao.pojo.Item;
import com.dlj.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;
    // @RequestMapping：里面放的是请求的url，和用户请求的url进行匹配
    // action可以写也可以不写
    @RequestMapping("/itemList.action")
    public ModelAndView queryItemList() {
        // 创建页面需要显示的商品数据
        List<Item> list = itemService.queryAllItem();


        // 创建ModelAndView，用来存放数据和视图
        ModelAndView modelAndView = new ModelAndView();
        // 设置数据到模型中
        modelAndView.addObject("itemList", list);
        // 设置视图jsp，需要设置视图的物理地址
        modelAndView.setViewName("itemList");

        return modelAndView;
    }


}
