package allumettes;

public interface Strategies {

    String getNom();

    int getPrise(Jeu jeu) throws CoupInvalideException;
}
