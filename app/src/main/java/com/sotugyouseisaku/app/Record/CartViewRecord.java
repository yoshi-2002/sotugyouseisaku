package com.sotugyouseisaku.app.Record;

import lombok.Data;

@Data
public class CartViewRecord {
    private int cartId;        // カートID
    private int productId;     // 商品ID
    private int quantity;      // 数量
    private String productName;// 商品名
    private int price;         // 価格
    private String jyoutai;    // 商品状態（新品・中古）
    private String maker;      // メーカー名
    private String category;   // カテゴリ名
    private String imageUrl;   // 画像URL
}
