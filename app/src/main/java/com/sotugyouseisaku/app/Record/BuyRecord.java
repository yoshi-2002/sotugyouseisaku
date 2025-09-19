package com.sotugyouseisaku.app.Record;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class BuyRecord {
    private int id;                // 購入ID
    private int productId;         // 商品ID（外部キー）
    private int quantity;          // 数量
    private LocalDateTime boughtAt; // 購入日時
}
