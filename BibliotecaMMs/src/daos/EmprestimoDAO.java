package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import models.Aluno;
import models.Emprestimo;
import models.Livro;

public class EmprestimoDAO {
	private Connection connection;

	public EmprestimoDAO() {
		connection = ConnectionFactory.getConnection();
	}
	public boolean inserir(Emprestimo emprestimo) {

		String sql = "insert into Emprestimo (aluno, livro, dataEmprestimo) " + "values (?, ?, ?);";
	
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, emprestimo.getAluno().getId());
			stmt.setLong(2, emprestimo.getLivro().getId());
			stmt.setDate(3, new java.sql.Date(emprestimo.getDataEmprestimo().getTimeInMillis()));
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Emprestimo> getLista() {
		List<Emprestimo> resultado = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				// criando o objeto emprestimo
				
				Emprestimo emprestimo = new Emprestimo();
				
				//criando os objetos Aluno e Livro atrav�s dos parametros 
				
				//retornados emprestimo.aluno e emprestimo.livro
				
				Aluno aluno = new Aluno();
				aluno.setId(rs.getLong("aluno"));
				
				Livro livro = new LivroDAO().getLivroById(rs.getLong("livro"));
				emprestimo.setAluno(aluno);
				emprestimo.setLivro(livro);

				// montando datas atrav�s do Calendar
				
				Calendar dataEmprestimo = Calendar.getInstance();
				dataEmprestimo.setTime(rs.getDate("dataEmprestimo"));
				emprestimo.setDataEmprestimo(dataEmprestimo);

				Calendar dataDevolucao = null;
				dataDevolucao = (Calendar) dataEmprestimo.clone();
				dataDevolucao.add(Calendar.DAY_OF_MONTH , Emprestimo.DIAS_DE_DURACAO);
				
				emprestimo.setDataEmprestimo(dataEmprestimo);
				emprestimo.setDataDevolucao(dataDevolucao);
				
				//teste de status de atraso
				
				if(Calendar.getInstance().after(dataDevolucao)) {
					emprestimo.setSituacao(false);
				}else {
					emprestimo.setSituacao(true);
				}

				// adicionando o objeto � lista
				resultado.add(emprestimo);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	public List<Emprestimo> getListaByAluno(Aluno aluno) {
		List<Emprestimo> resultado = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo where aluno=?");
			stmt.setLong(1, aluno.getId());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				// criando o objeto emp
				
				Emprestimo emprestimo = new Emprestimo();
				
				//criando os objetos Aluno e Livro atrav�s dos parametros
				
				//retornados emprestimo.aluno e emprestimo.livro
				
				Livro livro = new LivroDAO().getLivroById(rs.getLong("livro"));
				emprestimo.setAluno(aluno);
				emprestimo.setLivro(livro);

				// montando datas atrav�s do Calendar
				
				Calendar dataEmprestimo = Calendar.getInstance();
				dataEmprestimo.setTime(rs.getDate("dataEmprestimo"));
				emprestimo.setDataEmprestimo(dataEmprestimo);

				Calendar dataDevolucao = null;
				dataDevolucao = (Calendar) dataEmprestimo.clone();
				dataDevolucao.add(Calendar.DAY_OF_MONTH , Emprestimo.DIAS_DE_DURACAO);
				
				emprestimo.setDataEmprestimo(dataEmprestimo);
				emprestimo.setDataDevolucao(dataDevolucao);
				
				//teste de status de atraso
				if(Calendar.getInstance().after(dataDevolucao)) {
					emprestimo.setSituacao(false);
				}else {
					emprestimo.setSituacao(true);
				}

				// adicionando o objeto � lista
				resultado.add(emprestimo);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	public List<Emprestimo> getListaByLivro(Livro livro) {
		List<Emprestimo> resultado = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo where livro=?");
			stmt.setLong(1, livro.getId());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto emp
				Emprestimo emprestimo = new Emprestimo();
				
				//criando os objetos Aluno e Livro atrav�s dos parametros 
				
				//retornados emprestimo.aluno e emprestimo.livro
				
				Aluno aluno = new AlunoDAO().getById(rs.getLong("aluno"));
				emprestimo.setAluno(aluno);
				emprestimo.setLivro(livro);

				// montando datas atrav�s do Calendar
				
				Calendar dataEmprestimo = Calendar.getInstance();
				dataEmprestimo.setTime(rs.getDate("dataEmprestimo"));
				emprestimo.setDataEmprestimo(dataEmprestimo);

				Calendar dataDevolucao = null;
				dataDevolucao = (Calendar) dataEmprestimo.clone();
				dataDevolucao.add(Calendar.DAY_OF_MONTH , Emprestimo.DIAS_DE_DURACAO);
				
				emprestimo.setDataEmprestimo(dataEmprestimo);
				emprestimo.setDataDevolucao(dataDevolucao);
				
				// Testando se o livro est� atrasado
				if(Calendar.getInstance().after(dataDevolucao)) {
					emprestimo.setSituacao(false);
				}else {
					emprestimo.setSituacao(true);
				}

				// Objeto emprestimo adicionado na lista
				resultado.add(emprestimo);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	public boolean remover(Emprestimo emprestimo) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from emprestimo where livro=?");
		
			stmt.setLong(1, emprestimo.getLivro().getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean removerByLivro(Livro livro) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from emprestimo where livro=?");
			
			stmt.setLong(1, livro.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
