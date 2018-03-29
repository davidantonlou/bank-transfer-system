package com.example.exceptions;

import com.example.utils.Constants;

public class AmountValueException extends RuntimeException {
    public AmountValueException(Double amount, Double limit){
        super(String.format(Constants.ERROR_AMOUNT_VALUE, amount.toString(), limit.toString()));
    }
}
