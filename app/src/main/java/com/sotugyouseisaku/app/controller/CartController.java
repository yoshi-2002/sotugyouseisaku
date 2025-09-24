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
import com.sotugyouseisaku.app.service.CartDeleteService;
import com.sotugyouseisaku.app.service.IndexService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartViewService cartViewService;
    private final BuyService buyService;
    private final CartDeleteService cartDeleteService;
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

    /**
     * カート内の商品を購入テーブルに登録し、同時にカートを削除
     */
    @PostMapping("/buy/add")
    public String addToBuy(
            @ModelAttribute ProductSearchForm productSearchForm,
            Model model) {

        // 1. カート内の商品を取得
        CartViewResultListDTO cartViewResultListDTO = cartViewService.getAllCartItems();

        // 2. 購入テーブルに登録
        cartViewResultListDTO.getCartViewList().forEach(item ->
                buyService.addToBuy(item.getProductId(), item.getQuantity())
        );

        // 3. カートから削除（Insertスタイルに合わせて1件ずつ削除）
        cartViewResultListDTO.getCartViewList().forEach(item -> {
            cartDeleteService.deleteCartItem(item.getCartId()); // ←修正箇所
        });

        // 4. 元の検索結果画面に戻す準備
        ProductSearchFormDTO productSearchFormDTO = indexService.getSearchFormDTO();
        productSearchForm.giveProductSearchForm(productSearchFormDTO);
        ProductViewResultListDTO productViewResultListDTO =
                indexService.getSearchResultListDTO(productSearchForm);

        model.addAttribute("productViewResultListDTO", productViewResultListDTO);
        model.addAttribute("productSearchForm", productSearchForm);
        model.addAttribute("productSearchFormDTO", productSearchFormDTO);
        model.addAttribute("buyMessage", "購入が完了しました！");

        return "buy";
    }

    // ------------------------------
    // カートから削除する POST メソッド
    // ------------------------------
    @PostMapping("/cart/delete")
    public String deleteFromCart(
            @RequestParam("cartId") int cartId,
            @ModelAttribute ProductSearchForm productSearchForm,
            Model model) {

        // カートから削除
        cartDeleteService.deleteCartItem(cartId);

        // 最新のカート一覧を取得
        CartViewResultListDTO cartViewResultListDTO = cartViewService.getAllCartItems();

        // 元の検索結果画面に戻す準備
        ProductSearchFormDTO productSearchFormDTO = indexService.getSearchFormDTO();
        productSearchForm.giveProductSearchForm(productSearchFormDTO);
        ProductViewResultListDTO productViewResultListDTO =
                indexService.getSearchResultListDTO(productSearchForm);

        // モデルに値をセット
        model.addAttribute("cartViewResultListDTO", cartViewResultListDTO);
        model.addAttribute("productViewResultListDTO", productViewResultListDTO);
        model.addAttribute("productSearchForm", productSearchForm);
        model.addAttribute("productSearchFormDTO", productSearchFormDTO);
        model.addAttribute("cartMessage", "商品をカートから削除しました！");

        return "cart"; // cart.html に戻す
    }

}
