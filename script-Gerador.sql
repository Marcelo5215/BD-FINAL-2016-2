-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.8.2
-- PostgreSQL version: 9.5
-- Project Site: pgmodeler.com.br
-- Model Author: ---


-- Database creation must be done outside an multicommand file.
-- These commands were put in this file only for convenience.
-- -- object: novo_banco_de_dados | type: DATABASE --
-- -- DROP DATABASE IF EXISTS novo_banco_de_dados;
-- CREATE DATABASE novo_banco_de_dados
-- ;
-- -- ddl-end --
-- 

-- object: public."ORG_SUPERIOR" | type: TABLE --
-- DROP TABLE IF EXISTS public."ORG_SUPERIOR" CASCADE;
CREATE TABLE public."ORG_SUPERIOR"(
	"orgID" integer NOT NULL,
	"Nome" varchar(15),
	CONSTRAINT "PK" PRIMARY KEY ("orgID")

);
-- ddl-end --
ALTER TABLE public."ORG_SUPERIOR" OWNER TO postgres;
-- ddl-end --

-- object: public."ORG_SUBORDINADO" | type: TABLE --
-- DROP TABLE IF EXISTS public."ORG_SUBORDINADO" CASCADE;
CREATE TABLE public."ORG_SUBORDINADO"(
	"orsubID" integer NOT NULL,
	"Nome" varchar(15),
	"orgID_ORG_SUPERIOR" integer,
	CONSTRAINT "SUBPK" PRIMARY KEY ("orsubID")

);
-- ddl-end --
ALTER TABLE public."ORG_SUBORDINADO" OWNER TO postgres;
-- ddl-end --

-- object: "ORG_SUPERIOR_fk" | type: CONSTRAINT --
-- ALTER TABLE public."ORG_SUBORDINADO" DROP CONSTRAINT IF EXISTS "ORG_SUPERIOR_fk" CASCADE;
ALTER TABLE public."ORG_SUBORDINADO" ADD CONSTRAINT "ORG_SUPERIOR_fk" FOREIGN KEY ("orgID_ORG_SUPERIOR")
REFERENCES public."ORG_SUPERIOR" ("orgID") MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public."UNIDADE_GESTORA" | type: TABLE --
-- DROP TABLE IF EXISTS public."UNIDADE_GESTORA" CASCADE;
CREATE TABLE public."UNIDADE_GESTORA"(
	"ungID" integer NOT NULL,
	"Nome" varchar(50),
	"funcID_FUNCAO" integer,
	"orsubID_ORG_SUBORDINADO" integer,
	CONSTRAINT "uniPK" PRIMARY KEY ("ungID")

);
-- ddl-end --
ALTER TABLE public."UNIDADE_GESTORA" OWNER TO postgres;
-- ddl-end --

-- object: public."FUNCAO" | type: TABLE --
-- DROP TABLE IF EXISTS public."FUNCAO" CASCADE;
CREATE TABLE public."FUNCAO"(
	"funcID" integer NOT NULL,
	"Nome" varchar(15),
	CONSTRAINT "funcPK" PRIMARY KEY ("funcID")

);
-- ddl-end --
ALTER TABLE public."FUNCAO" OWNER TO postgres;
-- ddl-end --

-- object: "FUNCAO_fk" | type: CONSTRAINT --
-- ALTER TABLE public."UNIDADE_GESTORA" DROP CONSTRAINT IF EXISTS "FUNCAO_fk" CASCADE;
ALTER TABLE public."UNIDADE_GESTORA" ADD CONSTRAINT "FUNCAO_fk" FOREIGN KEY ("funcID_FUNCAO")
REFERENCES public."FUNCAO" ("funcID") MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "ORG_SUBORDINADO_fk" | type: CONSTRAINT --
-- ALTER TABLE public."UNIDADE_GESTORA" DROP CONSTRAINT IF EXISTS "ORG_SUBORDINADO_fk" CASCADE;
ALTER TABLE public."UNIDADE_GESTORA" ADD CONSTRAINT "ORG_SUBORDINADO_fk" FOREIGN KEY ("orsubID_ORG_SUBORDINADO")
REFERENCES public."ORG_SUBORDINADO" ("orsubID") MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public."SUBFUNCAO" | type: TABLE --
-- DROP TABLE IF EXISTS public."SUBFUNCAO" CASCADE;
CREATE TABLE public."SUBFUNCAO"(
	"subFuncID" integer NOT NULL,
	"Nome" varchar(15),
	CONSTRAINT "subfuncPK" PRIMARY KEY ("subFuncID")

);
-- ddl-end --
ALTER TABLE public."SUBFUNCAO" OWNER TO postgres;
-- ddl-end --

