package com.sotugyouseisaku.app.repository.view;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.sotugyouseisaku.app.Record.ProductJyoutaiRecord;

@Mapper
public interface ProductJyoutaiMapper {

    // product_view から重複を除いた状態一覧を取得
    List<ProductJyoutaiRecord> selectDistinctJyoutai();
}
