package histoire;

import villagegaulois.Etal;
import personnages.Gaulois;

public class ScenarioCasDegrade {
	
	public static void main(String[] args) {
		Etal etal = new Etal();
		
		etal.libererEtal();
		
		Gaulois obelix = new Gaulois("Obélix", 25);
		etal.occuperEtal(obelix, "menhirs", 5);
		etal.acheterProduit(2, null);
		
		try {
			etal.acheterProduit(0, null);
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		etal.libererEtal();
		
		try {
			etal.acheterProduit(2, obelix);
		}
		catch (IllegalStateException e) {
			e.printStackTrace();
		}
		
		System.out.println("Fin du test");
	}
}
