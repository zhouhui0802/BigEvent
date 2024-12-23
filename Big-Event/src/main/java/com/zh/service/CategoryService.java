package com.zh.service;

import com.zh.pojo.Category;

import java.util.List;

public interface CategoryService {

    void add(Category category);

    List<Category> list();

    Category findById(int id);

    void update(Category category);

}
