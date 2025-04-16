public abstract class Employee {
    protected String nom;
    protected int id;

    public Employee(String nom, int id) {
        this.nom = nom;
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }

    public abstract void afficherInfosEmployee();
}
