package relatorio;

//import java.util.ArrayList;
//import java.util.List;

public class Aluno {

	private String nome;
	private int matricula;
	private int colegiado;
	private String avaliacao[] = new String[6];
	private String media;
	private String resultado;
	
	//public Aluno(String nome, int matricula, ArrayList avaliacao){
		///super();
		//this.nome = nome;
		//this.matricula = matricula;
		//this.colegiado = colegiado;
		//this.avaliacao = avaliacao;
	//}
	
	public String getResultado() {
		return resultado;
	}


	public void setResultado(String resultado) {
		this.resultado = resultado;
	}


	public String getMedia(){
		return media;
	}
	
		
	public void setMedia(String media){		
		this.media = media;
		 	 
	}
	
	public void setAvaliacao(String avaliacao, int i) {
		this.avaliacao[i] = avaliacao;
	}
	
	public String getAvaliacao(int i) {
		return this.avaliacao[i];
	} 
	
	public String[] getAvaliacao() {
		return this.avaliacao;
	} 
	
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

	//public List<Avaliacao> getAvaliacao() {
	//	return avaliacao;
	//}

	//public void setAvaliacao(List<Avaliacao> avaliacao) {
	//	this.avaliacao = avaliacao;
	//}
}
