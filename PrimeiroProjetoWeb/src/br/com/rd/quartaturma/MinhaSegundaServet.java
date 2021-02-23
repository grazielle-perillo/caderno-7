package br.com.rd.quartaturma;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MinhaSegundaServet")
public class MinhaSegundaServet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public MinhaSegundaServet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Executar regra de negócio
		RequestDispatcher rd = null;
		try {
			
			List<Curso> lista = new ArrayList<Curso>();
			lista.add(new Curso("Nivelamento", 40));
			lista.add(new Curso("Frontend", 60));
			lista.add(new Curso("Banco de Dados", 40));
			lista.add(new Curso("Java", 40));
			
			request.setAttribute("cursos", lista);
			
			// Chamar JSP
			rd = request.getRequestDispatcher("/pages/ExibeCurso.jsp");
			rd.forward(request, response);
			
			
		} catch (ServletException | IOException e) {
			request.setAttribute("erro", "Erro de servidor.");
			rd = request.getRequestDispatcher("/pages/erro-validacao.jsp");
			rd.forward(request, response);
			
			e.printStackTrace();
		} catch (Exception e) {
			request.setAttribute("erro", "Erro desconhecido");
			rd = request.getRequestDispatcher("/pages/erro-validacao.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
	
	