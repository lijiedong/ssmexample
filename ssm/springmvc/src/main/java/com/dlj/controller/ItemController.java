package com.dlj.controller;

import com.dlj.dao.pojo.Item;
import com.dlj.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
    //根据id去修改Item
    @RequestMapping("/toupdateItemById.action")
    public ModelAndView toUpdateItemById(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model){
        String id=request.getParameter("id");
        Item item=itemService.queryItemById(id);
        ModelAndView modelAndView=new ModelAndView();
        //把商品放在模型中
        modelAndView.addObject("item",item);
        modelAndView.setViewName("editItem");
        return modelAndView;
    }
    //根据id去修改Item,这里本来是要有Model参数的，但是因为没有传递参数，所以没有
    @RequestMapping("updateItemById.action")
    public String updateItemById(Item item, MultipartFile pictureFile) throws IOException {
        // 图片上传
        // 设置图片名称，不能重复，可以使用uuid
        String picName = UUID.randomUUID().toString();

        // 获取文件名
        String oriName = pictureFile.getOriginalFilename();
        // 获取图片后缀
        String extName = oriName.substring(oriName.lastIndexOf("."));

        // 开始上传
        pictureFile.transferTo(new File("D:\\develop\\upload\\tmp" + picName + extName));

        // 设置图片名到商品中
        item.setPic(picName + extName);

        itemService.updateItemById(item);

        return "success";
    }
    //删除多个
    @RequestMapping(value="deleteItems.action")
    public String deleteItems(Integer[] ids){
        System.out.println(ids.toString());

        return "success";
    }
    // 测试json
    @RequestMapping("testJson.action")
    public @ResponseBody Item testJson(@RequestBody Item item) {
        System.out.println(item.toString()+"---");
        return item;
    }

}
