package com.vividswan.postservice.controller.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vividswan.postservice.common.response.ResponseService;
import com.vividswan.postservice.controller.user.dto.CreateUserReq;
import com.vividswan.postservice.controller.user.dto.UserResponse;
import com.vividswan.postservice.domain.user.usecase.CreateUser;

import lombok.RequiredArgsConstructor;

@RequestMapping("/v1/user")
@RequiredArgsConstructor
@RestController
public class UserController {
	private final ResponseService responseService;
	private final CreateUser createUser;

	@PostMapping("/")
	public UserResponse createUser(CreateUserReq req) {
		return createUser.execute(req);
	}

	@GetMapping("/")
	public UserResponse findUser(@RequestParam(required = false) String userId,
		@RequestParam(required = false) String nickname) {
		if (CollectionUti)
	}

}
