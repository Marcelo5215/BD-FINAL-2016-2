package br.cic.unb.bd.integracao;

import java.util.List;

import br.cic.unb.bd.estrutura.OrgaoSubordinado;

public interface OrgaoSubordinadoDAO {
	
	public void salvar(OrgaoSubordinado Osub);
		
	public void excluir(int id);
	
	public List<OrgaoSubordinado> pesquisarPorNome(String s);
	
	public OrgaoSubordinado pesquisarPorID(int id);
	
	public List<OrgaoSubordinado> pesquisarPorSuperior(int id);
	
}
