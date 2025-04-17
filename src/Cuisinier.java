import java.sql.SQLException;

public class Cuisinier extends Employee {
    database db = new database();

    public Cuisinier(String nom, int id) {
        super(nom, id);
        db.main();
        try{
            db.insertCuisinier(this);
        } catch (SQLException e){
            System.out.println("L'ingrédient n'a pas pu être enregistrer dans la base de donnée, l'erreur :" + e.getMessage());
        }
    }

    public String getRole(){return "Cuisinier";}

    @Override
    public void afficherInfosEmployee() {
        System.out.println("👨‍🍳 " + nom + " prépare les plats et met à jour le stock.");
    }
    
    public void preparerPlat(Plat plat) {
        System.out.println("🍽️ Préparation du plat : " + plat.getNom());
    }
}

