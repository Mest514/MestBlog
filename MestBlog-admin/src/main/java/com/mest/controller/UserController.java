package com.mest.controller;

import com.mest.domain.ResponseResult;
import com.mest.domain.entity.Role;
import com.mest.domain.entity.User;
import com.mest.domain.vo.PageVo;
import com.mest.domain.vo.UserInfoAndRoleIdsVo;
import com.mest.domain.vo.UserVo;
import com.mest.enums.AppHttpCodeEnum;
import com.mest.exception.SystemException;
import com.mest.mapper.UserMapper;
import com.mest.service.CommentUserService;
import com.mest.service.RoleService;
import com.mest.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: MestBlog
 * @description: 后台用户管理
 * @author: Mest
 * @create: 2023-01-16 18:06
 **/
@RestController
@RequestMapping("/system/user")
public class UserController {
    @Autowired
    private CommentUserService userService;

    @Autowired
    private RoleService roleService;


    @GetMapping("list")
    public ResponseResult<PageVo> list(UserVo userVo, Integer pageNum, Integer pageSize) {
        return userService.listAllUsers(userVo, pageNum, pageSize);
    }

    @DeleteMapping("/{id}")
    public ResponseResult deleteUserById(@PathVariable("id") List<Long> id) {
        return userService.deleteUserById(id);
    }

    @PutMapping("changeStatus")
    public ResponseResult changeStatus(@RequestBody User user) {
        userService.updateById(user);
        return ResponseResult.okResult();
    }


    /**
     * 根据用户编号获取详细信息
     */
    @GetMapping(value = {"/{userId}"})
    public ResponseResult getUserInfoAndRoleIds(@PathVariable(value = "userId") Long userId) {
        List<Role> roles = roleService.selectRoleAll();
        User user = userService.getById(userId);
        //当前用户所具有的角色id列表
        List<Long> roleIds = roleService.selectRoleIdByUserId(userId);

        UserInfoAndRoleIdsVo vo = new UserInfoAndRoleIdsVo(user, roles, roleIds);
        return ResponseResult.okResult(vo);
    }

    /**
     * 新增用户
     */
    @PostMapping
    public ResponseResult add(@RequestBody User user) {
        if (!StringUtils.hasText(user.getUserName())) {
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        if (!userService.checkUserNameUnique(user.getUserName())) {
            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
        }
        if (!userService.checkPhoneUnique(user)) {
            throw new SystemException(AppHttpCodeEnum.PHONENUMBER_EXIST);
        }
        if (!userService.checkEmailUnique(user)) {
            throw new SystemException(AppHttpCodeEnum.EMAIL_EXIST);
        }
        return userService.addUser(user);
    }

    /**
     * 修改用户信息
     */
    @PutMapping()
    public ResponseResult edit(@RequestBody User user) {

        userService.updateUser(user);
        return ResponseResult.okResult();
    }
}
