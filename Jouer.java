package allumettes;

/**
 * Lance une partie des 13 allumettes en fonction des arguments fournis
 * sur la ligne de commande.
 * 
 * @author Xavier Crégut
 * @version $Revision: 1.5 $
 */
public class Jouer {

    /** Lancer une partie. En argument sont donnés les deux joueurs sous
     * la forme nom@stratégie.
     * 
     * @param args la description des deux joueurs
     */
    private static final int NB_ALLUMETTES = 13;

    private static boolean confiant;

    public static void main(String[] args) {
        try {
            verifierNombreArguments(args);
            Joueur[] joueurs = initialiserJoueurs(args);
            Jeu jeu = new JeuReel(NB_ALLUMETTES);
            Jeu jeuProxy = new Proxy(jeu); // initialiser les joueurs
            Arbitre arbitre = new Arbitre(joueurs[0], joueurs[1]); // initialiser l´arbitre

            if (args[0].equals("-confiant")) {
                arbitre.arbitrer(jeu, jeu, joueurs[0]);
            } else {
                arbitre.arbitrer(jeu, jeuProxy, joueurs[0]);
            }
        } catch (ConfigurationException | CoupInvalideException e) {
            System.out.println();
            System.out.println("Erreur : " + e.getMessage());
            afficherUsage();
            System.exit(1);
        }
    }

    private static void verifierNombreArguments(String[] args) {
        final int nbJoueurs = 2;
        if (args.length < nbJoueurs) {
            throw new ConfigurationException("Trop peu d'arguments : " + args.length);
        }
        if (args.length > nbJoueurs + 1) {
            throw new ConfigurationException("Trop d'arguments : " + args.length);
        }
    }

    /** Afficher des indications sur la manière d'exécuter cette classe. */
    public static void afficherUsage() {
        System.out.println("\n" + "Usage :"
                + "\n\t" + "java allumettes.Jouer joueur1 joueur2"
                + "\n\t\t" + "joueur est de la forme nom@stratégie"
                + "\n\t\t" + "strategie = naif | rapide | expert | humain | tricheur"
                + "\n"
                + "\n\t" + "Exemple :"
                + "\n\t" + "	java allumettes.Jouer Xavier@humain "
                + "Ordinateur@naif"
                + "\n"
        );
    }

    // Initialiser les joueurs à partir des arguments de la ligne de commande
    private static Joueur[] initialiserJoueurs(String[] args) throws ConfigurationException {
        Joueur[] joueurs = new Joueur[2];
        int cf;

        if (args[0].equals("-confiant")) {
            cf = 1;
            confiant = true;
        } else {
            cf = 0;
            confiant = false;
        }

        for (int j = cf; j < Math.min(args.length, cf + 2); j++) {
            String[] joueurArgs = args[j].split("@");
            if (joueurArgs.length != 2 || joueurArgs[0].length() == 0){
                throw new ConfigurationException("Format non respecté");
            }
            String nom = joueurArgs[0];
            Strategies strategie = nommerStrategie(joueurArgs[1], nom);
            joueurs[j - cf] = new Joueur(nom, strategie);
        }
        return joueurs;
    }

    public static Strategies nommerStrategie(String nomStrategie, String nomJoueur) {
        switch (nomStrategie) {
            case "rapide":
                return new StrategieRapide();
            case "expert":
                return new StrategieExpert();
            case "tricheur":
                return new StrategieTricheur(confiant);
            case "humain":
                return new StrategieHumain(nomJoueur);
            case "naif":
                return new StrategieNaif();
            default:
                throw new ConfigurationException("Stratégie inconnue : " + nomStrategie);
        }
    }
}















