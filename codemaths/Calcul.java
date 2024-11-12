package codemaths;

/**
 * La classe Calcul fournit des méthodes pour calculer les coûts de tronçon entre deux secteurs.
 * Ces coûts sont déterminés en fonction des tailles des secteurs et des éventuels bras de mer entre eux.
 */
public class Calcul {
    /**
     * Méthode statique pour calculer le coût d'un tronçon entre deux secteurs.
     * Le coût est calculé en fonction des tailles des secteurs et des éventuels bras de mer entre eux.
     * 
     * @param secteur1 Le premier secteur du tronçon.
     * @param secteur2 Le deuxième secteur du tronçon.
     * @return Le coût total du tronçon entre les deux secteurs.
     */
    public static double calculerCoutTroncon(Secteur secteur1, Secteur secteur2) {
        // Récupération de la taille des deux secteurs
        double taille1 = secteur1.getTaille();
        double taille2 = secteur2.getTaille();
        
        // Calcul du coût du tronçon selon une formule de base (ici, une simple somme des tailles)
        double coutTroncon = Math.sqrt(Math.pow(taille1, 2) + Math.pow(taille2, 2));

        // Vérification s'il existe un bras de mer entre les deux secteurs et ajout du coût supplémentaire le cas échéant
        if (secteur1.getBrasDeMer() != null && secteur1.getBrasDeMer().getSecteur2() == secteur2) {
            coutTroncon += secteur1.getBrasDeMer().getCoutSupplementaire();
        } else if (secteur2.getBrasDeMer() != null && secteur2.getBrasDeMer().getSecteur2() == secteur1) {
            coutTroncon += secteur2.getBrasDeMer().getCoutSupplementaire();
        }

        return coutTroncon; // Retourne le coût total du tronçon
    }
}

