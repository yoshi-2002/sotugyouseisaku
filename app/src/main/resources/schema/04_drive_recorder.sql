DROP TABLE IF EXISTS online_shop.drive_recorder;
CREATE TABLE online_shop.drive_recorder (
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

COMMENT ON TABLE online_shop.drive_recorder IS 'ドライブレコーダー商品テーブル';
COMMENT ON COLUMN online_shop.drive_recorder.id IS '商品ID';
COMMENT ON COLUMN online_shop.drive_recorder.name IS '商品名';
COMMENT ON COLUMN online_shop.drive_recorder.jyoutai IS '状態（新品・中古）';
COMMENT ON COLUMN online_shop.drive_recorder.description IS '商品説明';
COMMENT ON COLUMN online_shop.drive_recorder.price IS '価格';
COMMENT ON COLUMN online_shop.drive_recorder.stock IS '在庫数';
COMMENT ON COLUMN online_shop.drive_recorder.created_at IS '作成日時';
COMMENT ON COLUMN online_shop.car_navigation.maker IS 'メーカー名';
COMMENT ON COLUMN online_shop.car_navigation.category IS '商品カテゴリ';
COMMENT ON COLUMN online_shop.car_navigation.image_url IS '画像URL';