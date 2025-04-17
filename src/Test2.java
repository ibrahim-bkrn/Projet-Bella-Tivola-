import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args){


        /*List<ingredient> ingredients1 = new ArrayList<>();
        ingredients1.add(new ingredient("Tomate", 100));
        ingredients1.add(new ingredient("Mozzarella", 80));

        List<ingredient> ingredients2 = new ArrayList<>();
        ingredients2.add(new ingredient("Mascarpone", 60));
        ingredients2.add(new ingredient("Biscuit", 40));

        List<ingredient> ingredients3 = new ArrayList<>();
        ingredients3.add(new ingredient("Pâtes", 150));
        ingredients3.add(new ingredient("Viande hachée", 100));

        List<ingredient> ingredients4 = new ArrayList<>();
        ingredients4.add(new ingredient("Saumon", 90));
        ingredients4.add(new ingredient("Crème fraîche", 70));

        Plat platTest = new Plat("Marguerita", 15, "Pizza", ingredients1);
        Plat platTest2 = new Plat("Tiramisu", 4, "Desert", ingredients2);
        Plat platTest3 = new Plat("Bolognaise", 10, "Pates", ingredients3);
        //Plat platTest4 = new Plat("Norvgegienne", 15, "Pizza", ingredients4);


        /*Commande commande = new Commande();
        commande.ajtPlatDansCommande(platTest);
        commande.ajtPlatDansCommande(platTest2);
        commande.ajtPlatDansCommande(platTest3);
        commande.ajtPlatDansCommande(platTest4);

        Menu menu = new Menu();
        menu.ajtPlatDansMenu(platTest);
        menu.ajtPlatDansMenu(platTest2);
        menu.ajtPlatDansMenu(platTest3);
        menu.ajtPlatDansMenu(platTest4);

        commande.afficherCommande();
        menu.afficherMenu();*/

        /*database database = new database();
        database.main();
        try{
            database.insertPlat(platTest);
            database.insertPlat(platTest2);
            database.insertPlat(platTest3);
            System.out.println("plat ajouté avec succes!");
        } catch (SQLException e){
            System.out.println("ça a pas marché" + e.getMessage());
        }*/

        /*ingredient ingr1 = new ingredient("tomate", 500);
        //System.out.println(ingr1.toString());
        try{
            database.insertIngredient(ingr1);
            System.out.println("Ingredient ajouté avec succes!");
        } catch (SQLException e){
            System.out.println("Ingrédient non ajouté" + e.getMessage());
        }*/

        Menu menu = new Menu();
        /*try{
            menu.afficherMenu();
        } catch (SQLException e){
            System.out.println(e);
        }*/

        System.out.println(menu.returnPlat("Tiramisu").getIngredients());

    }
}