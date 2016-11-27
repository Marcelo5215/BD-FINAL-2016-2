package br.cic.unb.bd.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.cic.unb.bd.estrutura.OrgaoSubordinado;

public class OrgaoSubordinadoDAO implements br.cic.unb.bd.integracao.OrgaoSubordinadoDAO{

	public void salvar(OrgaoSubordinado Osub) {
		EntityManager em = HibernateUtil.instance().em();
		//permite comecar a transacao para o bd
		em.getTransaction().begin();
		
		if (pesquisarPorID(Osub.getID()) == null){
			//se nao tiver no bd, cria
			em.persist(Osub);
		}
		else{
			//se ja tiver no bd, atualiza
			Osub = em.merge(Osub);
		}
		em.flush();
		//finaliza transacao
		em.getTransaction().commit();
		em.close();
		
	}

	public void excluir(int id) {
		EntityManager em = HibernateUtil.instance().em();
		
		em.getTransaction().begin();
		OrgaoSubordinado Osub = pesquisarPorID(id);
		if(Osub != null){
			em.remove(em.contains(Osub) ? Osub : em.merge(Osub));
			em.flush();
			em.getTransaction().commit();
		}
		em.close();		
	}

	public List<OrgaoSubordinado> pesquisarPorNome(String s) {
		String consulta = "FROM OrgaoSubordinado as Osub where Osub.nome = :pmtNome";
		
		EntityManager em = HibernateUtil.instance().em();
		List<OrgaoSubordinado> subs = em.createQuery(consulta).setParameter("pmtNome", s).getResultList();
		
		if (subs == null || subs.size()==0){
			return null;
		}
		return subs;
	}

	public OrgaoSubordinado pesquisarPorID(int id) {
		String consulta = "FROM OrgaoSubordinado as Osub where Osub.orsubID = :pmtID";
		
		EntityManager em = HibernateUtil.instance().em();
		
		List<OrgaoSubordinado> sub = em.createQuery(consulta).setParameter("pmtID", id).getResultList();
		
		if (sub == null || sub.size()==0){
			return null;
		}
		return sub.get(0);
	}

	public List<OrgaoSubordinado> pesquisarPorSuperior(int id) {
		String consulta = "FROM OrgaoSubordinado as Osub where Osub.superior.orgID = :pmtID";
		
		EntityManager em = HibernateUtil.instance().em();
		
		List<OrgaoSubordinado> subs = em.createQuery(consulta).setParameter("pmtID", id).getResultList();
		
		if (subs == null || subs.size()==0){
			return null;
		}
		return subs;
	}

}
