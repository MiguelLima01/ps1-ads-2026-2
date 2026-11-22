ALTER TABLE cars
    RENAME COLUMN year TO year_manufacture;

ALTER TABLE cars
    RENAME COLUMN price TO selling_price;

ALTER TABLE cars
    ALTER COLUMN selling_price TYPE NUMERIC(12, 2);

ALTER TABLE cars
    ADD COLUMN color TEXT;

UPDATE cars
SET color = 'Não informado'
WHERE color IS NULL;

ALTER TABLE cars
    ALTER COLUMN color SET NOT NULL;

ALTER TABLE cars
    ADD COLUMN imported BOOLEAN;

UPDATE cars
SET imported = FALSE
WHERE imported IS NULL;

ALTER TABLE cars
    ALTER COLUMN imported SET NOT NULL;

ALTER TABLE cars
    ADD COLUMN plates TEXT;

UPDATE cars
SET plates = 'LEGACY-' || id::text
WHERE plates IS NULL;

ALTER TABLE cars
    ALTER COLUMN plates SET NOT NULL;

ALTER TABLE cars
    ADD CONSTRAINT uq_cars_plates UNIQUE (plates);

ALTER TABLE cars
    ADD COLUMN selling_date DATE;
