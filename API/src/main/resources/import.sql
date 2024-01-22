
INSERT INTO tb_categoty (nome) VALUES ('Terror');
INSERT INTO tb_categoty (nome) VALUES ('Ação');
INSERT INTO tb_categoty (nome) VALUES ('RPG');
INSERT INTO tb_categoty (nome) VALUES ('Estratégia');
INSERT INTO tb_categoty (nome) VALUES ('Esportes');
INSERT INTO tb_categoty (nome) VALUES ('Aventura');
INSERT INTO tb_categoty (nome) VALUES ('Simulação');

INSERT INTO tb_game (name, review, grade, status) VALUES ('Resident evil 4', 'MUITO BOM', 9.0, 'FINALIZADO');
INSERT INTO tb_game (name, review, grade, status) VALUES ('Pokemon Emerald', 'Melhor jogo do pokemon', 8.0, 'FINALIZADO');
INSERT INTO tb_game (name, review, grade, status) VALUES ('The last of us', 'Critica generica', 9.0, 'FINALIZADO');

INSERT INTO tb_game_category ( game_id, category_id) VALUES (1, 1);
INSERT INTO tb_game_category ( game_id, category_id) VALUES (1, 2);
INSERT INTO tb_game_category ( game_id, category_id) VALUES (2, 3);
INSERT INTO tb_game_category ( game_id, category_id) VALUES (2, 6);
INSERT INTO tb_game_category ( game_id, category_id) VALUES (3, 1);
INSERT INTO tb_game_category ( game_id, category_id) VALUES (3, 2);
INSERT INTO tb_game_category ( game_id, category_id) VALUES (3, 6);

INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('filipe', 'lima', 'fhl@gmail.com', '123456');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('adm', 'lima', 'adm@gmail.com', '123456');


INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role(user_id, role_id) VALUES (1,1);
INSERT INTO tb_user_role(user_id, role_id) VALUES (2,1);
INSERT INTO tb_user_role(user_id, role_id) VALUES (2,2);


