package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammiDAO;

public class Model {
	
	AnagrammiDAO anagramma = new AnagrammiDAO();

	
	public boolean isCorrect(String anagramma){
		return this.anagramma.isCorrect(anagramma);
	}
	
	//prepara la ricorsione
	public List<String> doAnagramma(String parola){
		List<String> anagrammi = new LinkedList<String>();
		permuta("", parola, 0, anagrammi);
		return anagrammi;
	}

	//effettua la ricorsione
	private void permuta(String parziale, String parola, int livello, List<String> anagrammi) {
		
		if(parola.length()==0) { 
			// caso terminale 
			anagrammi.add(parziale);
			return;
			
		} else {
			for(int pos=0; pos<parola.length(); pos++) {
				
				char tentativo = parola.charAt(pos) ; 
				
				String nuovaParziale = parziale + tentativo ;
				String nuovaParola = parola.substring(0, pos)+parola.substring(pos+1) ;
					// togli il carattere pos da lettere
				
				permuta(nuovaParziale, nuovaParola, livello+1, anagrammi) ;
			}
		}
	}
}
