package com.manage.controller;

import com.github.pagehelper.PageInfo;
import com.manage.common.Result;
import com.manage.domain.Article;
import com.manage.service.ArticleService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @project：springboot_vue
 * @since：2025/5/19 9:44
 * @author：wzx
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    /**
     * 新增用户
     * @param article
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Article article) {
        articleService.add(article);
        return Result.success();
    }
    @PutMapping("/update")
    public Result updateById(@RequestBody Article article) {
        articleService.update(article);
        return Result.success();
    }
    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Integer id) {
        articleService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/deleteByIds")
    public Result deleteByIds(@RequestBody List<Integer> ids) {
        articleService.deleteByIds(ids);
            return Result.success();
    }

    @GetMapping("/selectAll")
    public Result selectAll(Article article) {
        List<Article> list = articleService.selectAll(article);
        return Result.success(list);
    }

    // 方式一
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Article article = articleService.selectById(id);
        return Result.success(article);
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectPage")
    public Result selectPage(Article article,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Article> pageInfo = articleService.selectPage(article,pageNum, pageSize);
        return Result.success(pageInfo);
    }

}