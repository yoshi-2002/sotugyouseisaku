CREATE OR REPLACE VIEW online_shop.buy_view AS
SELECT
    b.id AS buy_id,            -- 購入ID
    b.product_id,              -- 商品ID
    b.quantity,                -- 購入数量
    b.bought_at,               -- 購入日時
    p.name AS product_name,    -- 商品名
    p.price AS price,          -- 価格
    p.jyoutai,                 -- 商品状態（新品・中古）
    p.stock,                   -- 在庫数
    m.name AS maker,           -- メーカー名
    cat.name AS category,      -- カテゴリ名
    p.image_url                -- 画像URL
FROM online_shop.buy b
JOIN online_shop.product p
    ON b.product_id = p.id
JOIN online_shop.maker m
    ON p.maker_id = m.id
JOIN online_shop.category cat
    ON p.category_id = cat.id;

-- ===== コメント定義 =====
COMMENT ON VIEW online_shop.buy_view IS '購入履歴表示用ビュー（商品情報と数量を結合）';
COMMENT ON COLUMN online_shop.buy_view.buy_id IS '購入ID';
COMMENT ON COLUMN online_shop.buy_view.product_id IS '商品ID';
COMMENT ON COLUMN online_shop.buy_view.quantity IS '購入数量';
COMMENT ON COLUMN online_shop.buy_view.bought_at IS '購入日時';
COMMENT ON COLUMN online_shop.buy_view.product_name IS '商品名';
COMMENT ON COLUMN online_shop.buy_view.price IS '価格';
COMMENT ON COLUMN online_shop.buy_view.jyoutai IS '商品状態（新品・中古）';
COMMENT ON COLUMN online_shop.buy_view.stock IS '在庫数';
COMMENT ON COLUMN online_shop.buy_view.maker IS 'メーカー名';
COMMENT ON COLUMN online_shop.buy_view.category IS 'カテゴリ名';
COMMENT ON COLUMN online_shop.buy_view.image_url IS '商品画像URL';
