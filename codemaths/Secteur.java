package codemaths;

import java.util.HashMap;
import java.util.Map;

/**
 * La classe Secteur représente un secteur dans un système de cartographie.
 * Chaque secteur est caractérisé par un nom, une taille et des liaisons vers
 * d'autres secteurs avec leur coût de tronçon.
 */
public class Secteur {
    private int id;
    private String nom; // Nom du secteur
    private int taille; // Taille du secteur
    private Map<Secteur, Double> liaisons; // Cartographie des secteurs voisins et de leur coût de tronçon
    private BrasDeMer brasDeMer; // Bras de mer associé à ce secteur
    private Secteur parent; // Ajout de la référence vers le parent
    private int rank; // Ajout du rang

    public int id() {
        return id;
    }

    /**
     * Constructeur pour initialiser un secteur avec son nom et sa taille.
     *
     * @param nom    Le nom du secteur.
     * @param taille La taille du secteur.
     */
    public Secteur(int id, String nom, int taille) {
        this.id = id;
        this.nom = nom;
        this.taille = taille;
        this.liaisons = new HashMap<>(); // Initialisation de la cartographie des liaisons
        this.parent = this; // Initialisation du parent à lui-même
        this.rank = 0; // Initialisation du rang à 0
    }

    // Méthode pour obtenir le bras de mer associé à ce secteur
    public BrasDeMer getBrasDeMer() {
        return brasDeMer;
    }

    // Méthode pour définir le bras de mer associé à ce secteur
    public void setBrasDeMer(BrasDeMer brasDeMer) {
        this.brasDeMer = brasDeMer;
    }

    /**
     * Méthode pour obtenir le nom du secteur.
     *
     * @return Le nom du secteur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode pour obtenir la taille du secteur.
     *
     * @return La taille du secteur.
     */
    public int getTaille() {
        return taille;
    }

    /**
     * Méthode pour ajouter une liaison entre ce secteur et un autre secteur.
     * Si le secteur passé en paramètre est null ou si la liaison existe déjà, un
     * message d'erreur est affiché.
     *
     * @param secteur Le secteur voisin avec lequel ajouter la liaison.
     */
    public void ajouterLiaison(Secteur secteur) {
        if (secteur != null && !liaisons.containsKey(secteur)) {
            double coutTroncon = Calcul.calculerCoutTroncon(this, secteur);
            liaisons.put(secteur, coutTroncon);
            secteur.liaisons.put(this, coutTroncon);
            System.out.println("Liaison ajoutée entre " + nom + " et " + secteur.getNom() + " avec un coût de "
                    + String.format("%.2f", coutTroncon) + " euros");
        } else {
            // System.out.println("Le secteur passé en paramètre est null ou la liaison existe déjà.");
        }
    }

    /**
     * Méthode pour obtenir les liaisons du secteur avec les secteurs voisins et
     * leur coût de tronçon.
     *
     * @return Une cartographie des secteurs voisins et de leur coût de tronçon.
     */
    public Map<Secteur, Double> getLiaisons() {
        return liaisons;
    }

    // Méthode pour obtenir le parent
    public Secteur getParent() {
        return parent;
    }

    // Méthode pour définir le parent
    public void setParent(Secteur parent) {
        this.parent = parent;
    }

    // Méthode pour obtenir le rang
    public int getRank() {
        return rank;
    }

    // Méthode pour définir le rang
    public void setRank(int rank) {
        this.rank = rank;
    }
}

