package Projet;

import film.Film;

public class Repeter implements Film {

	
	public Repeter(Film f, int n)
	{
		this.n = n;
		nbrepet = n;
		film = f;
		
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
		
		if (n <= 0)
			return false;
		boolean suivant = film.suivante(écran);
		if(suivant == true) {
			cpt++;
		}
		if(cpt == 0) {
			return false;
		}
		if (!suivant && n != 1)
		{
			film.rembobiner();
			film.suivante(écran);
			n--;
		}
		else if (!suivant)
		{
			return false;
		}
			
		return true;
	}

	@Override
	public void rembobiner() {
		film.rembobiner();
		n = nbrepet;

	}
	
	private int n = 0;
	private int nbrepet = 0;
	private int cpt = 0;
	private Film film;

}
