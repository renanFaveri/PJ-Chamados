import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	out.println("<input type='text' name='txtNome'><br>");
	
	out.println("Cidade: ");	
	out.println("<input type='text' name='txtCidade'><br>");

	out.println("Data: ");	
	out.println("<input type='text' name='txtData'><br>");
	
	out.println("Descrição:");
	out.println("<textarea rows='4' cols='50' name='txtAreaDescricao'>  </textarea><br>");
	
	out.println("Sexo");
	out.println("<input type='radio' name='radioSexo' value='Homem' > Homem" + 
			" <input type='radio' name='radioSexo' value='Mulher'> Mulher<br>");
	
	out.println("Curso:");
	out.println("<select name= 'selectCurso'>" + 
			 " <option value='Técnico em Informatica'>Técnico em Informatica</option>" + 
			 " <option value='Técnico em Tecnologia'>Técnico em Tecnologia</option>" + 
			"</select>");
	
	out.println("<input type='submit' value='Cadastrar'>");
	
	
	
	out.println("</form>");
	
	out.println("</body>");
	out.println("</html>");	
	
		
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
	
		PrintWriter out = response.getWriter();		
		
		try {
			
			String nome = request.getParameter("txtNome");
			String cidade = request.getParameter("txtCidade");
			String datax = request.getParameter("txtData");
			String descricao = request.getParameter("txtAreaDescricao");
			String sexo = request.getParameter("radioSexo");
			String curso = request.getParameter("selectCurso");
			
			Class.forName("com.mysql.jdbc.Driver");
			String SQL = "INSERT INTO tab_chamados(nome,cidade,descricao,datax,sexo,curso)VALUES(?,?,?,?,?,?)";
			
			try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scc","root","");
			PreparedStatement pstm = conn.prepareStatement(SQL);
			
			pstm.setString(1,nome);
			pstm.setString(2,cidade);
			pstm.setString(3,descricao);
			pstm.setString(4,datax);
			pstm.setString(5,sexo);
			pstm.setString(6,curso);
			
			pstm.execute();
			pstm.close();
			conn.close();
			
			}catch(SQLException e){
				
				out.println("Erro de Conexão com o BD");
			}
		} catch (ClassNotFoundException ex) {			
			out.println("Erro de Conexão com Driver");
		}		
		
	}
	
}
