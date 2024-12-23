package com.zh.service.impl;

import com.zh.mapper.CategoryMapper;
import com.zh.pojo.Category;
import com.zh.service.CategoryService;
import com.zh.utils.ThreadLocalUtil;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public void add(Category category) {

        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());

        Map<String,Object> map= ThreadLocalUtil.get();
        Integer userId=(Integer)map.get("id");
        category.setCreateUser(userId);

        categoryMapper.add(category);
    }
}
