DROP TABLE IF EXISTS online_shop.smartphone_holder_alias;
CREATE TABLE online_shop.smartphone_holder_alias (
    id SERIAL PRIMARY KEY,
    alias VARCHAR(255) NOT NULL
);

COMMENT ON TABLE online_shop.smartphone_holder_alias IS 'スマホホルダー略称マスタ';
COMMENT ON COLUMN online_shop.smartphone_holder_alias.id IS '略称ID';
COMMENT ON COLUMN online_shop.smartphone_holder_alias.alias IS '商品略称（検索用）';
