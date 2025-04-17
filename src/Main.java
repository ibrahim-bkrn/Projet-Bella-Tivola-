import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        Menu menuTivola = new Menu();
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
                                break;
                            case 2:
                                menuTivola.afficherMenu();
                                break;
                            case 3:
                                System.out.print("Le nom du plat à supprimer : ");
                                String nomPlatASupp = sc.nextLine();
                                menuTivola.suppPlatDuMenu(nomPlatASupp);
                                break;
                            case 4:
                                consoleMenu = false;
                                break;
                            default:
                                System.out.println("Commande non reconnue");
                                break;
                        }
                    }
                    break;
                case 2:
            }

        }





    }
}


