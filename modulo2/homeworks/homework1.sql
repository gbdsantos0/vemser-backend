/*GRANT CONNECT TO VEM_SER;
GRANT CONNECT, RESOURCE, DBA TO VEM_SER;
GRANT CREATE SESSION TO VEM_SER;
GRANT DBA TO VEM_SER;
GRANT CREATE VIEW, CREATE PROCEDURE, CREATE SEQUENCE to VEM_SER;
GRANT UNLIMITED TABLESPACE TO VEM_SER;
GRANT CREATE MATERIALIZED VIEW TO VEM_SER;
GRANT CREATE TABLE TO VEM_SER;
GRANT GLOBAL QUERY REWRITE TO VEM_SER;
GRANT SELECT ANY TABLE TO VEM_SER;*/

--DROP TABLE VEM_SER.ESTUDANTE;
--DROP SEQUENCE VEM_SER.SEQ_ESTUDANTE;


CREATE TABLE VEM_SER.ESTUDANTE(
	id NUMBER NOT NULL,
	nome VARCHAR2(200) NOT NULL,
	data_nascimento DATE NOT NULL,
	nr_matricula NUMBER(10) NOT NULL,
	ativo CHAR(1) NOT NULL,--(�S� = ativo, �N� = n�o ativo)
	PRIMARY KEY(id)
);


CREATE SEQUENCE VEM_SER.seq_estudante
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

INSERT INTO VEM_SER.ESTUDANTE  (ID, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(VEM_SER.SEQ_ESTUDANTE.nextval, 'Maicon1', TO_DATE('08-09-1991', 'dd-mm-yyyy'), '0000000000', 'S');

INSERT INTO VEM_SER.ESTUDANTE (ID, NOME, DATA_NASCIMENTO, ATIVO, NR_MATRICULA)
VALUES(VEM_SER.SEQ_ESTUDANTE.nextval, 'Maicon2', TO_DATE('08-09-1991', 'dd-mm-yyyy'), 'S', '0000000001');

INSERT INTO VEM_SER.ESTUDANTE
VALUES(VEM_SER.SEQ_ESTUDANTE.nextval, 'Maicon3', TO_DATE('08-09-1991', 'dd-mm-yyyy'), '0000000002', 'S');

INSERT INTO VEM_SER.ESTUDANTE
VALUES(VEM_SER.SEQ_ESTUDANTE.nextval, 'Maicon4', TO_DATE('08-09-1991', 'dd-mm-yyyy'), '0000000003', 'n');

INSERT INTO VEM_SER.ESTUDANTE
VALUES(VEM_SER.SEQ_ESTUDANTE.nextval, 'Maicon5', TO_DATE('08-09-1991', 'dd-mm-yyyy'), '0000000004', 'S');

INSERT INTO VEM_SER.ESTUDANTE
VALUES(VEM_SER.SEQ_ESTUDANTE.nextval, 'Maicon6', TO_DATE('08-09-1991', 'dd-mm-yyyy'), '0000000005', 'S');

INSERT INTO VEM_SER.ESTUDANTE
VALUES(VEM_SER.SEQ_ESTUDANTE.nextval, 'Maicon7', TO_DATE('08-09-1991', 'dd-mm-yyyy'), '0000000006', 'S');

INSERT INTO VEM_SER.ESTUDANTE
VALUES(VEM_SER.SEQ_ESTUDANTE.nextval, 'Maicon8', TO_DATE('08-09-1991', 'dd-mm-yyyy'), '0000000007', 'S');

INSERT INTO VEM_SER.ESTUDANTE
VALUES(VEM_SER.SEQ_ESTUDANTE.nextval, 'Maicon9', TO_DATE('08-09-1991', 'dd-mm-yyyy'), '0000000008', 'S');

INSERT INTO VEM_SER.ESTUDANTE
VALUES(VEM_SER.SEQ_ESTUDANTE.nextval, 'Maicon10', TO_DATE('08-09-1991', 'dd-mm-yyyy'), '0000000009', 'S');


SELECT * FROM VEM_SER.ESTUDANTE;