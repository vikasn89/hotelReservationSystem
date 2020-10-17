CREATE TABLE hotel.room_types
(
    id bigint,
    room_type character varying(25),
    price_per_night bigint,
    CONSTRAINT room_type_prmry_id PRIMARY KEY (id),
    CONSTRAINT room_type_unq_index UNIQUE (room_type)
);

ALTER TABLE hotel.room_types
    OWNER to admin;
    
    CREATE SEQUENCE hotel.ROOM_TYPE_SEQ
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 100;

ALTER SEQUENCE hotel.ROOM_TYPE_SEQ
    OWNER TO admin;
    
 CREATE TABLE hotel.room
(
    id bigint,
    room_no character varying(10) NOT NULL,
    room_type_id bigint NOT NULL,
    is_available boolean,
    PRIMARY KEY (id),
    CONSTRAINT room_unq_index UNIQUE (room_no)
);

ALTER TABLE hotel.room
    OWNER to admin;
    
    CREATE SEQUENCE hotel."ROOM_SEQ"
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 100;

ALTER SEQUENCE hotel."ROOM_SEQ"
    OWNER TO admin;
    
    ALTER TABLE hotel.room
    ADD CONSTRAINT room_type_foreign_index FOREIGN KEY (room_type_id)
    REFERENCES hotel.room_types (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
CREATE INDEX fki_room_type_foreign_index
    ON hotel.room(room_type_id);
    
    CREATE TABLE hotel.customer
(
    id bigint,
    username character varying(15) NOT NULL,
    password character varying(1000) NOT NULL,
    first_name character varying(10),
    last_name character varying(10),
    email_id character varying(25) NOT NULL,
    contact_no character varying(12) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT customer_username_unq_index UNIQUE (username),
    CONSTRAINT customer_email_unq_index UNIQUE (email_id)
);

ALTER TABLE hotel.customer
    OWNER to admin;
    
    CREATE TABLE hotel.reservations
(
    id bigint,
    reservation_no character varying(10) NOT NULL,
    room_id bigint NOT NULL,
    no_of_guests bigint NOT NULL,
    check_in_dt date NOT NULL,
    check_out_dt date,
    PRIMARY KEY (id),
    CONSTRAINT room_foreign_index FOREIGN KEY (room_id)
        REFERENCES None (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE hotel.reservations
    OWNER to admin;