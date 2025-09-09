package com.sotugyouseisaku.app.dto;

import lombok.*;
import java.util.List;

import com.sotugyouseisaku.app.Record.ProductCategoryRecord;

/**
 * 商品検索フォーム用のDTOクラス（キャッシュ用）
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSearchFormDTO {

    /**
     * プルダウン用：カテゴリのリスト
     */
    private List<ProductCategoryRecord> categoryRecords;

    /**
     * 選択済みのカテゴリ
     */
    private String selectedCategory;
}
