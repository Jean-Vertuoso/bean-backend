INSERT INTO tb_categoria(nome) VALUES ('Rações para cães');
INSERT INTO tb_categoria(nome) VALUES ('Rações para gatos');
INSERT INTO tb_categoria(nome) VALUES ('Rações para equinos');
INSERT INTO tb_categoria(nome) VALUES ('Rações para aves');
INSERT INTO tb_categoria(nome) VALUES ('Sementes');
INSERT INTO tb_categoria(nome) VALUES ('Fertilizantes');
INSERT INTO tb_categoria(nome) VALUES ('Ferramentas');
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_produto (nome, marca, tipo_embalagem, preco, img_url) VALUES ('PURINA Pro Plan Ração Cães Adultos Médios Pro Plan Frango 15Kg', 'Purina Pro Plan', 13, 299.99, '');
INSERT INTO tb_produto (nome, marca, tipo_embalagem, preco, img_url) VALUES ('Ração Royal Canin Feline Gastro Intestinal 4Kg', 'ROYAL CANIN', 13, 302.78, '');
INSERT INTO tb_produto (nome, marca, tipo_embalagem, preco, img_url) VALUES ('Megazoo Ração Mix Calopsitas 900G', 'megazoo', 10, 64.90, '');
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (1,1)
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (2,2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (3,4);
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_estoque (quantidade, quantidade_minima, valor_total, ultima_atualizacao, produto_id) VALUES (26, 5, 8999.7, '2025-04-14T14:22:22', 1);
INSERT INTO tb_estoque (quantidade, quantidade_minima, valor_total, ultima_atualizacao, produto_id) VALUES (27, 5, 8175.06, '2025-04-14T14:22:22', 2);
INSERT INTO tb_estoque (quantidade, quantidade_minima, valor_total, ultima_atualizacao, produto_id) VALUES (28, 5, 1817.2, '2025-04-14T10:34:22', 3);
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_usuario (nome, email, senha) VALUES ('Jean da Rocha Vertuoso', 'jean@gmail.com', '$2a$10$wCLSve/wRNhOBCzIN87HqeBzzvyzd7RLokA7fWTBnrExzWW/zpfc.');
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_funcao (funcao) VALUES ('ADMIN');
INSERT INTO tb_funcao (funcao) VALUES ('OPERADOR');
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_usuario_funcao (usuario_id, funcao_id) VALUES (1,1);
INSERT INTO tb_usuario_funcao (usuario_id, funcao_id) VALUES (1,2);
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_cliente (nome, data_nascimento, tipo_documento, numero_documento, email) VALUES ('João da Silva', '1974-10-22', 2, '85214467052', 'joao@gmail.com');
INSERT INTO tb_cliente (nome, data_nascimento, tipo_documento, numero_documento, email) VALUES ('ONG Amigo dos animais', '2002-08-03', 1, '56366038000137', 'ongamigodosanimais@gmail.com');
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_cliente_telefones (ddd, numero, client_id) VALUES ('55', '969489371', 1);
INSERT INTO tb_cliente_telefones (ddd, numero, client_id) VALUES ('41', '969165401', 1);
INSERT INTO tb_cliente_telefones (ddd, numero, client_id) VALUES ('48', '981695657', 2);
INSERT INTO tb_cliente_telefones (ddd, numero, client_id) VALUES ('38', '992134343', 2);
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_cliente_enderecos (rua, numero, bairro, cidade, estado, cep, client_id) VALUES ('Avenida José Antônio de Oliveira Neto', '182', 'Centro', 'Araricá', 'RS', '93880970', 1);
INSERT INTO tb_cliente_enderecos (rua, numero, bairro, cidade, estado, cep, client_id) VALUES ('Avenida Willian Davids', 'S/N', 'Marquês dos Reis', 'Marquês dos Reis', 'PR', '86409970', 1);
INSERT INTO tb_cliente_enderecos (rua, numero, bairro, cidade, estado, cep, client_id) VALUES ('Rua Waldi Voss', '225', 'Zona Industrial Norte', 'Joinville', 'SC', '89219680', 2);
INSERT INTO tb_cliente_enderecos (rua, numero, bairro, cidade, estado, cep, client_id) VALUES ('Rua Um', 'S/N', 'São Francisco', 'Ouro Branco', 'MG', '36420979', 2);
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_sessao_de_caixa (data_hora_abertura, data_hora_fechamento, valor_inicial, valor_final, valor_esperado, observacoes, encerrada, operador_id) VALUES (TIMESTAMP WITH TIME ZONE '2025-04-14T08:00:00-03:00', TIMESTAMP WITH TIME ZONE '2025-04-14T18:00:00-03:00', 10000.00, 12238.10, 12238.10, 'Caixa fechado conforme esperado', true, 1);
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_venda (data_hora_venda, valor_total, desconto_total, forma_pagamento, cliente_id, operador_id, sessao_de_caixa_id) VALUES (TIMESTAMP WITH TIME ZONE '2025-04-14T10:34:22-03:00', 908.34, 0.0, 3, 1, 1, 1);
INSERT INTO tb_venda (data_hora_venda, valor_total, desconto_total, forma_pagamento, cliente_id, operador_id, sessao_de_caixa_id) VALUES (TIMESTAMP WITH TIME ZONE '2025-04-14T14:22:22-03:00', 2108.30, 105.42, 6, 2, 1, 1);
------------------------------------------------------------------------------------------------------------------
INSERT INTO tb_item_venda (venda_id, produto_id, quantidade, preco_unitario, desconto) VALUES (1, 3, 2, 64.90, 0);
INSERT INTO tb_item_venda (venda_id, produto_id, quantidade, preco_unitario, desconto) VALUES (2, 1, 4, 299.99, 0);
INSERT INTO tb_item_venda (venda_id, produto_id, quantidade, preco_unitario, desconto) VALUES (2, 2, 3, 302.78, 0);