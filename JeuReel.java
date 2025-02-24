package allumettes;

public class JeuReel implements Jeu {

    private int nbAllumettes;

    public JeuReel(int nombre) {
        assert (nombre > 0);
        this.nbAllumettes = nombre;
    }

    @Override
    public int getNombreAllumettes() {
        return this.nbAllumettes;
    }

    @Override
    public void retirer(int nbPrises) throws CoupInvalideException {
        if (nbPrises < 1) {
            throw new CoupInvalideException(nbPrises, "(< 1)");
        } else if (nbPrises > Jeu.PRISE_MAX) {
            if (this.nbAllumettes > Jeu.PRISE_MAX) {
                throw new CoupInvalideException(nbPrises, "(> " + Jeu.PRISE_MAX + ")");
            } else {
                throw new CoupInvalideException(nbPrises, "(> " + this.nbAllumettes + ")");
            }
        } else if (nbPrises > this.nbAllumettes) {
            throw new CoupInvalideException(nbPrises, "(> " + this.nbAllumettes + ")");
        }

        this.nbAllumettes -= nbPrises;
    }
}
