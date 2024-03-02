package com.vividswan.postservice.module.user.domain;

import com.vividswan.postservice.common.domain.DomainEntity;

import lombok.Getter;

public class User extends DomainEntity<User.UserProps> {
	public User(Long id, UserProps props) {
		super(id, props);
	}

	@Getter
	public static class UserProps {
		private Nickname nickname;
		private UserEmail email;
		private Password password;

	}
}
