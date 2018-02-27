
package com.william.spt.service;

import com.william.spt.core.CrudService;
import com.william.spt.entity.User;
import com.william.spt.mapper.UserMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author william
 */
@Service
@CacheConfig
public class UserService extends CrudService<UserMapper, User> {

	@Override
	@Cacheable(value="user-key")
	public User get(String id) {
		return super.get(id);
	}

	@Override
	public List<User> findList(User user) {
		return super.findList(user);
	}

	@Override
	public void save(User user) {
		super.save(user);
	}

	@Override
	public void update(User entity) {
		super.update(entity);
	}

	@Override
	public void delete(User user) {
		super.delete(user);
	}


}