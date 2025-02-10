create table parking_space(
    id           uuid primary key default gen_random_uuid(),
    number       smallint not null,
    floor_number smallint not null,
    free         boolean not null
)