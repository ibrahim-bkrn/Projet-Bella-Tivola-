import java.util.ArrayList;
import java.util.List;

public class Plat {
    private String nom;
    private double prix;
    private String type;
    private List<ingredient> ingredients;


    public Plat(String nom, double prix, String type){
        this.nom = nom;
        this.prix = prix;
        this.type = type;
    }

    public Plat(String nom, double prix, String type, List<ingredient> ingredients) {
        this.nom = nom;
        this.prix = prix;
        this.type = type;
        this.ingredients = ingredients;
    }

    public String getNom() { return nom; }
    public double getPrix() { return prix; }
    public String getType() {return type; }
    public List<ingredient> getIngredients() { return ingredients; }

    @Override
    public String toString() {
        return nom + "\t" + prix + "€\t" + type;
    }
}
