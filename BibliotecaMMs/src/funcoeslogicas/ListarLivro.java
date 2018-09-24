package funcoeslogicas;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.LivroDAO;
import models.Livro;



public class ListarLivro implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		LivroDAO dao = new LivroDAO();
		List<Livro> livros = dao.getLista();
		
		request.setAttribute("livros", livros);
		
		return "listaLivros.jsp";
		
		

	}

}
