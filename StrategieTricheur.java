package allumettes;

// La classe StrategieTricheur définit un joueur qui triche.

public class StrategieTricheur implements Strategies {

    private boolean confiant;

    public StrategieTricheur(boolean cf){
        this.confiant = cf ;
    }

    public String getNom() {
        return "Tricheur";
    }

    @Override
    public int getPrise(Jeu jeu) throws CoupInvalideException {
        assert (jeu.getNombreAllumettes() > 0);
        System.out.println("[Je triche...]");
        
        if (this.confiant){
            System.out.println("[Allumettes restantes : 2]");
        }

        int n = jeu.getNombreAllumettes() - 2;
        try {
            // retirer toutes les allumettes sauf 2 
            for (int i = 0; i < n; i++) {
                jeu.retirer(1);
            }
        } catch (CoupInvalideException e) {
            // Gestion des exceptions
        }
        // allumettes restantes:2 alors on prend 1
        return 1;
    }
}