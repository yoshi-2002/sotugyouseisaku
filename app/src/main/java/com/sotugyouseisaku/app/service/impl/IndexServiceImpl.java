package com.sotugyouseisaku.app.service.impl;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sotugyouseisaku.app.dto.ProductSearchFormDTO;
import com.sotugyouseisaku.app.dto.ProductViewResultListDTO;
import com.sotugyouseisaku.app.form.ProductSearchForm;
import com.sotugyouseisaku.app.repository.view.ProductCategoryMapper;
import com.sotugyouseisaku.app.repository.view.ProductViewMapper;
import com.sotugyouseisaku.app.Record.ProductCategoryRecord;
import com.sotugyouseisaku.app.Record.ProductViewRecord;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IndexServiceImpl  implements com.sotugyouseisaku.app.service.IndexService {

    private final ProductViewMapper productViewMapper;
    private final ProductCategoryMapper productCategoryMapper;

    @Cacheable("productSearchFormDTO")
    @Override
    public ProductSearchFormDTO getSearchFormDTO() {
       // Mapper から Record を取得
       List<ProductCategoryRecord> categoryRecords = productCategoryMapper.selectDistinctCategories();

        return ProductSearchFormDTO.builder()
                .categoryRecords(categoryRecords)
                .build();
    }

    @Override
    public ProductSearchFormDTO giveSearchFormDTO(ProductSearchForm form, ProductSearchFormDTO dto) {
        dto.setSelectedCategory(form.getCategory());
        return dto;
    }

    @Override
    public ProductViewResultListDTO getSearchResultListDTO(ProductSearchForm form) {
        // 入力条件（カテゴリ）に応じて View から商品リストを取得
        List<ProductViewRecord> productViewRecords = productViewMapper.selectAllProductView();

        return ProductViewResultListDTO.builder()
                .productViewList(productViewRecords)
                .build();
    }
}
