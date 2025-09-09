package com.sotugyouseisaku.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sotugyouseisaku.app.form.ProductSearchForm;
import com.sotugyouseisaku.app.dto.ProductViewResultListDTO;
import com.sotugyouseisaku.app.dto.ProductSearchFormDTO;
import com.sotugyouseisaku.app.service.IndexService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final IndexService indexService;

    @GetMapping("/index")
    public String index(
            @ModelAttribute ProductSearchForm productSearchForm,
            Model model) {

        // 1. 検索フォーム用データを取得（キャッシュ対応）
        ProductSearchFormDTO productSearchFormDTO = indexService.getSearchFormDTO();
        model.addAttribute("productSearchFormDTO", productSearchFormDTO);

        // 2. 入力条件をフォームに詰める（キャッシュから持ってきたデータに上書き）
        productSearchForm.giveProductSearchForm(productSearchFormDTO);

        // 3. 入力条件に基づいて検索結果を取得
        ProductViewResultListDTO productViewResultListDTO =
                indexService.getSearchResultListDTO(productSearchForm);

        // 4. 検索結果を画面に渡す
        model.addAttribute("productViewResultListDTO", productViewResultListDTO);

        // 5. 検索後も選択内容を保持する
        model.addAttribute("productSearchForm", productSearchForm);

        // ページ番号リストは今回は不要（後で入れる）
        return "index";
    }
}
