package com.vividswan.postservice.controller.user.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateUserRes {
	private String userId;
	private String nickname;
}
