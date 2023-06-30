package com.spring2Mock.paymentgateway.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@RequestMapping("/user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String name;

    private String email;

    private int accountNo;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Transaction> transactions;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    Refund refund;

}
