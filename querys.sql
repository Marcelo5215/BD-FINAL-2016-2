--Quanto LUIZ CARLOS NONATO GASTOU .....
SELECT SUM(dp.valor) FROM docpag AS dp
	JOIN pessoa AS p ON dp.cpf_pessoa = p.cpf
	WHERE p.cpf = 69258; -- LUIZ CARLOS NONATO

--Quanto NATALIO BARBOSA ALCANTARA GASTOU .....
SELECT SUM(dp.valor) FROM docpag AS dp
	JOIN pessoa AS p ON dp.cpf_pessoa = p.cpf
	WHERE p.cpf = 12606; -- NATALIO BARBOSA ALCANTARA 

SELECT SUM(dp.valor) FROM docpag AS dp
	JOIN pessoa AS p ON dp.cpf_pessoa = p.cpf
	WHERE p.nome LIKE 'FRANCISCO JOCA DE SOUSA FILHO'; 

--Quanto A PRESIDENCIA DA REPUBLICA GASTOU no periodo de julho a dezembro
SELECT SUM(dp.valor) FROM docpag AS dp
	JOIN pessoa AS p ON dp.cpf_pessoa = p.cpf
	JOIN org_superior AS os ON os.orgid = p.orgid_org_superior
	WHERE os.nome LIKE 'PRESIDENCIA DA REPUBLICA';

--Quanto A PRESIDENCIA DA REPUBLICA GASTOU no periodo de agosto
SELECT SUM(dp.valor) FROM docpag AS dp
	JOIN pessoa AS p ON dp.cpf_pessoa = p.cpf
	JOIN org_superior AS os ON os.orgid = p.orgid_org_superior
	WHERE os.nome LIKE 'PRESIDENCIA DA REPUBLICA' AND
	dp.data >= '2015-08-01' AND
	dp.data < '2015-09-01';

--Quanto cada pessoa gastou no período de julho à agosto de 2015,
--ordenado do maior ao menor valor e em caso de empate, por ordem
--lexicográfica
select p.nome, sum(dp.valor) from docpag as dp
	join pessoa as p on dp.cpf_pessoa = p.cpf
	group by p.nome
	order by sum(dp.valor) desc, p.nome;

--Quantas viagens cada pessoa realizou no período de julho à agosto de 2015,
--ordenado do maior ao menor valor e em caso de empate, por ordem
--lexicográfica. Só mostra os 100 primeiros elementos
select p.nome, count(dp.valor) from docpag as dp
	join pessoa as p on dp.cpf_pessoa = p.cpf
	group by p.nome
	order by count(dp.valor) desc, p.nome
	limit 100
	offset 0;

-- Mostra todas as viagens realizadas pela pessoa que mais gastou
select sel1.nome, dp2.* from
(select p.nome, p.cpf, count(dp.valor) from docpag as dp
	join pessoa as p on dp.cpf_pessoa = p.cpf
	group by p.cpf, p.nome
	order by count(dp.valor) desc, p.nome
	limit 1
	offset 0) as sel1
	join docpag as dp2 on dp2.cpf_pessoa = sel1.cpf
	order by dp2.data;
