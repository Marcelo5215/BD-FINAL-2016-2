package br.cic.unb.bd.integracao;

import java.util.List;

import br.cic.unb.bd.estrutura.Acao;

//Introducao das operacoes basicas utilizadas em uma camada de persistencia
public interface AcaoDAO {
	
	public void salvar(Acao a);
		
	public void excluir(int id);
	
	public List<Acao> pesquisarPorNome(String s);
	
	public Acao pesquisarPorID(int id);
	
	public List<Acao> pesquisarPorLinguagem(String s);
	
	public List<Acao> pesquisarPorPagamento(int id);
	
}
