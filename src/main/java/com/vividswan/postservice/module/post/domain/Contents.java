package com.vividswan.postservice.module.post.domain;

import lombok.Getter;

public class Contents {

	public static final int minLength = 5; // 최소 길이 설정
	public static final int maxLength = 10000; // 최대 길이 설정

	public enum ContentsValidationError {
		NULL_VALUE("내용 값이 null 입니다."),
		TOO_SHORT("내용은 " + minLength + "글자 이상이여야 합니다."),
		TOO_LONG("내용은 " + maxLength + "글자 이하여야 합니다.");

		@Getter
		private final String message;

		ContentsValidationError(String message) {
			this.message = message;
		}
	}

	@Getter
	private final String value;

	private Contents(String value) {
		this.value = value;
		validateContents();
	}

	public static Contents of(String value) {
		return new Contents(value);
	}

	private void validateContents() {
		if (this.value == null) {
			throw new IllegalArgumentException(ContentsValidationError.NULL_VALUE.getMessage());
		} else if (this.value.length() < minLength) {
			throw new IllegalArgumentException(ContentsValidationError.TOO_SHORT.getMessage());
		} else if (this.value.length() > maxLength) {
			throw new IllegalArgumentException(ContentsValidationError.TOO_LONG.getMessage());
		}
	}
}
