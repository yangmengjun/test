package com.hy.user.service.impl;

import com.hy.user.entity.User;
import com.hy.user.service.UserService;
import com.hy.user.mapper.UserMapper;
import com.hy.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangmengjun
 * @since 2018-09-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
