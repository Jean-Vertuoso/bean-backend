INSERT INTO tb_category(name) VALUES ('Alimentos');
INSERT INTO tb_category(name) VALUES ('Ferramentas');
INSERT INTO tb_category(name) VALUES ('Fertilizantes');
INSERT INTO tb_category(name) VALUES ('Rações para aves');
INSERT INTO tb_category(name) VALUES ('Rações para cães');
INSERT INTO tb_category(name) VALUES ('Rações para equinos');
INSERT INTO tb_category(name) VALUES ('Rações para gatos');
INSERT INTO tb_category(name) VALUES ('Sementes');
INSERT INTO tb_category(name) VALUES ('Solúveis');
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_product(name, brand, price, bar_code, img_url, packaging_type, unit_of_measure) VALUES ('PURINA Pro Plan Ração Cães Adultos Médios Pro Plan Frango 15Kg', 'Purina Pro Plan', 299.99, '7891234567890', 'https://m.media-amazon.com/images/I/71TeDXUSKdL._AC_SL1500_.jpg', 'BAG', 'UNIT');
INSERT INTO tb_product(name, brand, price, bar_code, img_url, packaging_type, unit_of_measure) VALUES ('Ração Royal Canin Feline Gastro Intestinal 4Kg', 'ROYAL CANIN', 302.78, '7896543210125', 'https://m.media-amazon.com/images/I/51XQFG1VUYL._AC_SL1200_.jpg', 'BAG', 'UNIT');
INSERT INTO tb_product(name, brand, price, bar_code, img_url, packaging_type, unit_of_measure) VALUES ('Megazoo Ração Mix Calopsitas 900G', 'megazoo', 64.90, '7890001112228', 'https://m.media-amazon.com/images/I/71NA9ETeEkL._AC_SL1200_.jpg', 'PACKAGE', 'UNIT');
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_product_category(product_id, category_id) VALUES (1,1);
INSERT INTO tb_product_category(product_id, category_id) VALUES (2,2);
INSERT INTO tb_product_category(product_id, category_id) VALUES (3,4);
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_inventory(quantity, minimum_quantity, total_value, last_updated, product_id) VALUES (26, 5, 8999.7, '2025-04-14T14:22:22', 1);
INSERT INTO tb_inventory(quantity, minimum_quantity, total_value, last_updated, product_id) VALUES (27, 5, 8175.06, '2025-04-14T14:22:22', 2);
INSERT INTO tb_inventory(quantity, minimum_quantity, total_value, last_updated, product_id) VALUES (28, 5, 1817.2, '2025-04-14T10:34:22', 3);
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_user(name, email, password) VALUES ('Usuario Admin', 'admin@admin.com', '$2a$10$wCLSve/wRNhOBCzIN87HqeBzzvyzd7RLokA7fWTBnrExzWW/zpfc.');
INSERT INTO tb_user(name, email, password) VALUES ('Jean da Rocha Vertuoso', 'jean@gmail.com', '$2a$10$wCLSve/wRNhOBCzIN87HqeBzzvyzd7RLokA7fWTBnrExzWW/zpfc.');
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_role(authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role(authority) VALUES ('ROLE_OPERATOR');
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_user_role(user_id, role_id) VALUES (1,1);
INSERT INTO tb_user_role(user_id, role_id) VALUES (1,2);
INSERT INTO tb_user_role(user_id, role_id) VALUES (2,2);
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_client(name, birth_date, document_type, document_number, email) VALUES ('João da Silva', '1974-10-22', 'CPF', '85214467052', 'joao@gmail.com');
INSERT INTO tb_client(name, birth_date, document_type, document_number, email) VALUES ('ONG Amigo dos animais', '2002-08-03', 'CNPJ', '56366038000137', 'ongamigodosanimais@gmail.com');
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_client_phones(area_code, number, client_id) VALUES ('55', '969489371', 1);
INSERT INTO tb_client_phones(area_code, number, client_id) VALUES ('41', '969165401', 1);
INSERT INTO tb_client_phones(area_code, number, client_id) VALUES ('48', '981695657', 2);
INSERT INTO tb_client_phones(area_code, number, client_id) VALUES ('38', '992134343', 2);
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_client_addresses(street, number, complement, neighborhood, city, state, postal_code, client_id) VALUES ('Avenida José Antônio de Oliveira Neto', '182', 'Casa', 'Centro', 'Araricá', 'RS', '93880970', 1);
INSERT INTO tb_client_addresses(street, number, complement, neighborhood, city, state, postal_code, client_id) VALUES ('Avenida Willian Davids', 'S/N', 'Ap. 182', 'Marquês dos Reis', 'Marquês dos Reis', 'PR', '86409970', 1);
INSERT INTO tb_client_addresses(street, number, complement, neighborhood, city, state, postal_code, client_id) VALUES ('Rua Waldi Voss', '225', 'Casa marrom', 'Zona Industrial Norte', 'Joinville', 'SC', '89219680', 2);
INSERT INTO tb_client_addresses(street, number, complement, neighborhood, city, state, postal_code, client_id) VALUES ('Rua Um', 'S/N', 'Segundo prédio Ap. 302', 'São Francisco', 'Ouro Branco', 'MG', '36420979', 2);
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_cash_session(opening_timestamp, closing_timestamp, opening_amount, closing_amount, expected_amount, notes, closed, operator_id) VALUES (TIMESTAMP WITH TIME ZONE '2025-04-14T08:00:00-03:00', TIMESTAMP WITH TIME ZONE '2025-04-14T18:00:00-03:00', 10000.00, 12238.10, 12238.10, 'Caixa fechado conforme esperado', true, 1);
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_sale(sale_timestamp, total_value, total_discount, payment_method, client_id, operator_id, cash_session_id) VALUES (TIMESTAMP WITH TIME ZONE '2025-04-14T10:34:22-03:00', 908.34, 0.0, 3, 1, 1, 1);
INSERT INTO tb_sale(sale_timestamp, total_value, total_discount, payment_method, client_id, operator_id, cash_session_id) VALUES (TIMESTAMP WITH TIME ZONE '2025-04-14T14:22:22-03:00', 2108.30, 105.42, 6, 2, 1, 1);
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_sale_item(sale_id, product_id, quantity, unit_price, discount) VALUES (1, 3, 2, 64.90, 0);
INSERT INTO tb_sale_item(sale_id, product_id, quantity, unit_price, discount) VALUES (2, 1, 4, 299.99, 0);
INSERT INTO tb_sale_item(sale_id, product_id, quantity, unit_price, discount) VALUES (2, 2, 3, 302.78, 0);
