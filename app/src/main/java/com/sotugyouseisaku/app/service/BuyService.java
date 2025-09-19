package com.sotugyouseisaku.app.service;

public interface BuyService {
    /**
     * 指定された商品を購入テーブルに登録する
     * @param productId 商品ID
     * @param quantity 数量（今回は1でも可）
     */
    void addToBuy(int productId, int quantity);
}
