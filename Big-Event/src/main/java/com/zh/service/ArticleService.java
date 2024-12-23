package com.zh.service;

import com.zh.pojo.Article;
import com.zh.pojo.PageBean;

public interface ArticleService {

    void add(Article article);

    PageBean<Article> list(Integer pageNum, Integer pageSize,Integer categoryId,String state);
}
