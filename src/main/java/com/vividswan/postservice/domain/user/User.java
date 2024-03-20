package com.vividswan.postservice.domain.user;

import com.vividswan.postservice.common.domain.DomainEntity;

import lombok.Builder;
import lombok.Getter;

public class User extends DomainEntity<User.UserProps> {
	public User(String id, UserProps props) {
		super(id, props);
	}

	@Builder
	@Getter
	public static class UserProps {
		private Nickname nickname;
		private UserEmail email;
		private Password password;

	}
}
