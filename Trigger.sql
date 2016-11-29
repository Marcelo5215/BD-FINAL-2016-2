CREATE TABLE bk_pessoa (
  cpf integer NOT NULL,
  nome character varying(50),
  orgid_org_superior integer
);


-- Stored Procedure
CREATE OR REPLACE FUNCTION salvaexcluido()
RETURNS trigger AS
$BODY$ BEGIN
IF (old.orgid_org_superior = 20000) THEN
	INSERT INTO bk_pessoa VALUES (old.cpf, old.nome, old.orgid_org_superior);
END IF;
RETURN NULL;

END; $BODY$
LANGUAGE 'plpgsql';

CREATE TRIGGER excluir_pessoa
AFTER DELETE
ON pessoa
FOR EACH ROW
WHEN (old.cpf IS DISTINCT FROM 4451)
EXECUTE PROCEDURE salvaexcluido();