package com.sotugyouseisaku.app.controller;

import java.util.List; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sotugyouseisaku.app.dto.ProductViewResultListDTO;
import com.sotugyouseisaku.app.service.IndexService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class HomeController {

    private final IndexService indexService; // Service を DI

    @GetMapping("/index") // ブラウザでアクセスするURL
    public String index(Model model) {

        // ServiceからDTOを取得
        List<ProductViewResultListDTO> productViewResultList = indexService.findAllProducts();

        // HTMLに渡す
        model.addAttribute("productViewResultList", productViewResultList);

        return "index"; // resources/templates/index.html
    }
}
