package com.william.spt.controller;


import com.william.spt.core.Result;
import com.william.spt.core.ResultCode;
import com.william.spt.core.ResultGenerator;
import com.william.spt.entity.User;
import com.william.spt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.william.spt.core.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author william
 * @since 2018-03-06
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * Created by william
     * Description: 测试
     */
    @RequestMapping(value = "/getUser/{userId}", method = RequestMethod.GET)
    public Result index(@PathVariable String userId){
        ResultGenerator resultMsg = new ResultGenerator();
        User user = userService.selectById(userId);
        if (empty(user)){
            return resultMsg.getFailResult("该用户不存在！").setCode(ResultCode.NOT_FOUND);
        } else {
            return resultMsg.getSuccessResult(user);
        }

    }

}

