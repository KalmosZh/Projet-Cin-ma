package film;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Ensemble de m�thodes de classe utilitaires pour la projection (sur System.in)
 * et la sauvegarde (dans un fichier) d'un film. Le format de fichier employ�
 * pour la sauvegarde est compatible avec le player graphique.
 */
public class Films {
	/**
	 * Projette un film dans sa totalit� sur System.in. Attention, la m�thode ne
	 * se termine pas si le film est infini.
	 * 
	 * @param f
	 *            Le film devant �tre projet�.
	 */
	public static void projeter(Film f) {
		char[][] écran = getEcran(f);
		while (f.suivante(écran)) {
			System.out.println(toString(écran));
			pause(1. / 12);
			effacer(écran);
		}
	}

	/**
	 * Sauvegarder un film dans un fichier.
	 * 
	 * @param f
	 *            Le film � sauvegarder.
	 * @param nom
	 *            le nom du fichier o� sauvegarder le film.
	 * @throws FileNotFoundException
	 *             Si le nom du fichier ne permet pas de le cr�er.
	 */
	public static void sauvegarder(Film f, String nom) throws FileNotFoundException {
		try (PrintWriter out = new PrintWriter(nom)) {
			char[][] écran = getEcran(f);
			out.println(f.largeur() + " " + f.hauteur());
			while (f.suivante(écran)) {
				out.println(toString(écran));
				out.println("\\newframe");
				effacer(écran);
			}
		}
	}

	/**
	 * Construit un �cran adapt� � la projection d'un film.
	 * 
	 * @param f
	 *            Le film pour lequel un �cran doit �tre constuit.
	 * @return L'�cran adapt� au film.
	 */
	public static char[][] getEcran(Film f) {
		char[][] écran = new char[f.hauteur()][f.largeur()];
		effacer(écran);
		return écran;
	}

	/**
	 * Efface un �cran.
	 * 
	 * @param �cran
	 *            L'�cran � effacer
	 */
	public static void effacer(char[][] écran) {
		for (char[] ligne : écran)
			Arrays.fill(ligne, ' ');
	}

	/**
	 * Convertit en chaine de caract�re un �cran.
	 * 
	 * @param �cran
	 *            L'�cran � convertir
	 * @return La chaine correspondante � l'�cran.
	 */
	public static String toString(char[][] écran) {
		StringBuilder s = new StringBuilder();
		for (char[] ligne : écran)
			s.append(new String(ligne) + System.lineSeparator());
		return s.toString();
	}

	/**
	 * Endort le programme pendant un temps donn�.
	 * 
	 * @param d
	 *            Le temps d'endormissement exprim� en seconde.
	 */
	public static void pause(double d) {
		try {
			Thread.sleep((long) (d * 1000));
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	// Cette classe n'a pas vocation � �tre instanci�e car elle ne contient que
	// des m�thodes de classe (i.e. statiques).
	// Introduire un constructeur priv� interdit toute instanciation (en dehors
	// de la classe elle m�me).
	private Films() {
	}
}
