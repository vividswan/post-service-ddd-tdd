package com.vividswan.postservice.module.user.domain;

public class Nickname {
	private final String value;

	private Nickname(String value) {
		this.value = value;
		validateNickname();
	}

	public static Nickname of(String value) {
		return new Nickname(value);
	}

	private void validateNickname() {
		if (this.value == null) {
			throw new IllegalArgumentException("닉네임 값이 null 입니다.");
		} else if (this.value.length() < 3) {
			throw new IllegalArgumentException("닉네임은 4글자 이상이여야합니다.");
		} else if (this.value.length() > 10) {
			throw new IllegalArgumentException("닉네임은 10글자 이하여야합니다.");
		}
	}
}
