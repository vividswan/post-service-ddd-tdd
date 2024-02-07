package com.vividswan.postservice.module.user.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class UserEmail {

	private static final String EMAIL_PATTERN =
		"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

	public enum EmailValidationError {
		NULL_VALUE("이메일 값이 null 입니다."),
		INVALID_FORMAT("유효하지 않은 이메일 형식입니다.");

		@Getter
		private final String message;

		EmailValidationError(String message) {
			this.message = message;
		}
	}

	@Getter
	@NotNull(message = "이메일 값이 null 입니다.")
	@Email(message = "유효하지 않은 이메일 형식입니다.")
	private final String value;

	private UserEmail(String value) {
		this.value = value;
		validateEmail();
	}

	public static UserEmail of(String value) {
		return new UserEmail(value);
	}

	private void validateEmail() {
		if (this.value == null) {
			throw new IllegalArgumentException(EmailValidationError.NULL_VALUE.getMessage());
		} else if (!this.value.matches(EMAIL_PATTERN)) {
			throw new IllegalArgumentException(EmailValidationError.INVALID_FORMAT.getMessage());
		}
	}
}
