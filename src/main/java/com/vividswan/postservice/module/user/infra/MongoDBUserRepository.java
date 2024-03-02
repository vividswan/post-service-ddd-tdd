package com.vividswan.postservice.module.user.infra;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDBUserRepository extends MongoRepository<UserDocument, String> {
}
