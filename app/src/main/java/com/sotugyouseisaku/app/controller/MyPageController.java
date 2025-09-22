package com.sotugyouseisaku.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sotugyouseisaku.app.dto.CartViewResultListDTO;
import com.sotugyouseisaku.app.dto.BuyViewResultListDTO;
import com.sotugyouseisaku.app.service.CartViewService;
import com.sotugyouseisaku.app.service.BuyViewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyPageController {

    private final CartViewService cartViewService;
    private final BuyViewService buyViewService;

    /**
     * マイページ表示（カート情報 + 購入履歴）
     */
    @GetMapping("/myPage")
    public String myPage(Model model) {
        // カート情報を取得
        CartViewResultListDTO cartViewResultListDTO = cartViewService.getAllCartItems();
        model.addAttribute("cartViewResultListDTO", cartViewResultListDTO);

        // 購入履歴を取得（BuyControllerの取得方法を参考）
        BuyViewResultListDTO buyViewResultListDTO = buyViewService.getAllBuyItems();
        model.addAttribute("buyViewResultListDTO", buyViewResultListDTO);

        return "myPage";
    }
}
