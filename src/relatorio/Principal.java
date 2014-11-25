package relatorio;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Aluno a = new Aluno();
		a.setMatricula(210105627);
		a.setNome("Arley Prates");
		a.setColegiado(195);
		a.setAvaliacao("Workshop", 10.0f, 3.0f);
		a.setAvaliacao("Prova1", 9.0f, 4.0f);
		a.getAvaliacao();
	}

}
