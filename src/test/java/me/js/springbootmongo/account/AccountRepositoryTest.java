package me.js.springbootmongo.account;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@DataMongoTest
class AccountRepositoryTest {
    @Autowired
    AccountRepository accountRepository;

    @Test
    public void findByEmail(){
        Account account = new Account();
        account.setEmail("sgs1158@naver.com");
        account.setUsername("JS LEE TEST");

        accountRepository.save(account);

        Optional<Account> byId = accountRepository.findById(account.getId());
        assertThat(byId).isNotEmpty();

        Optional<Account> byEmail = accountRepository.findByEmail(account.getEmail());
        assertThat(byEmail).isNotEmpty();
        assertThat(byEmail.get().getUsername()).isEqualTo("JS LEE TEST");

    }
}