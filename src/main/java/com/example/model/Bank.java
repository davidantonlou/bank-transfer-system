package com.example.model;

import com.example.utils.SystemUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ElementCollection(fetch=FetchType.EAGER)
    private Set<Customer> customerList;

    public Bank() {}

    public Bank(String name) {
        this.name = name;
        this.customerList = new HashSet<>();
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

    public Set<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(Set<Customer> customerList) {
        this.customerList = customerList;
    }

    @Override
    public String toString() {
        return new SystemUtils().toString(this);
    }
}
