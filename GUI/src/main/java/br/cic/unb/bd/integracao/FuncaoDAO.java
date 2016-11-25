package br.cic.unb.bd.integracao;

import br.cic.unb.bd.estrutura.Funcao;

public interface FuncaoDAO {
	
	public void salvar(Funcao f);
	
	public void atualizar(Funcao f);
	
	public void excluir(String s);
	
	public Funcao pesquisar(String s);
	
}
