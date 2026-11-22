ALTER TABLE cars
    ADD COLUMN customer_id BIGINT;

ALTER TABLE cars
    ADD CONSTRAINT fk_cars_customer
    FOREIGN KEY (customer_id) REFERENCES customers (id);
