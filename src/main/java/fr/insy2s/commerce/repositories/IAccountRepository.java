package fr.insy2s.commerce.repositories;


import fr.insy2s.commerce.dtos.AccountDto;
import fr.insy2s.commerce.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;





import java.util.List;
import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "select * from account where soft_delete = false ;",nativeQuery = true)
    List<Account> findAllWithoutArchive();
    @Query(value = "select * from account where soft_delete = true ;",nativeQuery = true)
    List<Account> findAllArchive();


    Optional<Account> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE Account a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAccount(String email);

    Account findByUsername(String username);
}
