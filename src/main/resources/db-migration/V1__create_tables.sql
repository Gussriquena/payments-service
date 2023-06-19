CREATE TABLE public.card_brand(
	id_brand BIGSERIAL NOT NULL,
	name VARCHAR(100),
	created_at TIMESTAMP,
	updated_at TIMESTAMP,
	CONSTRAINT card_pkey PRIMARY KEY (id_brand)
);

CREATE TABLE public.transaction_type(
	id_transaction_type BIGSERIAL NOT NULL,
	name VARCHAR(100),
	created_at TIMESTAMP,
	updated_at TIMESTAMP,
	CONSTRAINT id_transaction_type_pkey PRIMARY KEY (id_transaction_type)
);

CREATE TABLE public.payment_transaction(
	id_transaction BIGSERIAL NOT NULL,
	price DECIMAL(10,2),
	date_time_transaction TIMESTAMP,
	id_card_brand_FK INT8,
	id_transaction_type_FK INT8,
	CONSTRAINT transaction_pkey PRIMARY KEY (id_transaction),
	CONSTRAINT card_brand_pkey FOREIGN KEY (id_card_brand_FK) REFERENCES card_brand (id_brand),
	CONSTRAINT transaction_type_pkey FOREIGN KEY (id_transaction_type_FK) REFERENCES transaction_type (id_transaction_type)
);