package funcoeslogicas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.LivroDAO;
import models.Livro;

public class BuscarLivro implements Logica {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String titulo = request.getParameter("titulo");
		List<Livro> resultado = new ArrayList<>();
		
	
	
	return"listaLivros.jsp";
}

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
}