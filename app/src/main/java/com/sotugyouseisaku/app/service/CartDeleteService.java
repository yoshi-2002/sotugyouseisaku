package com.sotugyouseisaku.app.service;

public interface CartDeleteService {

    /**
     * 指定されたカートIDの商品を削除する
     * @param cartId 削除対象のカートID
     */
    void deleteCartItem(int cartId);
}
