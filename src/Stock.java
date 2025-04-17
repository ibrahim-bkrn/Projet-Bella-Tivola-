import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Stock {
    private List<ingredient> ingredients;
    database db = new database();

    public Stock() {
        this.ingredients = new ArrayList<>();
        db.main();
    }

    public List<ingredient> getIngredients() {
        return ingredients;
    }

    public void ajouterIngredient(ingredient ingr) {
        ingredients.add(ingr);
        try{
            db.insertIngredient(ingr);
        } catch (SQLException e){
            System.out.println("L'ingrédient n'a pas pu être enregistrer dans la base de donnée, l'erreur :" + e.getMessage());
        }
    }

    public ingredient rechercheIngredient(String nomIngredient) {
        for (ingredient i : ingredients) {
            if (i.getNom().equals(nomIngredient)) {
                return i;
            } else {
                return null;
            }
        } return null;
    }


    public String supprimerIngredient(ingredient ingrNom) {
        Boolean trouve = false;
        for (ingredient i : ingredients) {
            if (i.getNom().equals(ingrNom)) {
                ingredients.remove(i);
                trouve = true;
            }
        }
        if(trouve == false){
            return "Ingrédient pas trouvé";
        } else {
            return null;
        }
    }

    // Les méthodes permettant d'enlever du stock apres avoir fini une commande
    public void mettreAJourStock(List<ingredient> ingredientsDuPlat) {
        //Parcours dans la liste des ingrédients du plan (ex: marguerita 100g ensuite tomate 500g etc..)
        for (ingredient besoin : ingredientsDuPlat) {
            //Parcours pour chaque ingredient du plat tout les ingrédient du stock pour voir si il existe
            for (ingredient stock : ingredients) {
                if (stock.getNom().equals(besoin.getNom())) {
                    int nouvelleQuantite = stock.getQuantite() - besoin.getQuantite();
                    stock.setQuantite(nouvelleQuantite);
                    break;
                }
            }
        }
    }

    // Les méthodes permettant de cuisiner
    public boolean verifierDisponibilite(List<ingredient> ingredientsDuPlat) {
        for (ingredient besoin : ingredientsDuPlat) {
            boolean trouve = false;
            for (ingredient stock : ingredients) {
                if (stock.getNom().equals(besoin.getNom()) && stock.getQuantite() >= besoin.getQuantite() ) {
                    trouve = true;
                    break;
                }
            }
            if (!trouve) return false;
        }
        return true;
    }

    public void afficherStock() {
        System.out.println("---> Stock ");
        for (ingredient ingredientDuStock : ingredients) {
            System.out.println(ingredientDuStock.getNom() + " " + ingredientDuStock.getQuantite() +"g");
        }
    }
}





/*

    Map<String, Integer> ages = new HashMap<>();
    ages.put("Graven", 18);
    ages.put("Graven", 18);
    ages.put("Graven", 18);   POUR AJOUTER UNE CLE SUIVI DE SA VALEUR

    ages.remove("Graven");    POUR ENLEVER A PARTIR D'UNE CLE

    System.out.println(ages.toString);  POUR VOIR LA HASHMAP(dictionnaire)

    ages.clear(); POUR NETTOYER L'ENSEMBLE DES VALEURS

    if (ages.containsKey("graven"){}  ¨POUR VERIFIER A PARTIR D'UNE CLE, Values POUR LES VALEURS

    for (Entry<String,Integer> val : ages.entrySet()){
        Systeme.out.println(val.getKey() + val.getValue);
    }

 */
