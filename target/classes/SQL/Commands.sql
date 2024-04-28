select * from adm;

select * from usuario;

INSERT INTO adm (id,cpf,nome,senha) VALUES
                                      ('4','111.111.111-11','','senha1'),
                                      ('5','222.222.222-22','','senha2'),
                                      ('6','333.333.333-33','','senha3');

INSERT INTO usuario (id,cpf,nome,senha) VALUES
                                            ('1','444.444.444-44','João','senha4'),
                                            ('2','555.555.555-55','Paulo','senha5'),
                                            ('3','666.666.666-66','Judas','senha6');

INSERT INTO adm (id,cpf,senha) VALUES
                                                  ('1','750.802.731-00','senha'),
                                                  ('5','222.222.222-22','senha2'),
                                                  ('6','333.333.333-33','senha3');
/*Atualizar Tabela*/
UPDATE adm
SET senha = 'senha'
WHERE id = 1;

UPDATE usuario
SET senha = 'novaSenha123'
WHERE id = 1;



