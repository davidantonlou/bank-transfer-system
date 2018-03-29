package com.example.model;

import com.example.utils.SystemUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ElementCollection(fetch=FetchType.EAGER)
    private Set<Transfer> transferList;
    @ManyToOne
    @JoinColumn(name="bank")
    private Bank bank;
    @ManyToOne
    @JoinColumn(name="customer")
    private Customer customer;

    public Account() {}

    public Account(Bank associatedBank, Customer customer) {
        this.bank = associatedBank;
        this.customer = customer;
        this.transferList = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Transfer> getTransferList() {
        return transferList;
    }

    public void setTransferList(Set<Transfer> transferList) {
        this.transferList = transferList;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return new SystemUtils().toString(this);
    }
}
