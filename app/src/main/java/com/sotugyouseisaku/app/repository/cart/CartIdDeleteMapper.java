package com.sotugyouseisaku.app.repository.cart;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CartIdDeleteMapper {

    // ------------------------------
    // カートIDで商品を削除
    // ------------------------------
    void deleteCartItemTwo(@Param("cartId") int cartId);
}
