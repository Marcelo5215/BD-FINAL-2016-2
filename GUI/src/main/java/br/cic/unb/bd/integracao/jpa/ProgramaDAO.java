package br.cic.unb.bd.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.cic.unb.bd.estrutura.Programa;

public class ProgramaDAO implements br.cic.unb.bd.integracao.ProgramaDAO{

	public void salvar(Programa prog) {
		EntityManager em = HibernateUtil.instance().em();
		//permite comecar a transacao para o bd
		em.getTransaction().begin();
		
		if (pesquisarPorID(prog.getID()) == null){
			//se nao tiver no bd, cria
			em.persist(prog);
		}
		else{
			//se ja tiver no bd, atualiza
			prog = em.merge(prog);
		}
		em.flush();
		//finaliza transacao
		em.getTransaction().commit();
		em.close();
	}

	public void excluir(int id) {
		EntityManager em = HibernateUtil.instance().em();
		
		em.getTransaction().begin();
		Programa prog = pesquisarPorID(id);
		if(prog != null){
			em.remove(em.contains(prog) ? prog : em.merge(prog));
			em.flush();
			em.getTransaction().commit();
		}
		em.close();
	}

	public Programa pesquisarPorID(int id) {
		String consulta = "FROM Programa as prog where prog.ID = :pmtID";
		
		EntityManager em = HibernateUtil.instance().em();
		
		List<Programa> prog = em.createQuery(consulta).setParameter("pmtID", id).getResultList();
		
		if (prog == null || prog.size()==0){
			return null;
		}
		return prog.get(0);
	}

	public List<Programa> pesquisarPorNome(String s) {
		String consulta = "FROM Programa as prog where prog.name = :pmtNome";
		
		EntityManager em = HibernateUtil.instance().em();
		List<Programa> prog = em.createQuery(consulta).setParameter("pmtNome", s).getResultList();
		
		if (prog == null || prog.size()==0){
			return null;
		}
		return prog;
	}

}
