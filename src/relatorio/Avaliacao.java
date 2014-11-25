package relatorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Avaliacao {
	
	private float nota;
	private String nomeAvaliacao;
	private float peso;
	
	public void setAvaliacao(String nome, float nota, float peso) {
		Map<String, List<Float>> mapaNotas = new HashMap<String, List<Float>>();
		List<Float> setNota = new ArrayList<Float>();
	
		setNota.add(nota);
		setNota.add(peso);
		mapaNotas.put(nome, setNota);
		
		for (Map.Entry<String, List<Float>> entry : mapaNotas.entrySet()) {
		
			String key = entry.getKey();
			
			List<Float> values = entry.getValue();
			
			this.nomeAvaliacao = key;
			this.nota = values.get(0);
			this.peso = values.get(1);
			
			//System.out.println("Key = " + key);
			//System.out.println("Values =" + values );
		}
	}
	
	public void getAvaliacao() {
		System.out.println(this.nomeAvaliacao);
		System.out.println(this.nota);
		System.out.println(this.peso);
	}
	
	public float getNota() {
		return this.nota;
	}
	
	public String getNomeAvaliacao() {
		return this.nomeAvaliacao;
	}
	
	public float getPeso() {
		return this.peso;
	}
	
}
