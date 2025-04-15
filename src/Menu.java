import java.util.ArrayList;

public class Menu {
    ArrayList<Plat> leMenu;

    Menu() {
        this.leMenu = new ArrayList<>();
    }

    public void ajtPlatDansMenu(Plat platAjoute) {
        leMenu.add(platAjoute);
    }

    public void afficherMenu() {
        System.out.println("==============Menu================");
        for (int i = 0; i < leMenu.size(); i++) {
            System.out.println(leMenu.get(i).toString());
        }
        System.out.println("==================================");
    }
}
