package allumettes;
import java.util.Random;

// Une Strategie qui prend un nombre aleatoire d'allumettes 

public class StrategieNaif implements Strategies {
    public StrategieNaif() {
        
    }
    
    
    public String getNom() {
        return "Naif";
    }
    
    @Override
    public int getPrise(Jeu jeu) {
        assert (jeu.getNombreAllumettes() > 0);
        
        if (jeu.getNombreAllumettes() >= Jeu.PRISE_MAX) {
            return new Random().nextInt(Jeu.PRISE_MAX) + 1;
        } else {
            return new Random().nextInt(jeu.getNombreAllumettes()) + 1;
        }
    }
}
