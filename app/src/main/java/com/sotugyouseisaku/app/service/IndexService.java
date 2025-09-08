package com.sotugyouseisaku.app.service;

import com.sotugyouseisaku.app.dto.ProductViewResultListDTO;

public interface IndexService {
    /**
     * 商品一覧を取得する
     * @return 商品一覧
     */
    ProductViewResultListDTO findAllProducts();
    }
