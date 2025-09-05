DROP VIEW IF EXISTS online_shop.product_view;
CREATE VIEW online_shop.product_view AS
    SELECT id, name, description, price, stock, created_at, 'smartphone_holder' AS category
    FROM online_shop.smartphone_holder
    UNION ALL
    SELECT id, name, description, price, stock, created_at, 'drive_recorder' AS category
    FROM online_shop.drive_recorder
    UNION ALL
    SELECT id, name, description, price, stock, created_at, 'car_navigation' AS category
    FROM online_shop.car_navigation;

COMMENT ON VIEW online_shop.product_view IS '商品一覧表示用ビュー';
COMMENT ON COLUMN online_shop.product_view.id IS '商品ID';
COMMENT ON COLUMN online_shop.product_view.name IS '商品名';
COMMENT ON COLUMN online_shop.product_view.description IS '商品説明';
COMMENT ON COLUMN online_shop.product_view.price IS '価格';
COMMENT ON COLUMN online_shop.product_view.stock IS '在庫数';
COMMENT ON COLUMN online_shop.product_view.created_at IS '作成日時';
COMMENT ON COLUMN online_shop.product_view.category IS '商品カテゴリ（smartphone_holder, drive_recorder, car_navigation）';
