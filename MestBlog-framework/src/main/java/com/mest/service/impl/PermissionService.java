package com.mest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mest.domain.entity.Menu;
import com.mest.utils.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: MestBlog
 * @description: 判断具有的权限信息
 * @author: Mest
 * @create: 2023-01-14 21:23
 **/
@Service("ps")
public class PermissionService {

    /**
     * @Description: 判断当前用户是否具有permission
     * @Param: [permission] 在数据库中要判断的权限
     * @return: boolean
     * @Author: mest
     * @Date: 2023/1/14
     */
    public boolean hasPermission(String permission) {
        //如果是超级管理员，直接返回true
        if (SecurityUtils.isAdmin()) {
            return true;
        }
        //获取当前登录所具有的权限列表 判断是否存在该参数permission
        List<String> permissions = SecurityUtils.getLoginUser().getPermissions();
        return permissions.contains(permission);
    }

}
