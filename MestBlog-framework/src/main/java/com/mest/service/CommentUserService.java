package com.mest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mest.domain.ResponseResult;
import com.mest.domain.entity.User;
import com.mest.domain.vo.PageVo;
import com.mest.domain.vo.UserVo;

import java.util.List;


/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2023-01-02 19:10:06
 */
public interface CommentUserService extends IService<User> {

    ResponseResult userInfo();

    ResponseResult updateUserInfo(User user);

    ResponseResult register(User user);

    ResponseResult<PageVo> listAllUsers(UserVo userVo, Integer pageNum, Integer pageSize);

    ResponseResult deleteUserById(List<Long> id);

    boolean checkUserNameUnique(String userName);

    boolean checkPhoneUnique(User user);

    boolean checkEmailUnique(User user);

    ResponseResult addUser(User user);

    void updateUser(User user);



//    ResponseResult selectById(Long id);
}
