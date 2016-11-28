package br.cic.unb.bd.integracao.jpa.queries;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.cic.unb.bd.estrutura.*;
import br.cic.unb.bd.integracao.jpa.HibernateUtil;
import br.cic.unb.bd.integracao.jpa.OrgaoSuperiorDAO;
import br.cic.unb.bd.integracao.jpa.PessoaDAO;
import br.cic.unb.bd.integracao.jpa.queries.*;

public class Queries {
	
	public double quantoPessoaGastou(int cpf){
		PessoaDAO pDAO = new PessoaDAO();
		Pessoa p = new Pessoa();
		
		p = pDAO.pesquisarPorCPF(cpf);
		
		if(p == null){
			return 0;
		}
		
		EntityManager em = HibernateUtil.instance().em();
		String consulta = "SELECT SUM(dp.valor) "
				+ "FROM Pagamento AS dp "
				+ "JOIN Pessoa AS p ON dp.pessoa.CPF = p.CPF "
				+ "WHERE p.CPF = :pmtID";
		
		Query query = em.createQuery(consulta).setParameter("pmtID", cpf);
		
		List<Object> resultados = query.getResultList();
		
		double resultado = new Double((resultados.get(0)).toString());
		return resultado;
	}
	
	public double quantoOrgaoSuperiorGastou(String s){
		OrgaoSuperiorDAO osupDAO = new OrgaoSuperiorDAO();
		List<OrgaoSuperior> osup = new ArrayList<OrgaoSuperior>();
		
		osup = osupDAO.pesquisarPorNome(s);
		
		if(osup == null){
			return 0;
		}
		
		EntityManager em = HibernateUtil.instance().em();
		String consulta = "SELECT SUM(dp.valor) "
				+ "FROM Pagamento AS dp "
				+ "JOIN Pessoa AS p ON dp.pessoa.CPF = p.CPF "
				+ "JOIN OrgaoSuperior AS os ON os.orgID = p.superior.orgID "
				+ "WHERE os.name LIKE :pmtNome";
		
		Query query = em.createQuery(consulta).setParameter("pmtNome", s);
		
		List<Object> resultados = query.getResultList();
		
		double resultado = new Double((resultados.get(0)).toString());
		return resultado;
	}
	
	public List<PessoaValorTotal> quantoTodasPessoasGastaram(){
		EntityManager em = HibernateUtil.instance().em();
		String consulta = "select p.name, sum(dp.valor) "
				+ "from Pagamento as dp "
				+ "join Pessoa as p on dp.pessoa.CPF = p.CPF "
				+ "group by p.name "
				+ "order by sum(dp.valor) desc, p.name";
		
		Query query = em.createQuery(consulta);
		List<Object[]> tuplas = query.getResultList();
		List<PessoaValorTotal> resultados = new ArrayList<PessoaValorTotal>();
		
		for (Object[] obj : tuplas){
			PessoaValorTotal elemento = new PessoaValorTotal();
			elemento.setNome((String)obj[0]);
			elemento.setValor((Double)obj[1]);
			
			resultados.add(elemento);
		}
		return resultados;
	}
	
	public List<PessoaViagemTotal> quantoTodasPessoasViajaram(){
		EntityManager em = HibernateUtil.instance().em();
		String consulta = "select p.name, count(dp.valor) "
				+ "from Pagamento as dp "
				+ "join Pessoa as p on dp.pessoa.CPF = p.CPF "
				+ "group by p.name "
				+ "order by count(dp.valor) desc, p.name ";
		
		Query query = em.createQuery(consulta).setMaxResults(100);
		List<Object[]> tuplas = query.getResultList();
		List<PessoaViagemTotal> resultados = new ArrayList<PessoaViagemTotal>();
		
		for (Object[] obj : tuplas){
			PessoaViagemTotal elemento = new PessoaViagemTotal();
			elemento.setNome((String)obj[0]);
			elemento.setViagens((Long)obj[1]);
			
			resultados.add(elemento);
		}
		return resultados;
	}
	
	public List<PessoaPagamento> quantoPessoaMaisGastou(){
		EntityManager em = HibernateUtil.instance().em();
		String consulta1 = "select p.name, p.CPF, count(dp.valor) "
				+ "from Pagamento as dp "
				+ "join Pessoa as p on dp.pessoa.CPF = p.CPF "
				+ "group by p.CPF, p.name "
				+ "order by count(dp.valor) desc, p.name";
		Query query1 = em.createQuery(consulta1).setMaxResults(1);
		
		List<Object[]> tuplas1 = query1.getResultList();
		List<PessoaViagemTotal> resultados = new ArrayList<PessoaViagemTotal>();
		
		for (Object[] obj : tuplas1){
			PessoaViagemTotal elemento = new PessoaViagemTotal();
			elemento.setNome((String)obj[0]);
			elemento.setCpf((Integer)obj[1]);
			elemento.setViagens((Long)obj[2]);
			
			resultados.add(elemento);
		}
		
		//select externo
		PessoaViagemTotal sel1 = resultados.get(0);

		
		String consulta2 = "select sel1.nome, dp2.data, dp2.valor from "
				+ ":pmtPVT as sel1"
				+ "join Pagamento as dp2 on dp2.pessoa.CPF = sel1.CPF "
				+ "order by dp2.valor";
		Query query2 = em.createQuery(consulta2).setParameter("pmtPVT", sel1);
		List<Object[]> tuplas2 = query2.getResultList();
		List<PessoaPagamento> finais = new ArrayList<PessoaPagamento>();
		
		for (Object[] obj : tuplas1){
			PessoaPagamento elemento = new PessoaPagamento();
			elemento.setPessoaNome((String)obj[0]);
			elemento.setData((java.util.Date)obj[1]);
			elemento.setValor((Double)obj[2]);
			
			finais.add(elemento);
		}
		return finais;
	}
	
}
