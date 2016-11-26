package br.cic.unb.bd.integracao;

import java.util.List;

import br.cic.unb.bd.estrutura.Programa;

public interface ProgramaDAO {
	
	public void salvar(Programa prog);
		
	public void excluir(int id);
	
	public Programa pesquisarPorID(int id);
	
	public List<Programa> pesquisarPorNome(String s);
}
