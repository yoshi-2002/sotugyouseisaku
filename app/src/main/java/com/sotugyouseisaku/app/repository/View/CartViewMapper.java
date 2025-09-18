package com.sotugyouseisaku.app.repository.view;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.sotugyouseisaku.app.Record.CartViewRecord;

/**
 * cart_view を操作する Mapper
 */
@Mapper
public interface CartViewMapper {

    /**
     * cart_view から全データを取得する
     * @return cart_view の全データ
     */
    List<CartViewRecord> selectAllCartView();
}
