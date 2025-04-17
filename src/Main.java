import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean console = true;

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
                    System.out.println("4. 🚪 Quitter");
                    boolean consoleMenu = true;

                    while (consoleMenu) {
                        System.out.print("➡ Choisissez une option pour gérer le menu : ");
                        int choixConsoleMenu = sc.nextInt();

                        switch (choixConsoleMenu) {
                            case 1:
                                sc.nextLine(); // flush
                                System.out.print("🍽️ Nom du plat : ");
                                String nomPlat = sc.nextLine();

                                System.out.print("💰 Prix du plat : ");
                                double prixPlat = sc.nextDouble();

                                System.out.print("📂 Type du plat (ex : 🍕 Pizza, 🍰 Dessert) : ");
                                String typePlat = sc.next();

                                System.out.print("🧾 Nombre d’ingrédients nécessaires pour ce plat : ");
                                int nbIngredients = sc.nextInt();

                                ArrayList<ingredient> ingredientsDuPlat = new ArrayList<>();

                                for (int i = 1; i <= nbIngredients; i++) {
                                    System.out.print("🥄 Nom de l’ingrédient " + i + " : ");
                                    String nomIngredient = sc.next();

                                    System.out.print("⚖️ Quantité en grammes : ");
                                    int quantite = sc.nextInt();

                                    ingredientsDuPlat.add(new ingredient(nomIngredient, quantite));
                                }

                                menuTivola.ajtPlatDansMenu(new Plat(nomPlat, prixPlat, typePlat, ingredientsDuPlat));
                                break;

                            case 2:
                                try{
                                    menuTivola.afficherMenu();
                                } catch (SQLException e){
                                    System.out.println("Erreur dans l'affichage du menu : " + e.getMessage());
                                }
                                break;

                            case 3:
                                sc.nextLine();
                                System.out.print("🗑️ Nom du plat à supprimer : ");
                                String nomPlatASupp = sc.nextLine();
                                try{
                                    menuTivola.suppPlatDuMenu(nomPlatASupp);
                                } catch (SQLException e){
                                    System.out.println("Erreur dans la suppréssion du plat : " + e.getMessage());
                                }
                                break;

                            case 4:
                                consoleMenu = false;
                                break;

                            default:
                                System.out.println("❗ Commande non reconnue");
                                break;
                        }
                    }
                    break;

                case 2:
                    Commande commande = new Commande();
                    listeCommandesHistorique.add(commande);

                    System.out.println("========= 🧾 Gérer la commande =========");
                    System.out.println("1. ➕ Ajouter un plat à la commande");
                    System.out.println("2. 📄 Afficher la commande");
                    System.out.println("3. 🆔 Voir l'ID de la commande");
                    System.out.println("4. 💵 Voir le prix total");
                    System.out.println("5. ✅ Confirmer et enregistrer");
                    System.out.println("6. ❌ Supprimer la commande");
                    System.out.println("7. 🚪 Quitter");

                    boolean consoleCommande = true;

                    while (consoleCommande) {
                        System.out.print("➡ Choisissez une option : ");
                        int choixCommande = sc.nextInt();

                        switch (choixCommande) {
                            case 1:
                                sc.nextLine();
                                System.out.print("🍽️ Nom du plat à ajouter : ");
                                String nomPlatCommande = sc.nextLine();

                                if (stock.verifierDisponibilite(menuTivola.returnPlat(nomPlatCommande).getIngredients())) {
                                    commande.ajtPlatDansCommande(menuTivola.returnPlat(nomPlatCommande));
                                } else {
                                    System.out.println("❌ Ingrédients insuffisants ou absents du stock.");
                                }
                                break;

                            case 2:
                                commande.afficherCommande();
                                break;

                            case 3:
                                System.out.println("🆔 ID de la commande : " + commande.getId());
                                break;

                            case 4:
                                System.out.println("💵 Prix total : " + commande.totalPrixCommande() + " €");
                                break;

                            case 5:
                                commande.ajtDansBDD();
                                for (Plat plat : commande.getCommande()) {
                                    stock.mettreAJourStock(plat.getIngredients());
                                }
                                break;

                            case 6:
                                commande.suppDansBDD();
                                break;

                            case 7:
                                consoleCommande = false;
                                break;

                            default:
                                System.out.println("❗ Commande non reconnue");
                                break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("========= 📦 Gérer le stock =========");
                    System.out.println("1. ➕ Ajouter un ingrédient");
                    System.out.println("2. 🗑️ Supprimer un ingrédient");
                    System.out.println("3. 📄 Voir le stock");
                    System.out.println("4. 🚪 Quitter");

                    boolean consoleStock = true;

                    while (consoleStock) {
                        System.out.print("➡ Choisissez une option : ");
                        int choixStock = sc.nextInt();

                        switch (choixStock) {
                            case 1:
                                sc.nextLine();
                                System.out.print("🥄 Nom de l'ingrédient : ");
                                String nomIngredient = sc.nextLine();

                                System.out.print("⚖️ Quantité (g) : ");
                                int quantite = sc.nextInt();

                                stock.ajouterIngredient(new ingredient(nomIngredient, quantite));
                                break;

                            case 2:
                                sc.nextLine();
                                System.out.print("🗑️ Nom de l'ingrédient à supprimer : ");
                                String nomIngredientASupp = sc.nextLine();

                                stock.supprimerIngredient(nomIngredientASupp);
                                try {
                                    db.suppIngredient(nomIngredientASupp);
                                } catch (SQLException e) {
                                    System.out.println("❌ Erreur lors de la suppression : " + e.getMessage());
                                }
                                break;

                            case 3:
                                stock.afficherStock();
                                break;

                            case 4:
                                consoleStock = false;
                                break;

                            default:
                                System.out.println("❗ Commande non reconnue");
                                break;
                        }
                    }
                    break;

                case 4:
                    System.out.println("📜 Historique des commandes :");
                    for (Commande cmd : listeCommandesHistorique) {
                        cmd.afficherCommande();
                    }
                    break;

                case 5:
                    console = false;
                    System.out.println("👋 Merci d'avoir utilisé Bella Tivola !");
                    break;

                default:
                    System.out.println("❗ Commande non reconnue");
                    break;
            }
        }
    }
}



