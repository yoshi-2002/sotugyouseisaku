DROP TABLE IF EXISTS online_shop.category;
CREATE TABLE online_shop.category (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

COMMENT ON TABLE online_shop.category IS 'カテゴリ マスタ';
COMMENT ON COLUMN online_shop.category.id IS 'カテゴリID';
COMMENT ON COLUMN online_shop.category.name IS 'カテゴリ名';
