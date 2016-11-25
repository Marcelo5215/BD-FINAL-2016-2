package br.cic.unb.bd.integracao;

import br.cic.unb.bd.estrutura.Programa;

public interface ProgramaDAO {
	
	public void salvar(Programa prog);
	
	public void atualizar(Programa prog);
	
	public void excluir(String s);
	
	public Programa pesquisar(String s);
}
