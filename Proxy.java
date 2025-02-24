package allumettes;

// La classe Proxy aide l'arbitre à détecter qu'un joueur est tricheur.
public class Proxy implements Jeu {

    // Le proxy du jeu.
    private Jeu jeuProxy;

    /**
     * Constructeur de la classe Proxy.
     *
     * @param jeu : Le jeu courant
     */
    public Proxy(Jeu jeu) {
        assert (jeu != null);
        this.jeuProxy = jeu;
    }

    @Override
    public int getNombreAllumettes() {
        return this.jeuProxy.getNombreAllumettes();
    }

    @Override
    public void retirer(int nbPrises) throws OperationInterditeException {
        throw new OperationInterditeException("");
    }
}