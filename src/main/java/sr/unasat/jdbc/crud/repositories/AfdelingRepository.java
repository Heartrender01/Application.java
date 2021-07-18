package sr.unasat.jdbc.crud.repositories;

import sr.unasat.jdbc.crud.entities.Afdeling;

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
        List<Afdeling> afdelingList = new ArrayList<>();
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            String sql = "select * from afdeling";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("resultset: " + rs);

            while (rs.next()) {

                int id = rs.getInt("id");
                String afdeling = rs.getString("afdeling");

                afdelingList.add(new Afdeling(id));

            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return afdelingList;
    }


}
