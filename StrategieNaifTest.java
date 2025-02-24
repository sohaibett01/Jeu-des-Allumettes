package allumettes;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Classe de test de la classe StrategieRapide
 */
public class StrategieNaifTest {

    private Strategies strategie;

    @Before
    public void setUp() {
        this.strategie = new StrategieNaif();
    }

    @Test
    public void testgetNom() {
        assertEquals(this.strategie.getNom(), "Naif");
    }

    @Test
    public void testgetPrice() throws CoupInvalideException {
        int i;
        for (i = 1; i <= 13; i++) {
            if (i == 1) {
                assertTrue(this.strategie.getPrise(new JeuReel(i)) == i);
            } else {
                assertTrue(this.strategie.getPrise(new JeuReel(i)) >= 1 && this.strategie.getPrise(new JeuReel(i)) <= 3);
            }
        }
    }

    /**
     * Méthode pricipale de la classe StrategieNaiveTest
     *
     * @param args est la variable d'environnement qui est une table de caractères
     */
    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main(StrategieNaifTest.class.getName());
    }

}
