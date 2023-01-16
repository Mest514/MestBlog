package com.mest.enums;

/**
 * @Description: 响应枚举
 * @Param:
 * @return:
 * @Author: mest
 * @Date: 2022/12/18
 */
public enum AppHttpCodeEnum {
    // 成功
    SUCCESS(200, "操作成功"),
    // 登录
    NEED_LOGIN(401, "需要登录后操作"),
    NO_OPERATOR_AUTH(403, "无权限操作"),
    SYSTEM_ERROR(500, "出现错误"),
    USERNAME_EXIST(501, "用户名已存在"),
    PHONENUMBER_EXIST(502, "手机号已绑定其他用户"),
    EMAIL_EXIST(503, "邮箱已存在"),
    REQUIRE_USERNAME(504, "必需填写用户名"),
    LOGIN_ERROR(505, "用户名或密码错误"),
    CONTENT_NOT_NULL(506, "评论内容不能为空"),
    FILE_TYPE_ERROR(507, "文件格式错误，只能上传.png/.jpg类型"),
    USERNAME_NOT_NULL(508, "用户名不能为空"),
    NICKNAME_NOT_NULL(509, "昵称不能为空"),
    PASSWORD_NOT_NULL(510, "密码不能为空"),
    EMAIL_NOT_NULL(511, "邮箱不能为空"),
    TAGNAME_NOT_NULL(513, "标签不能为空"),
    TAGNAME_EXIST(514, "标签已存在"),
    CATEGORYNAME_EXIST(515, "分类已存在"),
    CATEGORYNAME_NOT_NULL(516, "分类名不能为空"),
    CATEGORYSTATUS_NOT_NULL(517, "分类状态不能为空"),
    NICKNAME_EXIST(512, "昵称已存在");

    int code;
    String msg;

    AppHttpCodeEnum(int code, String errorMessage) {
        this.code = code;
        this.msg = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
