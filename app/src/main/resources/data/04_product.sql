-- 商品データ登録（car_navigation + drive_recorder + smartphone_holder）

INSERT INTO online_shop.product (name, jyoutai, description, price, stock, maker_id, category_id, image_url) VALUES
-- カーナビゲーション
('カーナビゲーションA', '新品', '7インチワイド液晶', 35000.00, 8, 1, 1, 'https://t4.ftcdn.net/jpg/06/13/33/59/240_F_613335941_P2VoWdeKA9bDrv5Nk7Z5Ib0bTHyzVOCQ.jpg'),
('カーナビゲーションB', '新品', 'Bluetooth対応', 42000.00, 6, 2, 1, NULL),
('カーナビゲーションC', '新品', '地図更新無料付き', 50000.00, 4, 3, 1, NULL),

-- ドライブレコーダー
('ドライブレコーダーA', '新品', 'フルHD画質対応', 9800.00, 15, 4, 2, NULL),
('ドライブレコーダーB', '新品', '前後カメラ付き', 15000.00, 10, 2, 2, NULL),
('ドライブレコーダーC', '新品', '駐車監視機能あり', 20000.00, 5, 5, 2, NULL),

-- スマホホルダー
('スマホホルダーA', '新品', 'シンプルなスマホホルダー', 1200.00, 50, 6, 3, NULL),
('スマホホルダーB', '新品', '360度回転可能', 1800.00, 30, 7, 3, NULL),
('スマホホルダーC', '中古', 'エアコン吹き出し口タイプ', 1500.00, 20, 7, 3, NULL);
