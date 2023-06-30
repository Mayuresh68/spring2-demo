package com.spring2Mock.paymentgateway.Service;

import com.spring2Mock.paymentgateway.Enum.TransactionStatus;
import com.spring2Mock.paymentgateway.Model.Transaction;
import com.spring2Mock.paymentgateway.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    public void addTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    //2. DELETE API - Delete all transactions that are failed
    public void deleteTransactions(){
        List<Transaction>transactions = transactionRepository.findAll();

        for(Transaction tr : transactions){
            if(tr.getStatus().equals(TransactionStatus.FAILED)){
                transactions.remove(tr);
            }
        }
    }
}
