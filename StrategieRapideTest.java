package allumettes;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Classe de test de la classe StrategieRapide
 */
public class StrategieRapideTest {

    private Strategies strategie;

    @Before
    public void setUp() {
        this.strategie = new StrategieRapide();
    }

    @Test
    public void testnom() {
        assertEquals(this.strategie.getNom(), "Rapide");
    }

    @Test
    public void testgetPrise() throws CoupInvalideException {
        int i;
        for (i = 1; i <= 13; i++) {
            if (i == 1 || i == 2) {
                assertTrue(this.strategie.getPrise(new JeuReel(i)) == i);
            } else {
                assertTrue(this.strategie.getPrise(new JeuReel(i)) == 3);
            }
        }
    }

    /**
     * Méthode pricipale de la classe StrategieRapideTest
     *
     * @param args est la variable d'environnement qui est une table de caractères
     */
    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main(StrategieRapideTest.class.getName());
    }

}
