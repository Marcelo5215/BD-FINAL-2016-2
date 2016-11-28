package br.cic.unb.bd.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.cic.unb.bd.estrutura.Acao;
import br.cic.unb.bd.estrutura.UnidadeGestora;

public class UnidadeGestoraDAO implements br.cic.unb.bd.integracao.UnidadeGestoraDAO{

	public void salvar(UnidadeGestora ug) {
		EntityManager em = HibernateUtil.instance().em();
		//permite comecar a transacao para o bd
		em.getTransaction().begin();
		
		if (pesquisarPorID(ug.getID()) == null){
			//se nao tiver no bd, cria
			em.persist(ug);
		}
		else{
			//se ja tiver no bd, atualiza
			ug = em.merge(ug);
		}
		em.flush();
		//finaliza transacao
		em.getTransaction().commit();
		em.close();
	}

	public void excluir(int id) {
		EntityManager em = HibernateUtil.instance().em();
		
		em.getTransaction().begin();
		UnidadeGestora ug = pesquisarPorID(id);
		if(ug != null){
			em.remove(em.contains(ug) ? ug : em.merge(ug));
			em.flush();
			em.getTransaction().commit();
		}
		em.close();
	}

	public UnidadeGestora pesquisarPorID(int id) {
		String consulta = "FROM UnidadeGestora as ug where ug.ID = :pmtID";
		
		EntityManager em = HibernateUtil.instance().em();
		
		List<UnidadeGestora> ug = em.createQuery(consulta).setParameter("pmtID", id).getResultList();
		
		if (ug == null || ug.size()==0){
			return null;
		}
		return ug.get(0);
	}

	public List<UnidadeGestora> pesquisarPorNome(String s) {
		String consulta = "FROM UnidadeGestora as ug where ug.nome = :pmtNome";
		
		EntityManager em = HibernateUtil.instance().em();
		List<UnidadeGestora> ug = em.createQuery(consulta).setParameter("pmtNome", s).getResultList();
		
		if (ug == null || ug.size()==0){
			return null;
		}
		return ug;
	}

	public List<UnidadeGestora> pesquisarPorFuncao(int id) {
		String consulta = "FROM UnidadeGestora as ug where ug.funcao.id = :pmtID";
		
		EntityManager em = HibernateUtil.instance().em();
		
		List<UnidadeGestora> ugs = em.createQuery(consulta).setParameter("pmtID", id).getResultList();
		
		if (ugs == null || ugs.size()==0){
			return null;
		}
		return ugs;
	}

	public List<UnidadeGestora> pesquisarPorOrgao(int id) {
		String consulta = "FROM UnidadeGestora as ug where ug.orgSub.orsubID = :pmtID";
		
		EntityManager em = HibernateUtil.instance().em();
		
		List<UnidadeGestora> ugs = em.createQuery(consulta).setParameter("pmtID", id).getResultList();
		
		if (ugs == null || ugs.size()==0){
			return null;
		}
		return ugs;
	}

}
