package com.example.controller;

import com.example.exceptions.AmountValueException;
import com.example.model.*;
import com.example.repository.AccountRepository;
import com.example.repository.TransferRepository;
import com.example.utils.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferAgent {
    private final AccountRepository accountRepository;
    private final TransferRepository transferRepository;

    @Autowired
    TransferAgent(AccountRepository accountRepository,
                   TransferRepository transferRepository) {
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }

    @PostMapping(value = "/transfer")
    public Transfer addTransfer(@RequestBody TransferBodyRequest transferBodyRequest) {
        Account senderAccount = transferBodyRequest.getSender();
        Account receiverAccount = transferBodyRequest.getReceiver();
        Double amount = transferBodyRequest.getAmount();

        Transfer transfer;
        if (SystemUtils.areAcountsFromSameBank(senderAccount, receiverAccount)){
            transfer = new IntraBankTransfer(senderAccount, receiverAccount, amount);
        } else {
            transfer = new InterBankTransfer(senderAccount, receiverAccount, amount);
        }

        if (amount > transfer.getAmountLimit()) {
            throw new AmountValueException(amount, transfer.getAmountLimit());
        }

        return this.transferRepository.save(transfer);
    }
}
