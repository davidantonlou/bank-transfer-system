package com.example.model;

import com.example.utils.Constants;
import com.example.utils.SystemUtils;

import javax.persistence.Entity;

@Entity
public class InterBankTransfer extends Transfer {

    public InterBankTransfer() {}

    public InterBankTransfer(Account sender, Account receiver, Double total) {
        super(sender, receiver, total, Constants.INTER_BANK_COMMISSION,
                Constants.INTER_BANK_MAX_LIMIT, Constants.INTER_BANK_FAILURE_CHANCE);
    }

    @Override
    public boolean isSucced(){
        return true;
    }

    @Override
    public String toString() {
        return new SystemUtils().toString(this);
    }
}
