package com.sotugyouseisaku.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sotugyouseisaku.app.Record.BuyViewRecord;
import com.sotugyouseisaku.app.dto.BuyViewResultListDTO;
import com.sotugyouseisaku.app.repository.view.BuyViewMapper;
import com.sotugyouseisaku.app.service.BuyViewService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuyViewServiceImpl implements BuyViewService {

    private final BuyViewMapper buyViewMapper;

    @Override
    public BuyViewResultListDTO getAllBuyItems() {
        List<BuyViewRecord> buyViewRecords = buyViewMapper.selectAllBuyView();

        return BuyViewResultListDTO.builder()
                .buyViewList(buyViewRecords)
                .build();
    }
}
