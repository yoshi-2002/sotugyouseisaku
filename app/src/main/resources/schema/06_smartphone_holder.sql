DROP TABLE IF EXISTS online_shop.smartphone_holder;
CREATE TABLE online_shop.smartphone_holder (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    alias_id INT, -- 外部キーで略称マスタと接続
    jyoutai VARCHAR(10) NOT NULL,
    description TEXT,
    price NUMERIC(10,2) NOT NULL,
    stock INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    maker VARCHAR(50),
    category VARCHAR(50)
);

COMMENT ON TABLE online_shop.smartphone_holder IS 'スマホホルダー商品テーブル';
COMMENT ON COLUMN online_shop.smartphone_holder.id IS '商品ID';
COMMENT ON COLUMN online_shop.smartphone_holder.name IS '商品名';
COMMENT ON COLUMN online_shop.smartphone_holder.jyoutai IS '状態（新品・中古）';
COMMENT ON COLUMN online_shop.smartphone_holder.description IS '商品説明';
COMMENT ON COLUMN online_shop.smartphone_holder.price IS '価格';
COMMENT ON COLUMN online_shop.smartphone_holder.stock IS '在庫数';
COMMENT ON COLUMN online_shop.smartphone_holder.created_at IS '作成日時';
COMMENT ON COLUMN online_shop.car_navigation.maker IS 'メーカー名';
COMMENT ON COLUMN online_shop.car_navigation.category IS '商品カテゴリ';
COMMENT ON COLUMN online_shop.car_navigation.image_url IS '画像URL';