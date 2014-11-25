package relatorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Avaliacao {
	private String nome;
	private float nota;
	private float peso;	
	
	public void setAvaliacao(String nome, float nota, float peso) {
		Map<String, List<Float>> mapaNotas = new HashMap<String, List<Float>>();
		List<Float> setNota = new ArrayList<Float>();
		setNota.add(nota);
		setNota.add(peso);
		mapaNotas.put(nome, setNota);
	}
	public void getAvaliacao() {
		
	}
		
}
