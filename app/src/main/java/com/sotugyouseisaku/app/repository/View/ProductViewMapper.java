package com.sotugyouseisaku.app.repository.view;

import java.util.List;
import com.sotugyouseisaku.app.Record.ProductViewRecord;
import com.sotugyouseisaku.app.form.ProductSearchForm;

/**
 * product_view を操作する Mapper
 */
public interface ProductViewMapper {

    /**
     * product_view から全データを取得する（カテゴリ絞り込み対応）
     * @param form ユーザーが選択した検索条件
     * @return product_view の全データ（条件に応じて絞り込み）
     */
    List<ProductViewRecord> selectAllProductView(ProductSearchForm form);
}
