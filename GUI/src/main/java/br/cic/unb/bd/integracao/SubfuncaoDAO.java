package br.cic.unb.bd.integracao;

import br.cic.unb.bd.estrutura.Subfuncao;

public interface SubfuncaoDAO {
	public void salvar(Subfuncao sub);
	
	public void atualizar(Subfuncao sub);
	
	public void excluir(String s);
	
	public Subfuncao pesquisar(String s);
}
