package com.hy.base.web;


import com.hy.base.model.User;

/**
 * 用户holder
 * @author wangxingli
 * @date 2018/4/20 17:16
 */
public interface UserHolder {
    /**
     * 获取当前用户
     * @return
     */
    User getCurrentUser();
}
