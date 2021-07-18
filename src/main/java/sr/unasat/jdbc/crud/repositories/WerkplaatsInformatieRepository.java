package sr.unasat.jdbc.crud.repositories;

import sr.unasat.jdbc.crud.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WerkplaatsInformatieRepository {
    private Connection connection;

    public WerkplaatsInformatieRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("De driver is ddddddgeregistreerd!");

            String URL = "jdbc:mysql://localhost:3306/adres_boek";
            String USER = "root";
            String PASS = "Wh!te_RabB!t_13";
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println(connection);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load contact_info!");
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<WerkplaatsInformatie> findAllRecords() {
        List<WerkplaatsInformatie> werkplaatsInformatieList = new ArrayList<WerkplaatsInformatie>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "select wi.id , p.id pid, p.naam pnaam, a.id aid, a.afdeling aafdeling" +
                    " from werkplaats_informatie wi" +
                    " join persoon p" +
                    " on p.id = wi.persoon_id" +
                    " join afdeling a" +
                    " on a.id = wi.afdeling_id ";

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("resultset: " + rs);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");

                int persoonId = rs.getInt("pid");
                String persoonNaam = rs.getString("pnaam");
                Persoon persoon = new Persoon(persoonId, persoonNaam);

                int afdelingId = rs.getInt("aid");
                String afdelingAfdeling = rs.getString("aafdeling");
                Afdeling afdeling = new Afdeling(afdelingId);


                werkplaatsInformatieList.add(new WerkplaatsInformatie(id));

            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return werkplaatsInformatieList;
    }

    public int deleteAllRecords(WerkplaatsInformatie werkplaatsInformatie){
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "DELETE FROM werkplaats_informatie " +
                    "WHERE werkplaats_informatie.id > ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, werkplaatsInformatie.getId());
            result = stmt.executeUpdate();

            System.out.println("deleted: " + werkplaatsInformatie.getId());

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }


}
