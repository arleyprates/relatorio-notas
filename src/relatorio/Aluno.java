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
	
	public static void main(String[] args) {
		Aluno aluno1 = new Aluno();
		aluno1.matricula = Integer.parseInt("201312453");
		aluno1.nome = "Mateus Albuquerque dos Anjos";
		aluno1.colegiado = 192;
		

		Aluno aluno2 = new Aluno();
		aluno2.matricula = Integer.parseInt("201312453");
		aluno2.nome = "Mateus Henrique dos Santos";
		aluno2.colegiado = 187;
		
		System.out.println(aluno1.matricula + " " + aluno1.nome + " " + aluno1.colegiado);
		System.out.println(aluno2.matricula + " " + aluno2.nome + " " + aluno2.colegiado);
	}
	
}
