package com.vividswan.postservice.module.user.infra;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vividswan.postservice.module.user.infra.document.UserDocument;

public interface MongoDBUserRepository extends MongoRepository<UserDocument, String> {
}
