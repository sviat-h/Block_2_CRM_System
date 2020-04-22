INSERT INTO crm_system_db.public.accounts (id, username, email, password, role)
VALUES (1, 'admin', 'admin@gmail.com', '21232f297a57a5a743894ae4a801fc3', 'ADMIN');
INSERT INTO crm_system_db.public.users (id, first_name, last_name, age, phone, account_id)
VALUES (1, 'Admin', 'Adminovich', '100', '+380000000000', 1);