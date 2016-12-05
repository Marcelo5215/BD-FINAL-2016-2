CREATE TABLE bk_pessoa (
  cpf integer NOT NULL,
  nome character varying(50),
  orgid_org_superior integer
);



--Procedure para salvar os dados das pessoas demitidas da presidencia da republica
CREATE OR REPLACE FUNCTION salvaexcluido()
RETURNS trigger AS
$BODY$ BEGIN
IF (old.orgid_org_superior = 20000) THEN
	INSERT INTO bk_pessoa VALUES (old.cpf, old.nome, old.orgid_org_superior);
END IF;
RETURN NULL;

END; $BODY$
LANGUAGE 'plpgsql';


--Gatilho acionado apenas no horario de funcionamento 08hrs ate as 18hrs
CREATE TRIGGER excluir_pessoa
BEFORE DELETE OR INSERT ON pessoa
FOR EACH ROW
WHEN (DATE_PART('hour', current_timestamp) BETWEEN '08' AND '18')
	EXECUTE PROCEDURE salvaexcluido();
