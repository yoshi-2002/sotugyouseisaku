package com.sotugyouseisaku.app.service.impl;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.sotugyouseisaku.app.repository.cart.CartIdDeleteMapper;
import com.sotugyouseisaku.app.service.CartIdDeleteService;

@Service
@RequiredArgsConstructor
public class CartIdDeleteServiceImpl implements CartIdDeleteService {

    private final CartIdDeleteMapper cartIdDeleteMapper;

    /**
     * 指定されたカートIDの商品を削除する
     */
    @Override
    public void deleteCartIdItem(int cartId) {
        cartIdDeleteMapper.deleteCartItemTwo(cartId);
    }
}
