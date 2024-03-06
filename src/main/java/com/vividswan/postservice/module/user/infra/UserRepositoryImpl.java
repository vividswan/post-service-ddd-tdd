package com.vividswan.postservice.module.user.infra;

import org.springframework.stereotype.Repository;

import com.vividswan.postservice.module.user.domain.User;
import com.vividswan.postservice.module.user.infra.document.UserDocument;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

	private final MongoDBUserRepository mongoDBUserRepository;

	@Override
	public User save(User user) {
		UserDocument savedUser = mongoDBUserRepository.save(UserDocument.fromDomain(user));
		return savedUser.toDomain();
	}
}
