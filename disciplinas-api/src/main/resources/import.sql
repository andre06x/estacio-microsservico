INSERT INTO curso (id, nmcurso , descricao, duracao) VALUES ('36a21c12-e3d8-4052-aada-e3f1bd10648c', 'Sistemas de Informação', 'SI', 4);
INSERT INTO curso (id, nmcurso , descricao, duracao) VALUES ('76486b20-49fb-419d-985d-0f3fed2c17df', 'Ciência da Computação', 'CC',  4);
INSERT INTO curso (id, nmcurso , descricao, duracao) VALUES ('99a996f5-c948-4723-a226-03fbeb5fd9f4', 'Administração', 'ADM', 4);
INSERT INTO curso (id, nmcurso , descricao, duracao) VALUES ('77cfbb6d-9217-47bc-a5ac-60033c77bef5', 'Contabilidade', 'CONT', 4);
INSERT INTO curso (id, nmcurso , descricao, duracao) VALUES ('6f9fa01a-930f-4c42-abda-3607b830b696', 'Enfermagem', 'ENF', 5);

INSERT INTO disciplina (id, idcurso, nmdisciplina, periodo) VALUES ('26e09b6c-d94b-46ca-b1e4-791b7394b5c4', '36a21c12-e3d8-4052-aada-e3f1bd10648c', 'Modelagem de Sistemas', 4);
INSERT INTO disciplina (id, idcurso, nmdisciplina, periodo) VALUES ('2d16a561-b737-4d23-958d-2e24fecd104a', '36a21c12-e3d8-4052-aada-e3f1bd10648c', 'Engenharia de Software', 4);

INSERT INTO disciplina (id, idcurso, nmdisciplina, periodo) VALUES ('0d5c0ae3-5745-4927-a19b-fb9750e63922', '76486b20-49fb-419d-985d-0f3fed2c17df', 'Modelagem de Sistemas', 4);
INSERT INTO disciplina (id, idcurso, nmdisciplina, periodo) VALUES ('efdc7392-1b28-48e7-a385-c7596fe0c148', '76486b20-49fb-419d-985d-0f3fed2c17df', 'Engenharia de Software', 4);

INSERT INTO disciplina (id, idcurso, nmdisciplina, periodo) VALUES ('67af7187-5f00-415c-a150-a8be46e0c213', '99a996f5-c948-4723-a226-03fbeb5fd9f4', 'Adm pública', 4);
INSERT INTO disciplina (id, idcurso, nmdisciplina, periodo) VALUES ('85119fdd-dbf7-4c9d-b62a-c9d7be3e794e', '99a996f5-c948-4723-a226-03fbeb5fd9f4', 'Calculo 1', 4);


-- Inserindo alguns clientes
--INSERT INTO clientes (nome) VALUES ('João');
--INSERT INTO clientes (nome) VALUES ('Maria');
--INSERT INTO clientes (nome) VALUES ('Pedro');

-- Inserindo alguns pedidos
--INSERT INTO pedidos (descricao, cliente_id) VALUES ('Pedido 1', 1);
--INSERT INTO pedidos (descricao, cliente_id) VALUES ('Pedido 2', 1);
--INSERT INTO pedidos (descricao, cliente_id) VALUES ('Pedido 3', 2);
--INSERT INTO pedidos (descricao, cliente_id) VALUES ('Pedido 4', 3);
