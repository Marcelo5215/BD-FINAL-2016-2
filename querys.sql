--Quanto LUIZ CARLOS NONATO GASTOU .....
SELECT SUM(dp.valor) FROM docpag AS dp
	JOIN pessoa AS p ON dp.cpf_pessoa = p.cpf
	WHERE p.cpf = 69258; -- LUIZ CARLOS NONATO

--Quanto NATALIO BARBOSA ALCANTARA GASTOU .....
SELECT SUM(dp.valor) FROM docpag AS dp
	JOIN pessoa AS p ON dp.cpf_pessoa = p.cpf
	WHERE p.cpf = 12606; -- NATALIO BARBOSA ALCANTARA 

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