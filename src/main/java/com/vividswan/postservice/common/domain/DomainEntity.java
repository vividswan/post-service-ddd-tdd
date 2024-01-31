package com.vividswan.postservice.common.domain;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(of = "id")
@RequiredArgsConstructor
public class DomainEntity<T> {
	private final Long id;
	public final T props;
}
