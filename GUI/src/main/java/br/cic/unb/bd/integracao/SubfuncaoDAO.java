package br.cic.unb.bd.integracao;

import java.util.List;

import br.cic.unb.bd.estrutura.Subfuncao;

public interface SubfuncaoDAO {
	public void salvar(Subfuncao sub);
		
	public void excluir(int id);
	
	public Subfuncao pesquisarPorID(int id);
	
	public List<Subfuncao> pesquisarPorNome(String s);
	
}
