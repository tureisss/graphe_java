package codemaths;

/**
 * La classe Liaison représente une liaison entre deux secteurs dans un graphe.
 * Chaque liaison relie deux secteurs et a un coût associé.
 */
public class Liaison {
    private Secteur secteur1; // Premier secteur de la liaison
    private Secteur secteur2; // Deuxième secteur de la liaison
    private double coutLiaison; // Coût de la liaison

    /**
     * Constructeur pour initialiser une liaison avec ses secteurs et son coût.
     * 
     * @param secteur1 Le premier secteur de la liaison.
     * @param secteur2 Le deuxième secteur de la liaison.
     * @param coutLiaison Le coût de la liaison.
     */
    public Liaison(Secteur secteur1, Secteur secteur2, double coutLiaison) {
        this.secteur1 = secteur1;
        this.secteur2 = secteur2;
        this.coutLiaison = coutLiaison;
    }

    /**
     * Méthode pour obtenir le premier secteur de la liaison.
     * 
     * @return Le premier secteur de la liaison.
     */
    public Secteur getSecteur1() {
        return secteur1;
    }

    /**
     * Méthode pour obtenir le deuxième secteur de la liaison.
     * 
     * @return Le deuxième secteur de la liaison.
     */
    public Secteur getSecteur2() {
        return secteur2;
    }

    /**
     * Méthode pour obtenir le coût de la liaison.
     * 
     * @return Le coût de la liaison.
     */
    public double getCoutLiaison() {
        return coutLiaison;
    }
}

