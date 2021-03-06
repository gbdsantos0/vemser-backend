CREATE TABLE VEM_SER.PAIS(
	ID_PAIS NUMBER(38,0) PRIMARY KEY NOT NULL,
	NOME VARCHAR2(50) NOT NULL
);

CREATE TABLE VEM_SER.ESTADO(
	ID_ESTADO NUMBER(38,0) PRIMARY KEY NOT NULL,
	ID_PAIS NUMBER(38,0) NOT NULL,
	NOME VARCHAR2(50) NOT NULL,
	CONSTRAINT FK_ID_PAIS FOREIGN KEY (ID_PAIS) REFERENCES VEM_SER.PAIS(ID_PAIS)
);

CREATE TABLE VEM_SER.CIDADE(
	ID_CIDADE NUMBER(38,0) NOT NULL,
	ID_ESTADO NUMBER(38,0) NOT NULL,
	NOME VARCHAR2(50) NOT NULL,
	PRIMARY KEY (ID_CIDADE, ID_ESTADO),
	CONSTRAINT FK_ID_ESTADO FOREIGN KEY (ID_ESTADO) REFERENCES VEM_SER.ESTADO(ID_ESTADO)
);

CREATE TABLE VEM_SER.BAIRRO(
	ID_BAIRRO NUMBER(38,0) NOT NULL,
	ID_CIDADE NUMBER(38,0) NOT NULL,
	ID_ESTADO NUMBER(38,0) NOT NULL,
	NOME VARCHAR2(50) NOT NULL,
	PRIMARY KEY (ID_BAIRRO, ID_CIDADE),
	CONSTRAINT FK_ID_CIDADE FOREIGN KEY (ID_CIDADE,ID_ESTADO) REFERENCES VEM_SER.CIDADE(ID_CIDADE,ID_ESTADO)
);

CREATE TABLE VEM_SER.ENDERECO(
	ID_ENDERECO NUMBER(38,0) PRIMARY KEY NOT NULL,
	ID_BAIRRO NUMBER(38,0) NOT NULL,
	ID_CIDADE NUMBER(38,0) NOT NULL,
	LOGRADOURO VARCHAR2(255) NOT NULL,
	NUMERO NUMBER(38,0) NOT NULL,
	COMPLEMENTO VARCHAR2(100),
	CEP CHAR(9),
	CONSTRAINT FK_ID_BAIRRO FOREIGN KEY (ID_BAIRRO,ID_CIDADE) REFERENCES VEM_SER.BAIRRO(ID_BAIRRO,ID_CIDADE)
);

CREATE SEQUENCE VEM_SER.SEQ_PAIS
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE VEM_SER.SEQ_ESTADO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE VEM_SER.SEQ_CIDADE
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE VEM_SER.SEQ_BAIRRO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE VEM_SER.SEQ_ENDERECO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

--PAISES
INSERT INTO VEM_SER.PAIS
VALUES (VEM_SER.SEQ_PAIS.nextval,'BRASIL');

INSERT INTO VEM_SER.PAIS
VALUES (VEM_SER.SEQ_PAIS.nextval,'USA');

--SELECT * FROM VEM_SER.PAIS;

--ESTADOS BRASIL
INSERT INTO VEM_SER.ESTADO
VALUES (VEM_SER.SEQ_ESTADO.nextval,1,'RS');

INSERT INTO VEM_SER.ESTADO
VALUES (VEM_SER.SEQ_ESTADO.nextval,1,'PR');

--ESTADOS USA
INSERT INTO VEM_SER.ESTADO
VALUES (VEM_SER.SEQ_ESTADO.nextval,2,'Texas');

INSERT INTO VEM_SER.ESTADO
VALUES (VEM_SER.SEQ_ESTADO.nextval,2,'California');

--SELECT * FROM VEM_SER.ESTADO;

INSERT INTO VEM_SER.CIDADE
VALUES (VEM_SER.SEQ_CIDADE.nextval,1,'S?o Louren?o do Sul');

INSERT INTO VEM_SER.CIDADE
VALUES (VEM_SER.SEQ_CIDADE.nextval,2,'Curitiba');

INSERT INTO VEM_SER.CIDADE
VALUES (VEM_SER.SEQ_CIDADE.nextval,3,'Dallas');

