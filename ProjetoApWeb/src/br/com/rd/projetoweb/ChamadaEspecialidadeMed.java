package br.com.rd.projetoweb;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.rd.projeto.entity.EspecialidadeEntity;

@WebServlet("/ChamadaEspecialidadeMed")
public class ChamadaEspecialidadeMed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChamadaEspecialidadeMed() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if(acao == null) {
			this.listarEspecialidade(request, response);
		}else if(acao.equals("editar")) {
			this.editarEspecialidade(request, response);
		}else if(acao.equals("remover")){
			this.excluirEspecialidade(request, response);
		}else if(acao.equals("novo")) {
			RequestDispatcher rd = request.getRequestDispatcher("/pagesEspecialidade/nova-especialidade.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if(acao.equals("alterar"))
			this.atualizarEspecialidade(request);
		else if(acao.equals("novo"))
			this.insereEspecialidade(request);
		
		listarEspecialidade(request, response);
	}
	
	private void atualizarEspecialidade(HttpServletRequest request) {
		String nomeEspecialidade  =  request.getParameter("nome");
		String id  = request.getParameter("id");
		
		EntityManager em = CrudEntityManager.getEntityManager();
		EspecialidadeEntity especialidadeEntity = em.find(EspecialidadeEntity.class, new BigInteger(id));
		especialidadeEntity.setDsEspecialidade(nomeEspecialidade);

		em.getTransaction().begin();
		em.merge(especialidadeEntity);
		em.getTransaction().commit();
	}
	
	private void insereEspecialidade(HttpServletRequest request) {
		String nomeEspecialidade  =  request.getParameter("nome");
		
		EspecialidadeEntity especialidadeEntity = new EspecialidadeEntity();
		especialidadeEntity.setDsEspecialidade(nomeEspecialidade);
		
		EntityManager em = CrudEntityManager.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(especialidadeEntity);
		
		em.getTransaction().commit();
	}
	
	protected void listarEspecialidade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		
		EntityManager em = CrudEntityManager.getEntityManager();
		Query query = em.createNamedQuery("Especialidade.findAll", EspecialidadeEntity.class);
			
	    List<EspecialidadeEntity> especialidadeEntity =  query.getResultList();
		    
		request.setAttribute("especialidades", especialidadeEntity);
		rd = request.getRequestDispatcher("/pagesEspecialidade/exibe-especialidade.jsp");
		rd.forward(request, response);
	}
	
	private void editarEspecialidade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		String id = request.getParameter("id");
		
		EntityManager em = CrudEntityManager.getEntityManager();
		
		EspecialidadeEntity especialidadeEntity = em.find(EspecialidadeEntity.class, new BigInteger(id));
		request.setAttribute("especialidade", especialidadeEntity);
		
		rd = request.getRequestDispatcher("/pagesEspecialidade/altera-especialidade.jsp");
		rd.forward(request, response);
	}
	
	private void excluirEspecialidade(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String id = request.getParameter("id");
		
		EntityManager em = CrudEntityManager.getEntityManager();
		
		EspecialidadeEntity especialidadeEntity = em.find(EspecialidadeEntity.class, new BigInteger(id));
		em.getTransaction().begin();
		em.remove(especialidadeEntity);
		em.getTransaction().commit();

		this.listarEspecialidade(request, response);
	}
}
