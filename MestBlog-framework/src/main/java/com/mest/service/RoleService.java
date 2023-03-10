package com.mest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mest.domain.entity.Role;

import java.util.List;


/**
 * 角色信息表(Role)表服务接口
 *
 * @author makejava
 * @since 2023-01-09 15:45:04
 */
public interface RoleService extends IService<Role> {


    List<String> selectRoleKeyByUserId(Long id);

    List<Role> selectRoleAll();

    List<Long> selectRoleIdByUserId(Long userId);
}
