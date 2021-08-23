insert into public.orders (id, total_price, user_id, status, create_date, modify_date)
values (1, 100.01, 1, 'OPEN', '2015-07-29T19:30:40','2015-07-29T19:30:40');
insert into public.orders (id, total_price, user_id, status, create_date, modify_date)
values (2, 50.99, 2, 'OPEN', '2015-07-29T19:30:40','2015-07-29T19:30:40');
insert into public.orders (id, total_price, user_id, status, create_date, modify_date)
values (3, 1.09, 1, 'OPEN', '2020-07-29T19:30:40','2020-07-29T19:30:40');
insert into public.orders (id, total_price, user_id, status, create_date, modify_date)
values (4, 1111.09, 1, 'COMPLETED', '2020-03-29T19:30:40','2020-03-29T19:30:40');

insert into PUBLIC.users (id, first_name, last_name, login, password, email, phone, created_at, updated_at, active,
                          is_verified)
values (1,
        'user1_firstName',
        'user1_lastName',
        'user1_login',
        'user1_password',
        'user1_@email.com',
        'user1_phone',
        '1970-01-01 00:00:00-00',
        null,
        'OFF',
        'NO');

insert into PUBLIC.users (id, first_name, last_name, login, password, email, phone, created_at, updated_at, active,
                          is_verified)
values (2,
        'user2_firstName',
        'user2_lastName',
        'user2_login',
        'user2_password',
        'user2_@email.com',
        'user2_phone',
        '1970-01-01 00:00:00-00',
        null,
        'OFF',
        'NO');