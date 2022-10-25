package com.cydeo.controller;

import com.cydeo.model.Account;
import com.cydeo.model.Transaction;
import com.cydeo.service.AccountService;
import com.cydeo.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransactionController {

    private final TransactionService transactionService;
    private final AccountService accountService;

    public TransactionController(TransactionService transactionService, AccountService accountService){
        this.transactionService = transactionService;
        this.accountService = accountService;
    }

    @GetMapping("/make-transfer")
    public String getIndex(Account account, Model model){

        // we need all acccounts to provide them as sender , receiver
        model.addAttribute("accounts", accountService.listAllAccount());

        // we need empty transaction object to get info from UI

        model.addAttribute("transaction", Transaction.builder().build());

        // we need list of last 10 transactions
        model.addAttribute("transactions", transactionService.lastTransactionList());


//        model.addAttribute("transactiontList", transactionService.listAllAccount());
        return "/transaction/make-transfer";
    }
}
