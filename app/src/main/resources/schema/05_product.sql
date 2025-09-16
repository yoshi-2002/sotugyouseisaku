DROP TABLE IF EXISTS online_shop.product;
CREATE TABLE online_shop.product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    jyoutai VARCHAR(10) NOT NULL,
    description TEXT,
    price NUMERIC(10,2) NOT NULL,
    stock INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    maker_id INT NOT NULL,
    category_id INT NOT NULL,
    image_url VARCHAR(255),
    CONSTRAINT fk_product_maker FOREIGN KEY (maker_id) REFERENCES online_shop.maker(id),
    CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES online_shop.category(id)
);

COMMENT ON TABLE online_shop.product IS '商品テーブル（統合版）';
COMMENT ON COLUMN online_shop.product.id IS '商品ID';
COMMENT ON COLUMN online_shop.product.name IS '商品名';
COMMENT ON COLUMN online_shop.product.jyoutai IS '状態（新品・中古）';
COMMENT ON COLUMN online_shop.product.description IS '商品説明';
COMMENT ON COLUMN online_shop.product.price IS '価格';
COMMENT ON COLUMN online_shop.product.stock IS '在庫数';
COMMENT ON COLUMN online_shop.product.created_at IS '作成日時';
COMMENT ON COLUMN online_shop.product.maker_id IS 'メーカーID（外部キー）';
COMMENT ON COLUMN online_shop.product.category_id IS 'カテゴリID（外部キー）';
COMMENT ON COLUMN online_shop.product.image_url IS '画像URL';
