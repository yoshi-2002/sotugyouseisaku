package com.sotugyouseisaku.app.service;

public interface CartIdDeleteService {
    /**
     * 指定されたカートIDの商品を削除する
     * @param cartId 削除する商品のカートID
     */
    void deleteCartIdItem(int cartId);
}
