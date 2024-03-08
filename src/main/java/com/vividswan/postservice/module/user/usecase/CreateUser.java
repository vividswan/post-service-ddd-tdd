package com.vividswan.postservice.module.user.usecase;

import org.springframework.stereotype.Service;

import com.vividswan.postservice.common.usecase.UseCase;
import com.vividswan.postservice.module.user.domain.Nickname;
import com.vividswan.postservice.module.user.domain.Password;
import com.vividswan.postservice.module.user.domain.User;
import com.vividswan.postservice.module.user.domain.UserEmail;
import com.vividswan.postservice.module.user.dto.CreateUserReq;
import com.vividswan.postservice.module.user.dto.CreateUserRes;
import com.vividswan.postservice.module.user.infra.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateUser implements UseCase<CreateUserReq, CreateUserRes> {

	private final UserRepository userRepository;

	@Override
	public CreateUserRes execute(CreateUserReq req) {

		User.UserProps userProps = User.UserProps.builder()
			.nickname(Nickname.of(req.getNickname()))
			.email(UserEmail.of(req.getEmail()))
			.password(Password.of(req.getPassword()))
			.build();

		User saveedUser = userRepository.save(new User(null, userProps));

		return CreateUserRes.builder()
			.userId(saveedUser.getId())
			.nickname(saveedUser.getProps().getNickname().getValue())
			.build();
	}
}
