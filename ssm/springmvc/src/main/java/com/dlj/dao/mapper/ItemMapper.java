package com.dlj.dao.mapper;

import com.dlj.dao.pojo.Item;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 下面这个注解是为了开启事务
@Transactional
public interface ItemMapper {
    List<Item> queryAllItem();
    Item queryItemById(Integer id);
    void updateItemById(Item item);
}
