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

    public void insertPlat(Plat plat) throws SQLException{
        String sql = "INSERT INTO plats(nom,prix,type) VALUES(?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, plat.getNom());
        preparedStatement.setDouble(2, plat.getPrix());
        preparedStatement.setString(3, plat.getType());

        preparedStatement.executeUpdate();
    }

    public void insertIngredient(ingredient ingr) throws SQLException {
        String sql = "INSERT INTO stocks(nom,quantite) VALUES(?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, ingr.getNom());
        preparedStatement.setDouble(2, ingr.getQuantite());

        preparedStatement.executeUpdate();
    }


}
