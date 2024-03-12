package com.vividswan.postservice.module.user.route;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vividswan.postservice.common.response.ResponseService;
import com.vividswan.postservice.module.user.dto.CreateUserReq;
import com.vividswan.postservice.module.user.dto.CreateUserRes;
import com.vividswan.postservice.module.user.usecase.CreateUser;

import lombok.RequiredArgsConstructor;

@RequestMapping("/v1/user")
@RequiredArgsConstructor
@RestController
public class UserController {
	private final ResponseService responseService;
	private final CreateUser createUser;

	@PostMapping("/")
	public CreateUserRes createUser(CreateUserReq req) {
		return createUser.execute(req);
	}

}
