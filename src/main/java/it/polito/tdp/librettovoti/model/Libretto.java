package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {
	
	private List<Voto> listaVoti;
	
	public Libretto() {
		this.listaVoti = new ArrayList<Voto>();
	}
	
	public void add(Voto v) {
		this.listaVoti.add(v);
	}
	
	public Libretto filtraVoti(int punti) {
		Libretto result = new Libretto();
		for(Voto v : this.listaVoti) {
			if(v.getPunti()==punti)
				result.add(v);
		}
		return result;
	}
	
	/**
	 * Resituisce il punteggio di un esame dato il nome
	 * @param nome Nome dell'esame
	 * @return punteggio numerico, oppure {@code null} se l'esame non esiste
	 */
	public Integer votoEsame(String nome) {
		for(Voto v : this.listaVoti) {
			if(v.getNomeCorso().equals(nome)) {
				return v.getPunti();
			}
		}
//		return -1;
		return null;
//		throw new IllegalArgumentException("Corso non trovato");
	}
	
	public boolean isDuplicato(Voto v) {
		for(Voto v1 : this.listaVoti) {
			if(v1.equals(v))
				return true;
		}
		return false;
	}
	
	public boolean isConflitto(Voto v) {
		Integer punti = this.votoEsame(v.getNomeCorso());
		if(punti != null && punti != v.getPunti())
			return true;
		else
			return false;
	}
	
	public String toString() {
		return this.listaVoti.toString();
	}
}
