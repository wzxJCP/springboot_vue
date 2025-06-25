package com.manage.mapper;

import com.manage.domain.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @project：springboot_vue
 * @since：2025/5/19 9:40
 * @author：wzx
 */
public interface AdminMapper {
    List<Admin> selectAll(Admin admin);

    @Select("select * from admin where id = #{id}")
    Admin selectById(Integer id);

    void insert(Admin admin);

    void updateById(Admin admin);

    @Delete("delete from admin where id = #{id}")
    void deleteById(Integer id);

    @Select("select * from admin where username = #{username}")
    Admin selectByUsername(String username);
}
