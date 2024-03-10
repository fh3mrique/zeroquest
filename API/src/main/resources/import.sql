
INSERT INTO tb_categoty (nome) VALUES ('Terror');
INSERT INTO tb_categoty (nome) VALUES ('Ação');
INSERT INTO tb_categoty (nome) VALUES ('RPG');
INSERT INTO tb_categoty (nome) VALUES ('Estratégia');
INSERT INTO tb_categoty (nome) VALUES ('Esportes');
INSERT INTO tb_categoty (nome) VALUES ('Aventura');
INSERT INTO tb_categoty (nome) VALUES ('Simulação');

INSERT INTO tb_platform (name) VALUES ('Playstation 1');
INSERT INTO tb_platform (name) VALUES ('Playstation 2');
INSERT INTO tb_platform (name) VALUES ('Xbox 360');
INSERT INTO tb_platform (name) VALUES ('PS4');
INSERT INTO tb_platform (name) VALUES ('PC');

INSERT INTO tb_game (name,img_url, platform_id, review, grade, status) VALUES ('Resident evil 4', 'https://cdn.thegamesdb.net/images/original/boxart/front/7801-1.jpg', 3,  'MUITO BOM', 9.0, 'FINALIZADO');
INSERT INTO tb_game (name, img_url, platform_id, review, grade, status) VALUES ('Pokemon Emerald','https://cdn.thegamesdb.net/images/original/boxart/front/2365-1.jpg', 5, 'Melhor jogo do pokemon', 8.0, 'FINALIZADO');
INSERT INTO tb_game (name, img_url, platform_id, review, grade, status) VALUES ('The last of us','https://cdn.thegamesdb.net/images/original/boxart/front/109072-1.jpg', 4, 'Critica generica', 9.0, 'FINALIZADO');

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


