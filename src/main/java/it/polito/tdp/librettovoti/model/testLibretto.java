package it.polito.tdp.librettovoti.model;

public class testLibretto {

	public static void main(String[] args) {
		
		Libretto lib = new Libretto();
		lib.add(new Voto("Analisi 1", 30));
		lib.add(new Voto("Fisica 1", 18));
		lib.add(new Voto("Informatica", 25));
		lib.add(new Voto("Algebra lineare", 25));
		
		System.out.println(lib);

		System.out.println("Voti pari a 25");
		Libretto lib25 = lib.filtraVoti(25);
		System.out.println(lib25);
		
		
	}

}
