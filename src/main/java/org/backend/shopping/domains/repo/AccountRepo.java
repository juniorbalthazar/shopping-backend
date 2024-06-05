package org.backend.shopping.domains.repo;

import org.backend.shopping.domains.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepo   extends JpaRepository<Account, Integer> {

    @Query("select e from Account e where e.username =?1 and  e.active=true")
    Optional<Account> findByusername(String username);

}
