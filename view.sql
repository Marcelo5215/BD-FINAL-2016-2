-- Ordena os ordens superiores em relacão à porcentagem gasta em viagens
-- em relação à todo o dinheiro gasto e transforma numa view
create view gastos_org_superiores as
	(select os.*, 100 * sum(dp.valor) / tot.total as porcetagem_de_gastos, sum(dp.valor) as soma_gastos from org_superior as os
		join pessoa as p on os.orgID = p.orgID_ORG_SUPERIOR
		join docpag as dp on p.cpf = dp.cpf_pessoa
		join (select sum(dp.valor) as total from docpag as dp) as tot on true
		group by os.orgID, tot.total
		order by 100 * sum(dp.valor) / tot.total desc);

--Essa view pode ser utilizada para observar a porcentagem de gastos de outras tabelas.
-- Tanto de gastos relativos à algum orgão, função, entre outros, como também gastos em relação ao total

--Optou-se por utilizar os orgãos superiores para guardar a porcentagem, já que a utilização de outras tabelas
-- implicaria em porcentagens menores, o que poderia aumentar a imprecisão devido ao uso de artmética de ponto flutuante
