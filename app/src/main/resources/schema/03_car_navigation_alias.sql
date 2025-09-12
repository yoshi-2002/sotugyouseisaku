DROP TABLE IF EXISTS online_shop.car_navigation_alias;
CREATE TABLE online_shop.car_navigation_alias (
    id SERIAL PRIMARY KEY,
    alias VARCHAR(255) NOT NULL
);

COMMENT ON TABLE online_shop.car_navigation_alias IS 'カーナビ略称マスタ';
COMMENT ON COLUMN online_shop.car_navigation_alias.id IS '略称ID';
COMMENT ON COLUMN online_shop.car_navigation_alias.alias IS '商品略称（検索用）';
