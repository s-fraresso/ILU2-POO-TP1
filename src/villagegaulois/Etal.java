package villagegaulois;

import personnages.Gaulois;

public class Etal {
	private Gaulois vendeur;
	private String produit;
	private int quantiteDebutMarche;
	private int quantite;
	private boolean etalOccupe = false;

	public boolean isEtalOccupe() {
		return etalOccupe;
	}

	public Gaulois getVendeur() {
		return vendeur;
	}

	public void occuperEtal(Gaulois vendeur, String produit, int quantite) {
		this.vendeur = vendeur;
		this.produit = produit;
		this.quantite = quantite;
		quantiteDebutMarche = quantite;
		etalOccupe = true;
	}

	public String libererEtal() {
		etalOccupe = false;
		StringBuilder chaine = new StringBuilder();
		try {
			chaine.append("Le vendeur " + vendeur.getNom() + " quitte son �tal, ");
			int produitVendu = quantiteDebutMarche - quantite;
			if (produitVendu > 0) {
				chaine.append(
						"il a vendu " + produitVendu + " " + produit + " parmi les " + quantiteDebutMarche + " qu'il voulait vendre.\n");
			} else {
				chaine.append("il n'a malheureusement rien vendu.\n");
			}
			return chaine.toString();
		}
		catch (NullPointerException e) {
			e.printStackTrace();
			return chaine.toString();
		}
	}

	public String afficherEtal() {
		if (etalOccupe) {
			return "L'�tal de " + vendeur.getNom() + " est garni de " + quantite
					+ " " + produit + "\n";
		}
		return "L'�tal est libre";
	}

	public String acheterProduit(int quantiteAcheter, Gaulois acheteur) throws IllegalArgumentException, IllegalStateException {
		if (quantiteAcheter < 1) {
			throw new IllegalArgumentException();
		}
		
		if (!etalOccupe) {
			throw new IllegalStateException();
		}
		
		StringBuilder chaine = new StringBuilder();
		
		try {
			chaine.append(acheteur.getNom() + " veut acheter " + quantiteAcheter + " " + produit + " � " + vendeur.getNom());
		}
		catch (NullPointerException e) {
			e.printStackTrace();
			return chaine.toString();
		}
		
		if (quantite == 0) {
			chaine.append(", malheureusement il n'y en a plus !\n");
			quantiteAcheter = 0;
		}
		if (quantiteAcheter > quantite) {
			chaine.append(", comme il n'y en a plus que " + quantite + ", "
					+ acheteur.getNom() + " vide l'�tal de "
					+ vendeur.getNom() + ".\n");
			quantiteAcheter = quantite;
			quantite = 0;
		}
		if (quantite != 0) {
			quantite -= quantiteAcheter;
			chaine.append(". " + acheteur.getNom()
					+ ", est ravi de tout trouver sur l'�tal de "
					+ vendeur.getNom() + "\n");
		}
		return chaine.toString();
	}

	public boolean contientProduit(String produit) {
		return produit.equals(this.produit);
	}

}
