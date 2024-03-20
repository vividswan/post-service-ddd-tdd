package com.vividswan.postservice.module.user.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.vividswan.postservice.domain.user.Password;

@DisplayName("비밀번호 검증 테스트")
class PasswordTest {

	@Test
	@DisplayName("유효한 비밀번호일 때")
	public void validPassword() {
		// given
		String value = "Valid1Pass";

		// when
		Password password = Password.of(value);

		// then
		assertEquals(value, password.getValue());
	}

	@Test
	@DisplayName("비밀번호가 null일 때")
	public void passwordIsNull() {
		// given
		String value = null;

		// when
		// then
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> Password.of(value));
		assertEquals(Password.PasswordValidationError.NULL_VALUE.getMessage(), exception.getMessage());
	}

	@Test
	@DisplayName("비밀번호 길이가 너무 짧을 때")
	public void passwordTooShort() {
		// given
		String value = "Ab1";

		// when
		// then
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> Password.of(value));
		assertEquals(Password.PasswordValidationError.TOO_SHORT.getMessage(), exception.getMessage());
	}

	@Test
	@DisplayName("비밀번호 길이가 너무 길 때")
	public void passwordTooLong() {
		// given
		String value = "A1b2C3d4E5f6G7h8I9";

		// when
		// then
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> Password.of(value));
		assertEquals(Password.PasswordValidationError.TOO_LONG.getMessage(), exception.getMessage());
	}

	@Test
	@DisplayName("비밀번호에 숫자가 포함되지 않았을 때")
	public void passwordLacksNumber() {
		// given
		String value = "Abcdefgh";

		// when
		// then
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> Password.of(value));
		assertEquals(Password.PasswordValidationError.NO_NUMBER.getMessage(), exception.getMessage());
	}

	@Test
	@DisplayName("비밀번호에 대문자가 포함되지 않았을 때")
	public void passwordLacksUppercase() {
		// given
		String value = "ab1cdefgh";

		// when
		// then
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> Password.of(value));
		assertEquals(Password.PasswordValidationError.NO_UPPERCASE.getMessage(), exception.getMessage());
	}
}
