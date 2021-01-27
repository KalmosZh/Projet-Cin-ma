package Projet;

import film.Film;
import film.Films;

public class Incruster implements Film {
	
	public Incruster(Film f, Film g, int ligne, int colonne) {
		film1 = f;
		film2 = g;
		this.ligne = ligne;
		this.colonne = colonne; 
		
	}

	@Override
	public int hauteur() {
		return film1.hauteur();
	}

	@Override
	public int largeur() {
		return film1.largeur();
	}

	@Override
	public boolean suivante(char[][] écran) {
		if(ligne < 0)
			ligne = 0;
		if(colonne < 0)
			colonne =0;
		char [][] film_ecran1 = Films.getEcran(film1);
		char [][] film_ecran2 = Films.getEcran(film2);
		boolean c = film2.suivante(film_ecran2);
		if(c == false) {
			this.ok = false;
		}
		if(ok == true) {
			boolean b = film1.suivante(film_ecran1);
			
			if(b == false) {
				return false;
			}
			
			
			for(int i = 0; i < ligne; i++) {
				for(int j = 0; j < largeur(); j++) {
					écran[i][j] = film_ecran1[i][j];
				}
			}
			if(film2.hauteur() + ligne < hauteur()) {
				for(int i = ligne; i < film2.hauteur() + ligne; i++) {
					
					for(int j = 0; j < colonne; j++) {
						écran[i][j] = film_ecran1[i][j];
					}
					if(film2.largeur() + colonne < largeur()) {
						for(int k = colonne; k < film2.largeur() + colonne; k++) {
							écran[i][k] = film_ecran2[i - ligne][k - colonne];
						}
						for(int l = colonne + film2.largeur(); l < largeur(); l++) {
							écran[i][l] = film_ecran1[i][l];
						}
					}
					else {
						for(int m = colonne; m < largeur(); m++) {
							écran[i][m] = film_ecran2[i - ligne][m - colonne];
						}
					}
				}
				for(int i = film2.hauteur() + ligne; i < hauteur(); i++) {
					for(int j = 0; j < largeur(); j++) {
						écran[i][j] = film_ecran1[i][j];
					}
				}
			}
			else {
				for(int i = ligne; i < hauteur(); i++) {
					
					for(int j = 0; j < colonne; j++) {
						écran[i][j] = film_ecran1[i][j];
					}
					if(film2.largeur() + colonne <= largeur()) {
						for(int k = colonne; k < film2.largeur() + colonne; k++) {
							écran[i][k] = film_ecran2[i - ligne][k - colonne];
						}
						for(int l = colonne + film2.largeur(); l < largeur(); l++) {
							écran[i][l] = film_ecran1[i][l];
						}
					}
					else {
						for(int m = colonne; m < largeur(); m++) {
							écran[i][m] = film_ecran2[i - ligne][m - colonne];
						}
					}
				}
			}
		}
		else {
			boolean b = film1.suivante(écran);
			if(b == false) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void rembobiner() {
		film1.rembobiner();
		film2.rembobiner();
		this.ok = true;
	}
	private Film film1;
	private Film film2;
	private int ligne = 0;
	private int colonne = 0;
	private boolean ok = true;

}
