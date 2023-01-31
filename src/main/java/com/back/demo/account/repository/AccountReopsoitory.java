package com.back.demo.account.repository;

import com.back.demo.account.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountReopsoitory extends JpaRepository<AccountEntity, String> {
}
