package sr.unasat.jdbc.crud.repositories;


import sr.unasat.jdbc.crud.entities.Geslacht;
import sr.unasat.jdbc.crud.entities.Land;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeslachtRepository {
    private Connection connection;

    public GeslachtRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("De driver is geregistreerd!");

            String URL = "jdbc:mysql://localhost:3306/adres_boek";
            String USER = "root";
            String PASS = "Wh!te_RabB!t_13";
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println(connection);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Geslacht> findAllRecords(){
        List<Geslacht> geslachtList = new ArrayList<Geslacht>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "select * from geslacht";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("resultset: " + rs);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String geslacht = rs.getString("geslacht");

                geslachtList.add(new Geslacht(id, geslacht));

            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return geslachtList;
    }

    public int insertOneRecord(Geslacht geslacht) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "insert into geslacht (geslacht) values(?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, geslacht.getGeslacht());
            result = stmt.executeUpdate();
            System.out.println("resultset: " + result);

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

    public int deleteOneRecord(Geslacht geslacht){
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "DELETE FROM geslacht WHERE gesclacht.id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, geslacht.getId());
            result = stmt.executeUpdate();
            System.out.println("deleted: " + geslacht.getId());

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

}
