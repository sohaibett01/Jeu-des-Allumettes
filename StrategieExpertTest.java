package allumettes;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Classe de test de la classe StrategieExperte
 */
public class StrategieExpertTest {

    private Strategies strategie;

    @Before
    public void setUp() {
        this.strategie = new StrategieExpert();
    }

    @Test
    public void testgetNom() {
        assertEquals(this.strategie.getNom(), "Expert");
    }

    @Test
    public void testgetPrice() throws CoupInvalideException {
        int i, k;
        k = 1;
        for (i = 2; i <= 4; i++) {
            assertTrue(this.strategie.getPrise(new JeuReel(i)) == (i - 1));
        }
        for (i = 6; i <= 8; i++) {
            assertTrue(this.strategie.getPrise(new JeuReel(i)) == k);
            k++;
        }
        k = 1;
        for (i = 10; i <= 12; i++) {
            assertTrue(this.strategie.getPrise(new JeuReel(i)) == k);
            k++;
        }
    }

    /**
     * Méthode pricipale de la classe StrategieExperteTest
     *
     * @param args est la variable d'environnement qui est une table de caractères
     */
    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main(StrategieExpertTest.class.getName());
    }

}
