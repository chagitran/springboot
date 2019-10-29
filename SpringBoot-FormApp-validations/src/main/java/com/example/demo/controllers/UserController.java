package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.contants.AppContants;
import com.example.demo.entity.UserEntity;
import com.example.demo.pojo.User;
import com.example.demo.properties.AppProperties;
import com.example.demo.repository.UserDao;

@Controller
public class UserController {

	@Autowired
	private AppProperties appProperties;
	/*
	 * @Autowired private AppContants appContants;
	 */
	@Autowired
	private UserDao userDao;

	/**
	 * This method is used to load registration form empty
	 * 
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/registerUser")
	public String loadForm(Model model) {

		// Form binding object
		User userObject = new User();
		// storing in model
		model.addAttribute(AppContants.USER_OBJ, userObject);
		loadFormData(model);
		return AppContants.VIEW_REG;

	}

	/**
	 * This method is used to handle user register form submission
	 * 
	 * @param user
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user, Model model) {
		// System.out.println(user);

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		UserEntity insertEntity = userDao.save(userEntity);

		if (insertEntity.getUserId() != null) {
			String sucess = appProperties.getMessages().get(AppContants.REG_SUCCESS);
			model.addAttribute(AppContants.SUCCESS_MSG, sucess);
		} else {
			String failure = appProperties.getMessages().get(AppContants.REG_FAILURE);
			model.addAttribute(AppContants.FAILURE_MSG, failure);
		}
		loadFormData(model);

		return "redirect:/userCreationSuccess";

	}

	/**
	 * this method is used to display success msg post registration
	 * 
	 * @return
	 */
	@RequestMapping(value = "/userCreationSuccess", method = RequestMethod.GET)
	public String registerUserSucess(Model model) {
		User userObject = new User();
		model.addAttribute(AppContants.USER_OBJ, userObject);
		loadFormData(model);
		return AppContants.VIEW_REG;

	}
	

	@RequestMapping(value = "/viewUsers")
	public String viewUsers(Model model) {
		Iterable<UserEntity> userEntity = userDao.findAll();

		List<User> userList = new ArrayList<User>();
		for (UserEntity entity : userEntity) {
			User user = new User();
			BeanUtils.copyProperties(entity, user);
			userList.add(user);
			model.addAttribute(AppContants.USER_OBJS, userList);
		}
		return AppContants.VIEW_USERS;
	}

	@RequestMapping(value = "/viewUsers1")
	public String viewUsers1(Model model, @RequestParam("pn") Integer currentPageNo) {
		Integer pageSize = 3;

		PageRequest page = PageRequest.of(currentPageNo - 1, pageSize);
		Page<UserEntity> pageData = userDao.findAll(page);
		// Iterable<UserEntity> userEntity = userDao.findAll();
		List<UserEntity> userEntities = pageData.getContent();
		List<User> userList = new ArrayList<User>();

		int tp = pageData.getTotalPages();
		int cp = currentPageNo;

		for (UserEntity entity : userEntities) {
			User user = new User();
			BeanUtils.copyProperties(entity, user);
			userList.add(user);
			model.addAttribute(AppContants.USER_OBJS, userList);
			model.addAttribute("tp", tp);
			model.addAttribute("cp", cp);
		}
		return AppContants.VIEW_USERS;
	}

	@RequestMapping(value = "/deleteUser")
	public String deleteUser(Model model, @RequestParam("userId") Integer userId) {

		
		userDao.deleteById(userId);

		return "redirect:/viewUsers1?pn=1";

	}

	@RequestMapping(value = "/editUser")
	public String editUser(Model model, @RequestParam("userId") Integer userId) {

		if (null != userId && !"".equals(userId)) {
			Optional<UserEntity> userEntity = userDao.findById(userId);
			if (userEntity.isPresent()) {
				User user = new User();
				BeanUtils.copyProperties(userEntity.get(), user);
				user.setUserId(userId);
				model.addAttribute(AppContants.USER_OBJ, user);
			}
		}
		loadFormData(model);
		return AppContants.EDIT_USER;

	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUserById(Model model, @ModelAttribute("user") User user,
			@RequestParam("userId") Integer userId) {

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		userEntity.setUserId(userId);
		UserEntity insertEntity = userDao.save(userEntity);

		if (insertEntity.getUserId() != null) {
			String sucess = appProperties.getMessages().get(AppContants.REG_SUCCESS);
			model.addAttribute(AppContants.SUCCESS_MSG, sucess);
		} else {
			String failure = appProperties.getMessages().get(AppContants.REG_FAILURE);
			model.addAttribute(AppContants.FAILURE_MSG, failure);
		}
		loadFormData(model);

		return AppContants.EDIT_USER;

	}

	@RequestMapping(value = "/get")
	public @ResponseBody List<String> getEmails() {

		Iterable<UserEntity> userEntity = userDao.findAll();

		List<String> userList = new ArrayList();
		for (UserEntity entity : userEntity) {
			User user = new User();
			BeanUtils.copyProperties(entity, user);
			userList.add(user.getEmail());
		}
		return userList;

	}

	@RequestMapping(value = "/getEmailById")
	public @ResponseBody String getEmailByUser(@RequestParam("uid") Integer userId) {

		String user = userDao.getEmailById(userId);
		user.length();
		return user;

	}

	private void loadFormData(Model model) {
		List<String> countriesList = new ArrayList<>();
		countriesList.add("UK");
		countriesList.add("USA");
		countriesList.add("INDIA");
		countriesList.add("GERMANY");
		countriesList.add("LONDON");
		model.addAttribute("countryList", countriesList);
	}
}