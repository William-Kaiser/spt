package com.william.spt.controller;


import com.william.spt.core.BaseController;
import com.william.spt.entity.User;
import com.william.spt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author william
 * @since 2018-02-28
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
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User index(){
        User user = userService.selectById(1);
        logger.info("user="+user);
        return user;
    }

    /**
     * Created by william
     * Description: 添加用户
     */
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public User save(){
        User user = new User();
        user.setUserName("小明");
        user.setPassword("123456");
        userService.insert(user);
        return user;
    }

}

