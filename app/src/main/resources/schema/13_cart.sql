CREATE TABLE online_shop.cart (
    id SERIAL PRIMARY KEY,
    product_id INT NOT NULL UNIQUE,        -- 商品ID（外部キー, ユニーク制約）
    quantity INT DEFAULT 1,                -- 数量
    added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_cart_product FOREIGN KEY (product_id) REFERENCES online_shop.product(id)
);


COMMENT ON TABLE online_shop.cart IS '簡易カートテーブル（ユーザー無し、一人用）';
COMMENT ON COLUMN online_shop.cart.id IS 'カートID';
COMMENT ON COLUMN online_shop.cart.product_id IS '商品ID';
COMMENT ON COLUMN online_shop.cart.quantity IS '数量';
COMMENT ON COLUMN online_shop.cart.added_at IS '追加日時';
