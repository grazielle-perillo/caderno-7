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
import br.com.rd.projeto.entity.TipoExameEntity;

@WebServlet("/ChamadaTipoExame")
public class ChamadaTipoExame extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ChamadaTipoExame() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if(acao == null) {
			this.listarTipoExame(request, response);
		}else if(acao.equals("editar")) {
			this.editarTipoExame(request, response);
		}else if(acao.equals("remover")){
			this.excluirTipoExame(request, response);
		}else if(acao.equals("novo")) {
			RequestDispatcher rd = request.getRequestDispatcher("/pagesExame/novo-tipo-exame.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		if(acao.equals("alterar"))
			this.atualizaTipoExame(request);
		else if(acao.equals("novo"))
			this.insereTipoExame(request);
		
		listarTipoExame(request, response);
		
	}

	private void atualizaTipoExame(HttpServletRequest request) {
		String nomeExame  =  request.getParameter("nome");
		String id  = request.getParameter("id");
		
		EntityManager em = CrudEntityManager.getEntityManager();
		TipoExameEntity tipoExameEntity = em.find(TipoExameEntity.class, new BigInteger(id));
		tipoExameEntity.setDsTipoExame(nomeExame);

		em.getTransaction().begin();
		em.merge(tipoExameEntity);
		em.getTransaction().commit();
	}

	private void insereTipoExame(HttpServletRequest request) {
		String nomeExame  =  request.getParameter("nome");
		
		TipoExameEntity tipoExameEntity = new TipoExameEntity();
		tipoExameEntity.setDsTipoExame(nomeExame);
		
		EntityManager em = CrudEntityManager.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(tipoExameEntity);
		
		em.getTransaction().commit();
	}
	
	protected void listarTipoExame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd = null;
		
		EntityManager em = CrudEntityManager.getEntityManager();
		Query query = em.createNamedQuery("TipoExame.findAll", TipoExameEntity.class);
			
	    List<TipoExameEntity> TipoExameEntity =  query.getResultList();
		    
		request.setAttribute("exames", TipoExameEntity);
		rd = request.getRequestDispatcher("/pagesExame/exibe-exame.jsp");
		rd.forward(request, response);
	}
	
	private void editarTipoExame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		String id = request.getParameter("id");
		
		EntityManager em = CrudEntityManager.getEntityManager();
		
		TipoExameEntity tipoExameEntity = em.find(TipoExameEntity.class, new BigInteger(id));
		request.setAttribute("exame", tipoExameEntity);
		
		rd = request.getRequestDispatcher("/pagesExame/altera-exame.jsp");
		rd.forward(request, response);
	}
	
	private void excluirTipoExame(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String id = request.getParameter("id");
		
		EntityManager em = CrudEntityManager.getEntityManager();
		
		TipoExameEntity tipoExameEntity = em.find(TipoExameEntity.class, new BigInteger(id));
		em.getTransaction().begin();
		em.remove(tipoExameEntity);
		em.getTransaction().commit();

		this.listarTipoExame(request, response);
	}
}
