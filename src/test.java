import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        // Création des ingrédients du stock
        Stock stock = new Stock();
        stock.ajouterIngredient(new ingredient("Tomate", 500));
        stock.ajouterIngredient(new ingredient("Mozzarella", 300));
        stock.ajouterIngredient(new ingredient("Pâte", 400));
        stock.ajouterIngredient(new ingredient("Sucre", 200));
        stock.ajouterIngredient(new ingredient("Café", 100));
        stock.ajouterIngredient(new ingredient("Crème", 150));

        stock.afficherStock();
        System.out.println("---------------------------------");

        // Création de plats avec ingrédients
        List<ingredient> ingredientsPizza = new ArrayList<>();
        ingredientsPizza.add(new ingredient("Tomate", 100));
        ingredientsPizza.add(new ingredient("Mozzarella", 100));
        ingredientsPizza.add(new ingredient("Pâte", 150));
        Plat pizza = new Plat("Pizza Margherita", 12.0, "Pizza", ingredientsPizza);

        List<ingredient> ingredientsDessert = new ArrayList<>();
        ingredientsDessert.add(new ingredient("Sucre", 50));
        ingredientsDessert.add(new ingredient("Café", 20));
        ingredientsDessert.add(new ingredient("Crème", 30));
        Plat tiramisu = new Plat("Tiramisu", 6.0, "Dessert", ingredientsDessert);

        // Ajout des plats dans le menu
        Menu menu = new Menu();
        menu.ajtPlatDansMenu(pizza);
        menu.ajtPlatDansMenu(tiramisu);

        //menu.afficherMenu();

        // Création d'une commande
        Commande commande = new Commande();

        // Vérification disponibilité
        if (stock.verifierDisponibilite(pizza.getIngredients())) {
            commande.ajtPlatDansCommande(pizza);
            stock.mettreAJourStock(pizza.getIngredients());
        } else {
            System.out.println("❌ Ingrédients manquants pour : " + pizza.getNom());
        }

        if (stock.verifierDisponibilite(tiramisu.getIngredients())) {
            commande.ajtPlatDansCommande(tiramisu);
            stock.mettreAJourStock(tiramisu.getIngredients());
        } else {
            System.out.println("❌ Ingrédients manquants pour : " + tiramisu.getNom());
        }

        commande.afficherCommande();

        System.out.println("📦 Stock mis à jour :");
        stock.afficherStock();
    }
}

