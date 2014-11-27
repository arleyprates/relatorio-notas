package relatorio;

import java.util.ArrayList;

public class Aluno {

	private String nome;
	private int matricula;
	private int colegiado;
	private ArrayList<Avaliacao> avaliacao;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public int getColegiado() {
		return colegiado;
	}
	
	public void setColegiado(int colegiado) {
		this.colegiado = colegiado;
	}

	public ArrayList<Avaliacao> getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(ArrayList<Avaliacao> avaliacao) {
		this.avaliacao = avaliacao;
	}
}
