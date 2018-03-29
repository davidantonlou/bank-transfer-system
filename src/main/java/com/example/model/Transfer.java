package com.example.model;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Inheritance
public abstract class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="sender")
    private Account sender;
    @ManyToOne
    @JoinColumn(name="receiver")
    private Account receiver;
    private ZonedDateTime transferDate;
    private Double amount;
    private Double commission;
    private Double amountLimit;
    private Float failureChance;

    public Transfer() {}

    public Transfer(Account sender, Account receiver, Double amount, Double commission, Double amountLimit, Float failureChance) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.commission = commission;
        this.amountLimit = amountLimit;
        this.failureChance = failureChance;
    }

    @PrePersist
    public void initializeTransferDate() {
        transferDate = ZonedDateTime.now();
    }

    public boolean isSucced(){
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }

    public ZonedDateTime getTransferDate() {
        return transferDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getCommission() {
        return commission;
    }

    public Double getAmountLimit() {
        return amountLimit;
    }

    public Float getFailureChance() {
        return failureChance;
    }
}
