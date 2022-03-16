package it.polito.tdp.alien.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Model {
	private Map<String, List<String>> dizionario;
	
	public Model() {
		dizionario = new TreeMap<String, List<String>>();
	}

	public String traduci(String string) {
		// TODO Auto-generated method stub
		String risultato;
		if (this.dizionario.containsKey(string)) {
			risultato = string + " = " + this.dizionario.get(string).toString();
			//for (String s : )
		}
		else {
			risultato = "Parola non presente nel dizionario.";
		}
		return risultato;
	}

	public String aggiungi(String string, String string2) {
		// TODO Auto-generated method stub
		String risultato;
		if (!this.dizionario.containsKey(string)) {
			this.dizionario.put(string, new LinkedList<String>());
			this.dizionario.get(string).add(string2);
			risultato =  "Aggiunta la traduzione: " + string + " - " + string2;
		}
		else {
			if (!this.dizionario.get(string).contains(string2)) {
				this.dizionario.get(string).add(string2);
				risultato =  "Aggiunta la traduzione: " + string + " - " + string2;
			}
			else { 
				risultato = "Traduzione gia' presente nel dizionario.";
			}
		}
		return risultato;
	}

	public boolean verifica(String input) {
		// TODO Auto-generated method stub
		boolean trovato = false;
    	for (int i=0; i<input.length(); i++) {
    		if (Character.isAlphabetic(input.charAt(i))) {
    			trovato = true;
    		}
    	}
    	return trovato;
	}

	
	


}
