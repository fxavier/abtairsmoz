INSERT INTO grupo VALUES(1,'Administrador');
INSERT INTO grupo VALUES(2,'DBC');
INSERT INTO grupo VALUES(3,'ABT');

INSERT INTO `permissao` VALUES (1, 'ROLE_CADASTRAR_DISTRITO');
INSERT INTO `permissao` VALUES (2, 'ROLE_CADASTRAR_LOCALIDADE');
INSERT INTO `permissao` VALUES (3, 'ROLE_CADASTRAR_BAIRRO');
INSERT INTO `permissao` VALUES (4, 'ROLE_CADASTRAR_ROCEADOR');
INSERT INTO `permissao` VALUES (5, 'ROLE_CADASTRAR_SUPERVISORES');
INSERT INTO `permissao` VALUES (6, 'ROLE_CADASTRAR_TOTAIS_DOS');
INSERT INTO `permissao` VALUES (7, 'ROLE_CADASTRAR_DETALHES_DOS');
INSERT INTO `permissao` VALUES (8, 'ROLE_CADASTRAR_USUARIOS');

INSERT INTO `usuario` VALUES ('1', 'admin', 'admin@africairs.net', '$2a$10$fvMZAEn9LprgOqS7pBIdruwOdjc8trfEHy6eyBPYWYpt9/8dF51D.', '1');


INSERT INTO usuario_grupo VALUES(1,1);
INSERT INTO usuario_grupo VALUES(1,2);
INSERT INTO usuario_grupo VALUES(1,3);

INSERT INTO grupo_permissao (codigo_grupo, codigo_permissao) VALUES (1, 1);
INSERT INTO grupo_permissao (codigo_grupo, codigo_permissao) VALUES (1, 2);
INSERT INTO grupo_permissao (codigo_grupo, codigo_permissao) VALUES (1, 3);
INSERT INTO grupo_permissao (codigo_grupo, codigo_permissao) VALUES (1, 4);
INSERT INTO grupo_permissao (codigo_grupo, codigo_permissao) VALUES (1, 5);
INSERT INTO grupo_permissao (codigo_grupo, codigo_permissao) VALUES (1, 6);
INSERT INTO grupo_permissao (codigo_grupo, codigo_permissao) VALUES (1, 7);