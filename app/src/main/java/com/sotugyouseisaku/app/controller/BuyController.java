package com.sotugyouseisaku.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sotugyouseisaku.app.dto.BuyViewResultListDTO;
import com.sotugyouseisaku.app.service.BuyViewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BuyController {

    private final BuyViewService buyViewService;

    /**
     * 購入履歴を全件表示
     */
    @GetMapping("/buy")
    public String buy(Model model) {
        BuyViewResultListDTO buyViewResultListDTO = buyViewService.getAllBuyItems();
        model.addAttribute("buyViewResultListDTO", buyViewResultListDTO);
        return "myPage";
    }
}
