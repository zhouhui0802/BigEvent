package com.zh.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zh.mapper.ArticleMapper;
import com.zh.pojo.Article;
import com.zh.pojo.PageBean;
import com.zh.service.ArticleService;
import com.zh.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());

        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        article.setCreateUser(id);

        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {

        PageBean<Article> pb=new PageBean<>();

        PageHelper.startPage(pageNum,pageSize);

        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");

        List<Article> as=articleMapper.list(id,categoryId,state);

        Page<Article> p=(Page<Article>) as;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());

        return pb;
    }
}
