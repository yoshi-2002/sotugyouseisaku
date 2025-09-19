package com.sotugyouseisaku.app.repository.cart;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.sotugyouseisaku.app.Record.CartDeleteRecord;

@Mapper
public interface CartDeleteMapper {

    // ------------------------------
    // 指定されたカートIDのレコードを削除
    // ------------------------------
    void deleteCartItems(List<CartDeleteRecord> cartRecords);
}