-- object: public."muitos_SUBFUNCAO_tem_muitos_FUNCAO" | type: TABLE --
-- DROP TABLE IF EXISTS public."muitos_SUBFUNCAO_tem_muitos_FUNCAO" CASCADE;
CREATE TABLE public."muitos_SUBFUNCAO_tem_muitos_FUNCAO"(
	"subFuncID_SUBFUNCAO" integer,
	"funcID_FUNCAO" integer,
	CONSTRAINT "muitos_SUBFUNCAO_tem_muitos_FUNCAO_pk" PRIMARY KEY ("subFuncID_SUBFUNCAO","funcID_FUNCAO")

);
-- ddl-end --

-- object: "SUBFUNCAO_fk" | type: CONSTRAINT --
-- ALTER TABLE public."muitos_SUBFUNCAO_tem_muitos_FUNCAO" DROP CONSTRAINT IF EXISTS "SUBFUNCAO_fk" CASCADE;
ALTER TABLE public."muitos_SUBFUNCAO_tem_muitos_FUNCAO" ADD CONSTRAINT "SUBFUNCAO_fk" FOREIGN KEY ("subFuncID_SUBFUNCAO")
REFERENCES public."SUBFUNCAO" ("subFuncID") MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: "FUNCAO_fk" | type: CONSTRAINT --
-- ALTER TABLE public."muitos_SUBFUNCAO_tem_muitos_FUNCAO" DROP CONSTRAINT IF EXISTS "FUNCAO_fk" CASCADE;
ALTER TABLE public."muitos_SUBFUNCAO_tem_muitos_FUNCAO" ADD CONSTRAINT "FUNCAO_fk" FOREIGN KEY ("funcID_FUNCAO")
REFERENCES public."FUNCAO" ("funcID") MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: public."PROGRAMA" | type: TABLE --
-- DROP TABLE IF EXISTS public."PROGRAMA" CASCADE;
CREATE TABLE public."PROGRAMA"(
	"progID" integer NOT NULL,
	"Nome" varchar(100),
	CONSTRAINT "COD" PRIMARY KEY ("progID")

);
-- ddl-end --
ALTER TABLE public."PROGRAMA" OWNER TO postgres;
-- ddl-end --

-- object: public."muitos_PROGRAMA_tem_muitos_SUBFUNCAO" | type: TABLE --
-- DROP TABLE IF EXISTS public."muitos_PROGRAMA_tem_muitos_SUBFUNCAO" CASCADE;
CREATE TABLE public."muitos_PROGRAMA_tem_muitos_SUBFUNCAO"(
	"progID_PROGRAMA" integer,
	"subFuncID_SUBFUNCAO" integer,
	CONSTRAINT "muitos_PROGRAMA_tem_muitos_SUBFUNCAO_pk" PRIMARY KEY ("progID_PROGRAMA","subFuncID_SUBFUNCAO")

);
-- ddl-end --

