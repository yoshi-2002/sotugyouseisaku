DROP VIEW IF EXISTS online_shop.product_view;
CREATE VIEW online_shop.product_view AS
    SELECT id, name, jyoutai, description, price, stock, created_at, maker, category, image_url
    FROM online_shop.car_navigation
    UNION ALL
    SELECT id, name, jyoutai, description, price, stock, created_at, maker, category, NULL AS image_url
    FROM online_shop.smartphone_holder
    UNION ALL
    SELECT id, name, jyoutai, description, price, stock, created_at, maker, category, NULL AS image_url
    FROM online_shop.drive_recorder;

COMMENT ON VIEW online_shop.product_view IS '商品一覧表示用ビュー';
COMMENT ON COLUMN online_shop.product_view.id IS '商品ID';
COMMENT ON COLUMN online_shop.product_view.name IS '商品名';
COMMENT ON COLUMN online_shop.product_view.jyoutai IS '状態（新品・中古）';
COMMENT ON COLUMN online_shop.product_view.description IS '商品説明';
COMMENT ON COLUMN online_shop.product_view.price IS '価格';
COMMENT ON COLUMN online_shop.product_view.stock IS '在庫数';
COMMENT ON COLUMN online_shop.product_view.created_at IS '作成日時';
COMMENT ON COLUMN online_shop.car_navigation.maker IS 'メーカー名';
COMMENT ON COLUMN online_shop.car_navigation.category IS '商品カテゴリ';
COMMENT ON COLUMN online_shop.car_navigation.image_url IS '画像URL';