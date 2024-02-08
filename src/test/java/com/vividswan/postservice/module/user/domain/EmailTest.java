package com.vividswan.postservice.module.user.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("이메일 테스트")
class EmailTest {

	@Test
	@DisplayName("유효한 이메일 값일 때")
	public void 유효한_이메일_값일_때() {
		// given
		String value = "test@example.com";

		// when
		UserEmail email = UserEmail.of(value);

		// then
		assertEquals(value, email.getValue());
	}

	@Test
	@DisplayName("이메일이 null 값일 때")
	public void 이메일이_null_값일_때() {
		// given
		String value = null;

		// when
		// then
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
			() -> UserEmail.of(value));
		assertEquals(UserEmail.EmailValidationError.NULL_VALUE.getMessage(), illegalArgumentException.getMessage());
	}

	@Test
	@DisplayName("이메일 형식이 유효하지 않을 때")
	public void 이메일_형식이_유효하지_않을_때() {
		// given
		String value = "invalidEmail";

		// when
		// then
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
			() -> UserEmail.of(value));
		assertEquals(UserEmail.EmailValidationError.INVALID_FORMAT.getMessage(), illegalArgumentException.getMessage());
	}
}
