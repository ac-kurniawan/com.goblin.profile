CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table profile
(
    id UUID not null primary key default uuid_generate_v4(),
    first_name VARCHAR(255) not null,
    last_name VARCHAR(255) not null,
    address VARCHAR(255) not null,
    country VARCHAR(255) not null,
    province VARCHAR(255) not null,
    city VARCHAR(255) not null,
    zipcode VARCHAR(255) not null,
    created_at TIMESTAMPTZ not null default NOW(),
    updated_at TIMESTAMPTZ,
   	deleted_at TIMESTAMPTZ,
    version INT not null default 0
);
