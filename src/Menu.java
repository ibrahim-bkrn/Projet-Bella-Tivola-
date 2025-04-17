import java.util.ArrayList;

public class Menu {
    ArrayList<Plat> leMenu;

    Menu() {
        this.leMenu = new ArrayList<>();
    }

    public void ajtPlatDansMenu(Plat platAjoute) {
        leMenu.add(platAjoute);
    }

    public void suppPlatDuMenu(String nomPlat) {
        for (Plat plat : leMenu) {
            if (plat.getNom().equals(nomPlat)) {
                leMenu.remove(plat);
            } else {
                System.out.println(plat.getNom() + " n'existe pas !");
            }
        }
    }

    public Plat returnPlat(String nomPlat) {
        for (Plat plat : leMenu) {
            if (plat.getNom().equals(nomPlat)) {
                return plat;
            }
        }
        return null;
    }

    public void afficherMenu() {
        System.out.println("==============Menu================");
        for (int i = 0; i < leMenu.size(); i++) {
            System.out.println(leMenu.get(i).toString());
        }
        System.out.println("==================================");
    }
}
