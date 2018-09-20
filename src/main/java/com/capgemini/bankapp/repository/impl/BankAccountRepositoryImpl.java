package com.capgemini.bankapp.repository.impl;

import java.util.HashSet;

import org.springframework.stereotype.Repository;

import com.capgemini.bankapp.entities.BankAccount;
import com.capgemini.bankapp.repository.BankAccountRepository;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {
 private HashSet<BankAccount> accounts;
 
	public BankAccountRepositoryImpl() {
		super();
		accounts = new HashSet<>();
		accounts.add(new BankAccount(1234,"priyanka","SAVING",64000));
		accounts.add(new BankAccount(1235,"malyka","SAVING",24000));
		accounts.add(new BankAccount(1236,"sameera","SAVING",54000));
		accounts.add(new BankAccount(1237,"muskaan","SAVING",44000));
		
	}

	@Override
	public double getBalance(long accountId) {
		for (BankAccount bankAccount : accounts) {
			if(bankAccount.getAccountId() == accountId)
				return bankAccount.getAccountBalance();
		}
		return -1;
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		for (BankAccount bankAccount : accounts) {
			if(bankAccount.getAccountId() == accountId) {
				bankAccount.setAccountBalance(newBalance);
				return true;
			}
		}
		return false;
	}


}
