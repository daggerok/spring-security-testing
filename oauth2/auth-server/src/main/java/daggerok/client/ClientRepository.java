package daggerok.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>, QueryDslPredicateExecutor<Client> {
  Optional<Client> findFirstByUsername(@Param("usrname") final String username);
}
