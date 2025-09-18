package com.sotugyouseisaku.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sotugyouseisaku.app.Record.CartViewRecord;
import com.sotugyouseisaku.app.dto.CartViewResultListDTO;
import com.sotugyouseisaku.app.repository.view.CartViewMapper;
import com.sotugyouseisaku.app.service.CartViewService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartViewServiceImpl implements CartViewService {

    private final CartViewMapper cartViewMapper;

    @Override
    public CartViewResultListDTO getAllCartItems() {
        List<CartViewRecord> cartViewRecords = cartViewMapper.selectAllCartView();

        return CartViewResultListDTO.builder()
                .cartViewList(cartViewRecords)
                .build();
    }
}
