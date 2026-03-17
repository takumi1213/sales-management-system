package com.takumi.sales.controller;

import com.takumi.sales.entity.Customer;
import com.takumi.sales.entity.Deal;
import com.takumi.sales.repository.CustomerRepository;
import com.takumi.sales.repository.DealRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DealController {

  private final DealRepository dealRepository;
  private final CustomerRepository customerRepository;

  public DealController(DealRepository dealRepository, CustomerRepository customerRepository) {
    this.dealRepository = dealRepository;
    this.customerRepository = customerRepository;
  }

  @GetMapping("/customers/{customerId}/deals/new")
  public String showDealForm(@PathVariable Long customerId, Model model) {

    Customer customer = customerRepository.findById(customerId).orElseThrow();

    Deal deal = new Deal();
    deal.setCustomer(customer);

    model.addAttribute("deal", deal);

    return "deal-form";
  }

  @PostMapping("/deals")
  public String saveDeal(@ModelAttribute Deal deal) {

    dealRepository.save(deal);

    return "redirect:/customers/" + deal.getCustomer().getId();
  }

  @GetMapping("/deals/{id}")
  public String dealDetail(@PathVariable Long id, Model model) {

    Deal deal = dealRepository.findById(id).orElseThrow();

    model.addAttribute("deal", deal);

    return "deal-detail";
  }
}