package com.sotugyouseisaku.app.dto;

import lombok.*;
import java.util.List;

import com.sotugyouseisaku.app.Record.ProductCategoryRecord;
import com.sotugyouseisaku.app.Record.ProductJyoutaiRecord;
import com.sotugyouseisaku.app.Record.ProductMakerRecord;

/**
 * 商品検索フォーム用のDTOクラス（キャッシュ用）
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSearchFormDTO {

    /**
     * プルダウン用：状態（新品・中古）のリスト
     */
    private List<ProductJyoutaiRecord> jyoutaiRecords;

    /**
     * 選択済みの状態（新品・中古）
     */
    private String selectedJyoutai;

    /**
     * プルダウン用：カテゴリのリスト
     */
    private List<ProductCategoryRecord> categoryRecords;

    /**
     * 選択済みのカテゴリ
     */
    private String selectedCategory;

    /**
     * プルダウン用：メーカーのリスト
     */
    private List<ProductMakerRecord> makerRecords;

    /**
     * 選択済みのメーカー
     */
    private String selectedMaker;
}
