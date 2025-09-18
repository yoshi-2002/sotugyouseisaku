CREATE OR REPLACE VIEW online_shop.cart_view AS
SELECT
    c.id AS cart_id,           -- カートID
    c.product_id,              -- 商品ID
    c.quantity,                -- カートに入れた数量
    c.added_at,                -- カートに追加した日時
    p.name AS product_name,    -- 商品名
    p.price AS price,          -- 価格
    p.jyoutai,                 -- 商品状態（新品・中古）
    p.stock,                   -- 在庫数
    m.name AS maker,           -- メーカー名
    cat.name AS category       -- カテゴリ名
FROM online_shop.cart c
JOIN online_shop.product p
    ON c.product_id = p.id
JOIN online_shop.maker m
    ON p.maker_id = m.id
JOIN online_shop.category cat
    ON p.category_id = cat.id;

-- ===== コメント定義 =====
COMMENT ON VIEW online_shop.cart_view IS 'カート表示用ビュー（商品情報と数量を結合）';
COMMENT ON COLUMN online_shop.cart_view.cart_id IS 'カートID';
COMMENT ON COLUMN online_shop.cart_view.product_id IS '商品ID';
COMMENT ON COLUMN online_shop.cart_view.quantity IS '数量';
COMMENT ON COLUMN online_shop.cart_view.added_at IS '追加日時';
COMMENT ON COLUMN online_shop.cart_view.product_name IS '商品名';
COMMENT ON COLUMN online_shop.cart_view.price IS '価格';
COMMENT ON COLUMN online_shop.cart_view.jyoutai IS '商品状態（新品・中古）';
COMMENT ON COLUMN online_shop.cart_view.stock IS '在庫数';
COMMENT ON COLUMN online_shop.cart_view.maker IS 'メーカー名';
COMMENT ON COLUMN online_shop.cart_view.category IS 'カテゴリ名';
