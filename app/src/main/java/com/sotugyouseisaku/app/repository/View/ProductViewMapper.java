package com.sotugyouseisaku.app.repository.View;

import java.util.List;
import com.sotugyouseisaku.app.Record.ProductViewRecord;

/**
 * product_view を操作する Mapper
 */
public interface ProductViewMapper {

    /**
     * product_view から全データを取得する
     * @return product_view の全データ
     */
    List<ProductViewRecord> selectAllProductView();
}
