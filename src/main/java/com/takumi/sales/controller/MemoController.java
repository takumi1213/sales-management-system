package com.takumi.sales.controller;

import com.takumi.sales.entity.Deal;
import com.takumi.sales.entity.Memo;
import com.takumi.sales.repository.DealRepository;
import com.takumi.sales.repository.MemoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.time.LocalDateTime;

@Controller
public class MemoController {

  private final MemoRepository memoRepository;
  private final DealRepository dealRepository;

  public MemoController(MemoRepository memoRepository, DealRepository dealRepository) {
    this.memoRepository = memoRepository;
    this.dealRepository = dealRepository;
  }

  // 🔥 メモ登録画面表示
  @GetMapping("/deals/{dealId}/memos/new")
  public String showMemoForm(@PathVariable Long dealId, Model model) {

    Deal deal = dealRepository.findById(dealId).orElseThrow();

    Memo memo = new Memo();
    memo.setDeal(deal);

    model.addAttribute("memo", memo);

    return "memo-form";
  }

  // 🔥 メモ保存
  @PostMapping("/memos")
  public String saveMemo(@ModelAttribute Memo memo) {

    // 🔥 ここが超重要（DBから取り直す）
    Deal deal = dealRepository.findById(memo.getDeal().getId()).orElseThrow();

    memo.setDeal(deal);

    memo.setCreatedAt(LocalDateTime.now());

    memoRepository.save(memo);

    // 🔥 案件詳細に戻る（おすすめ）
    return "redirect:/deals/" + deal.getId();
  }
}