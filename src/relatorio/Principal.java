package relatorio;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Aluno al = new Aluno();
		al.setMatricula(210105627);
		al.setNome("Arley Prates");
		al.setColegiado(195);
		
		ArrayList<Aluno> arrayAluno = new ArrayList<Aluno>();
		arrayAluno.add(al);
		
		Avaliacao av = new Avaliacao();
		av.setNomeAvaliacao("Prova1");
		av.setNota(10.0f);
		av.setPeso(3.0f);
		
		ArrayList<Avaliacao> arrayAvaliacao = new ArrayList<Avaliacao>();
		arrayAvaliacao.add(av);
		
		al.setAvaliacao(arrayAvaliacao);
		
		System.out.println(al.getNome());
		System.out.println(al.getMatricula());
		System.out.println(al.getColegiado());
		//Duvida como imprimir um arrayList
		System.out.println(al.getAvaliacao());
		

	}

}
