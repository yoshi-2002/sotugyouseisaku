package com.sotugyouseisaku.app.repository.product;

import java.util.List;

import com.sotugyouseisaku.app.Record.ProductRecord;

public interface ProductMapper {
    /**
     * productsテーブルから全データを取得する
     * @return productsテーブルの全データ
     */
    List<ProductRecord> selectAllProducts();
}
