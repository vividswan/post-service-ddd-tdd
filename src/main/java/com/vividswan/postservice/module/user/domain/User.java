package com.vividswan.postservice.module.user.domain;

import com.vividswan.postservice.common.domain.DomainEntity;

class UserProps {
	private Nickname nickname;
	private UserEmail email;
	private String password;

}

public class User extends DomainEntity<UserProps> {
	public User(Long id, UserProps props) {
		super(id, props);
	}
}
