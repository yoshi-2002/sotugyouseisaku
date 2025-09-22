package com.sotugyouseisaku.app.service;

import com.sotugyouseisaku.app.dto.BuyViewResultListDTO;

public interface BuyViewService {
    /**
     * 購入履歴を全件取得する
     */
    BuyViewResultListDTO getAllBuyItems();
}
