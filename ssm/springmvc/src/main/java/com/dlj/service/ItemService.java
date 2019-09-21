package com.dlj.service;

import com.dlj.dao.mapper.ItemMapper;
import com.dlj.dao.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ItemService {
    @Autowired
    private ItemMapper itemMapper;
    public List<Item> queryAllItem(){
        return itemMapper.queryAllItem();
    }
    public Item queryItemById(String Id){
        return itemMapper.queryItemById(Integer.parseInt(Id));
    }
    public void updateItemById(Item item){
        item.setCreatetime(new Date());
        itemMapper.updateItemById(item);
    }

}
