CREATE TABLE online_shop.buy (
    id SERIAL PRIMARY KEY,
    product_id INT NOT NULL UNIQUE,          -- 商品ID（外部キー, ユニーク制約を追加）
    quantity INT DEFAULT 1,                  -- 購入数量
    bought_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_buy_product FOREIGN KEY (product_id) REFERENCES online_shop.product(id)
);

-- コメント
COMMENT ON TABLE online_shop.buy IS '購入履歴テーブル（簡易版、一人用）';
COMMENT ON COLUMN online_shop.buy.id IS '購入ID';
COMMENT ON COLUMN online_shop.buy.product_id IS '商品ID';
COMMENT ON COLUMN online_shop.buy.quantity IS '購入数量';
COMMENT ON COLUMN online_shop.buy.bought_at IS '購入日時';