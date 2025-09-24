package com.sotugyouseisaku.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sotugyouseisaku.app.dto.CartViewResultListDTO;
import com.sotugyouseisaku.app.dto.BuyViewResultListDTO;
import com.sotugyouseisaku.app.dto.ProductSearchFormDTO;
import com.sotugyouseisaku.app.dto.ProductViewResultListDTO;
import com.sotugyouseisaku.app.form.ProductSearchForm;
import com.sotugyouseisaku.app.service.CartViewService;
import com.sotugyouseisaku.app.service.BuyViewService;
import com.sotugyouseisaku.app.service.CartDeleteService; // ← カート画面と同じサービスを使用
import com.sotugyouseisaku.app.service.IndexService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyPageController {

    private final CartViewService cartViewService;
    private final BuyViewService buyViewService;
    private final CartDeleteService cartDeleteService; // ← CartIdDeleteService ではなくこちらを使用
    private final IndexService indexService;

    /**
     * マイページ表示（カート情報 + 購入履歴）
     */
    @GetMapping("/myPage")
    public String myPage(Model model) {
        // カート情報を取得
        CartViewResultListDTO cartViewResultListDTO = cartViewService.getAllCartItems();
        model.addAttribute("cartViewResultListDTO", cartViewResultListDTO);

        // 購入履歴を取得
        BuyViewResultListDTO buyViewResultListDTO = buyViewService.getAllBuyItems();
        model.addAttribute("buyViewResultListDTO", buyViewResultListDTO);

        return "myPage";
    }

    // ------------------------------
    // マイページからカートを削除する POST メソッド
    // ------------------------------
    @PostMapping("/myPage/cart/delete")
    public String deleteFromCartInMyPage(
            @RequestParam("cartId") int cartId,
            @ModelAttribute ProductSearchForm productSearchForm,
            Model model) {

        // カートから削除（カート画面と同じサービスを使う）
        cartDeleteService.deleteCartItem(cartId);

        // 最新のカート一覧を取得
        CartViewResultListDTO cartViewResultListDTO = cartViewService.getAllCartItems();

        // 元の検索結果画面に戻す準備
        ProductSearchFormDTO productSearchFormDTO = indexService.getSearchFormDTO();
        productSearchForm.giveProductSearchForm(productSearchFormDTO);
        ProductViewResultListDTO productViewResultListDTO =
                indexService.getSearchResultListDTO(productSearchForm);

        // 最新の購入履歴を取得
        BuyViewResultListDTO buyViewResultListDTO = buyViewService.getAllBuyItems();

        // モデルに値をセット
        model.addAttribute("cartViewResultListDTO", cartViewResultListDTO);
        model.addAttribute("productViewResultListDTO", productViewResultListDTO);
        model.addAttribute("productSearchForm", productSearchForm);
        model.addAttribute("productSearchFormDTO", productSearchFormDTO);
        model.addAttribute("buyViewResultListDTO", buyViewResultListDTO);
        model.addAttribute("cartMessage", "商品をカートから削除しました！");

        return "myPage"; // myPage.html に戻す
    }
}
