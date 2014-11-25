package relatorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Avaliacao {
	
	private float notas;
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
			
			System.out.println("Key = " + key);
			System.out.println("Values =" + values );
		}
	}		
}
