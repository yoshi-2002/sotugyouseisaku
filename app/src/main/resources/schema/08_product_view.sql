DROP VIEW IF EXISTS online_shop.product_view;
CREATE VIEW online_shop.product_view AS
    SELECT c.id, c.name, COALESCE(a.alias, '') AS alias, c.jyoutai, c.description, c.price, c.stock, c.created_at, c.maker, c.category, c.image_url
    FROM online_shop.car_navigation c
    LEFT JOIN online_shop.car_navigation_alias a ON c.alias_id = a.id
UNION ALL
    SELECT s.id, s.name, COALESCE(a.alias, '') AS alias, s.jyoutai, s.description, s.price, s.stock, s.created_at, s.maker, s.category, NULL AS image_url
    FROM online_shop.smartphone_holder s
    LEFT JOIN online_shop.smartphone_holder_alias a ON s.alias_id = a.id
UNION ALL
    SELECT d.id, d.name, COALESCE(a.alias, '') AS alias, d.jyoutai, d.description, d.price, d.stock, d.created_at, d.maker, d.category, NULL AS image_url
    FROM online_shop.drive_recorder d
    LEFT JOIN online_shop.drive_recorder_alias a ON d.alias_id = a.id;

COMMENT ON VIEW online_shop.product_view IS '商品一覧表示用ビュー';
COMMENT ON COLUMN online_shop.product_view.id IS '商品ID';
COMMENT ON COLUMN online_shop.product_view.name IS '商品名';
COMMENT ON COLUMN online_shop.product_view.alias IS '商品略称（検索用）';
COMMENT ON COLUMN online_shop.product_view.jyoutai IS '状態（新品・中古）';
COMMENT ON COLUMN online_shop.product_view.description IS '商品説明';
COMMENT ON COLUMN online_shop.product_view.price IS '価格';
COMMENT ON COLUMN online_shop.product_view.stock IS '在庫数';
COMMENT ON COLUMN online_shop.product_view.created_at IS '作成日時';
COMMENT ON COLUMN online_shop.product_view.maker IS 'メーカー名';
COMMENT ON COLUMN online_shop.product_view.category IS '商品カテゴリ';
COMMENT ON COLUMN online_shop.product_view.image_url IS '画像URL';
