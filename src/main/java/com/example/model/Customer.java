package com.example.model;

import com.example.utils.SystemUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ElementCollection(fetch=FetchType.EAGER)
    private Set<Account> accountList;

    public Customer() {}

    public Customer(String name) {
        this.name = name;
        this.accountList = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(Set<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        return new SystemUtils().toString(this);
    }

}
