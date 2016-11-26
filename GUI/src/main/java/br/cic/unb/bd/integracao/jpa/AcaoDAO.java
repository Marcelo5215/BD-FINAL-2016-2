package br.cic.unb.bd.integracao.jpa;

import br.cic.unb.bd.estrutura.Acao;

import java.util.List;

import javax.persistence.EntityManager;



/**
 * Classe de persistencia para implementar as operacoes
 * a serem realizadas sobre a entidade Acao do BD
 * @author Davi
 *
 */
public class AcaoDAO implements br.cic.unb.bd.integracao.AcaoDAO{


	public void salvar(Acao a) {
		EntityManager em = HibernateUtil.instance().em();
		//permite comecar a transacao para o bd
		em.getTransaction().begin();
		
		if (pesquisarPorID(a.getID()) == null){
			//se nao tiver no bd, cria
			em.persist(a);
		}
		else{
			//se ja tiver no bd, atualiza
			a = em.merge(a);
		}
		em.flush();
		//finaliza transacao
		em.getTransaction().commit();
		em.close();
	}


	public void excluir(int id) {
		EntityManager em = HibernateUtil.instance().em();
		
		em.getTransaction().begin();
		Acao acao = pesquisarPorID(id);
		if(acao != null){
			em.remove(em.contains(acao) ? acao : em.merge(acao));
			em.flush();
			em.getTransaction().commit();
		}
		em.close();
	}

	public List<Acao> pesquisarPorNome(String s) {
		String consulta = "SELECT * FROM ACAO a WHERE a.nome = :pmtNome";
		
		EntityManager em = HibernateUtil.instance().em();
		List<Acao> acoes = em.createNamedQuery(consulta).setParameter("pmtNome", s).getResultList();
		
		if (acoes == null || acoes.size()==0){
			return null;
		}
		return acoes;
	}

	public Acao pesquisarPorID(int id) {
		String consulta = "SELECT * FROM ACAO a WHERE a.acaoID = :pmtID";
		
		EntityManager em = HibernateUtil.instance().em();
		
		List<Acao> acao = em.createNamedQuery(consulta).setParameter("pmtID", id).getResultList();
		
		if (acao == null || acao.size()==0){
			return null;
		}
		return acao.get(0);
	}
	
	public List<Acao> pesquisarPorLinguagem(String s) {
		String consulta = "SELECT * FROM ACAO a WHERE a.LinguagemCidada = :pmtNome";
		
		EntityManager em = HibernateUtil.instance().em();
		List<Acao> acoes = em.createNamedQuery(consulta).setParameter("pmtNome", s).getResultList();
		
		if (acoes == null || acoes.size()==0){
			return null;
		}
		return acoes;
	}


	public List<Acao> pesquisarPorPagamento(int id) {
		String consulta = "SELECT * FROM ACAO a WHERE a.docpagID_DOCPAG = :pmtID";
		
		EntityManager em = HibernateUtil.instance().em();
		
		List<Acao> acoes = em.createNamedQuery(consulta).setParameter("pmtID", id).getResultList();
		
		if (acoes == null || acoes.size()==0){
			return null;
		}
		return acoes;
	}
	
	
	
}
