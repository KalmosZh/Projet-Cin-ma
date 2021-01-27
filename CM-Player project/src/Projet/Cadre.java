package Projet;

import film.Film;
import film.Films;

public class Cadre implements Film {

	public Cadre(Film f)
	{
		film = f;
	}
	
	@Override
	public int hauteur() {
		return film.hauteur() + 2;
	}

	@Override
	public int largeur() {
		return film.largeur() + 2;
	}

	@Override
	public boolean suivante(char[][] écran) {
		char [][] film_ecran = Films.getEcran(film);
		boolean b = film.suivante(film_ecran);
		if (b == false)
			return false;
		for (int i = 0; i < largeur(); i++)
		{
			écran[0][i] = '*';
		}
		for (int i = 1; i < hauteur() - 1; i++)
		{
			écran[i][0] = '*';
			for (int j = 0; j < largeur() - 2; j++)
			{
				écran[i][j + 1] = film_ecran[i - 1][j];
			}
			écran[i][largeur() - 1] = '*';
		}
		for (int i = 0; i < largeur(); i++)
		{
			écran[hauteur() - 1][i] = '*';
		}
		return true;
	}

	@Override
	public void rembobiner() {
		film.rembobiner();

	}
	
	private Film film;

}
