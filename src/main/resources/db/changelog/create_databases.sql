CREATE TYPE task_status AS ENUM ('Not Done', 'In Progress', 'Done');

create table if not exists public.roles (
                                            id serial primary key ,
                                            name varchar(50) not null unique
);

alter table public.roles
    owner to postgres;

insert into public.roles (name)
values ('Root'), ('Regular')
on conflict (name) do nothing ;

create table if not exists public.user
(
    id       uuid default gen_random_uuid() not null
        primary key,
    username varchar(255)                   not null
        unique,
    password varchar(255)                   not null,
    email    varchar(255)                   not null
        unique
);

alter table public.user
    owner to postgres;


create table if not exists public.user_roles (
     id      serial primary key ,
     user_id uuid not null
         constraint fk_user
             references public.user (id),
     role_id int not null
         constraint fk_role
             references public.roles (id),
     constraint unique_user_role unique (user_id, role_id)
);

alter table public.user_roles
    owner to postgres;

create table if not exists public.tasks
(
    id          serial
    primary key,
    title       varchar(255) not null,
    description text,
    status      varchar(50)
    constraint tasks_status_check
    check ((status)::text = ANY
((ARRAY ['Not Done'::character varying, 'In Progress'::character varying, 'Done'::character varying])::text[])),
    start_date  date         not null,
    end_date    date,
    user_id     uuid         not null
    constraint fk_user
    references public.user
    );

alter table public.tasks
    owner to postgres;



    