package com.manage.mapper;

import com.manage.domain.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @project：springboot_vue
 * @since：2025/6/29 1:16
 * @author：wzx
 */
@Mapper
public interface DepartmentMapper {
    List<Department> selectAll(Department department);

    @Select("select * from department where id = #{id}")
    Department selectById(Integer id);

    void insert(Department department);

    void updateById(Department department);

    @Delete("delete from department where id = #{id}")
    void deleteById(Integer id);

    /**
     * 根据部门名称查询部门信息
     */
    @Select("SELECT id, deptname FROM department WHERE deptname = #{deptName}")
    Department selectByName(String deptName);
}
