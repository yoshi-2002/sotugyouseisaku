package com.sotugyouseisaku.app.service;

import com.sotugyouseisaku.app.dto.CartViewResultListDTO;

public interface CartViewService {
    /**
     * カート内の商品を全件取得する
     */
    CartViewResultListDTO getAllCartItems();
}
