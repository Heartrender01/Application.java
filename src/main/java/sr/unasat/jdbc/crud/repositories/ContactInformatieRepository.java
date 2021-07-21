package sr.unasat.jdbc.crud.repositories;

import sr.unasat.jdbc.crud.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactInformatieRepository {
    private Connection connection;

    public ContactInformatieRepository() {
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

    public List<ContactInformatie> findAllRecords() {
        List<ContactInformatie> contactList = new ArrayList<ContactInformatie>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "select ci.id, ci.adres, ci.telefoon_nummer , p.id pid, p.naam pnaam, l.id lid, l.naam land_naam, g.id gid, g.geslacht ggeslacht, wi.id wiid, a.id aid, a.afdeling aafdeling" +
                    " from contact_informatie ci" +
                    " join persoon p" +
                    " on p.id = ci.persoon_id" +
                    " join land l  " +
                    " on l.id = ci.land_id" +
                    " join geslacht g" +
                    " on g.id = ci.geslacht_id" +
                    " join werkplaats_informatie wi" +
                    " on wi.id = ci.werkplaats_id" +
                    " join afdeling a" +
                    " on wi.afdeling_id = a.id";

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("resultset: " + rs);

            while (rs.next()) {

                int id = rs.getInt("id");
                String adres = rs.getString("adres");
                int telefoonNummer = rs.getInt("telefoon_nummer");

                int persoonId = rs.getInt("pid");
                String persoonNaam = rs.getString("pnaam");
                Persoon persoon = new Persoon(persoonId, persoonNaam);

                int afdelingId = rs.getInt("aid");
                String afdelingNaam = rs.getString("aafdeling");
                Afdeling afdeling = new Afdeling(afdelingId, afdelingNaam);

                int landId = rs.getInt("lid");
                String landNaam = rs.getString("land_naam");
                Land land = new Land(landId, landNaam);

                int geslachtId = rs.getInt("gid");
                String ggeslacht = rs.getString("ggeslacht");
                Geslacht geslacht = new Geslacht(geslachtId, ggeslacht);

                int wiId = rs.getInt("wiid");
                WerkplaatsInformatie werkplaatsInfo = new WerkplaatsInformatie(wiId, persoon, afdeling);

                contactList.add(new ContactInformatie(id, adres, telefoonNummer, persoon, land, geslacht, werkplaatsInfo));

            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return contactList;
    }
    public int updateOneRecord(ContactInformatie contact) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "update contact_informatie ci set ci.telefoon_nummer = ?, ci.persoon_id = ? where ci.id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, contact.getTelefoonNummer());
            stmt.setInt(2, contact.getPersoon().getId());
            stmt.setInt(3, contact.getId());
            result = stmt.executeUpdate();
            System.out.println("resultset: " + result);

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

}

