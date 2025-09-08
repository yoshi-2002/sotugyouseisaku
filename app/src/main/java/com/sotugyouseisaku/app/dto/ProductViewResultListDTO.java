package com.sotugyouseisaku.app.dto;

import java.util.List;

import com.sotugyouseisaku.app.Record.ProductViewRecord;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductViewResultListDTO {

    private List<ProductViewRecord> productViewList; // ProductViewRecord のリスト
    private int totalPages;
    private int currentPage;
    private long totalCount;
    private int pageSize;
    private int startCount;
    private int endCount;

    public boolean isHasPrevious() {
        return currentPage > 1;
    }

    public boolean isHasNext() {
        return currentPage < totalPages;
    }
}

