package it.polito.tdp.librettovoti.model;

import java.util.*;

import db.LibrettoDAO;

public class Libretto {
	
	private List<Voto> listaVoti;
	
	public Libretto() {
		this.listaVoti = new ArrayList<Voto>();
	}
	
	public boolean add(Voto v) {
		LibrettoDAO dao = new LibrettoDAO();
		boolean res =dao.createVoto(v);
		return res;
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
	
	public List<Voto> getVoti(){
		LibrettoDAO dao = new LibrettoDAO();
		return dao.readAllVoto();
	}
	
	public Libretto votiMigliorati() {
		Libretto nuovo = new Libretto();
		for(Voto v : this.listaVoti) {
			int punti = v.getPunti();
			
			if(punti>=24)
				punti+=2;
			else
				punti+=1;
			
			if(punti>30)
				punti=30;
			
			nuovo.add(new Voto(v.getNomeCorso(),punti, v.getData()));
		}
		return nuovo;
	}
	
	public void cancellaVotiMinori(int punti) {
		for(Voto v : this.listaVoti) {
			if(v.getPunti()<punti) {
				this.listaVoti.remove(v);				
			}
		}
	}
	
	public String toString() {
		return this.listaVoti.toString();
	}
}
