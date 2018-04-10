import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovoChamadoServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws IOException{
		
	PrintWriter	out = response.getWriter();
	
	out.println("<html>");
	out.println("<head>");
	out.println("<title>");
	out.println("Sistema de Cadastro de Chamados");
	out.println("</title>");
	out.println("</head>");
	out.println("<body>");
	out.println("<h1>");
	out.println("Meu Primeiro Servlet");
	out.println("</h1>");
	
	out.println("<form method='POST'>");
	out.println("Nome: ");	
	out.println("<input type='text' name='txtNome'>");
	out.println("<input type='submit' value='Cadastrar'>");
	out.println("</form>");
		
	out.println("</body>");
	out.println("</html>");	
	
		
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
	
		PrintWriter out = response.getWriter();		
		
		try {
			
			String nome = request.getParameter("txtNome");
			
			Class.forName("com.mysql.jdbc.Driver");
			
			try {
				
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssc","root","");
				
			} catch (SQLException e) {
			
				out.println("Erro de Conexão com Driver");
			}
				
		
		} catch (ClassNotFoundException ex) {			
			out.println("Erro de Conexão com Driver");
		}		
		
	}
	
}
