package br.cic.unb.bd.integracao;

import br.cic.unb.bd.estrutura.Pessoa;

public interface PessoaDAO {
	
	public void salvar(Pessoa pe);
	
	public void atualizar(Pessoa pe);
	
	public void excluir(String s);
	
	public Pessoa pesquisar(String s);
}
