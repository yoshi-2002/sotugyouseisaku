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
     * ユーザーが選択したメーカーを保持する
     */
    private String maker;

    /**
     * フリーワード検索用
     */
    private String keyword;

    /**
     * キャッシュからフォームに値を入れる
     */
    public void giveProductSearchForm(ProductSearchFormDTO dto) {
        this.category = dto.getSelectedCategory();
        this.maker = dto.getSelectedMaker();
    }
}
