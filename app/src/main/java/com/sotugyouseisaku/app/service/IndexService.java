package com.sotugyouseisaku.app.service;

import com.sotugyouseisaku.app.dto.ProductViewResultListDTO;
import com.sotugyouseisaku.app.dto.ProductSearchFormDTO;
import com.sotugyouseisaku.app.form.ProductSearchForm;

public interface IndexService {
    /**
     * 商品一覧を取得する
     * @return 商品一覧
     */
    /**
     * 検索フォーム用DTOを取得（キャッシュ対応）
     */
    ProductSearchFormDTO getSearchFormDTO();

    /**
     * 入力フォームの値をDTOにセットする
     */
    ProductSearchFormDTO giveSearchFormDTO(ProductSearchForm form, ProductSearchFormDTO dto);

    /**
     * 入力条件に基づいて検索結果を取得
     */
    ProductViewResultListDTO getSearchResultListDTO(ProductSearchForm form);
}
