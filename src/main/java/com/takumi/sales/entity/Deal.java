package com.takumi.sales.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Deal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private Integer amount;
  private String status;

  // 顧客との紐づき（多対1）
  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  // メモとの紐づき（1対多）
  @OneToMany(mappedBy = "deal", cascade = CascadeType.ALL)
  private List<Memo> memos;

  // ===== getter / setter =====
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public Integer getAmount() {
    return amount;
  }
  public void setAmount(Integer amount) {
    this.amount = amount;
  }
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public Customer getCustomer() {
    return customer;
  }
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
  public List<Memo> getMemos() {
    return memos;
  }
  public void setMemos(List<Memo> memos) {
    this.memos = memos;
  }
}