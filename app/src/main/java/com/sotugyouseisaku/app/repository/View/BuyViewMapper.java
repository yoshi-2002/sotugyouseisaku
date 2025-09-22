package com.sotugyouseisaku.app.repository.view;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.sotugyouseisaku.app.Record.BuyViewRecord;

/**
 * buy_view を操作する Mapper
 */
@Mapper
public interface BuyViewMapper {

    /**
     * buy_view から全データを取得する
     * @return buy_view の全データ
     */
    List<BuyViewRecord> selectAllBuyView();
}
