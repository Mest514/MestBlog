package com.mest.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program: MestBlog
 * @description:
 * @author: Mest
 * @create: 2023-01-16 18:15
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    //主键
    private Long id;
    //用户名
    private String userName;
    //昵称
    private String nickName;

    //账号状态（0正常 1停用）
    private String status;
    //邮箱
    private String email;
    //手机号
    private String phonenumber;
    //用户性别（0男，1女，2未知）
    private String sex;
    //创建时间
    private Date createTime;


}
