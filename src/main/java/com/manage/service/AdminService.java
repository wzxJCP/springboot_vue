package com.manage.service;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.domain.Account;
import com.manage.domain.Admin;
import com.manage.exception.CustomException;
import com.manage.mapper.AdminMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @project：springboot_vue
 * @since：2025/5/19 9:43
 * @author：wzx
 */
@Service
public class AdminService {
    @Resource
    private AdminMapper adminMapper;

    public void add(Admin admin) {
        String username = admin.getUsername();
        Admin admin1 = adminMapper.selectByUsername(username);
        // 检查用户名是否已存在
        if (admin1 != null) {
            throw new CustomException("500", "账号已存在");
        }
        // 如果密码为空，则设置默认空字符串（防止null值）
        if (StrUtil.isBlank(admin.getPassword())) {
            admin.setPassword(username+"123456");
        } 
        // 冗余检查，确保密码字段处理一致性
        if (StrUtil.isBlank(admin.getPassword())) {
            admin.setPassword(username+"123456");
        }
        // 设置用户角色为普通员工(EMP)
        admin.setRole("EMP");
        // 插入新员工数据到数据库
        adminMapper.insert(admin);
    }
    public void update(Admin admin) {
        adminMapper.updateById(admin);
    }

    public void deleteById(Integer id) {
        adminMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteByIds(List<Integer> ids) {
        for (Integer id : ids) {
            this.deleteById(id);
        }
    }
    public Admin selectById(Integer id) {
        return adminMapper.selectById(id);
    }

    public List<Admin> selectAll(Admin admin) {
        return adminMapper.selectAll(admin);
    }

    public PageInfo<Admin> selectPage(Admin  admin,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> list = adminMapper.selectAll(admin);
        return PageInfo.of(list);
    }

    public Admin login(Account account) {
        String username = account.getUsername();
        Admin e = adminMapper.selectByUsername(username);
        if (e == null) {
            throw new CustomException("500", "账号不存在");
        }
        String password = account.getPassword();
        if (!e.getPassword().equals(password)) {
            throw new CustomException("500", "账号或密码错误");
        }
        return e;
    }
    public void register(Admin admin) {
        this.add(admin);
    }

    public void updatePassword(Account account) {
        Integer id = account.getId();
        Admin admin = adminMapper.selectById(id);
        if (!admin .getPassword().equals(account.getPassword())) {
            throw new CustomException("500", "原密码错误");
        }
        admin.setPassword(account.getNewPassword());
        this.update(admin);
    }

}
