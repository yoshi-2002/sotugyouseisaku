package com.sotugyouseisaku.app.Record;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class CartRecord {
    private int id;              // カートID
    private int productId;       // 商品ID（外部キー）
    private int quantity;        // 数量
    private LocalDateTime addedAt; // 追加日時
}
