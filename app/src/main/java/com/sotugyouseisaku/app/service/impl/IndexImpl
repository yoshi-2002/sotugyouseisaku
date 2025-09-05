package com.sotugyouseisaku.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sotugyouseisaku.app.Record.ProductViewRecord;
import com.sotugyouseisaku.app.repository.view.ProductViewMapper;
import com.sotugyouseisaku.app.dto.ProductViewResultListDTO;
import com.sotugyouseisaku.app.service.IndexService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IndexImpl implements IndexService {

    private final ProductViewMapper productViewMapper;

    @Override
    public ProductViewResultListDTO findAllProducts() {
        List<ProductViewRecord> productViewRecords = productViewMapper.selectAllProducts();

        return ProductViewResultListDTO.builder()
                .productViewList(productViewRecords)
                .build();
    }
}
