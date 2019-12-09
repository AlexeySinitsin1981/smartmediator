-- Test data.

INSERT INTO org_statuses ("code", "name")
VALUES ('new', 'Новая'),
       ('wait', 'Ожидает'),
       ('confirm', 'Подтверждена'),
       ('ban', 'Забанена');

INSERT INTO user_statuses ("code", "name")
VALUES ('new', 'Новая'),
       ('wait', 'Ожидает'),
       ('confirm', 'Подтверждена'),
       ('ban', 'Забанена');

INSERT INTO roles ("code", "name")
VALUES ('user', 'Пользователь'),
       ('admin', 'Администратор');

INSERT INTO order_statuses ("code", "name")
VALUES ('draft', 'Черновик'),
       ('new', 'Новый'),
       ('cancel', 'Отменен'),
       ('taken', 'Подтвержден'),
       ('shipped', 'Отправлен'),
       ('delivered', 'Доставлен'),
       ('lost', 'Потерян');

INSERT INTO bids_statuses ("code", "name")
VALUES ('new', 'Новая'),
       ('confirmed', 'Подтверждена'),
       ('denied', 'Отклонена'),
       ('refresh', 'Обновлена');

INSERT INTO delivery_types ("code", "name")
VALUES ('pickup', 'Самовывоз'),
       ('supply', 'Доставка');

INSERT INTO public.users(
    id, email, password_hash, full_name, status, role)
VALUES (
           '0848bc4f-b8df-4e73-9551-e3e168fee181',
           'email1@mail.ru',
           'password1',
           'name1',
           (select id from user_statuses where code = 'new'),
           (select id from roles where code = 'user'));

INSERT INTO public.users(
    id, email, password_hash, full_name, status, role)
VALUES (
           '0848bc4f-b8df-4e73-9551-e3e168fee182',
           'email2@mail.ru',
           'password2',
           'name2',
           (select id from user_statuses where code = 'new'),
           (select id from roles where code = 'user'));

INSERT INTO public.users(
    id, email, password_hash, full_name, status, role)
VALUES (
           '0848bc4f-b8df-4e73-9551-e3e168fee183',
           'email3@mail.ru',
           'password3',
           'name3',
           (select id from user_statuses where code = 'new'),
           (select id from roles where code = 'user'));

INSERT INTO public.organizations(
    id, full_name, name, inn, status, address)
VALUES (
           '1848bc4f-b8df-4e73-9551-e3e168fee181',
           'OOO Мясо-молочный комбинат им. Артамонова',
           'ММК',
           '111-222-333-444',
           (select id from org_statuses where code = 'new'),
           '420500, г. Казань, ул. Загородная, д. 12');

INSERT INTO public.users_organizations(user_id, org_id)
VALUES ('0848bc4f-b8df-4e73-9551-e3e168fee181', '1848bc4f-b8df-4e73-9551-e3e168fee181');

INSERT INTO public.users_organizations(user_id, org_id)
VALUES ('0848bc4f-b8df-4e73-9551-e3e168fee182', '1848bc4f-b8df-4e73-9551-e3e168fee181');

INSERT INTO public.organizations(
    id, full_name, name, inn, status, address)
VALUES (
           '1848bc4f-b8df-4e73-9551-e3e168fee182',
           'ЗАО Мебельная фабрика "Эврика"',
           'Эврика',
           '111-222-333-445',
           (select id from org_statuses where code = 'new'),
           '420500, г. Казань, ул. Мебельная, д. 47');

INSERT INTO public.users_organizations(user_id, org_id)
VALUES ('0848bc4f-b8df-4e73-9551-e3e168fee183', '1848bc4f-b8df-4e73-9551-e3e168fee182');

INSERT INTO public.sellers(id, org_id)
VALUES ('2848bc4f-b8df-4e73-9551-e3e168fee181', '1848bc4f-b8df-4e73-9551-e3e168fee181');

INSERT INTO public.sellers(id, org_id)
VALUES ('2848bc4f-b8df-4e73-9551-e3e168fee182', '1848bc4f-b8df-4e73-9551-e3e168fee182');

INSERT INTO public.price_patterns(id, code, name, seller_id, parent_id, deleted)
VALUES (
            '2008bc4f-b8df-4e73-9551-e3e168fee181',
            'price_pattern_code1',
            'price_pattern_name1',
            '2848bc4f-b8df-4e73-9551-e3e168fee181',
            NULL,
            false
        );

INSERT INTO public.price_patterns(id, code, name, seller_id, parent_id, deleted)
         VALUES (
                    '2018bc4f-b8df-4e73-9551-e3e168fee181',
                    'price_pattern_code2',
                    'price_pattern_name2',
                        '2848bc4f-b8df-4e73-9551-e3e168fee181',
                    '2008bc4f-b8df-4e73-9551-e3e168fee181',
                    false
                );

INSERT INTO public.price_patterns(id, code, name, seller_id, parent_id, deleted)
         VALUES (
                    '2028bc4f-b8df-4e73-9551-e3e168fee181',
                    'price_pattern_code3',
                    'price_pattern_name3',
                        '2848bc4f-b8df-4e73-9551-e3e168fee181',
                    '2018bc4f-b8df-4e73-9551-e3e168fee181',
                    false
                );

INSERT INTO public.price_patterns(id, code, name, seller_id, parent_id, deleted)
         VALUES (
                    '2038bc4f-b8df-4e73-9551-e3e168fee181',
                    'price_pattern_code4',
                    'price_pattern_name4',
                        '2848bc4f-b8df-4e73-9551-e3e168fee181',
                    '2028bc4f-b8df-4e73-9551-e3e168fee181',
                    false
                );

INSERT INTO public.price_patterns(id, code, name, seller_id, parent_id, deleted)
         VALUES (
                    '2048bc4f-b8df-4e73-9551-e3e168fee181',
                    'price_pattern_code5',
                    'price_pattern_name5',
                        '2848bc4f-b8df-4e73-9551-e3e168fee181',
                    '2028bc4f-b8df-4e73-9551-e3e168fee181',
                    false
                );

INSERT INTO public.price_patterns(id, code, name, seller_id, parent_id, deleted)
VALUES (
           '2068bc4f-b8df-4e73-9551-e3e168fee181',
           'price_pattern_code6',
           'price_pattern_name6',
               '2848bc4f-b8df-4e73-9551-e3e168fee181',
           '2038bc4f-b8df-4e73-9551-e3e168fee181',
           false
       );