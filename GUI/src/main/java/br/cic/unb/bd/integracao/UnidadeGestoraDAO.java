package br.cic.unb.bd.integracao;

import java.util.List;

import br.cic.unb.bd.estrutura.UnidadeGestora;

public interface UnidadeGestoraDAO {
	
	public void salvar(UnidadeGestora ug);
		
	public void excluir(int id);
	
	public UnidadeGestora pesquisarPorID(int id);
	
	public List<UnidadeGestora> pesquisarPorNome(String s);
	
	public List<UnidadeGestora> pesquisarPorFuncao(int id);
	
	public List<UnidadeGestora> pesquisarPorOrgao(int id);
}
