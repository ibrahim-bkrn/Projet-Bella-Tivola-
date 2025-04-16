public class Cuisinier extends Employee {
    public Cuisinier(String nom, int id) {
        super(nom, id);
    }

    @Override
    public void afficherInfosEmployee() {
        System.out.println("👨‍🍳 " + nom + " prépare les plats et met à jour le stock.");
    }
    
    public void preparerPlat(Plat plat) {
        System.out.println("🍽️ Préparation du plat : " + plat.getNom());
    }
}

