package daggerok.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OauthClientDetailsRepository extends JpaRepository<OauthClientDetails, Long>, QueryDslPredicateExecutor<OauthClientDetails> {}
