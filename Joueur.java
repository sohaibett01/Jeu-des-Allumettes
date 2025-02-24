package allumettes;

public class Joueur {

    private String nom;
    private Strategies strategie;

    // Constructeur du joueur : définit un joueur à partir de son nom et sa stratégie de jeu
    public Joueur(String nom, Strategies strategie) {
        this.nom = nom;
        this.strategie = strategie;
    }

    // Obtenir le nom du joueur
    public String getNom() {
        return this.nom;
    }

    // Obtenir le nombre d'allumettes que le joueur souhaite prendre
    public int getPrise(Jeu jeu) throws CoupInvalideException {
        return strategie.getPrise(jeu);
    }
}
