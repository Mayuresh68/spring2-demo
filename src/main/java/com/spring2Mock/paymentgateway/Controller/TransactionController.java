package com.spring2Mock.paymentgateway.Controller;

import com.spring2Mock.paymentgateway.Enum.TransactionStatus;
import com.spring2Mock.paymentgateway.Model.Transaction;
import com.spring2Mock.paymentgateway.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/txn")
public class TransactionController {
     @Autowired
    TransactionService transactionService;

     @PostMapping("/addTxn")
     public void addTransaction(@RequestBody Transaction transaction){
         transactionService.addTransaction(transaction);
     }

    //2. DELETE API - Delete all transactions that are failed
    @DeleteMapping("/clear-all-transactions")
    public void deleteTransactions(){
        transactionService.deleteTransactions();
    }
}
