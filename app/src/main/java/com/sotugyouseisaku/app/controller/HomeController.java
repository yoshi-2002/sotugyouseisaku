package com.sotugyouseisaku.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sotugyouseisaku.app.form.ProductSearchForm;
import com.sotugyouseisaku.app.dto.ProductViewResultListDTO;
import com.sotugyouseisaku.app.dto.ProductSearchFormDTO;
import com.sotugyouseisaku.app.service.IndexService;

import lombok.RequiredArgsConstructor;

// バリデーション用
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final IndexService indexService;

    @GetMapping("/index")
    public String index(
            @ModelAttribute ProductSearchForm productSearchForm,
            Model model) {

        ProductSearchFormDTO productSearchFormDTO = indexService.getSearchFormDTO();
        model.addAttribute("productSearchFormDTO", productSearchFormDTO);

        productSearchForm.giveProductSearchForm(productSearchFormDTO);

        ProductViewResultListDTO productViewResultListDTO =
                indexService.getSearchResultListDTO(productSearchForm);

        model.addAttribute("productViewResultListDTO", productViewResultListDTO);
        model.addAttribute("productSearchForm", productSearchForm);

        return "index";
    }

    @PostMapping("/index")
    public String search(
            @Valid @ModelAttribute ProductSearchForm productSearchForm,
            BindingResult result,
            Model model) {

        ProductSearchFormDTO productSearchFormDTO = indexService.getSearchFormDTO();

        // バリデーションエラー時
        if (result.hasErrors()) {
            model.addAttribute("productSearchFormDTO", productSearchFormDTO);
            model.addAttribute("productSearchForm", productSearchForm);

            // 空のDTOをBuilderで渡して画面崩れを防止
            ProductViewResultListDTO emptyDto = ProductViewResultListDTO.builder()
                    .productViewList(java.util.List.of())
                    .build();
            model.addAttribute("productViewResultListDTO", emptyDto);

            return "index";
        }

        // バリデーション通過時
        productSearchFormDTO = indexService.giveSearchFormDTO(productSearchForm, productSearchFormDTO);

        ProductViewResultListDTO productViewResultListDTO =
                indexService.getSearchResultListDTO(productSearchForm);

        model.addAttribute("productViewResultListDTO", productViewResultListDTO);
        model.addAttribute("productSearchForm", productSearchForm);
        model.addAttribute("productSearchFormDTO", productSearchFormDTO);

        return "index";
    }
}
