package com.vividswan.postservice.module.user.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.vividswan.postservice.domain.user.Nickname;

@DisplayName("닉네임 테스트")
class NicknameTest {

	@Test
	public void 알맞는_닉네임_값일_때() {
		// given
		String value = "vividswan";

		// when
		Nickname nickname = Nickname.of(value);

		// then
		assertEquals(value, nickname.getValue());
	}

	@Test
	public void 닉네임이_null_값일_때() {
		// given
		String value = null;

		// when
		// then
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
			() -> Nickname.of(value));
		assertEquals(illegalArgumentException.getMessage(), Nickname.NicknameValidationError.NULL_VALUE.getMessage());
	}

	@Test
	public void 닉네임_길이가_짧을_때() {
		// given
		String value = "abc";

		// when
		// then
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
			() -> Nickname.of(value));
		assertEquals(illegalArgumentException.getMessage(), Nickname.NicknameValidationError.TOO_SHORT.getMessage());
	}

	@Test
	public void 닉네임_길이가_길_때() {
		// given
		String value = "longLongTestNickname";

		// when
		// then
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
			() -> Nickname.of(value));
		assertEquals(illegalArgumentException.getMessage(), Nickname.NicknameValidationError.TOO_LONG.getMessage());
	}
}
