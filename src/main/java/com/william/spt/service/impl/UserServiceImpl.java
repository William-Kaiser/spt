package com.william.spt.service.impl;

import com.william.spt.entity.User;
import com.william.spt.mapper.UserMapper;
import com.william.spt.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author william
 * @since 2018-02-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
