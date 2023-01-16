package com.mest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.mest.domain.entity.UserRole;
import com.mest.mapper.UserRoleMapper;
import com.mest.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * @Author 三更  B站： https://space.bilibili.com/663528522
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {
}
