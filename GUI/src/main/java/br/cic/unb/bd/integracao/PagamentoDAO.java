package br.cic.unb.bd.integracao;

import br.cic.unb.bd.estrutura.Pagamento;

public interface PagamentoDAO {
	
	public void salvar(Pagamento pag);
	
	public void atualizar(Pagamento pag);
	
	public void excluir(String s);
	
	public Pagamento pesquisar(String s);
}
