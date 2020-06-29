package com.system.repository;

import com.system.model.entities.Account;
import com.system.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findAccountByUsername(String username);

    Account findAccountById(Integer id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Account ac set ac.username=:username, ac.email=:email, ac.role=:role where ac.id =:acId")
    void updateAccountById(@Param("acId") Integer id, @Param("username") String username, @Param("email") String email, @Param("role") Role role);
}
