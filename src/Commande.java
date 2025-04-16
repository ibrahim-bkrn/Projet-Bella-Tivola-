import java.util.ArrayList;
import java.util.List;

public class Commande {
    ArrayList<Plat> laCommande; // Les élements de la liste sotn de type plat, on pourra donc les manipulers avec elt.getnom() apr exemple

    Commande() {
        this.laCommande = new ArrayList<>();
    }

    public List<Plat> getCommande() {return laCommande;}

    public void ajtPlatDansCommande(Plat platAjoute) {
        laCommande.add(platAjoute);
    }

    public void afficherCommande() {
        System.out.println("============Commande==============");
        for (int i = 0; i < laCommande.size(); i++) {
            System.out.println(laCommande.get(i).getNom() + "\t" + laCommande.get(i).getPrix() + "€");
        }
        totalPrixCommande();
        System.out.println("==================================");
    }

    public double totalPrixCommande() {
        double total = 0;
        for (int i = 0; i < laCommande.size(); i++) {
            total += laCommande.get(i).getPrix();
        }
        return total;
    }
}


/*

        ArrayList list = new ArrayList();
        ArrayList<String> listInt = new ArrayList(); // Pour preciser un type d'element dans le tableau

        list.add("A");
        list.add(15);
        System.out.println(list);

        list.get(0); //pour récuperer la valeur à cette indice
        list.remove(0); //pour enlever le premier element
        list.clear(); //nettoie completement la liste
        list.size(); //renvoi la longueur de la liste
        if (list.contains("A")) {}; //Pour vérifier qu'un element est dans la liste


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

 */