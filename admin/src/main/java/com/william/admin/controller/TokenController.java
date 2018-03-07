package com.william.admin.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.william.spt.core.BaseController;
import com.william.spt.core.ResultGenerator;
import com.william.spt.entity.User;
import com.william.spt.service.UserService;
import com.william.spt.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author william
 * @since 2018-02-28
 */
@RestController
@RequestMapping("/jwt")
public class TokenController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public Object getAccessToken(@RequestBody User user) {

        ResultGenerator resultMsg =  new ResultGenerator();
        try {

            //验证用户名密码
            User exitUser = userService.selectOne(new EntityWrapper<User>()
                    .like(StringUtils.isNotBlank(user.getUserName()),"user_name", user.getUserName())
                    .eq("password",user.getPassword()));
            if (empty(exitUser)) {
                return resultMsg.getFailResult("该用户不存在！");
            }
            //拼装accessToken
            String accessToken = JwtUtils.createJWT(exitUser);
            //返回accessToken
             return resultMsg.getSuccessResult(accessToken);

        } catch(Exception ex) {
            return resultMsg.getFailResult(ex.getMessage());
        }
    }
}

