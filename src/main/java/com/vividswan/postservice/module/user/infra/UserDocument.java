package com.vividswan.postservice.module.user.infra;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collation = "user")
public class UserDocument {
	private String nickname;
	private String email;
	private String password;
}
