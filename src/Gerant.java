import java.sql.SQLException;

public class Gerant extends Employee {
    database db = new database();

    public Gerant(String nom, int id) {
        super(nom, id);
        db.main();
        try{
            db.insertGérant(this);
        } catch (SQLException e){
            System.out.println("L'ingrédient n'a pas pu être enregistrer dans la base de donnée, l'erreur :" + e.getMessage());
        }
    }

    public String getRole (){return "Gerant";}

    @Override
    public void afficherInfosEmployee() {
        System.out.println("Gérant : " + nom + " | ID : " + id);
    }

    public void ajouterIngredientAuStock(Stock stock, ingredient ingr) {
        stock.ajouterIngredient(ingr);
        System.out.println("🧾 Ingrédient ajouté au stock : " + ingr.getNom());
    }

    public void afficherStock(Stock stock) {
        System.out.println("📦 Stock actuel :");
        for (ingredient ingr : stock.getIngredients()) {
            System.out.println("- " + ingr.getNom() + " : " + ingr.getQuantite() + "g");
        }
    }
}

