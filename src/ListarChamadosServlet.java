

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarChamadosServlet extends HttpServlet {

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scc","root","");
			
			}catch(SQLException e){
				out.println("Erro de Conexão com o BD");
			}
			
		} catch (ClassNotFoundException ex) {			
			out.println("Erro de Conexão com Driver");
		}		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
