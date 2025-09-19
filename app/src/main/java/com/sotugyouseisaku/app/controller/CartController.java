package com.sotugyouseisaku.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sotugyouseisaku.app.dto.CartViewResultListDTO;
import com.sotugyouseisaku.app.dto.ProductSearchFormDTO;
import com.sotugyouseisaku.app.dto.ProductViewResultListDTO;
import com.sotugyouseisaku.app.form.ProductSearchForm;
import com.sotugyouseisaku.app.service.CartViewService;
import com.sotugyouseisaku.app.service.BuyService;
import com.sotugyouseisaku.app.service.IndexService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartViewService cartViewService;
    private final BuyService buyService;
    private final IndexService indexService; 
    /**
     * カート内商品を全件表示
     */
    @GetMapping("/cart")
    public String cart(Model model) {
        CartViewResultListDTO cartViewResultListDTO = cartViewService.getAllCartItems();
        model.addAttribute("cartViewResultListDTO", cartViewResultListDTO);
        return "cart";
    }

    // ------------------------------
    // buyに追加する POST メソッド
    // ------------------------------
    @PostMapping("/buy/add")
    public String addToBuy(
            @RequestParam("productId") int productId,
            @RequestParam(value = "quantity", defaultValue = "1") int quantity,
            @ModelAttribute ProductSearchForm productSearchForm,
            Model model) {
    
        // 購入テーブルに追加
        buyService.addToBuy(productId, quantity);
    
        // 元の検索結果画面に戻す
        ProductSearchFormDTO productSearchFormDTO = indexService.getSearchFormDTO();
        productSearchForm.giveProductSearchForm(productSearchFormDTO);
        ProductViewResultListDTO productViewResultListDTO =
                indexService.getSearchResultListDTO(productSearchForm);
    
        model.addAttribute("productViewResultListDTO", productViewResultListDTO);
        model.addAttribute("productSearchForm", productSearchForm);
        model.addAttribute("productSearchFormDTO", productSearchFormDTO);
        model.addAttribute("buyMessage", "購入が完了しました！");
    
        return "index"; // index.html に戻す
    }
    
}
