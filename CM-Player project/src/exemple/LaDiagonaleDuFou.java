package exemple;

import java.io.FileNotFoundException;

import Projet.Cadre;
import Projet.Coller;
import Projet.Extrait;
import Projet.Incruster;
import Projet.Repeter;
import film.Film;
import film.Films;

/**
 * Un exemple basique d'impl�mentation de l'interface Film.
 */
public class LaDiagonaleDuFou implements Film {
	private int num = 0;
	private static final int NB_IMAGES = 3;

	@Override
	public int hauteur() {
		return 10;
	}

	@Override
	public int largeur() {
		return hauteur(); // ce sera un carr�
	}

	@Override
	public boolean suivante(char[][] écran) {
		if (num == NB_IMAGES)
			return false;
		écran[num % hauteur()][num % hauteur()] = 'a'; // un 'a' se balade sur
														// la diagonale
		++num;
		return true;
	}

	@Override
	public void rembobiner() {
		num = 0;
	}

	/**
	 * La projection (puis la sauvegarde) d'un tel film.
	 */
	public static void main(String[] args) {
		Film film = new LaDiagonaleDuFou();
		Films.projeter(film);
		film.rembobiner();
		try {
			Films.sauvegarder(film, "fou.txt");
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier 'fou.txt' n'a pas pu être créé.");
		}
	}
}
