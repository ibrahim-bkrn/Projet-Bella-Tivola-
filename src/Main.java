import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        /*
        Ajout d’un menu interactif en console
        o Options disponibles :
            § Afficher le menu (données chargées depuis MySQL).
            § Passer une commande (vérification du stock et ajout à la base).
            § Afficher l’état du stock et le modifier (ajout/retrait d’ingrédients).
            § Consulter l’historique des commandes.
         */
        Scanner sc = new Scanner(System.in);
        Boolean console = true;

        database db = new database();
        db.main();
        Menu menuTivola = new Menu();
        Stock stock = new Stock();
        ArrayList<Commande> listeCommandesHistorique = new ArrayList<>();
        System.out.println("========= 🍝 BELLA TIVOLA - MENU CONSOLE =========");
        System.out.println("1. 📋 Gérer le menu");
        System.out.println("2. 🧾 Passer une commande");
        System.out.println("3. 📦 Gérer le stock");
        System.out.println("4. 📜 Voir l'historique des commandes");
        System.out.println("5. ❌ Quitter");

        while (console) {
            System.out.print("➡ Choisissez une option : ");
            int choix = sc.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("========= 🍝 Gérer le menu =========");
                    System.out.println("1. 🍽️ Ajouter un plat");
                    System.out.println("2. 📜 Afficher le menu");
                    System.out.println("3. 🗑️ Supprimer un plat");
                    System.out.println("4. 📜 Voir l'historique des commandes");
                    System.out.println("5. 🚪 Quitter");
                    Boolean consoleMenu = true;
                    while (consoleMenu) {
                        System.out.print("➡ Choisissez une option pour gérer le menu : ");
                        int choixConsoleMenu = sc.nextInt();
                        switch (choixConsoleMenu) {
                            case 1:
                                System.out.print("🍽️ Nom du plat : ");
                                String nomPlat = sc.nextLine();
                                nomPlat = sc.nextLine();

                                System.out.print("💰 Prix du plat : ");
                                double prixPlat = sc.nextDouble();

                                System.out.print("📂 Type du plat (ex : 🍕 Pizza, 🍰 Dessert) : ");
                                String typePlat = sc.next();

                                System.out.print("🧾 Nombre d’ingrédients nécessaires pour ce plat : ");
                                int nbIngredients = sc.nextInt();

                                ArrayList<ingredient> ingredientsDuPlat = new ArrayList<>();

                                for (int i = 1; i < nbIngredients+1; i++) {
                                    System.out.print("🥄 Nom de l’ingrédient "+ i +" : ");
                                    String nomIngredient = sc.next();

                                    System.out.print("⚖️ Quantité en grammes : ");
                                    int quantite = sc.nextInt();

                                    ingredientsDuPlat.add(new ingredient(nomIngredient, quantite));
                                }

                                // Instanciation du plat à ajouter
                                menuTivola.ajtPlatDansMenu(new Plat(nomPlat, prixPlat, typePlat, ingredientsDuPlat));
                                try{
                                    db.insertPlat(new Plat(nomPlat, prixPlat, typePlat, ingredientsDuPlat));
                                } catch (SQLException e){
                                    System.out.println("Erreur lors de l'insertion du plat : " + e.getMessage());
                                }
                                break;
                            case 2:
                                menuTivola.afficherMenu();
                                break;
                            case 3:
                                System.out.print("Le nom du plat à supprimer : ");
                                String nomPlatASupp = sc.nextLine();
                                nomPlatASupp = sc.nextLine();
                                menuTivola.suppPlatDuMenu(nomPlatASupp);
                                break;
                            case 4:
                                System.out.println("-----> Historique de l'affichage des commandes");
                                for (Commande commande : listeCommandesHistorique) {
                                    commande.afficherCommande();
                                }
                            case 5:
                                consoleMenu = false;
                                break;
                            default:
                                System.out.println("Commande non reconnue");
                                break;
                        }
                    }
                    break;
                case 2:
                    Commande commande = new Commande();
                    listeCommandesHistorique.add(commande);
                    System.out.println("========= 🍝 Gérer la commande =========");
                    System.out.println("1. 🍽️ Ajouter un plat à la commande");
                    System.out.println("2. 📜 Afficher la commande");
                    System.out.println("3. 🗑️ Avoir l'id de la commande");
                    System.out.println("4. 🗑️ Avoir le prix total");
                    System.out.println("5. 🚪 Confirmer la commande et l'enregistrer dans la Base de donnée");
                    System.out.println("6. 🗑️ Supprimer la commande");
                    System.out.println("7. 🚪 Quitter");

                    Boolean consoleCommande = true;
                    while (consoleCommande) {
                        System.out.print("➡ Choisissez une option pour gérer le menu : ");
                        int choixConsoleMenu = sc.nextInt();
                        switch (choixConsoleMenu) {
                            case 1:
                                System.out.print("Saisissez le nom du plat que vous voulez ajouté : ");
                                String nomPlat = sc.nextLine();
                                nomPlat = sc.nextLine();
                                if (stock.verifierDisponibilite(menuTivola.returnPlat(nomPlat).getIngredients())){
                                    commande.ajtPlatDansCommande(menuTivola.returnPlat(nomPlat));
                                } else{
                                    System.out.print("Les ingrédients du plats sont pas présent dans le stock ou ne sont pas suffisant");
                                }
                                break;
                            case 2:
                                commande.afficherCommande();
                                break;
                            case 3:
                                System.out.println("L'id de la commande est : " + commande.getId());
                                break;
                            case 4:
                                System.out.println(commande.totalPrixCommande());
                                break;
                            case 5:
                                commande.ajtDansBDD();
                                for (Plat plat : commande.getCommande()){
                                    stock.mettreAJourStock(plat.getIngredients());
                                }
                                break;
                            case 6:
                                commande.suppDansBDD();
                                break;
                            case 7 :
                                consoleCommande = false;
                            default:
                                System.out.println("Commande non reconnue");
                                break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("========= 🍝 Gérer le stock =========");
                    System.out.println("1. 🍽️ Ajouter un ingrédient");
                    System.out.println("2. 📜 Supprimer un ingrédient");
                    System.out.println("3. 🗑️ Voir le stock");
                    System.out.println("4. Quitter");

                    Boolean consoleStock = true;
                    while (consoleStock) {
                        System.out.print("➡ Choisissez une option pour gérer le stock : ");
                        int choixConsoleStock = sc.nextInt();
                        switch (choixConsoleStock) {
                            case 1:
                                System.out.print("Nom de l'ingrédient : ");
                                String nomIngredient = sc.nextLine();
                                nomIngredient = sc.nextLine();

                                System.out.print("Quantité en gramme : ");
                                int quantite = sc.nextInt();

                                stock.ajouterIngredient(new ingredient(nomIngredient, quantite));
                                try {
                                    db.insertIngredient(new ingredient(nomIngredient, quantite));
                                }catch (SQLException e){
                                    System.out.println("Ingrédient pas ajouté : " + e.getMessage());
                                }
                                break;
                            case 2:
                                System.out.print("Nom de l'ingrédient que vous voulez supprimer : ");
                                String nomIngredientASupp = sc.nextLine();
                                nomIngredientASupp = sc.nextLine();

                                ingredient ingredientCherche = stock.rechercheIngredient(nomIngredientASupp);

                                stock.supprimerIngredient(ingredientCherche);
                                try {
                                    db.suppIngredient(ingredientCherche);
                                }catch (SQLException e){
                                    System.out.println("Ingrédient pas ajouté : " + e.getMessage());
                                }
                                break;
                            case 3:
                                stock.afficherStock();
                                break;
                            case 4:
                                consoleStock = false;
                                break;
                            default:
                                System.out.println("Commande non reconnue");
                                break;
                        }
                    }
                case 4:
                    System.out.println("---> Historique des commandes : ");
                    for(Commande cmd : listeCommandesHistorique){
                        cmd.afficherCommande();
                    }
                    break;
                case 5:
                    console = false;
                    break;
                default:
                    System.out.println("Commande non reconnue");
                    break;
            }

        }
    }
}


