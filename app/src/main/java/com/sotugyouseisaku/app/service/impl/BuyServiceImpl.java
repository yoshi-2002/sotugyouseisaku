package com.sotugyouseisaku.app.service.impl;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.sotugyouseisaku.app.repository.buy.BuyMapper;
import com.sotugyouseisaku.app.service.BuyService;

@Service
@RequiredArgsConstructor
public class BuyServiceImpl implements BuyService {

    private final BuyMapper buyMapper;

    /**
     * 購入テーブルに商品を追加する
     * @param productId 商品ID
     * @param quantity 数量（今回は1でも可）
     */
    @Override
    public void addToBuy(int productId, int quantity) {
        buyMapper.insertBuyItem(productId, quantity);
    }
}
