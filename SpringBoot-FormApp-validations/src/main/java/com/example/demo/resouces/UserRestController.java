package com.example.demo.resouces;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.exceptionhand.UserNotFoundException;
import com.example.demo.pojo.User;
import com.example.demo.repository.UserDao;

@RestController
public class UserRestController {

	@Autowired
	private UserDao userDao;

	@GetMapping(value = "/getId", produces = { "application/json", "application/xml" })
	public @ResponseBody User getUserById(@RequestParam("uid") Integer uId) {
		Optional<UserEntity> user = userDao.findById(uId);

		if (user.isPresent()) {
			User users = new User();
			BeanUtils.copyProperties(user.get(), users);
			return users;
		} else {
			throw new UserNotFoundException("No product found");
		}

	}

}
