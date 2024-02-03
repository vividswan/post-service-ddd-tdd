package com.vividswan.postservice.module.user.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("닉네임 테스트")
class NicknameTest {

	@Test
	public void 닉네임이_null_값일_때() {
		// given
		String value = null;

		// when
		// then
		IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class,
			() -> Nickname.of(value));
		Assertions.assertEquals(illegalArgumentException.getMessage(), "닉네임 값이 null 입니다.");
	}
}
