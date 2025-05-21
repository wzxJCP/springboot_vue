package com.springboot_vue.mapper;

import com.springboot_vue.domain.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @project：springboot_vue
 * @since：2025/5/19 9:40
 * @author：wzx
 */
public interface EmployeeMapper {
    List<Employee> selectAll();

    @Select("select * from employee where id = #{id}")
    Employee selectById(Integer id);

    void insert(Employee employee);

    void updateById(Employee employee);

    @Delete("delete from employee where id = #{id}")
    void deleteById(Integer id);
}
