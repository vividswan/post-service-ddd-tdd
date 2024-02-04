package com.vividswan.postservice.module.user.domain;

import static com.vividswan.postservice.module.user.domain.Nickname.NicknameValidationError.*;

import lombok.Getter;

public class Nickname {

	public static final int minLength = 4;
	public static final int maxLength = 10;

	public enum NicknameValidationError {
		NULL_VALUE("닉네임 값이 null 입니다."),
		TOO_SHORT("닉네임은 " + minLength + "글자 이상이여야합니다."),
		TOO_LONG("닉네임은 " + maxLength + "글자 이하여야합니다.");

		@Getter
		private final String message;

		NicknameValidationError(String message) {
			this.message = message;
		}
	}

	@Getter
	private final String value;

	private Nickname(String value) {
		this.value = value;
		validateNickname();
	}

	public static Nickname of(String value) {
		return new Nickname(value);
	}

	private void validateNickname() {
		if (this.value == null) {
			throw new IllegalArgumentException(NULL_VALUE.getMessage());
		} else if (this.value.length() < minLength) {
			throw new IllegalArgumentException(TOO_SHORT.getMessage());
		} else if (this.value.length() > maxLength) {
			throw new IllegalArgumentException(TOO_LONG.getMessage());
		}
	}
}
