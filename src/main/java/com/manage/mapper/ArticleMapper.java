package com.manage.mapper;

import com.manage.domain.Article;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @project：springboot_vue
 * @since：2025/5/19 9:40
 * @author：wzx
 */
public interface ArticleMapper {
    List<Article> selectAll(Article article);

    @Select("select * from article where id = #{id}")
    Article selectById(Integer id);

    void insert(Article article);

    void updateById(Article article);

    @Delete("delete from article where id = #{id}")
    void deleteById(Integer id);

}
