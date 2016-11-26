package br.cic.unb.bd.integracao;

import java.util.List;
import java.util.Date;

import br.cic.unb.bd.estrutura.Pagamento;

public interface PagamentoDAO {
	
	public void salvar(Pagamento pag);
		
	public void excluir(int id);
	
	public Pagamento pesquisarPorID(int id);

	public List<Pagamento> pesquisarPorNome(String s);
	
	public List<Pagamento> pesquisarPorValor(double valor);
	
	public List<Pagamento> pesquisarPorData(Date data);
	
	public List<Pagamento> pesquisarPorPessoa(int cpf);
}
