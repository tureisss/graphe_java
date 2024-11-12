/**
 * La classe BrasDeMer représente un bras de mer entre deux secteurs d'un réseau.
 */
package codemaths;

// Définition de la classe BrasDeMer
public class BrasDeMer {
    private Secteur secteur1; // Premier secteur lié par le bras de mer
    private Secteur secteur2; // Deuxième secteur lié par le bras de mer
    private double coutSupplementaire; // Coût supplémentaire du bras de mer

    /**
     * Constructeur pour initialiser un bras de mer avec ses secteurs et le coût de la liaison.
     * @param secteur1 Le premier secteur lié par le bras de mer.
     * @param secteur2 Le deuxième secteur lié par le bras de mer.
     * @param coutLiaison Le coût de la liaison entre les deux secteurs.
     */
    public BrasDeMer(Secteur secteur1, Secteur secteur2, double coutLiaison) {
        this.secteur1 = secteur1;
        this.secteur2 = secteur2;
        this.coutSupplementaire = coutLiaison * 2; // Calcul du coût supplémentaire (ici, le double du coût de la liaison)
    }

    /**
     * Méthode pour obtenir le premier secteur lié par le bras de mer.
     * @return Le premier secteur lié par le bras de mer.
     */
    public Secteur getSecteur1() {
        return secteur1;
    }

    /**
     * Méthode pour obtenir le deuxième secteur lié par le bras de mer.
     * @return Le deuxième secteur lié par le bras de mer.
     */
    public Secteur getSecteur2() {
        return secteur2;
    }

    /**
     * Méthode pour obtenir le coût supplémentaire du bras de mer.
     * @return Le coût supplémentaire du bras de mer.
     */
    public double getCoutSupplementaire() {
        return coutSupplementaire;
    }
}
