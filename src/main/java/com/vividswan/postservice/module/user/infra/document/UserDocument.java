package com.vividswan.postservice.module.user.infra.document;

import org.springframework.data.mongodb.core.mapping.Document;

import com.vividswan.postservice.module.user.domain.User;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@Document(collation = "user")
public class UserDocument {
	private String nickname;
	private String email;
	private String password;

	public static UserDocument fromDomain(User user) {
		User.UserProps props = user.getProps();
		return UserDocument.builder()
			.nickname(props.getNickname().getValue())
			.email(props.getEmail().getValue())
			.password(props.getPassword().getValue())
			.build();
	}
}
