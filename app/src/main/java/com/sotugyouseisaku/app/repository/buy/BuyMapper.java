package com.sotugyouseisaku.app.repository.buy;

// import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
// import com.sotugyouseisaku.app.Record.BuyRecord;

@Mapper
public interface BuyMapper {

    // ------------------------------
    // 購入テーブルに商品を追加
    // ------------------------------
    void insertBuyItem(@Param("productId") int productId,
                       @Param("quantity") int quantity);

    // ------------------------------
    // 購入履歴を全件取得
    // ------------------------------
    // List<BuyRecord> selectAllBuyItems();
}
