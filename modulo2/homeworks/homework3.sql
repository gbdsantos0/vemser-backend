--Fazer um RIGHT OUTER JOIN entre tabelas:
--Pessoa e Contato
SELECT p.NOME, c.NUMERO
FROM VEM_SER.PESSOA p
RIGHT OUTER JOIN VEM_SER.CONTATO c ON (p.ID_PESSOA = c.ID_PESSOA);

--Pessoa, PESSOA_X_PESSOA_ENDERECO e Endereco_Pessoa
SELECT p.NOME, ep.LOGRADOURO
FROM VEM_SER.PESSOA p
RIGHT OUTER JOIN VEM_SER.PESSOA_X_PESSOA_ENDERECO pxpe
	ON p.ID_PESSOA = pxpe.ID_PESSOA
RIGHT OUTER JOIN VEM_SER.ENDERECO_PESSOA ep
	ON pxpe.ID_ENDERECO = ep.ID_ENDERECO;

--Todas as tabelas (comešando por pessoa)
SELECT * --p.NOME, ep.LOGRADOURO, c.NUMERO
FROM VEM_SER.PESSOA p
RIGHT OUTER JOIN VEM_SER.CONTATO c
	ON p.ID_PESSOA = c.ID_PESSOA
RIGHT OUTER JOIN VEM_SER.PESSOA_X_PESSOA_ENDERECO pxpe
	ON p.ID_PESSOA = pxpe.ID_PESSOA
RIGHT OUTER JOIN VEM_SER.ENDERECO_PESSOA ep
	ON pxpe.ID_ENDERECO = ep.ID_ENDERECO;


--Fazer um OUTER FULL JOIN entre tabelas:
--Pessoa e Contato
SELECT p.NOME, c.NUMERO
FROM VEM_SER.PESSOA p
FULL OUTER JOIN VEM_SER.CONTATO c ON (p.ID_PESSOA = c.ID_PESSOA);

--Pessoa, PESSOA_X_PESSOA_ENDERECO e Endereco_Pessoa
SELECT p.NOME, ep.LOGRADOURO
FROM VEM_SER.PESSOA p
FULL OUTER JOIN VEM_SER.PESSOA_X_PESSOA_ENDERECO pxpe
	ON p.ID_PESSOA = pxpe.ID_PESSOA
FULL OUTER JOIN VEM_SER.ENDERECO_PESSOA ep
	ON pxpe.ID_ENDERECO = ep.ID_ENDERECO;
	
--Todas as tabelas (comešando por pessoa)
SELECT * --p.NOME, ep.LOGRADOURO, c.NUMERO
FROM VEM_SER.PESSOA p
FULL OUTER JOIN VEM_SER.CONTATO c
	ON p.ID_PESSOA = c.ID_PESSOA
FULL OUTER JOIN VEM_SER.PESSOA_X_PESSOA_ENDERECO pxpe
	ON p.ID_PESSOA = pxpe.ID_PESSOA
FULL OUTER JOIN VEM_SER.ENDERECO_PESSOA ep
	ON pxpe.ID_ENDERECO = ep.ID_ENDERECO;
	

--Utilizando o EXISTS, selecione as pessoas que tem enderešo
SELECT p.NOME FROM VEM_SER.PESSOA p
WHERE EXISTS 
(SELECT pxpe.ID_ENDERECO FROM VEM_SER.PESSOA_X_PESSOA_ENDERECO pxpe
WHERE p.ID_PESSOA = pxpe.ID_PESSOA);

--Selecione nome, id da tabela pessoa e uma com logradouro e id da tabela enderešo
SELECT p.NOME, p.ID_PESSOA, ep.LOGRADOURO, ep.ID_ENDERECO
FROM VEM_SER.PESSOA p, VEM_SER.ENDERECO_PESSOA ep
WHERE EXISTS 
(SELECT pxpe.ID_ENDERECO FROM VEM_SER.PESSOA_X_PESSOA_ENDERECO pxpe
WHERE p.ID_PESSOA = pxpe.ID_PESSOA AND  pxpe.ID_ENDERECO = ep.ID_ENDERECO);


SELECT p.NOME, p.ID_PESSOA, ep.LOGRADOURO, ep.ID_ENDERECO
FROM VEM_SER.PESSOA p
INNER JOIN VEM_SER.PESSOA_X_PESSOA_ENDERECO pxpe
	ON p.ID_PESSOA = pxpe.ID_PESSOA
INNER JOIN VEM_SER.ENDERECO_PESSOA ep
	ON pxpe.ID_ENDERECO = ep.ID_ENDERECO;