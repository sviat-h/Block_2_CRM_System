INSERT INTO crm_system_db.public.accounts (id, username, email, password, confirm_password, role)
VALUES (1, 'admin', 'admin@gmail.com', 'admin', 'admin', 'ADMIN');
INSERT INTO crm_system_db.public.users (id, first_name, last_name, age, phone, account_id)
VALUES (1, 'Admin', 'Adminovich', '100', '+380000000000', 1);