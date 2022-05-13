package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;

public class Voto {
	private String nomeCorso;
	private int punti; 
	private LocalDate data;
	
	public Voto(String nomeCorso, int punti, LocalDate data) {
		this.nomeCorso = nomeCorso;
		this.punti = punti;
		this.data = data;
		
	}

	public String getNomeCorso() {
		return nomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	public int getPunti() {
		return punti;
	}

	public void setPunti(int punti) {
		this.punti = punti;
	}
	
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return nomeCorso + ": " + punti + " (" + this.data.toString() + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeCorso == null) ? 0 : nomeCorso.hashCode());
		result = prime * result + punti;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (nomeCorso == null) {
			if (other.nomeCorso != null)
				return false;
		} else if (!nomeCorso.equals(other.nomeCorso))
			return false;
		if (punti != other.punti)
			return false;
		return true;
	}
	
	
	
	
	
}
