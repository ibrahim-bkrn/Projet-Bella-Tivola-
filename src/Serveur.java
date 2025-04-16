import java.util.ArrayList;
import java.util.List;

public class Serveur extends Employee {
    private List<Commande> commandes;

    public Serveur(String nom, int id) {
        super(nom, id);
        commandes = new ArrayList<Commande>();
    }

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

