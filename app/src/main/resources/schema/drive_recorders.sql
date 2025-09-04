DROP TABLE IF EXISTS online_shop.drive_recorders;
CREATE TABLE online_shop.drive_recorders (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price NUMERIC(10,2) NOT NULL,
    stock INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON TABLE online_shop.drive_recorders IS 'ドライブレコーダー商品テーブル';
COMMENT ON COLUMN online_shop.drive_recorders.id IS '商品ID';
COMMENT ON COLUMN online_shop.drive_recorders.name IS '商品名';
COMMENT ON COLUMN online_shop.drive_recorders.description IS '商品説明';
COMMENT ON COLUMN online_shop.drive_recorders.price IS '価格';
COMMENT ON COLUMN online_shop.drive_recorders.stock IS '在庫数';
COMMENT ON COLUMN online_shop.drive_recorders.created_at IS '作成日時';