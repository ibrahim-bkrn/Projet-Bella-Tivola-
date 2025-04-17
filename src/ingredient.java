public class ingredient {
    private String nomIngredient;
    private int quantite;

    public ingredient(String nomIngredient, int quantite) {
        this.nomIngredient = nomIngredient;
        this.quantite = quantite;
    }

    public String getNom() {return nomIngredient;}
    public int getQuantite() {return quantite;}

    public void setQuantite(int quantite) {this.quantite = quantite;}

    public boolean ruptureStock(){
        if (quantite == 0) return true;
        else return false;
    }

    @Override
    public String toString() {
        return nomIngredient + " " + quantite + "g";
    }
}
