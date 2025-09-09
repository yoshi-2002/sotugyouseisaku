package com.sotugyouseisaku.app.repository.view;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.sotugyouseisaku.app.Record.ProductCategoryRecord;

@Mapper
public interface ProductCategoryMapper {

    // product_view から重複を除いたカテゴリ一覧を取得
    List<ProductCategoryRecord> selectDistinctCategories();
}