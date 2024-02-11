package com.vividswan.postservice.module.post.domain;

import java.time.LocalDateTime;

import com.vividswan.postservice.common.domain.DomainEntity;

class PostProps {
	private Title title;
	private Long userId;
	private String contents;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}

public class Post extends DomainEntity<PostProps> {
	public Post(Long id, PostProps props) {
		super(id, props);
	}
}
