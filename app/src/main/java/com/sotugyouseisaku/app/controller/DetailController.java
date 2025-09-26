package com.sotugyouseisaku.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sotugyouseisaku.app.dto.ProductViewResultListDTO;
import com.sotugyouseisaku.app.form.ProductSearchForm;
import com.sotugyouseisaku.app.service.IndexService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DetailController {

    private final IndexService indexService;

    /**
     * 商品詳細ページ表示
     */
    @GetMapping("/detail")
    public String detail(@RequestParam("id") int id, Model model) {

        // 商品一覧を取得（検索条件なし）
        ProductViewResultListDTO productViewResultListDTO =
                indexService.getSearchResultListDTO(new ProductSearchForm());

        // クリックされたIDの商品を取得（必ず存在する想定）
        var product = productViewResultListDTO.getProductViewList()
                        .stream()
                        .filter(p -> p.getId() == id)
                        .findFirst()
                        .get(); // findFirst().get() で Optional の中身を直接取得

        model.addAttribute("product", product);

        return "detail";
    }
}
