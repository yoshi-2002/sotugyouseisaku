DROP TABLE IF EXISTS online_shop.smartphone_holders;
CREATE TABLE online_shop.smartphone_holders (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price NUMERIC(10,2) NOT NULL,
    stock INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON TABLE online_shop.smartphone_holders IS 'スマホホルダー商品テーブル';
COMMENT ON COLUMN online_shop.smartphone_holders.id IS '商品ID';
COMMENT ON COLUMN online_shop.smartphone_holders.name IS '商品名';
COMMENT ON COLUMN online_shop.smartphone_holders.description IS '商品説明';
COMMENT ON COLUMN online_shop.smartphone_holders.price IS '価格';
COMMENT ON COLUMN online_shop.smartphone_holders.stock IS '在庫数';
COMMENT ON COLUMN online_shop.smartphone_holders.created_at IS '作成日時';