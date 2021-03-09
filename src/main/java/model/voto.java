package model;

import java.time.LocalDate;

/**
 * classe voto contiene informazioni su un esame superato
 * @author sebas
 *
 */
public class voto {
	private String corso;
	private int voto;
	private LocalDate data;
	
	/**
	 * costruisceun nuovo voto.
	 * @param corso nome del corso superato
	 * @param voto valore del voto acquisito
	 * @param data di superamento esame
	 */
	
	public voto(String corso, int voto, LocalDate data) {
		this.corso = corso;
		this.voto = voto;
		this.data = data;
	}

	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
	
	

}
