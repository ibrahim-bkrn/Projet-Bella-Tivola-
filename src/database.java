import java.sql.*;

public class database {
    private static String url = "jdbc:mysql://localhost:3306/bellaTivola";
    private static String user = "root";
    private static String password = "ibrahim";
    private static Connection conn;

    public void main (){
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connexion réussie à la base de données !");
        } catch (SQLException e) {
            System.out.println("❌ Erreur de connexion : " + e.getMessage());
        }
    }

    //Gérer la tables plats
    public void insertPlat(Plat plat) throws SQLException{
        String sql = "INSERT INTO plats(nom,prix,type) VALUES(?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, plat.getNom());
        preparedStatement.setDouble(2, plat.getPrix());
        preparedStatement.setString(3, plat.getType());

        preparedStatement.executeUpdate();
    }

    public void suppPlat(Plat plat) throws SQLException {
        String sql = "DELETE FROM plats WHERE nom = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, plat.getNom());

        preparedStatement.executeUpdate();
    }

    //Gérer la table stock des ingrédients
    public void insertIngredient(ingredient ingr) throws SQLException {
        String sql = "INSERT INTO stocks(nom,quantite) VALUES(?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, ingr.getNom());
        preparedStatement.setInt(2, ingr.getQuantite());

        preparedStatement.executeUpdate();
    }

    public void suppIngredient(ingredient ingr) throws SQLException {
        String sql = "DELETE FROM stocks WHERE nom = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, ingr.getNom());

        preparedStatement.executeUpdate();
    }

    //Gérer la classe employee
    public void insertServeur(Serveur serveur) throws SQLException {
        String sql = "INSERT INTO employes(nom, role) VALUES(?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, serveur.getNom());
        preparedStatement.setString(2, serveur.getRole());

        preparedStatement.executeUpdate();
    }

    public void insertCuisinier(Cuisinier cuisinier) throws SQLException {
        String sql = "INSERT INTO employes(nom, role) VALUES(?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, cuisinier.getNom());
        preparedStatement.setString(2, cuisinier.getRole());

        preparedStatement.executeUpdate();
    }

    public void insertGérant(Gerant gerant) throws SQLException {
        String sql = "INSERT INTO employes(nom, role) VALUES(?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, gerant.getNom());
        preparedStatement.setString(2, gerant.getRole());

        preparedStatement.executeUpdate();
    }

    //Gérer la classe commande
    public void insertCommande(Commande commande) throws SQLException {
        String sql = "INSERT INTO commande(id, total) VALUES(?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setDouble(1, commande.getId());
        preparedStatement.setDouble(2, commande.totalPrixCommande());

        preparedStatement.executeUpdate();
    }

    public void suppCommande(Commande commande) throws SQLException {
        String sql = "DELETE FROM commande WHERE id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setDouble(1, commande.getId());

        preparedStatement.executeUpdate();
    }

    public int getDernierIdCommande() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM commande;");
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0; // Si la table est vide
        }
    }



}
