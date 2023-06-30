package com.spring2Mock.paymentgateway.Service;


import com.spring2Mock.paymentgateway.Enum.TransactionStatus;
import com.spring2Mock.paymentgateway.Model.Refund;
import com.spring2Mock.paymentgateway.Model.Transaction;
import com.spring2Mock.paymentgateway.Model.User;
import com.spring2Mock.paymentgateway.Repository.TransactionRepository;
import com.spring2Mock.paymentgateway.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    //1. GET API - Find the total amount of successful transactions for a user
    public int totalAmount(int userId) {
        User user = userRepository.findById(userId).get();
        //1 user ca have list of transactions

        List<Transaction> transactions = user.getTransactions();
        int total=0;
        for(Transaction tr : transactions){
            if(tr.getStatus().equals(TransactionStatus.SUCCESS)){
                total += tr.getAmount();
            }
        }
        return total;


    }

    public void clearFailedTransactions() {
        List<User> users = userRepository.findAll();

        for(User curUser : users){
            List<Transaction>transactions = curUser.getTransactions();
            for(Transaction tr : transactions){
                if(tr.getStatus().equals(TransactionStatus.FAILED)){
                    transactionRepository.delete(tr);
                }
            }
        }

    }


    //3. GET API - Return UserId with maximum refund amount.
    int maxRefund=0,refund=0,userid=0;
    public int maxRefundUser() {
        List<User> users = userRepository.findAll();

        for(User curUser : users){
            if(curUser.getRefund().getAmount() > maxRefund){
                maxRefund = curUser.getRefund().getAmount();
                userid = curUser.getUserId();
            }
        }
        return userid;
    }
}
