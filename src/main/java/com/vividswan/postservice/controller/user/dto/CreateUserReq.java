package com.vividswan.postservice.controller.user.dto;

import lombok.Data;

@Data
public class CreateUserReq {
	private String nickname;
	private String email;
	private String password;
}
