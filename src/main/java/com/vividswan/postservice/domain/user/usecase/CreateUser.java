package com.vividswan.postservice.domain.user.usecase;

import org.springframework.stereotype.Service;

import com.vividswan.postservice.common.usecase.UseCase;
import com.vividswan.postservice.controller.user.dto.CreateUserReq;
import com.vividswan.postservice.controller.user.dto.UserResponse;
import com.vividswan.postservice.domain.user.Nickname;
import com.vividswan.postservice.domain.user.Password;
import com.vividswan.postservice.domain.user.User;
import com.vividswan.postservice.domain.user.UserEmail;
import com.vividswan.postservice.infra.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateUser implements UseCase<CreateUserReq, UserResponse> {

	private final UserRepository userRepository;

	@Override
	public UserResponse execute(CreateUserReq req) {

		User.UserProps userProps = User.UserProps.builder()
			.nickname(Nickname.of(req.getNickname()))
			.email(UserEmail.of(req.getEmail()))
			.password(Password.of(req.getPassword()))
			.build();

		User saveedUser = userRepository.save(new User(null, userProps));

		return UserResponse.builder()
			.userId(saveedUser.getId())
			.nickname(saveedUser.getProps().getNickname().getValue())
			.build();
	}
}
