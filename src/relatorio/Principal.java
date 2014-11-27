package relatorio;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Aluno al = new Aluno();
		al.setMatricula(210105627);
		al.setNome("Arley Prates");
		al.setColegiado(195);
		
		Aluno al1 = new Aluno();
		al1.setMatricula(210101234);
		al1.setNome("Fulano de Tal");
		al1.setColegiado(193);
		
		ArrayList<Aluno> arrayAluno = new ArrayList<Aluno>();
		
		arrayAluno.add(al);
		arrayAluno.add(al1);
		
		Avaliacao av = new Avaliacao();
		av.setNomeAvaliacao("Prova1");
		av.setNota(10.0f);
		av.setPeso(3.0f);
		
		Avaliacao av1 = new Avaliacao();
		av1.setNomeAvaliacao("Prova2");
		av1.setNota(9.0f);
		av1.setPeso(3.0f);
		
		ArrayList<Avaliacao> arrayAvaliacao = new ArrayList<Avaliacao>();
		
		arrayAvaliacao.add(av);
		arrayAvaliacao.add(av1);
		
		al.setAvaliacao(arrayAvaliacao);
		al1.setAvaliacao(arrayAvaliacao);
		
		for (Aluno value : arrayAluno){
			System.out.println(value.getNome());
			System.out.println(value.getMatricula());
			System.out.println(value.getColegiado());
			for (Avaliacao x : value.getAvaliacao()){
				System.out.println(x.getNomeAvaliacao());
				System.out.println(x.getNota());
				System.out.println(x.getPeso());
			}
		}
	}

}
