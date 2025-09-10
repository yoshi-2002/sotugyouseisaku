package com.sotugyouseisaku.app.repository.view;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.sotugyouseisaku.app.Record.ProductMakerRecord;

@Mapper
public interface ProductMakerMapper {

    // product_view から重複を除いたメーカー一覧を取得
    List<ProductMakerRecord> selectDistinctMakers();
}
