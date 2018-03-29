package com.example.model;

import com.example.utils.Constants;
import com.example.utils.SystemUtils;

import javax.persistence.Entity;

@Entity
public class IntraBankTransfer extends Transfer {

    public IntraBankTransfer(){}

    public IntraBankTransfer(Account sender, Account receiver, Double total) {
        super(sender, receiver, total, Constants.INTRA_BANK_COMMISSION,
                Constants.INTRA_BANK_MAX_LIMIT, Constants.INTRA_BANK_FAILURE_CHANCE);
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
