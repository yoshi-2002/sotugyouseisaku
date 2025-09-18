package com.sotugyouseisaku.app.dto;

import java.util.List;

import com.sotugyouseisaku.app.Record.CartViewRecord;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartViewResultListDTO {

    private List<CartViewRecord> cartViewList; // CartViewRecord のリスト

}
