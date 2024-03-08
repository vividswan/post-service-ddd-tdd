package com.vividswan.postservice.module.user.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateUserRes {
	private String userId;
	private String nickname;
}
