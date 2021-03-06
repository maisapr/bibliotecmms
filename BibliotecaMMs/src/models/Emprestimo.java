package models;

import java.util.Calendar;

public class Emprestimo {

	public final static int DIAS_DE_DURACAO = 14;
	public final static int MAXIMO_ALUNO = 3;

	private Calendar dataEmprestimo;
	private Calendar dataDevolucao;
	private Livro livro; // Id do Livro
	private Aluno aluno; // Matricula do Aluno
	private boolean situacao; // Situa��o do Aluno

	public boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public Livro getLivro() {
		return this.livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Calendar dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Calendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

}
