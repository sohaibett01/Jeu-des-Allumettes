package allumettes;

import java.util.Scanner;

// Une Stratégie dont un joueur humain qui joue
public class StrategieHumain implements Strategies {

    private String nom;
    private static final Scanner scan = new Scanner(System.in);

    public StrategieHumain(String name) {
        this.nom = name;
    }

    public String getNom() {
        return "Humain";
    }

    @Override
    public int getPrise(Jeu jeu) throws CoupInvalideException {
        assert (jeu.getNombreAllumettes() > 0);
        boolean fin = false;
        int nbPrise = 0;
        

        while (!fin) {
            System.out.print(this.nom + ", combien d'allumettes ? ");
            String strScan = scan.nextLine();

            try {
                nbPrise = Integer.parseInt(strScan);
                fin = true;

            } catch (NumberFormatException e){
                if ("triche".equals(strScan)) {
                    try {
                        jeu.retirer(1);
                        System.out.println("[Une allumette en moins, plus que " + jeu.getNombreAllumettes() + ". Chut !]\r");
                        continue;
                    } catch (CoupInvalideException e1){
                    }


            }  else {
                System.out.println("Vous devez donner un entier.");
            } 
        }
    }
        return nbPrise;
    }
}