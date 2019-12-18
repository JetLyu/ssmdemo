package com.crx.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crx.mapper.UserMapper;
import com.crx.pojo.User;
import com.crx.pojo.UserExample;
import com.crx.pojo.UserExample.Criteria;

@Service
public class UserService {
	@Resource
	private UserMapper um;

	public User login(User user) {
		UserExample ue = new UserExample();
		Criteria  c = ue.createCriteria();
		c.andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
		List<User> users = um.selectByExample(ue);
		return users.isEmpty()?null:users.get(0);
	}

}
