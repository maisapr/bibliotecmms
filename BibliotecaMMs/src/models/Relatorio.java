package models;

public class Relatorio {
	
	long id;
	int matricula;
	String aluno;
	String titulo;
	String autor;
	int edicao;
	String dataEmprestimo;
	boolean atraso;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public int getmatriculaAluno() {
		return matricula;
	}
	public void setMatriculaAluno(int matricula) {
		this.matricula = matricula;
	}
	public String getAluno() {
		return aluno;
	}
	public void setAluno(String aluno) {
		this.aluno = aluno;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	public String getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(String dataEmprestimo) {
			this.dataEmprestimo = dataEmprestimo; 
	}
	public boolean getAtraso() {
		   return atraso;
	}
	public void setAtraso(boolean atraso) {
		this.atraso = atraso;
	}
	
	
	
	
	}

