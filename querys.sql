--Quanto LUIZ CARLOS NONATO GASTOU .....
SELECT SUM(dp.valor) FROM docpag AS dp
	JOIN pessoa AS p ON dp.cpf_pessoa = p.cpf
	WHERE p.cpf = 69258; -- LUIZ CARLOS NONATO