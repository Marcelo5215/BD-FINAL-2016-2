package br.cic.unb.bd.integracao;

import br.cic.unb.bd.estrutura.Acao;

//Introducao das operacoes basicas utilizadas em uma camada de persistencia
public interface AcaoDAO {
	
	public void salvar(Acao a);
	
	public void atualizar(Acao a);
	
	public void excluir(String s);
	
	public Acao pesquisar(String s);
	
}
