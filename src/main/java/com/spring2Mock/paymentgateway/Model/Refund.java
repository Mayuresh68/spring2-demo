package com.spring2Mock.paymentgateway.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Refund {

    private int amount;

    @OneToOne
    @JoinColumn
    User user;

    @OneToOne
    @JoinColumn
    Transaction transaction;
}
