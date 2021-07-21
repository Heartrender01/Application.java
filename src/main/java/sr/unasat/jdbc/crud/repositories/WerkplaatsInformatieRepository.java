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
            System.out.println("De driver is geregistreerd!");

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
        List<WerkplaatsInformatie> infoList = new ArrayList<WerkplaatsInformatie>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "select wi.id, p.id pid, p.naam pnaam, a.id aid, a.afdeling afdeling_naam" +
                    " from werkplaats_informatie wi" +
                    " join persoon p" +
                    " on p.id = wi.persoon_id" +
                    " join afdeling a  " +
                    " on a.id = wi.afdeling_id";

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("resultset: " + rs);

            while (rs.next()) {

                int id = rs.getInt("id");

                int persoonId = rs.getInt("pid");
                String persoonNaam = rs.getString("pnaam");
                Persoon persoon = new Persoon(persoonId, persoonNaam);

                int afdelingId = rs.getInt("aid");
                String afdelingNaam = rs.getString("afdeling_naam");
                Afdeling afdeling = new Afdeling(afdelingId, afdelingNaam);

                infoList.add(new WerkplaatsInformatie(id, persoon, afdeling));

            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return infoList;
    }

    public int deleteOneRecord(WerkplaatsInformatie werkplaatsInformatie) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "DELETE FROM werkplaats_informatie WHERE werkplaats_informatie.id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, werkplaatsInformatie.getId());
            result = stmt.executeUpdate();

            System.out.println("deleted: " + werkplaatsInformatie.getId());

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

    public WerkplaatsInformatie findOneRecord(int werkplaatsinformatie) {
        WerkplaatsInformatie werkplaatsInfo = null;
        PreparedStatement stmt = null;
        try {
            String sql = "select wi.id, p.id pid, p.naam pnaam, a.id aid, a.afdeling afdeling_naam" +
                    " from werkplaats_informatie wi" +
                    " join persoon p" +
                    " on p.id = wi.persoon_id" +
                    " join afdeling a  " +
                    " on a.id = wi.afdeling_id" +
                    " where wi.id = ? ";

            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, werkplaatsinformatie);
            ResultSet rs = stmt.executeQuery();
            System.out.println("resultset: " + rs);

            if (rs.next()) {

                int id = rs.getInt("wi.id");

                int persoonId = rs.getInt("pid");
                String persoonNaam = rs.getString("pnaam");
                Persoon persoon = new Persoon(persoonId, persoonNaam);

                int afdelingId = rs.getInt("aid");
                String afdelingNaam = rs.getString("afdeling_naam");
                Afdeling afdeling = new Afdeling(afdelingId, afdelingNaam);

                werkplaatsInfo = new WerkplaatsInformatie(id, persoon, afdeling);
            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return werkplaatsInfo;
    }

    public int deleteAllRecords(WerkplaatsInformatie werkplaatsInformatie) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "DELETE FROM werkplaats_informatie WHERE werkplaats_informatie.id > ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, werkplaatsInformatie.getId());
            result = stmt.executeUpdate();

            System.out.println("deleted all records " + werkplaatsInformatie.getId());

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

    public int insertOneRecord(WerkplaatsInformatie werkplaatsInformatie) {
        int result = 0;
        try {
            String sql = "insert into werkplaats_informatie" +
                     " set id = ? , persoon_id = ? , afdeling_id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1 , werkplaatsInformatie.getId());
            stmt.setInt(2, werkplaatsInformatie.getPersoon().getId());
            stmt.setInt(3, werkplaatsInformatie.getAfdeling().getId());


            result = stmt.executeUpdate();
            System.out.println("resultset: " + result);

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }
}
