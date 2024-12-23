package com.zh.controller;

import com.zh.pojo.Category;
import com.zh.pojo.Result;
import com.zh.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Result add(@RequestBody @Validated Category category) {
        categoryService.add(category);
        return Result.success();
    }

    @GetMapping
    public Result<List<Category>> list(){
        List<Category> cs=categoryService.list();
        return Result.success(cs);
    }

    @GetMapping("/detail")
    public Result<Category> detail(Integer id){
        Category c=categoryService.findById(id);
        return Result.success(c);
    }

    @PutMapping
    public Result update(@RequestBody @Validated Category category) {
        categoryService.update(category);
        return Result.success();
    }
}
