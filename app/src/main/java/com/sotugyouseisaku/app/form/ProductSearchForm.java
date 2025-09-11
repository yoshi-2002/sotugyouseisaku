package com.sotugyouseisaku.app.form;

import org.springframework.stereotype.Component;
import com.sotugyouseisaku.app.dto.ProductSearchFormDTO;
import lombok.Data;

@Component
@Data
public class ProductSearchForm {

    /**
     * ユーザーが選択した状態（新品・中古）を保持する
     */
    private String jyoutai;

    /**
     * ユーザーが選択したカテゴリを保持する
     */
    private String category;

    /**
     * ユーザーが選択したメーカーを保持する
     */
    private String maker;

    /**
     * ユーザーが入力した価格下限
     */
    private Integer priceMin;

    /**
     * ユーザーが入力した価格上限
     */
    private Integer priceMax;

    /**
     * フリーワード検索用
     */
    private String keyword;

    /**
     * キャッシュからフォームに値を入れる
     */
    public void giveProductSearchForm(ProductSearchFormDTO dto) {
        this.jyoutai = dto.getSelectedJyoutai();
        this.category = dto.getSelectedCategory();
        this.maker = dto.getSelectedMaker();
    }
}
