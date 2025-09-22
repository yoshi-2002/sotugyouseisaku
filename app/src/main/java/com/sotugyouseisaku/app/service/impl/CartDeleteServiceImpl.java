package com.sotugyouseisaku.app.service.impl;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.sotugyouseisaku.app.repository.cart.CartDeleteMapper;
import com.sotugyouseisaku.app.service.CartDeleteService;

@Service
@RequiredArgsConstructor
public class CartDeleteServiceImpl implements CartDeleteService {

    private final CartDeleteMapper cartDeleteMapper;

    /**
     * カートの商品を削除する
     * @param cartId 削除するカートID
     */
    @Override
    public void deleteCartItem(int cartId) {
        cartDeleteMapper.deleteCartItem(cartId);
    }
}
