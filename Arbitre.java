package allumettes;

public class Arbitre {

    private Joueur joueur1;
    private Joueur joueur2;

    public Arbitre(Joueur j1, Joueur j2) {
        assert (j1 != null && j2 != null);
        this.joueur1 = j1;
        this.joueur2 = j2;
    }

    // Vérifie si le jeu est fini et qu'on a un résultat
    public boolean resultat(Joueur joueurActuel, Jeu jeu) {
        assert (joueurActuel != null && jeu != null);

        if (jeu.getNombreAllumettes() > 0) {
            return false;
        } else {
            System.out.println(joueurSuivant(joueurActuel).getNom() + " perd !");
            System.out.println(joueurActuel.getNom() + " gagne !");
            return true;
        }
    }

    public void arbitrer(Jeu jeu, Jeu jeuProxy, Joueur joueurActuel) throws CoupInvalideException {
        assert (jeu != null && jeuProxy != null && joueurActuel != null);

        int prise;
        while (!(resultat(joueurActuel, jeu))) {
            System.out.println("Allumettes restantes : " + jeu.getNombreAllumettes());
            try {
                prise = joueurActuel.getPrise(jeuProxy);
                System.out.println(joueurActuel.getNom() + " prend " + prise + " " +
                        getString(prise) + ".");
                jeu.retirer(prise);
                joueurActuel = joueurSuivant(joueurActuel); // Passer au joueur suivant
            } catch (CoupInvalideException e) {
                System.out.println("Impossible ! Nombre invalide : " + e.getCoup() + " " + e.getProbleme());
                arbitrer(jeu, jeuProxy, joueurActuel);
                break;
            } catch (OperationInterditeException e) {
                System.out.println("Abandon de la partie car " +
                        joueurActuel.getNom() + " triche !");
                break;
            }
        }
    }

    // Méthode pour obtenir le joueur suivant
    public Joueur joueurSuivant(Joueur joueurActuel) {
        if (joueurActuel == this.joueur1) {
            return this.joueur2;
        } else {
            return this.joueur1;
        }
    }

    public String getString(int prise) {
        if (prise >= 2) {
            return "allumettes";
        } else {
            return "allumette";
        }
    }
}