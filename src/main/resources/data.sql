DROP TABLE IF EXISTS item;

CREATE TABLE item
(
    item_no LONG AUTO_INCREMENT  PRIMARY KEY,
    name TEXT NOT NULL,
    amount INT NOT NULL,
    inventory_code LONG DEFAULT NULL
);

