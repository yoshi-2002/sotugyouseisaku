package com.sotugyouseisaku.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sotugyouseisaku.app.dto.ProductViewResultListDTO;
import com.sotugyouseisaku.app.service.IndexService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final IndexService indexService;

    @GetMapping("/index")
    public String index(Model model) {
        // ServiceからDTOを取得
        ProductViewResultListDTO productViewResultListDTO = indexService.findAllProducts();

        // HTMLに渡す
        model.addAttribute("productViewResultListDTO", productViewResultListDTO);

        // templates/index.html を表示
        return "index";
    }
}
