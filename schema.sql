create database metrics;


CREATE TABLE person_resolution_service_metrics (
	id bigserial NOT NULL,
	endpoint varchar(255) NULL,
	errors int4 NULL,
	household_matches int4 NULL,
	individual_matches int4 NULL,
	non_matches int4 NULL,
	"timestamp" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT person_resolution_service_metrics_pkey PRIMARY KEY (id)
);

CREATE TABLE batch_loader_metrics (
	id bigserial NOT NULL,
	file_created timestamp NULL,
	file_name varchar(255) NULL,
	file_picked_up timestamp NULL,
	file_processed timestamp NULL,
	number_of_records int4 NULL,
	"timestamp" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT batch_loader_metrics_pkey PRIMARY KEY (id)
);