INSERT INTO VEM_SER.CIDADE
VALUES (VEM_SER.SEQ_CIDADE.nextval,4,'Los Angeles');
--SELECT * FROM VEM_SER.CIDADE;

INSERT INTO VEM_SER.BAIRRO 
VALUES (VEM_SER.SEQ_BAIRRO.nextval,1,1,'NAVEGANTES');

INSERT INTO VEM_SER.BAIRRO 
VALUES (VEM_SER.SEQ_BAIRRO.nextval,2,2,'JARDIM BOTANICO');

INSERT INTO VEM_SER.BAIRRO 
VALUES (VEM_SER.SEQ_BAIRRO.nextval,3,3,'WEST DALLAS');

INSERT INTO VEM_SER.BAIRRO 
VALUES (VEM_SER.SEQ_BAIRRO.nextval,4,4,'SKID ROW');

SELECT * FROM VEM_SER.BAIRRO;

--ENDERECOS SLS
INSERT INTO VEM_SER.ENDERECO
VALUES (VEM_SER.SEQ_ENDERECO.nextval,1,1,'RUA SAO PEDRO',115,'CASA','96170-000');

INSERT INTO VEM_SER.ENDERECO
VALUES (VEM_SER.SEQ_ENDERECO.nextval,1,1,'RUA JACOB RHEINGANTZ',185,'CASA','96170-000');

--ENDERECOS CURITIBA
INSERT INTO VEM_SER.ENDERECO
VALUES (VEM_SER.SEQ_ENDERECO.nextval,2,2,'RUA ALM. GONCALVES',46,'CASA','80215-150');

INSERT INTO VEM_SER.ENDERECO
VALUES (VEM_SER.SEQ_ENDERECO.nextval,2,2,'RUA IMAC. CONCEICAO',553,'CASA','80215-030');

--ENDERECOS DALLAS
INSERT INTO VEM_SER.ENDERECO
VALUES (VEM_SER.SEQ_ENDERECO.nextval,3,3,'TORONTO ST',3544,'CASA','75212');

INSERT INTO VEM_SER.ENDERECO
VALUES (VEM_SER.SEQ_ENDERECO.nextval,3,3,'FUREY ST',3299,'CASA','75212');

--ENDERECOS LOS ANGELES
INSERT INTO VEM_SER.ENDERECO
VALUES (VEM_SER.SEQ_ENDERECO.nextval,4,4,'5TH ST',310,'CASA','90013');

INSERT INTO VEM_SER.ENDERECO
VALUES (VEM_SER.SEQ_ENDERECO.nextval,4,4,'6TH ST',399,'CASA','90014');



SELECT * FROM VEM_SER.ENDERECO;


/*DROP TABLE VEM_SER.PAIS;
DROP TABLE VEM_SER.ESTADO;
DROP TABLE VEM_SER.CIDADE;
DROP TABLE VEM_SER.BAIRRO;
DROP TABLE VEM_SER.ENDERECO;
DROP SEQUENCE VEM_SER.SEQ_PAIS;
DROP SEQUENCE VEM_SER.SEQ_ESTADO;
DROP SEQUENCE VEM_SER.SEQ_CIDADE;
DROP SEQUENCE VEM_SER.SEQ_BAIRRO;
DROP SEQUENCE VEM_SER.SEQ_ENDERECO;*/

--SCRIPTS HOMEWORK 2

--1
SELECT * FROM VEM_SER.PAIS
ORDER BY NOME DESC;

--2
SELECT LOGRADOURO, CEP FROM VEM_SER.ENDERECO
WHERE UPPER(LOGRADOURO) LIKE 'A%';

--3
SELECT * FROM VEM_SER.ENDERECO
WHERE CEP REGEXP '%0';

--4
SELECT * FROM VEM_SER.ENDERECO
WHERE NUMERO BETWEEN 1 AND 100;

--5
SELECT * FROM VEM_SER.ENDERECO
WHERE LOGRADOURO LIKE 'RUA%'
ORDER BY CEP DESC;

--6
SELECT COUNT(*) FROM VEM_SER.ENDERECO;

--7
SELECT ID_CIDADE, COUNT(*) FROM VEM_SER.ENDERECO
GROUP BY ID_CIDADE;

