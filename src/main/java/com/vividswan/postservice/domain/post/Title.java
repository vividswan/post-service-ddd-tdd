package com.vividswan.postservice.domain.post;

import lombok.Getter;

public class Title {

	public static final int minLength = 5; // 최소 길이 설정
	public static final int maxLength = 100; // 최대 길이 설정

	public enum TitleValidationError {
		NULL_VALUE("제목 값이 null 입니다."),
		TOO_SHORT("제목은 " + minLength + "글자 이상이여야 합니다."),
		TOO_LONG("제목은 " + maxLength + "글자 이하여야 합니다.");

		@Getter
		private final String message;

		TitleValidationError(String message) {
			this.message = message;
		}
	}

	@Getter
	private final String value;

	private Title(String value) {
		this.value = value;
		validateTitle();
	}

	public static Title of(String value) {
		return new Title(value);
	}

	private void validateTitle() {
		if (this.value == null) {
			throw new IllegalArgumentException(TitleValidationError.NULL_VALUE.getMessage());
		} else if (this.value.length() < minLength) {
			throw new IllegalArgumentException(TitleValidationError.TOO_SHORT.getMessage());
		} else if (this.value.length() > maxLength) {
			throw new IllegalArgumentException(TitleValidationError.TOO_LONG.getMessage());
		}
	}
}
