import java.sql.SQLException;
import java.util.*;
import java.sql.*;

public class Menu {
    ArrayList<Plat> leMenu;
    database db = new database();

    Menu() {
        this.leMenu = new ArrayList<>();
        db.main();

        try{
            for (Plat plat : db.selectPlatsPourMenu()) {
                leMenu.add(plat);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void ajtPlatDansMenu(Plat platAjoute) {
        leMenu.add(platAjoute);
        try {
            db.insertPlat(platAjoute);
        } catch (SQLException e) {
            System.out.println("❌ Erreur lors de l'insertion du plat : " + e.getMessage());
        }
    }

    public void suppPlatDuMenu(String nomPlat) throws SQLException {
        Plat platASupprimer = null;

        // Chercher le plat dans la liste
        for (Plat plat : leMenu) {
            if (plat.getNom().equals(nomPlat)) {
                platASupprimer = plat;
                break;
            }
        }

        // Si trouvé, on le supprime de la liste et de la bdd
        if (platASupprimer != null) {
            leMenu.remove(platASupprimer);
            db.suppPlat(platASupprimer);
        } else{
            System.out.println(nomPlat + " n'existe pas !");
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

    public void afficherMenu () throws SQLException {
        /*System.out.println("==============Menu================");
        for (int i = 0; i < leMenu.size(); i++) {
            System.out.println(leMenu.get(i).toString());
        }
        System.out.println("==================================");*/

        List<Plat> plats = db.selectPlatsPourMenu();
        System.out.println("==📋 MENU DE LA BELLA TIVOLA 🍽️==");
        for (Plat plat : plats) {
            System.out.println(plat);
        }
        System.out.println("=================================");
    }
}
