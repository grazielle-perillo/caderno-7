package br.com.rd.quartaturma;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.rd.quartaturma.dao.CidadeDAO;
import br.com.rd.quartaturma.entity.CidadeEntity;
import br.com.rd.quartaturma.vo.Cidade;

@WebServlet("/ChamadaJspCidades")
public class ChamadaJspCidades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChamadaJspCidades() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if(acao == null) {
			this.listarCidades(request, response);
		}else if(acao.equals("editar")) {
			this.editarCidade(request, response);
		}else if(acao.equals("remover")){
			this.excluirCidade(request, response);
		}else if(acao.equals("novo")) {
			RequestDispatcher rd = request.getRequestDispatcher("/pages/nova-cidade.jsp");
			rd.forward(request, response);
		}
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = ConexaoMySql.obterConexao();
		CidadeDAO cidadeDAO = new CidadeDAO(conn);
		
		String acao = request.getParameter("acao");
		
		if(acao.equals("alterar"))
			this.atualizaCidade(cidadeDAO, request);
		else if(acao.equals("novo"))
			this.insereCidade(cidadeDAO, request);
		
		listarCidades(request, response);
		
	}
    
    private void atualizaCidade(CidadeDAO cidadeDAO, HttpServletRequest request) {
    	String numeroIbge  = request.getParameter("ibge");
		String nomeCidade  =  request.getParameter("nome");
		String id  = request.getParameter("id");
		Long nIbge = Long.parseLong(numeroIbge);
		
		//Cidade cidade = new Cidade();
		//cidade.setCidadeIbge(Integer.valueOf(numeroIbge));
		//cidade.setCidade(nomeCidade);
		//cidade.setIdCidade(Integer.valueOf(id));
		//cidadeDAO.atualizarCidade(cidade);
		
		EntityManager em = CrudEntityManager.getEntityManager();
		CidadeEntity cidadeEntity = em.find(CidadeEntity.class, new BigInteger(id));
		cidadeEntity.setCidade(nomeCidade);
		cidadeEntity.setCidadeIbge(BigInteger.valueOf(nIbge));

		em.getTransaction().begin();
		em.merge(cidadeEntity);
		em.getTransaction().commit();
	}

    private void insereCidade(CidadeDAO cidadeDAO, HttpServletRequest request) {
		String nomeCidade  =  request.getParameter("nome");
		String numeroIbge  = request.getParameter("ibge");
		Long nIbge = Long.parseLong(numeroIbge);

		//	Cidade cidade = new Cidade();
		//		cidade.setCidade(nomeCidade);
		//		cidade.setCidadeIbge(numeroIbge);
		//		cidadeDAO.inserirCidade(cidade);
		CidadeEntity cidadeEntity = new CidadeEntity();
		cidadeEntity.setCidade(nomeCidade);
		cidadeEntity.setCidadeIbge(BigInteger.valueOf(nIbge));
		cidadeEntity.setIdUf(BigInteger.valueOf(1));
		
		EntityManager em = CrudEntityManager.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(cidadeEntity);
		
		em.getTransaction().commit();
	}
    
	protected void listarCidades(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Connection conn = ConexaoMySql.obterConexao();
		//CidadeDAO cidadeDAO = new CidadeDAO(conn);
		
		RequestDispatcher rd = null;
		
	//	try {
			//List<Cidade> cidades = cidadeDAO.getCidades();
			//request.setAttribute("cidades", cidades);
			EntityManager em = CrudEntityManager.getEntityManager();
			Query query = em.createNamedQuery("Cidade.findAll", CidadeEntity.class);
			
		    List<CidadeEntity> cidadesEntity =  query.getResultList();
		    
			request.setAttribute("cidades", cidadesEntity);
			rd = request.getRequestDispatcher("/pages/exibe-cidades.jsp");
			rd.forward(request, response);
			
		//} catch (SQLException e) {
		//	request.setAttribute("erro", "Erro ao consultar lista de cidades");
		//	e.printStackTrace();
		//}
	}
		
	private void editarCidade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		String id = request.getParameter("id");
		
		//Connection conn = ConexaoMySql.obterConexao();
		//CidadeDAO cidadeDAO = new CidadeDAO(conn);
		EntityManager em = CrudEntityManager.getEntityManager();
		
	//	try {
			//Cidade cidade = cidadeDAO.getCidadeById(Integer.valueOf(id));
			CidadeEntity cidadeEntity = em.find(CidadeEntity.class, new BigInteger(id));
			request.setAttribute("cidade", cidadeEntity);
			
			rd = request.getRequestDispatcher("/pages/altera-cidade.jsp");
			rd.forward(request, response);
			
	//	} catch (Exception e) {
		//	request.setAttribute("erro", "Erro ao editar cidade");
		//	e.printStackTrace();
		//}
		
	}
	
	private void excluirCidade(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String id = request.getParameter("id");
		
		//Connection conn = ConexaoMySql.obterConexao();
		//CidadeDAO cidadeDAO = new CidadeDAO(conn);	
		EntityManager em = CrudEntityManager.getEntityManager();
		
		//cidadeDAO.excluirCidade(Integer.valueOf(id));
		CidadeEntity cidadeEntity = em.find(CidadeEntity.class, new BigInteger(id));
		em.getTransaction().begin();
		em.remove(cidadeEntity);
		em.getTransaction().commit();

		//Listar novamente os usuários
		///listarCidades(request, response);
		this.listarCidades(request, response);
	}
}
