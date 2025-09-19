CREATE VIEW online_shop.product_view AS
SELECT
    p.id,                 -- 商品ID
    p.name,               -- 商品名
    p.jyoutai,            -- 状態（新品・中古）
    p.description,        -- 商品説明
    p.price,              -- 価格
    p.stock,              -- 在庫数
    p.created_at,         -- 作成日時
    m.name AS maker,      -- メーカー名
    c.name AS category,   -- 商品カテゴリ
    STRING_AGG(ca.alias_name, ',') AS alias_name, -- カテゴリ別名をカンマ区切りで集約
    p.image_url           -- 画像URL
FROM online_shop.product p
JOIN online_shop.maker m ON p.maker_id = m.id
JOIN online_shop.category c ON p.category_id = c.id
LEFT JOIN online_shop.category_alias ca ON p.category_id = ca.category_id
GROUP BY
    p.id, p.name, p.jyoutai, p.description, p.price, p.stock, p.created_at, m.name, c.name, p.image_url;

-- ===== コメント定義 =====
COMMENT ON VIEW online_shop.product_view IS '商品一覧表示用ビュー（方法B：別名を集約して重複なし）';

COMMENT ON COLUMN online_shop.product_view.id IS '商品ID';
COMMENT ON COLUMN online_shop.product_view.name IS '商品名';
COMMENT ON COLUMN online_shop.product_view.jyoutai IS '状態（新品・中古）';
COMMENT ON COLUMN online_shop.product_view.description IS '商品説明';
COMMENT ON COLUMN online_shop.product_view.price IS '価格';
COMMENT ON COLUMN online_shop.product_view.stock IS '在庫数';
COMMENT ON COLUMN online_shop.product_view.created_at IS '作成日時';
COMMENT ON COLUMN online_shop.product_view.maker IS 'メーカー名';
COMMENT ON COLUMN online_shop.product_view.category IS '商品カテゴリ';
COMMENT ON COLUMN online_shop.product_view.alias_name IS 'カテゴリの別名（カンマ区切りで集約）';
COMMENT ON COLUMN online_shop.product_view.image_url IS '画像URL';

-- DROP VIEW IF EXISTS online_shop.product_view;

-- -- 商品一覧表示用ビュー（category_alias 対応）
-- CREATE VIEW online_shop.product_view AS
-- SELECT 
--     p.id,                 
--     p.name,               
--     p.jyoutai,            
--     p.description,        
--     p.price,              
--     p.stock,              
--     p.created_at,         
--     m.name AS maker,      
--     c.name AS category,   
--     ca.alias_name,        -- 別名を追加（NULLの場合あり）
--     p.image_url           
-- FROM online_shop.product p
-- JOIN online_shop.maker m 
--     ON p.maker_id = m.id
-- JOIN online_shop.category c 
--     ON p.category_id = c.id
-- LEFT JOIN online_shop.category_alias ca 
--     ON p.category_id = ca.category_id;

-- -- ===== コメント定義 =====
-- COMMENT ON VIEW online_shop.product_view IS '商品一覧表示用ビュー（別名対応）';

-- COMMENT ON COLUMN online_shop.product_view.id IS '商品ID';
-- COMMENT ON COLUMN online_shop.product_view.name IS '商品名';
-- COMMENT ON COLUMN online_shop.product_view.jyoutai IS '状態（新品・中古）';
-- COMMENT ON COLUMN online_shop.product_view.description IS '商品説明';
-- COMMENT ON COLUMN online_shop.product_view.price IS '価格';
-- COMMENT ON COLUMN online_shop.product_view.stock IS '在庫数';
-- COMMENT ON COLUMN online_shop.product_view.created_at IS '作成日時';
-- COMMENT ON COLUMN online_shop.product_view.maker IS 'メーカー名';
-- COMMENT ON COLUMN online_shop.product_view.category IS '商品カテゴリ';
-- COMMENT ON COLUMN online_shop.product_view.alias_name IS 'カテゴリ別名';
-- COMMENT ON COLUMN online_shop.product_view.image_url IS '画像URL';


