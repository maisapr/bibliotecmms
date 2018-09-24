package funcoeslogicas;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.AlunoDAO;
import models.Aluno;



public class ListarAluno implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		AlunoDAO dao = new AlunoDAO();
		List<Aluno> aluno = dao.getLista();
		
		request.setAttribute("aluno", aluno);
		
		return "listaAluno.jsp";
		
		

	}

}
