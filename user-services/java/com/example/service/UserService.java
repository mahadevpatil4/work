package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dao.UserRepository;
import com.example.entity.User;
import com.example.valueobj.Department;
import com.example.valueobj.ResponseTempletVo;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public ResponseTempletVo getUserWithDepartment(long userId) {
		System.out.println("inside dept ");
		ResponseTempletVo vo = new ResponseTempletVo();
		User user = userRepository.findByUserId(userId);

		Department department = restTemplate.getForObject("http://localhost:8085/department/" + user.getDepartmentId(),
				Department.class);

		vo.setUser(user);
		vo.setDepartment(department);
		return vo;

	}

}
