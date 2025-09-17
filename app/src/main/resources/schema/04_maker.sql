DROP TABLE IF EXISTS online_shop.maker;
CREATE TABLE online_shop.maker (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

COMMENT ON TABLE online_shop.maker IS 'メーカー マスタ';
COMMENT ON COLUMN online_shop.maker.id IS 'メーカーID';
COMMENT ON COLUMN online_shop.maker.name IS 'メーカー名';
