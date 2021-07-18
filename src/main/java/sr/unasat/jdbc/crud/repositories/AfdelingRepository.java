package sr.unasat.jdbc.crud.repositories;

import sr.unasat.jdbc.crud.entities.Afdeling;
import sr.unasat.jdbc.crud.entities.Persoon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AfdelingRepository {
    private Connection connection;

    public AfdelingRepository() {
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

    public List<Afdeling> findAllRecords(){
        List<Afdeling> afdelingList = new ArrayList<Afdeling>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "select * from afdeling";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("resultset: " + rs);
            while (rs.next()) {

                int id = rs.getInt("id");
                String afdeling = rs.getString("afdeling");

                afdelingList.add(new Afdeling(id, afdeling));
            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return afdelingList;
    }

    public int insertOneRecord(Afdeling afdeling) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "insert into afdeling (afdeling) values(?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, afdeling.getAfdeling());
            result = stmt.executeUpdate();
            System.out.println("resultset: " + result);

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

    public int deleteOneRecord(Afdeling afdeling){
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "DELETE FROM afdeling WHERE afdeling.id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, afdeling.getId());
            result = stmt.executeUpdate();

            System.out.println("deleted: " + afdeling.getId());

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

}
