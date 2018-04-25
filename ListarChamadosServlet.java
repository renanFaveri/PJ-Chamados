

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarChamadosServlet extends HttpServlet {

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
	try {	
		
try {
	
	        String SQL = "Select * FROM tab_chamados";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scc","root","");
			
			if(request.getParameter("id")!=null) {
			
			int ID = Integer.parseInt(request.getParameter("id"));
			String SQLDelete = "DELETE From tab_chamados WHERE id=?";
			
			PreparedStatement pstn = conn.prepareStatement(SQLDelete);
			pstn.setInt(1,ID);
			pstn.execute();
			
			}
			
			Statement stn= conn.createStatement();
			ResultSet rs = stn.executeQuery(SQL);
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>");
			out.println("Sistema de Lista de Chamados");
			out.println("</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>");
			out.println("Lista de Chamados");
			out.println("</h1>");
			
			out.println("<table width='100%' border='1'>");
			out.println("<tr>");
			out.println("<th>Nome</th>");
			out.println("<th>Cidade</th>");
			out.println("<th>Editar</th>");
			out.println("<th>Excluir</th>");
			out.println("<tr>");
			
			out.println("<table width='100%' border='1'>");
			out.println("<tr>");
			out.println("<th>Nome</th>");
			out.println("<th>Cidade</th>");
			out.println("<th>Editar</th>");
			out.println("<th>Excluir</th>");
			out.println("<tr>");
			
			while(rs.next()) {
				
				out.println("<table width='100%' border='1'>");
				out.println("<td>"+rs.getString("nome")+"</td>");
				out.println("<td>"+rs.getString("cidade")+"</td>");				
				
				out.println("<td>Editar</td>");
				out.println("<td><a href='http://localhost:8080/PJ-Chamados_v2/Listar?id'"+rs.getInt("id")+">[Excluir]</a></td>");
				out.println("<tr>");				
			}
	
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");	
			
			stn.execute(SQL);
			stn.close();
			conn.close();
		
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
