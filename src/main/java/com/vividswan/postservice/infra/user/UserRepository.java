package com.vividswan.postservice.infra.user;

import com.vividswan.postservice.domain.user.User;

public interface UserRepository {
	User save(User user);
}
