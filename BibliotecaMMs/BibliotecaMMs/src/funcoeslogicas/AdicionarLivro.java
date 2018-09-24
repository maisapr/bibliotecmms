package funcoeslogicas;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.LivroDAO;
import models.Livro;

public class AdicionarLivro implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
			{
		
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String editora = request.getParameter("editora");
		String edicao = request.getParameter("edicao");
		String dataEmTexto = request.getParameter("dataPublicacao");

		Calendar dataFinalPublicacao = null;

		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataFinalPublicacao = Calendar.getInstance();
			dataFinalPublicacao.setTime(date);
			
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Livro livro = new Livro();
		livro.setTitulo(titulo);
		livro.setAutor(autor);
		livro.setEditora(editora);
		livro.setEdicao(edicao);
		livro.setDataPublicacao(dataFinalPublicacao);

		LivroDAO dao = new 	LivroDAO();
		dao.inserir(livro);
		
		return "livroAdicionado.jsp"; 

	}

}
	

