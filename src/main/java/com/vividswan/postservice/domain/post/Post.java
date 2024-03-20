package com.vividswan.postservice.domain.post;

import java.time.LocalDateTime;

import com.vividswan.postservice.common.domain.DomainEntity;

class PostProps {
	private Title title;
	private Long userId;
	private Contents contents;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}

public class Post extends DomainEntity<PostProps> {
	public Post(Long id, PostProps props) {
		super(id, props);
	}
}
