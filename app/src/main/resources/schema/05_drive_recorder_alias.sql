DROP TABLE IF EXISTS online_shop.drive_recorder_alias;
CREATE TABLE online_shop.drive_recorder_alias (
    id SERIAL PRIMARY KEY,
    alias VARCHAR(255) NOT NULL
);

COMMENT ON TABLE online_shop.drive_recorder_alias IS 'ドライブレコーダー略称マスタ';
COMMENT ON COLUMN online_shop.drive_recorder_alias.id IS '略称ID';
COMMENT ON COLUMN online_shop.drive_recorder_alias.alias IS '商品略称（検索用）';
