package allumettes;

// Une Strategie qui prend le maximum allumettes possibles 

public class StrategieRapide implements Strategies {
    public StrategieRapide() {
        // Aucune initialisation nécessaire
    }
    
    public String getNom() {
        return "Rapide";
    }
        
    @Override
    public int getPrise(Jeu jeu) {
        assert (jeu.getNombreAllumettes() > 0);
    
        if (jeu.getNombreAllumettes() <= Jeu.PRISE_MAX) {
            return jeu.getNombreAllumettes();
        } else {
            return Jeu.PRISE_MAX;
        }    
    }
}