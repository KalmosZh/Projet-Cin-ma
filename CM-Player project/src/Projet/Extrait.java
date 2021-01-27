package Projet;

import film.Film;
import film.Films;

public class Extrait implements Film {

	
	public Extrait(Film f, int debut, int fin)
	{
		film = f;
		this.debut = debut;
		this.fin = fin;
	}
	
	@Override
	public int hauteur() {
		return film.hauteur();
	}

	@Override
	public int largeur() {
		return film.largeur();
	}

	@Override
	public boolean suivante(char[][] écran) {
		while (index < debut)
		{
			boolean b = film.suivante(écran);
			if (b == false)
				return false;
			Films.effacer(écran);
			index++;
		}
		if (index >= debut && index <= fin)
		{
			boolean b = film.suivante(écran);
			if (b == false)
				return false;
			index++;
			return true;
		}
		return false;
	}

	@Override
	public void rembobiner() {
		film.rembobiner();
		index = 0;
	}
	
	private int debut = 0;
	private int fin = 0;
	private int index = 0;
	private Film film;

}
