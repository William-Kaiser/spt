package com.william.admin.service.impl;

import com.william.admin.entity.User;
import com.william.admin.mapper.UserMapper;
import com.william.admin.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author william
 * @since 2018-03-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
