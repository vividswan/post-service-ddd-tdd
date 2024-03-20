package com.vividswan.postservice.infra.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vividswan.postservice.infra.user.document.UserDocument;

public interface MongoDBUserRepository extends MongoRepository<UserDocument, String> {
}
