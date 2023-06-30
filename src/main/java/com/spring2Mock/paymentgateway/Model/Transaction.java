package com.spring2Mock.paymentgateway.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.RequestMapping;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@RequestMapping("/transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    private int amount;

    @Enumerated(EnumType.STRING)
    TransactionStatus status;

    @ManyToOne
    @JoinColumn
    User user;

    @OneToOne(mappedBy = "transaction",cascade = CascadeType.ALL)
    Refund refund;
}
