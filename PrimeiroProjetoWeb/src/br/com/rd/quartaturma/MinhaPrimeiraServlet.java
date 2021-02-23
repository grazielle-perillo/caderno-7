package br.com.rd.quartaturma;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MinhaPrimeiraServlet
 */
@WebServlet("/MinhaPrimeiraServlet")
public class MinhaPrimeiraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MinhaPrimeiraServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
	try {
		out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Minha servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Minha primeira servlet</h1>");
		out.println("</body>");
		out.println("</html>");
	} catch (IOException e) {
		System.out.println("Erro ao criar servlet" + e.getMessage());
	}
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

doGet(request, response);
}
}
