package com.hy.base.web;


import com.hy.base.model.User;

/**
 * 用户信息对象
 */
public interface UserHolder {
    /**
     * 获取当前登录用户
     * @return
     */
    User getCurrentUser();
}
