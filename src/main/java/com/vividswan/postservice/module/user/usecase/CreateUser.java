package com.vividswan.postservice.module.user.usecase;

import org.springframework.stereotype.Service;

import com.vividswan.postservice.common.usecase.UseCase;
import com.vividswan.postservice.module.user.domain.Nickname;
import com.vividswan.postservice.module.user.domain.Password;
import com.vividswan.postservice.module.user.domain.UserEmail;
import com.vividswan.postservice.module.user.dto.CreateUserReq;
import com.vividswan.postservice.module.user.dto.CreateUserRes;

@Service
public class CreateUser implements UseCase<CreateUserReq, CreateUserRes> {
	@Override
	public CreateUserRes execute(CreateUserReq req) {
		Nickname nickname = Nickname.of(req.getNickname());
		UserEmail email = UserEmail.of(req.getEmail());
		Password password = Password.of(req.getPassword());

		// TODO : DB에 유저 저장 후 UserId return

		return CreateUserRes.builder()
			.userId(1L)
			.nickname(nickname.getValue())
			.build();
	}
}
