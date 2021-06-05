package model;

import java.util.*;

/**
 * gestisce un insieme di esami superati
 * @author sebas
 *
 */

public class libretto {
	private List<voto> voti;
	private Map<String,voto> votimappa; //identity map
	/**
	 * creo un libretto nuovo, vuoto
	 */
	public libretto() {
		this.voti = new ArrayList<voto>();
		votimappa = new HashMap<String,voto>();
	}
	public void add(voto v) {
		this.voti.add(v);
		this.votimappa.put(v.getCorso(), v);
	}
	/**
	 * controlla se esiste già un esame con lo stesso voto
	 * @param v
	 * @return
	 */
	public boolean esisteduplicato(voto v) {
		voto trovato = this.votimappa.get(v.getCorso());
		if(trovato == null) return false;
		if(trovato.getVoto()==v.getVoto()) return true;
		else return false;
		
		
	}
	/**
	 * verifica che nel libretto ci sia già lo stesso esame ma con votazione diversa
	 * @param c
	 * @return
	 */
	public boolean esisteconflitto(voto c) {
		boolean trovato = false;
		for(voto vo : this.voti) {
			if(vo.getCorso().equals(c.getCorso()) && vo.getVoto()!=c.getVoto()) {
				trovato = true;
				break;
			}
			
		}
		return trovato;
		
	}
	

}

