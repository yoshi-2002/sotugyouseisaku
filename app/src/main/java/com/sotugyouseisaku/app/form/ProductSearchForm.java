package com.sotugyouseisaku.app.form;

import org.springframework.stereotype.Component;
import com.sotugyouseisaku.app.dto.ProductSearchFormDTO;
import lombok.Data;

@Component
@Data
public class ProductSearchForm {

    /**
     * ユーザーが選択したカテゴリを保持する
     */
    private String category;

    /**
     * キャッシュからフォームに値を入れる
     */
    public void giveProductSearchForm(ProductSearchFormDTO dto) {
        this.category = dto.getSelectedCategory();
    }
}
