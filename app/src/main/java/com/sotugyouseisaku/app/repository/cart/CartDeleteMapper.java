package com.sotugyouseisaku.app.repository.cart;

// import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
// import com.sotugyouseisaku.app.Record.CartDeleteRecord;

@Mapper
public interface CartDeleteMapper {

    // ------------------------------
    // カートから商品を削除
    // ------------------------------
    void deleteCartItem(@Param("cartId") int cartId);

    // ------------------------------
    // 削除対象のカート一覧を取得（必要なら）
    // ------------------------------
    // List<CartDeleteRecord> selectAllCartForDelete();
}
