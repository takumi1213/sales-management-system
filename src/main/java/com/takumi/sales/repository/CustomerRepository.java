package com.takumi.sales.repository;

import com.takumi.sales.entity.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
  List<Customer> findByNameContaining(String keyword);
}
