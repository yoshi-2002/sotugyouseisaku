// package com.sotugyouseisaku.app.service.impl;

// import java.util.List;

// import org.springframework.stereotype.Service;
// import lombok.RequiredArgsConstructor;

// import com.sotugyouseisaku.app.Record.CartDeleteRecord;
// import com.sotugyouseisaku.app.repository.cart.CartDeleteMapper;
// import com.sotugyouseisaku.app.service.CartDeleteService;

// @Service
// @RequiredArgsConstructor
// public class CartDeleteServiceImpl implements CartDeleteService {

//     private final CartDeleteMapper cartDeleteMapper;

//     /**
//      * カートの商品を削除する（まとめて削除）
//      * @param deleteList 削除対象のカート商品リスト
//      */
//     @Override
//     public void deleteCartItems(List<CartDeleteRecord> deleteList) {
//         if (deleteList != null && !deleteList.isEmpty()) {
//             cartDeleteMapper.deleteCartItems(deleteList);
//         }
//     }
// }
