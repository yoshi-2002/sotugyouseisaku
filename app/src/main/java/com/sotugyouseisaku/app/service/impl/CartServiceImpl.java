package com.sotugyouseisaku.app.service.impl;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.sotugyouseisaku.app.repository.cart.CartMapper;
import com.sotugyouseisaku.app.service.CartService;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartMapper cartMapper;

    /**
     * カートに商品を追加する
     * @param productId 追加する商品のID
     * @param quantity 数量（今回は1でも可）
     */
    @Override
    public void addToCart(int productId, int quantity) {
        cartMapper.insertCartItem(productId, quantity);
    }
}
