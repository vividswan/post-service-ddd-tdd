package com.vividswan.postservice.infra.user.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.vividswan.postservice.domain.user.Nickname;
import com.vividswan.postservice.domain.user.Password;
import com.vividswan.postservice.domain.user.User;
import com.vividswan.postservice.domain.user.UserEmail;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@Document(collation = "user")
public class UserDocument {
	@Id
	private String id;
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

	public User toDomain() {
		User.UserProps userProps = User.UserProps.builder()
			.nickname(Nickname.of(this.getNickname()))
			.email(UserEmail.of(this.getEmail()))
			.password(Password.of(this.getPassword()))
			.build();
		return new User(this.id, userProps);
	}
}
