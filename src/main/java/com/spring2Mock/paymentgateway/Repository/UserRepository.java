package com.spring2Mock.paymentgateway.Repository;

import com.spring2Mock.paymentgateway.Model.User;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
