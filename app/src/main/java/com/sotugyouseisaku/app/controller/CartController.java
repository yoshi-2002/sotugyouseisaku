package com.sotugyouseisaku.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sotugyouseisaku.app.dto.CartViewResultListDTO;
import com.sotugyouseisaku.app.service.CartViewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartViewService cartViewService;

    /**
     * カート内商品を全件表示
     */
    @GetMapping("/cart")
    public String cart(Model model) {
        CartViewResultListDTO cartViewResultListDTO = cartViewService.getAllCartItems();
        model.addAttribute("cartViewResultListDTO", cartViewResultListDTO);
        return "cart";
    }
}
