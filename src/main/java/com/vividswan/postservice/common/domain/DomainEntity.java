package com.vividswan.postservice.common.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(of = "id")
@RequiredArgsConstructor
public class DomainEntity<T> {
	private final Long id;
	@Getter
	public final T props;
}
