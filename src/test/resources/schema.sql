CREATE TABLE transportation_form
(
    id             BIGSERIAL PRIMARY KEY,
    userid         VARCHAR(320) NOT NULL,
    username       VARCHAR(50)  NOT NULL,
    origin         VARCHAR(20),
    destination    VARCHAR(20),
    one_way        BOOLEAN,
    expense        int,
    departure_date date,
    is_check       boolean,
    created_at     timestamp
);