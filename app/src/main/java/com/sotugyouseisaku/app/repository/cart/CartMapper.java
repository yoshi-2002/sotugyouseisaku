package com.sotugyouseisaku.app.repository.cart;

// import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
// import com.sotugyouseisaku.app.Record.CartRecord;

@Mapper
public interface CartMapper {

    // ------------------------------
    // カートに商品を追加
    // ------------------------------
    void insertCartItem(@Param("productId") int productId,
                        @Param("quantity") int quantity);

    // ------------------------------
    // カート内容を取得
    // ------------------------------
    // List<CartRecord> selectAllCartItems();
}
