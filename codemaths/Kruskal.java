/**
 * La classe Kruskal implémente l'algorithme de Kruskal pour trouver l'arbre couvrant minimal d'un graphe pondéré.
 */
package codemaths;

import java.util.*;

// Définition de la classe Kruskal
public class Kruskal {
    private List<Secteur> secteurs; // Liste des secteurs du graphe

    /**
     * Constructeur pour initialiser un objet Kruskal avec une liste de secteurs.
     * @param secteurs La liste des secteurs du graphe.
     */
    public Kruskal(List<Secteur> secteurs) {
        this.secteurs = secteurs;
    }

    /**
     * Méthode pour exécuter l'algorithme de Kruskal à partir d'un index spécifié pour le tri des liaisons.
     * @param index L'index à partir duquel trier les liaisons avant d'exécuter l'algorithme.
     */
    public void kruskal(int index) {
        List<Liaison> arbreCouvrantMinimal = new ArrayList<>(); // Liste des liaisons de l'arbre couvrant minimal
        double coutTotal = 0.0; // Coût total de l'arbre couvrant minimal
        Set<Secteur> ensembleSecteurs = new HashSet<>(); // Ensemble de secteurs pour suivre les ensembles de secteurs

        // Initialisation des ensembles pour chaque secteur
        for (Secteur secteur : secteurs) {
            makeSet(secteur);
            ensembleSecteurs.add(secteur);
        }

        // Création d'une liste de liaisons à partir des secteurs et de leurs liaisons
        List<Liaison> liaisons = new ArrayList<>();
        for (Secteur secteur : secteurs) {
            for (Map.Entry<Secteur, Double> entry : secteur.getLiaisons().entrySet()) {
                Secteur voisin = entry.getKey();
                double coutLiaison = entry.getValue();
                liaisons.add(new Liaison(secteur, voisin, coutLiaison));
            }
        }

        // Tri des liaisons par poids croissant en fonction de l'index spécifié
        liaisons.sort(Comparator.comparingDouble(Liaison::getCoutLiaison));
        Liaison l1 = liaisons.get(index);
        liaisons.set(index, liaisons.get(0));
        liaisons.set(0, l1);

        // Parcours trié des liaisons et construction de l'arbre couvrant minimal
        for (Liaison liaison : liaisons) {
            Secteur secteur1 = liaison.getSecteur1();
            Secteur secteur2 = liaison.getSecteur2();
            if (!findSet(secteur1).equals(findSet(secteur2))) {
                arbreCouvrantMinimal.add(liaison); // Ajout de la liaison à l'arbre couvrant minimal
                coutTotal += liaison.getCoutLiaison(); // Ajout du coût de la liaison au coût total
                union(secteur1, secteur2); // Union des ensembles contenant secteur1 et secteur2
                ensembleSecteurs.remove(secteur1); // Retrait des secteurs fusionnés de l'ensemble de secteurs
                ensembleSecteurs.remove(secteur2);
            }
        }

        // Affichage du coût total de l'arbre couvrant minimal
        System.out.println("Coût total de l'arbre couvrant minimal : " + String.format("%.2f", coutTotal) + " euros");

        // Affichage de l'arbre de Kruskal
        System.out.println("Arbre de Kruskal :");
        for (Liaison liaison : arbreCouvrantMinimal) {
            System.out.println(liaison.getSecteur1().getNom() + " - " + liaison.getSecteur2().getNom()
                    + " (coût : " + String.format("%.2f", liaison.getCoutLiaison()) + " euros)");
        }
    }

    /**
     * Méthode privée pour initialiser un ensemble (arbre) pour un secteur.
     * @param secteur Le secteur pour lequel initialiser l'ensemble.
     */
    private void makeSet(Secteur secteur) {
        secteur.setParent(secteur);
        secteur.setRank(0);
    }

    /**
     * Méthode privée pour trouver le représentant (la racine) de l'ensemble (arbre) contenant un secteur.
     * @param secteur Le secteur pour lequel trouver le représentant.
     * @return Le représentant (la racine) de l'ensemble contenant le secteur.
     */
    private Secteur findSet(Secteur secteur) {
        if (secteur != secteur.getParent()) {
            secteur.setParent(findSet(secteur.getParent()));
        }
        return secteur.getParent();
    }

    /**
     * Méthode privée pour unir deux ensembles (arbres).
     * @param secteur1 Le premier secteur à unir.
     * @param secteur2 Le deuxième secteur à unir.
     */
    private void union(Secteur secteur1, Secteur secteur2) {
        Secteur racine1 = findSet(secteur1);
        Secteur racine2 = findSet(secteur2);

        if (racine1 != racine2) {
            if (racine1.getRank() < racine2.getRank()) {
                racine1.setParent(racine2);
            } else if (racine1.getRank() > racine2.getRank()) {
                racine2.setParent(racine1);
            } else {
                racine2.setParent(racine1);
                racine1.setRank(racine1.getRank() + 1);
            }
        }
    }
}
