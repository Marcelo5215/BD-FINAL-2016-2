CREATE TABLE bk_pessoa (
  cpf integer NOT NULL,
  nome character varying(50),
  orgid_org_superior integer
);


-- Stored Procedure
CREATE OR REPLACE FUNCTION salvaexcluido()
RETURNS trigger AS
$BODY$ BEGIN
INSERT INTO bk_pessoa VALUES (old.cpf, old.nome, old.orgid_org_superior);

RETURN NULL;

END; $BODY$
LANGUAGE 'plpgsql';

CREATE TRIGGER excluir_pessoa
AFTER DELETE
ON pessoa
FOR EACH ROW
EXECUTE PROCEDURE salvaexcluido();