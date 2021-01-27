package Projet;

import film.Film;

public class Coller implements Film {
	
	public Coller(Film f, Film g) {
		film1 = f;
		film2 = g;
	}

	@Override
	public int hauteur() {
		return Math.max(film1.hauteur(), film2.hauteur());
	}

	@Override
	public int largeur() {
		return Math.max(film1.largeur(), film2.largeur());
	}

	@Override
	public boolean suivante(char[][] écran) {
		if (change == false) {
			boolean b = film1.suivante(écran);
			if(b == false) {
				change = true;
				film1.rembobiner();
			}
		}
		if (change == true) {
			boolean c = film2.suivante(écran);
			if(c == false) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void rembobiner() {
		film1.rembobiner();
		film2.rembobiner();
		change = false;

	}
	private Film film1;
	private Film film2;
	private boolean change = false;
	
}
