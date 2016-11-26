package br.cic.unb.bd.integracao;

import java.util.List;

import br.cic.unb.bd.estrutura.OrgaoSuperior;

public interface OrgaoSuperiorDAO {
	
	public void salvar(OrgaoSuperior Osup);
		
	public void excluir(int id);
	
	public OrgaoSuperior pesquisarPorID(int id);
	
	public List<OrgaoSuperior> pesquisarPorNome(String s);
}
