package com.vividswan.postservice.domain.user;

import static com.vividswan.postservice.domain.user.Password.PasswordValidationError.*;

import lombok.Getter;

public class Password {

	public static final int minLength = 8;
	public static final int maxLength = 16;

	public enum PasswordValidationError {
		NULL_VALUE("비밀번호 값이 null 입니다."),
		TOO_SHORT("비밀번호는 " + minLength + "글자 이상이여야합니다."),
		TOO_LONG("비밀번호는 " + maxLength + "글자 이하여야합니다."),
		NO_NUMBER("비밀번호에는 적어도 하나의 숫자가 포함되어야 합니다."),
		NO_UPPERCASE("비밀번호에는 적어도 하나의 대문자가 포함되어야 합니다.");

		@Getter
		private final String message;

		PasswordValidationError(String message) {
			this.message = message;
		}
	}

	@Getter
	private final String value;

	private Password(String value) {
		this.value = value;
		validatePassword();
	}

	public static Password of(String value) {
		return new Password(value);
	}

	private void validatePassword() {
		if (this.value == null) {
			throw new IllegalArgumentException(NULL_VALUE.getMessage());
		} else if (this.value.length() < minLength) {
			throw new IllegalArgumentException(TOO_SHORT.getMessage());
		} else if (this.value.length() > maxLength) {
			throw new IllegalArgumentException(TOO_LONG.getMessage());
		} else if (!this.value.matches(".*\\d.*")) {
			throw new IllegalArgumentException(NO_NUMBER.getMessage());
		} else if (!this.value.matches(".*[A-Z].*")) {
			throw new IllegalArgumentException(NO_UPPERCASE.getMessage());
		}
	}
}
