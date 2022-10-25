package com.cydeo.repository;

import com.cydeo.exception.RecordNotFoundException;
import com.cydeo.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class AccountRepository {

    public static List<Account> accountList = new ArrayList<>();

    public Account save(Account account){
        accountList.add(account);
        return account;
    }

    public List<Account> findAll() {
        return accountList;
    }


    public void findById(UUID id) {
        accountList.stream().filter(p -> p.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new RecordNotFoundException("Account does not exist in the database."));
    }
}
