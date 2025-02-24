package allumettes;

import java.util.Random;

// Une stratégie qui essaye de gagner à tous les coups
public class StrategieExpert implements Strategies {

    public StrategieExpert() {
    }

    public String getNom() {
        return "Expert";
    }

    @Override
    public int getPrise(Jeu jeu) {
        assert (jeu.getNombreAllumettes() > 0);

        Random random = new Random();

        if ((jeu.getNombreAllumettes() - 1) % (Jeu.PRISE_MAX + 1) == 0) {
            if (jeu.getNombreAllumettes() >= Jeu.PRISE_MAX) {
                return random.nextInt(Jeu.PRISE_MAX) + 1;
            } else {
                return random.nextInt(jeu.getNombreAllumettes()) + 1;
            }
        } else {
            return (jeu.getNombreAllumettes() - 1) % (Jeu.PRISE_MAX + 1);
        }
    }

}

