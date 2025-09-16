DROP VIEW IF EXISTS online_shop.product_view;

-- 商品一覧表示用ビュー
CREATE VIEW online_shop.product_view AS
    SELECT 
        p.id,                 -- 商品ID
        p.name,               -- 商品名
        p.jyoutai,            -- 状態（新品・中古）
        p.description,        -- 商品説明
        p.price,              -- 価格
        p.stock,              -- 在庫数
        p.created_at,         -- 作成日時
        m.name AS maker,      -- メーカー名（JOINで取得）
        c.name AS category,   -- 商品カテゴリ（JOINで取得）
        p.image_url           -- 画像URL
    FROM online_shop.product p
        JOIN online_shop.maker m 
            ON p.maker_id = m.id
        JOIN online_shop.category c 
            ON p.category_id = c.id;

-- ===== コメント定義 =====
COMMENT ON VIEW online_shop.product_view IS '商品一覧表示用ビュー';

COMMENT ON COLUMN online_shop.product_view.id IS '商品ID';
COMMENT ON COLUMN online_shop.product_view.name IS '商品名';
COMMENT ON COLUMN online_shop.product_view.jyoutai IS '状態（新品・中古）';
COMMENT ON COLUMN online_shop.product_view.description IS '商品説明';
COMMENT ON COLUMN online_shop.product_view.price IS '価格';
COMMENT ON COLUMN online_shop.product_view.stock IS '在庫数';
COMMENT ON COLUMN online_shop.product_view.created_at IS '作成日時';
COMMENT ON COLUMN online_shop.product_view.maker IS 'メーカー名';
COMMENT ON COLUMN online_shop.product_view.category IS '商品カテゴリ';
COMMENT ON COLUMN online_shop.product_view.image_url IS '画像URL';
