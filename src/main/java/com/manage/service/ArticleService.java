package com.manage.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.domain.Account;
import com.manage.domain.Article;
import com.manage.exception.CustomException;
import com.manage.mapper.ArticleMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @project：springboot_vue
 * @since：2025/5/19 9:43
 * @author：wzx
 */
@Service
public class ArticleService {
    @Resource
    private ArticleMapper articleMapper;

    public void add(Article article) {
        article.setTime(DateUtil.now());
        articleMapper.insert(article);
    }
    public void update(Article article) {
        articleMapper.updateById(article);
    }

    public void deleteById(Integer id) {
        articleMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteByIds(List<Integer> ids) {
        for (Integer id : ids) {
            this.deleteById(id);
        }
    }
    public Article selectById(Integer id) {
        return articleMapper.selectById(id);
    }

    public List<Article> selectAll(Article article) {
        return articleMapper.selectAll(article);
    }

    public PageInfo<Article> selectPage(Article  article,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Article> list = articleMapper.selectAll(article);
        return PageInfo.of(list);
    }

    public Integer selectCountByDate(String date) {
        return articleMapper.selectCountByDate(date);
    }
}
