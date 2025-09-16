

CREATE TABLE online_shop.category_alias (
    id SERIAL PRIMARY KEY,
    category_id INT NOT NULL,
    alias_name VARCHAR(100) NOT NULL,
    CONSTRAINT fk_category_alias_category FOREIGN KEY (category_id) REFERENCES online_shop.category(id)
);

COMMENT ON TABLE online_shop.category_alias IS 'カテゴリの別名マスタ';
COMMENT ON COLUMN online_shop.category_alias.id IS '別名ID';
COMMENT ON COLUMN online_shop.category_alias.category_id IS 'カテゴリID（外部キー）';
COMMENT ON COLUMN online_shop.category_alias.alias_name IS 'カテゴリの別名';