create table parking_space(
    id           uuid primary key default gen_random_uuid(),
    number       smallint not null,
    floor_number smallint not null,
    free         boolean not null
);

insert into parking_space(number, floor_number, free)
values
    (1, 1, false),
    (2, 1, false),
    (3, 1, false),
    (4, 1, false),
    (1, 2, true),
    (2, 2, true),
    (3, 2, true),
    (4, 2, true);