public class Gerant extends Employee {

    public Gerant(String nom, int id) {
        super(nom, id);
    }

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

