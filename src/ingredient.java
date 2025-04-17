import java.sql.*;
import java.sql.SQLException;

public class ingredient {
    private String nomIngredient;
    private int quantite;
    database db = new database();

    public ingredient(String nomIngredient, int quantite) {
        this.nomIngredient = nomIngredient;
        this.quantite = quantite;
        db.main();
    }

    public String getNom() {return nomIngredient;}
    public int getQuantite() {return quantite;}

    public void setQuantite(String nomIngredient, int quantite) {
        this.quantite = quantite;
        try {
            db.setQuantiteBDD(quantite, nomIngredient);
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public boolean ruptureStock(){
        if (quantite == 0) return true;
        else return false;
    }

    @Override
    public String toString() {
        return nomIngredient + " " + quantite + "g";
    }
}
