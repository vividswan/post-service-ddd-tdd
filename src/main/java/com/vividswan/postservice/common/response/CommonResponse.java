package com.vividswan.postservice.common.response;

import lombok.Data;

@Data
public class CommonResponse {
	protected Boolean isSuccess;
	protected int code;
	protected String message;
}
