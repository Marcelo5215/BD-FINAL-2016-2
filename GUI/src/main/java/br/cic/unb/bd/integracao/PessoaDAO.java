package br.cic.unb.bd.integracao;

import java.util.List;

import br.cic.unb.bd.estrutura.Pessoa;

public interface PessoaDAO {
	
	public void salvar(Pessoa pe);
		
	public void excluir(int id);
	
	public Pessoa pesquisarPorCPF(int cpf);
	
	public List<Pessoa> pesquisarPorNome(String nome);
	
	public List<Pessoa> pesquisarPorOrgao(int id);
}
