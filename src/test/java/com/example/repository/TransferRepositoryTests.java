package com.example.repository;

import com.example.model.*;
import com.example.utils.Constants;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TransferRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private TransferRepository transferRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private BankRepository bankRepository;

    @Test
    public void testAddIntraTransfer() {
        Customer customer1 = this.customerRepository.save(new Customer("customer1"));
        Customer customer2 = this.customerRepository.save(new Customer("customer2"));

        Bank bank1 = this.bankRepository.save(new Bank("bank1"));

        Account sender = this.accountRepository.save(new Account(bank1, customer1));
        Account receiver = this.accountRepository.save(new Account(bank1, customer2));
        Double amount = 1000.0;

        Transfer transfer = this.transferRepository.save(new IntraBankTransfer(sender, receiver, amount));
        Assert.assertEquals(transfer.getAmount(), amount);
        Assert.assertEquals(transfer.getSender(), sender);
        Assert.assertEquals(transfer.getReceiver(), receiver);
        Assert.assertEquals(transfer.getCommission(), Constants.INTRA_BANK_COMMISSION);
    }

    @Test
    public void testAddInterTransfer() {
        Customer customer1 = this.customerRepository.save(new Customer("customer1"));
        Customer customer2 = this.customerRepository.save(new Customer("customer2"));

        Bank bank1 = this.bankRepository.save(new Bank("bank1"));
        Bank bank2 = this.bankRepository.save(new Bank("bank2"));

        Account sender = this.accountRepository.save(new Account(bank1, customer1));
        Account receiver = this.accountRepository.save(new Account(bank2, customer2));
        Double amount = 1000.0;

        Transfer transfer = new InterBankTransfer(sender, receiver, amount);
        Transfer insertedTransfer = this.transferRepository.save(transfer);
        Assert.assertEquals(insertedTransfer.getAmount(), amount);
        Assert.assertEquals(insertedTransfer.getSender(), sender);
        Assert.assertEquals(insertedTransfer.getReceiver(), receiver);
        Assert.assertEquals(insertedTransfer.getCommission(), Constants.INTER_BANK_COMMISSION);
    }
}
