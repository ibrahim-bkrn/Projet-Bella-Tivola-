import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Serveur extends Employee {
    private List<Commande> commandes;
    database db = new database();

    public Serveur(String nom, int id) {
        super(nom, id);
        commandes = new ArrayList<Commande>();
        db.main();
        try{
            db.insertServeur(this);
        } catch (SQLException e){
            System.out.println("L'ingrédient n'a pas pu être enregistrer dans la base de donnée, l'erreur :" + e.getMessage());
        }
    }

    public String getRole() {return "serveur";}

    @Override
    public void afficherInfosEmployee() {
        System.out.println("Serveur : " + nom + " | ID : " + id + " | Rôle : Serveur");
    }

    public void prendreCommande(Commande commande) {
        commandes.add(commande);
    }

    public void envoyerCommandeEnCuisine(Commande commande) {
        System.out.println("📤 Commande envoyée en cuisine par " + nom);
    }
}

