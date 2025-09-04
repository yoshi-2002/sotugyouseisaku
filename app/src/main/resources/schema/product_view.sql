-- ============================
-- 商品一覧ビュー
-- ============================
DROP VIEW IF EXISTS online_shop.products_view;
CREATE VIEW online_shop.products_view AS
    SELECT id, name, description, price, stock, created_at, 'smartphone_holder' AS category
    FROM online_shop.smartphone_holders
    UNION ALL
    SELECT id, name, description, price, stock, created_at, 'drive_recorder' AS category
    FROM online_shop.drive_recorders
    UNION ALL
    SELECT id, name, description, price, stock, created_at, 'car_navigation' AS category
    FROM online_shop.car_navigation;

COMMENT ON VIEW online_shop.products_view IS '商品一覧表示用ビュー';
COMMENT ON COLUMN online_shop.products_view.id IS '商品ID';
COMMENT ON COLUMN online_shop.products_view.name IS '商品名';
COMMENT ON COLUMN online_shop.products_view.description IS '商品説明';
COMMENT ON COLUMN online_shop.products_view.price IS '価格';
COMMENT ON COLUMN online_shop.products_view.stock IS '在庫数';
COMMENT ON COLUMN online_shop.products_view.created_at IS '作成日時';
COMMENT ON COLUMN online_shop.products_view.category IS '商品カテゴリ（smartphone_holder, drive_recorder, car_navigation）';


-- DROP TABLE IF EXISTS online_shop.products;
-- CREATE TABLE online_shop.products (
--     id SERIAL PRIMARY KEY,
--     name VARCHAR(100) NOT NULL,
--     description TEXT,
--     price NUMERIC(10,2) NOT NULL,
--     stock INT DEFAULT 0,
--     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
-- );