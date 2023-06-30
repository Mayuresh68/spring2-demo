package com.spring2Mock.paymentgateway.Controller;

import com.spring2Mock.paymentgateway.Enum.TransactionStatus;
import com.spring2Mock.paymentgateway.Model.User;
import com.spring2Mock.paymentgateway.Service.TransactionService;
import com.spring2Mock.paymentgateway.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
        userService.addUser(user);
        return " User added ";

    }

    //1. GET API - Find the total amount of successful transactions for a user
    @GetMapping("/successAmount")
    public int totalAmount(@RequestParam("userId") int userId){
        return userService.totalAmount(userId);
    }


    //2. DELETE API - Delete all transactions that are failed (of all users)
    @DeleteMapping("/delete-all")
    public void clearFailedTransactions(){
        userService.clearFailedTransactions();
    }

    //3. GET API - Return UserId with maximum refund amount.
    @GetMapping("/max-refund")
    public int maxRefund(){
        userService.maxRefundUser();
    }
}
