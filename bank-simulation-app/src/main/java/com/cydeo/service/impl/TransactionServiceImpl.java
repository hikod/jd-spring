package com.cydeo.service.impl;

import com.cydeo.enums.AccountType;
import com.cydeo.exception.AccountOwnershipException;
import com.cydeo.exception.BadRequestException;
import com.cydeo.exception.BalanceNotSufficientException;
import com.cydeo.exception.UnderConstructionException;
import com.cydeo.model.Account;
import com.cydeo.model.Transaction;
import com.cydeo.repository.AccountRepository;
import com.cydeo.repository.TransactionRepository;
import com.cydeo.service.TransactionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class TransactionServiceImpl implements TransactionService {
    @Value("${under_construction}")
    private boolean under_construction;
    AccountRepository accountRepository;
    TransactionRepository transactionRepository;

    public TransactionServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository){
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction makeTransfer(Account sender, Account receiver, BigDecimal amount, Date creationDate, String message) {
        if(!under_construction) {
            validateAccount(sender, receiver);
            checkAccountOwnerShip(sender, receiver);
            executeBalanceAndUpdateIfRequired(amount, sender, receiver);
        /*
            after all validations completed, and money if transferred we need to create transaction
            please create needed classes/ methods for this step save the transaction
         */
            Transaction transaction = Transaction.builder()
                    .amount(amount)
                    .sender(sender.getId())
                    .receiver(receiver.getId())
                    .message(message)
                    .creationDate(creationDate)
                    .build();
            return transactionRepository.save(transaction);
        } else
             throw new UnderConstructionException("App is under construction, try again later");
    }

    private void executeBalanceAndUpdateIfRequired(BigDecimal amount, Account sender, Account receiver) {
        if(checkSenderBalance(sender, amount)){
            sender.setBalance(sender.getBalance().subtract(amount));
            receiver.setBalance(receiver.getBalance().add(amount));
        } else{
            // not enough balance
            throw new BalanceNotSufficientException("Balance is not enough for this transfer");
        }
    }

    private boolean checkSenderBalance(Account sender, BigDecimal amount) {

            return sender.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) >= 0;
    }

    private void checkAccountOwnerShip(Account sender, Account receiver) {

        /**
         *  Write an if statement that checks if one of the account is saving,
         *  and if user of sender or receiver is not the same , throw AccountOwnershipException
         */

        if((sender.getAccountType().equals(AccountType.SAVING)
                || receiver.getAccountType().equals(AccountType.SAVING))
                && !sender.getUserId().equals(receiver.getUserId())){
            throw new AccountOwnershipException("One of the accounts is Savings. Transactions between savings and checking account are allowed between same user accounts only. Account Id's dont match.");
        }

    }

    private void validateAccount(Account sender, Account receiver) {

        /**
         * - if any of the account is null
         * - if account ids are the same (same account)
         * - if the account exist in the database(repository)
         */

        if (sender == null || receiver == null ){
            throw new BadRequestException("Sender or Receiver cannot be null");
        }

        if (sender.getId() == receiver.getId()){
            throw new BadRequestException("Sender account needs to be different than Receiver");
        }

        findAccountById(sender.getId());
        findAccountById(receiver.getId());
    }

    private void findAccountById(UUID id) {
        accountRepository.findById(id);
    }

    @Override
    public List<Transaction> findAllTransaction() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> lastTransactionList() {
        return transactionRepository.findAll().stream()
                .sorted(Comparator.comparing(Transaction::getCreationDate).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

}
