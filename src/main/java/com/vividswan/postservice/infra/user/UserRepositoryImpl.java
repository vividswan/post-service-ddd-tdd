package com.vividswan.postservice.infra.user;

import org.springframework.stereotype.Repository;

import com.vividswan.postservice.domain.user.User;
import com.vividswan.postservice.infra.user.document.UserDocument;

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
