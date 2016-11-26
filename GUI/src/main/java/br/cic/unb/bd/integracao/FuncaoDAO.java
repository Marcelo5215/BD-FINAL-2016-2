package br.cic.unb.bd.integracao;

import java.util.List;

import br.cic.unb.bd.estrutura.Funcao;

public interface FuncaoDAO {
	
	public void salvar(Funcao f);
		
	public void excluir(int id);
	
	public List<Funcao> pesquisarPorNome(String s);
	
	public Funcao pesquisarPorID(int id);
		
	
}
