package allumettes;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Classe de test de la classe StrategieTricheur
 */
public class StrategieTricheurTest {

    private Strategies strategie;

    private boolean confiant;

    @Before
    public void setUp() {
        this.strategie = new StrategieTricheur(confiant);
    }

    @Test
    public void testgetNom() {
        assertEquals(this.strategie.getNom(), "Tricheur");
    }

    @Test
    public void testgetPrice() throws CoupInvalideException {
        int i;
        for (i = 3; i <= 13; i++) {
            assertTrue(this.strategie.getPrise(new JeuReel(i)) == 1);
        }
    }

    /**
     * Méthode pricipale de la classe StrategieTricheurTest
     *
     * @param args est la variable d'environnement qui est une table de caractères
     */
    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main(StrategieTricheurTest.class.getName());
    }

}
