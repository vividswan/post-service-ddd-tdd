package com.vividswan.postservice.module.post.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("내용 검증 테스트")
class ContentsTest {

	@Test
	@DisplayName("유효한 내용 값일 때")
	public void 유효한_내용_값일_때() {
		// given
		String value = "This is a valid content with enough length.";

		// when
		Contents contents = Contents.of(value);

		// then
		assertEquals(value, contents.getValue());
	}

	@Test
	@DisplayName("내용이 null 값일 때")
	public void 내용이_null_값일_때() {
		// given
		String value = null;

		// when
		// then
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
			() -> Contents.of(value));
		assertEquals(Contents.ContentsValidationError.NULL_VALUE.getMessage(), illegalArgumentException.getMessage());
	}

	@Test
	@DisplayName("내용 길이가 너무 짧을 때")
	public void 내용_길이가_너무_짧을_때() {
		// given
		String value = "1234";

		// when
		// then
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
			() -> Contents.of(value));
		assertEquals(Contents.ContentsValidationError.TOO_SHORT.getMessage(), illegalArgumentException.getMessage());
	}

	@Test
	@DisplayName("내용 길이가 너무 길 때")
	public void 내용_길이가_너무_길_때() {
		// given
		StringBuilder longContentBuilder = new StringBuilder();
		for (int i = 0; i < Contents.maxLength + 1; i++) {
			longContentBuilder.append("a");
		}
		String value = longContentBuilder.toString();

		// when
		// then
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
			() -> Contents.of(value));
		assertEquals(Contents.ContentsValidationError.TOO_LONG.getMessage(), illegalArgumentException.getMessage());
	}
}
