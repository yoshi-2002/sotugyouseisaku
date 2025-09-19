package com.sotugyouseisaku.app.service;

import java.util.List;
import com.sotugyouseisaku.app.Record.CartDeleteRecord;

public interface CartDeleteService {

    /**
     * 指定された商品リストをカートから削除する
     * @param deleteList 削除対象のカート商品リスト
     */
    void deleteCartItems(List<CartDeleteRecord> deleteList);
}
