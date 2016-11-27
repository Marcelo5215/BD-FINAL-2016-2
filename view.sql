-- As views seguintes:
-- Ordenam _______ em relacão à porcentagem gasta em viagens
-- em relação à todo o dinheiro gasto e transformam em views

--Essas views pode ser utilizada para observar a porcentagem de gastos de outras tabelas.
-- Tanto de gastos relativos à algum orgão, função, entre outros, como também gastos em relação ao total

create view gastos_org_superiores as
	(select os.*, 100 * sum(dp.valor) / tot.total as porcentagem_de_gastos, sum(dp.valor) as soma_gastos from org_superior as os
		join pessoa as p on os.orgID = p.orgID_ORG_SUPERIOR
		join docpag as dp on p.cpf = dp.cpf_pessoa
		join (select sum(dp.valor) as total from docpag as dp) as tot on true
		group by os.orgID, tot.total
		order by 100 * sum(dp.valor) / tot.total desc);
-- Optou-se por utilizar os orgãos superiores para facilitar consultas relativas à ele de orgãos subordinados ao de unidades gestoras.
-- Pode-se verificar quais orgãos subordinados consomem mais em relação à seu orgão principal


create view gastos_pessoas as
	(select p.*, 100 * sum(dp.valor) / tot.total as porcentagem_de_gastos, sum(dp.valor) as soma_gastos from pessoa as p
		join docpag as dp on p.cpf = dp.cpf_pessoa
		join (select sum(dp.valor) as total from docpag as dp) as tot on true
		group by p.cpf, tot.total
		order by 100 * sum(dp.valor) / tot.total desc);
-- Percebeu-se que a tabela de pessoas apresenta uma maior presição que a de orgãos superiores,
-- uma vez que a soma de seus percentuais é mais próxima de 100
-- Essa view permite consulta mais precisas para consultas de menor escala

create view gastos_docpag as
	(select dp.*, 100 * dp.valor / tot.total as porcentagem_de_gastos from docpag as dp
		join (select sum(dp.valor) as total from docpag as dp) as tot on true
		group by dp.docpagID, tot.total
		order by 100 * dp.valor / tot.total desc);
-- Alta precisão do percentual, útil para verificações que não envolvam pessoa, como ACAO e PROGRAMA
