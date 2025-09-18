package com.sotugyouseisaku.app.service;

public interface CartService {
    /**
     * 指定された商品をカートに追加する
     * @param productId 商品ID
     * @param quantity 数量（今回は1でも可）
     */
    void addToCart(int productId, int quantity);
}
