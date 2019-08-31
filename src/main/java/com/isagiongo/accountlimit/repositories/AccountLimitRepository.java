package com.isagiongo.accountlimit.repositories;

import com.isagiongo.accountlimit.models.entities.AccountLimit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountLimitRepository extends MongoRepository<AccountLimit, String> {
}
