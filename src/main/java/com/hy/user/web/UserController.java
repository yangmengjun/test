package com.hy.user.web;


import com.hy.base.BaseController;
import com.hy.user.entity.User;
import com.hy.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangmengjun
 * @since 2018-09-05
 */
@RestController
@RequestMapping("/user/")
@Api(value = "/user", description = "用户操作API", position = 1)
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @RequestMapping("/getById")
    @ApiOperation("根据ID获取用户")
    public User getById(Integer id){
        return userService.selectById(id);
    }

}

