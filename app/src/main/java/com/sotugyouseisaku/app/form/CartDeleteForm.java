package com.sotugyouseisaku.app.form;

import org.springframework.stereotype.Component;
import lombok.Data;

/**
 * カート削除用フォーム
 * カートから削除する商品IDと数量を保持する
 */
@Component
@Data
public class CartDeleteForm {

    /**
     * 削除する商品のID
     */
    private int productId;

    /**
     * 削除する数量（デフォルト1）
     */
    private int quantity = 1;
}
