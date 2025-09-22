package com.sotugyouseisaku.app.dto;

import java.util.List;

import com.sotugyouseisaku.app.Record.BuyViewRecord;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuyViewResultListDTO {

    private List<BuyViewRecord> buyViewList; // BuyViewRecord のリスト

}
