package br.com.aula.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aula.dao.ContatoDao;
import br.com.aula.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * O método service aceita todos os métodos HTTP. Para dar tratamento específico
	 * usa-se os métodos doGet e doPost Além do GET e do POST, o protocolo HTTP
	 * possui ainda mais 7 métodos: PUT, DELETE, HEAD, TRACE, CONNECT, OPTIONS e
	 * PATCH.
	 */
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response)
					throws IOException, ServletException {
		
		// busca o writer
		PrintWriter out = response.getWriter();
		
		// buscando os parâmetros no request
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("nascimento");
		Calendar nascimento = null;

		// fazendo a conversão da data		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			nascimento = Calendar.getInstance();
			nascimento.setTime(date);
		} catch (Exception e) {
			out.println("Erro de conversão da data: " + e.getMessage());
			return; //para a execução do método
		}
		
		// monta um objeto contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setNascimento(nascimento);
		
		// salva o contato
		try {
			
			ContatoDao dao = new ContatoDao();
			dao.adiciona(contato);
		
			RequestDispatcher rd = request.getRequestDispatcher("/NewContact	.jsp");
			rd.forward(request,response);
			
		}catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}