-- object: "PROGRAMA_fk" | type: CONSTRAINT --
-- ALTER TABLE public."muitos_PROGRAMA_tem_muitos_SUBFUNCAO" DROP CONSTRAINT IF EXISTS "PROGRAMA_fk" CASCADE;
ALTER TABLE public."muitos_PROGRAMA_tem_muitos_SUBFUNCAO" ADD CONSTRAINT "PROGRAMA_fk" FOREIGN KEY ("progID_PROGRAMA")
REFERENCES public."PROGRAMA" ("progID") MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: "SUBFUNCAO_fk" | type: CONSTRAINT --
-- ALTER TABLE public."muitos_PROGRAMA_tem_muitos_SUBFUNCAO" DROP CONSTRAINT IF EXISTS "SUBFUNCAO_fk" CASCADE;
ALTER TABLE public."muitos_PROGRAMA_tem_muitos_SUBFUNCAO" ADD CONSTRAINT "SUBFUNCAO_fk" FOREIGN KEY ("subFuncID_SUBFUNCAO")
REFERENCES public."SUBFUNCAO" ("subFuncID") MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: public."ACAO" | type: TABLE --
-- DROP TABLE IF EXISTS public."ACAO" CASCADE;
CREATE TABLE public."ACAO"(
	"acaoID" integer NOT NULL,
	nome varchar(15),
	linguagemcidada varchar(50),
	"docpagID_DOCPAG" integer,
	"progID_PROGRAMA" integer,
	CONSTRAINT "acaoPK" PRIMARY KEY ("acaoID")

);
-- ddl-end --
ALTER TABLE public."ACAO" OWNER TO postgres;
-- ddl-end --

-- object: public."DOCPAG" | type: TABLE --
-- DROP TABLE IF EXISTS public."DOCPAG" CASCADE;
CREATE TABLE public."DOCPAG"(
	"docpagID" integer NOT NULL,
	nome varchar(15),
	"Valor" decimal,
	data date,
	"CPF_PESSOA" integer,
	CONSTRAINT "dogpagPK" PRIMARY KEY ("docpagID")

);
-- ddl-end --
ALTER TABLE public."DOCPAG" OWNER TO postgres;
-- ddl-end --

-- object: public."PESSOA" | type: TABLE --
-- DROP TABLE IF EXISTS public."PESSOA" CASCADE;
CREATE TABLE public."PESSOA"(
	"CPF" integer NOT NULL,
	nome varchar(15),
	"orgID_ORG_SUPERIOR" integer,
	CONSTRAINT "cpfPK" PRIMARY KEY ("CPF")

);
-- ddl-end --
ALTER TABLE public."PESSOA" OWNER TO postgres;
-- ddl-end --

-- object: "PESSOA_fk" | type: CONSTRAINT --
-- ALTER TABLE public."DOCPAG" DROP CONSTRAINT IF EXISTS "PESSOA_fk" CASCADE;
ALTER TABLE public."DOCPAG" ADD CONSTRAINT "PESSOA_fk" FOREIGN KEY ("CPF_PESSOA")
REFERENCES public."PESSOA" ("CPF") MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "DOCPAG_fk" | type: CONSTRAINT --
-- ALTER TABLE public."ACAO" DROP CONSTRAINT IF EXISTS "DOCPAG_fk" CASCADE;
ALTER TABLE public."ACAO" ADD CONSTRAINT "DOCPAG_fk" FOREIGN KEY ("docpagID_DOCPAG")
REFERENCES public."DOCPAG" ("docpagID") MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "PROGRAMA_fk" | type: CONSTRAINT --
-- ALTER TABLE public."ACAO" DROP CONSTRAINT IF EXISTS "PROGRAMA_fk" CASCADE;
ALTER TABLE public."ACAO" ADD CONSTRAINT "PROGRAMA_fk" FOREIGN KEY ("progID_PROGRAMA")
REFERENCES public."PROGRAMA" ("progID") MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "ORG_SUPERIOR_fk" | type: CONSTRAINT --
-- ALTER TABLE public."PESSOA" DROP CONSTRAINT IF EXISTS "ORG_SUPERIOR_fk" CASCADE;
ALTER TABLE public."PESSOA" ADD CONSTRAINT "ORG_SUPERIOR_fk" FOREIGN KEY ("orgID_ORG_SUPERIOR")
REFERENCES public."ORG_SUPERIOR" ("orgID") MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --


