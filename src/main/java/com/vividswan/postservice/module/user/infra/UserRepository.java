package com.vividswan.postservice.module.user.infra;

import com.vividswan.postservice.module.user.domain.User;

public interface UserRepository {
	User save(User user);
}
