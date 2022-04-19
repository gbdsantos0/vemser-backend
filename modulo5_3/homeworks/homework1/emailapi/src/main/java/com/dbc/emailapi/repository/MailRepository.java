package com.dbc.emailapi.repository;

import com.dbc.emailapi.entity.MailMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailRepository extends MongoRepository<MailMessage,String> {
}
