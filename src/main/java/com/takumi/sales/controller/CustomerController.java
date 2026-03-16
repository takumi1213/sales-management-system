package com.takumi.sales.controller;

import com.takumi.sales.entity.Customer;
import com.takumi.sales.repository.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

  private final CustomerRepository customerRepository;

  public CustomerController(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @GetMapping("/customers")
  public String listCustomers(@RequestParam(required = false) String keyword, Model model) {

    List<Customer> customers;

    if (keyword != null && !keyword.isEmpty()) {
      customers = customerRepository.findByNameContaining(keyword);
    } else {
      customers = customerRepository.findAll();
    }

    model.addAttribute("customers", customers);
    model.addAttribute("keyword", keyword);

    return "customers";
  }

  @GetMapping("/customers/new")
  public String showForm(Model model) {
    model.addAttribute("customer", new Customer());
    return "customer-form";
  }

  @PostMapping("/customers")
  public String saveCustomer(@ModelAttribute Customer customer) {
    customerRepository.save(customer);
    return "redirect:/customers";
  }

  @GetMapping("/customers/edit/{id}")
  public String editCustomer(@PathVariable Long id, Model model) {

    Customer customer = customerRepository.findById(id).orElseThrow();

    model.addAttribute("customer", customer);

    return "customer-form";
  }

  @GetMapping("/customers/delete/{id}")
  public String deleteCustomer(@PathVariable Long id) {

    customerRepository.deleteById(id);

    return "redirect:/customers";
  }

}