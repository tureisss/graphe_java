package codemaths;

import java.util.HashMap;

import sae22.Sae22_Exception;
import sae22.Sae22_Region;

public class Main {
    public static void main(String[] args) throws Sae22_Exception {
        // Création d'une liste pour stocker les secteurs
        HashMap<String, Secteur> secteurs = new HashMap<>();

        Sae22_Region region = new Sae22_Region("France_Nouvelles_Regions");
        int maxi = 0;
        int max = region.population(0);
        for(int i = 0; i<region.taille(); i++) {
            secteurs.put(region.nom(i), new Secteur(i, region.nom(i), region.superficie(i)));
            if(region.superficie(i) > max) {
                maxi = i;
                max = region.population(i);
            }
        }
        
        for(Secteur s : secteurs.values()) {
            for(String voisin : region.voisins(s.id())) {
                s.ajouterLiaison(secteurs.get(voisin));
            }
        }
        /* Création d'un bras de mer entre les secteurs
        BrasDeMer brasDeMer1 = new BrasDeMer(aube, hautemarne, Calcul.calculerCoutTroncon(aube, hautemarne));
        aube.setBrasDeMer(brasDeMer1);
        hautemarne.setBrasDeMer(brasDeMer1);

        BrasDeMer brasDeMer2 = new BrasDeMer(marne, hautemarne, Calcul.calculerCoutTroncon(marne, hautemarne));
        marne.setBrasDeMer(brasDeMer2);
        hautemarne.setBrasDeMer(brasDeMer2);

        BrasDeMer brasDeMer3 = new BrasDeMer(meuse, marne, Calcul.calculerCoutTroncon(meuse, marne));
        meuse.setBrasDeMer(brasDeMer3);
        marne.setBrasDeMer(brasDeMer3);

        BrasDeMer brasDeMer4 = new BrasDeMer(ardennes, marne, Calcul.calculerCoutTroncon(ardennes, marne));
        ardennes.setBrasDeMer(brasDeMer4);
        marne.setBrasDeMer(brasDeMer4);*/

        // Appel de l'algorithme de Kruskal
        Kruskal kruskal = new Kruskal(secteurs.values().stream().toList());
        kruskal.kruskal(maxi);
    }
}



