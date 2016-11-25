package br.cic.unb.bd.integracao;

import br.cic.unb.bd.estrutura.UnidadeGestora;

public interface UnidadeGestoraDAO {
	
	public void salvar(UnidadeGestora ug);
	
	public void atualizar(UnidadeGestora ug);
	
	public void excluir(String s);
	
	public UnidadeGestora pesquisar(String s);
}
