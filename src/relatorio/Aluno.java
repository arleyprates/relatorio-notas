package relatorio;

public class Aluno extends Avaliacao{

	private String nome;
	private int matricula;
	private int colegiado;
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
	
}
