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

	public String traduci(String parola) {
		// TODO Auto-generated method stub
		if (this.isAlfabetico(parola)) {
			return this.traduciNormale(parola);
		} else {
			if (this.isWildCard(parola)) {
				return this.traduciWildCard(parola);
			}
			else {
				return null;
			}
		}
	}

	public String aggiungi(String string, String string2) {
		// TODO Auto-generated method stub
		String risultato;
		if (!this.isAlfabetico(string) || !this.isAlfabetico(string2)) {
			return null;
		}
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

	public boolean isAlfabetico(String parola) {
		// TODO Auto-generated method stub
    	for (int i=0;i<parola.length();i++) {
    		if (Character.isAlphabetic(parola.charAt(i)) == false) {
    			return false;
    		}
    	}
    	return true;
	}

	public boolean isWildCard(String parola) {
		int cnt = 0;
		if (!parola.contains("?")) {
			return false;
		}
		for (int i=0;i<parola.length();i++) {
			if (parola.charAt(i) == '?') {
				cnt++;
			}
		}
		if (cnt > 1) {
			return false;
		}
		return true;
	}
	
	private String traduciNormale(String parola) {
		String risultato;
		if (this.dizionario.containsKey(parola)) {
			risultato = parola + " = " + this.dizionario.get(parola).toString();
		}
		else {
			risultato = "Parola non presente nel dizionario.";
		}
		return risultato;
	}
	
	private String traduciWildCard(String parola) {
		String risultato = "";
		List<String> paroleCoincidenti = new LinkedList<String>();
 		String coincidente = null;
		boolean fail;
		for (String s : this.dizionario.keySet()) {
			fail = false;
			if (s.length() == parola.length()) {
				for (int i=0;i<s.length();i++) {
					if (parola.charAt(i) != '?' &&
							s.charAt(i) != parola.charAt(i)) {
						fail = true;
					}
				}
				if (fail == false) {
					coincidente = s;
					paroleCoincidenti.add(coincidente);
				}
			}
		}
		for (String s : paroleCoincidenti) {
			if (risultato != "") {
				risultato += "\n";
			}
			risultato += this.traduciNormale(s);
		}
		return risultato;
	}

}
