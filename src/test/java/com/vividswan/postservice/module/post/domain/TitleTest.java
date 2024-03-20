package com.vividswan.postservice.module.post.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.vividswan.postservice.domain.post.Title;

@DisplayName("제목 검증 테스트")
class TitleTest {

	@Test
	@DisplayName("유효한 제목 값일 때")
	public void 유효한_제목_값일_때() {
		// given
		String value = "Valid Title";

		// when
		Title title = Title.of(value);

		// then
		assertEquals(value, title.getValue());
	}

	@Test
	@DisplayName("제목이 null 값일 때")
	public void 제목이_null_값일_때() {
		// given
		String value = null;

		// when
		// then
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
			() -> Title.of(value));
		assertEquals(Title.TitleValidationError.NULL_VALUE.getMessage(), illegalArgumentException.getMessage());
	}

	@Test
	@DisplayName("제목 길이가 너무 짧을 때")
	public void 제목_길이가_너무_짧을_때() {
		// given
		String value = "Shrt";

		// when
		// then
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
			() -> Title.of(value));
		assertEquals(Title.TitleValidationError.TOO_SHORT.getMessage(), illegalArgumentException.getMessage());
	}

	@Test
	@DisplayName("제목 길이가 너무 길 때")
	public void 제목_길이가_너무_길_때() {
		// given
		String value = "This title is way too long for the Title class to accept, as it exceeds the maximum length that is allowed.";

		// when
		// then
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
			() -> Title.of(value));
		assertEquals(Title.TitleValidationError.TOO_LONG.getMessage(), illegalArgumentException.getMessage());
	}
}
