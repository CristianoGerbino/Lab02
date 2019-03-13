package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	private Map<String, WordEnhanced> dizionario;

	
	public AlienDictionary() {
		dizionario = new HashMap<String, WordEnhanced>();
	}


	public boolean add(String alien, String trad) {
		WordEnhanced daAggiungere = dizionario.get(alien);
		if (daAggiungere == null) {
			return false;
		}
		daAggiungere.add(trad);
		return true;
	}
	
	
	
	
	
	
}
