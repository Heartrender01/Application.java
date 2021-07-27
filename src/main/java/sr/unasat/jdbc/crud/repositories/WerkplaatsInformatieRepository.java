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

                int id = rs.getInt("wi.id");

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
            String sql =
                    " DELETE FROM werkplaats_informatie WHERE werkplaats_informatie.id = ?";
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
            stmt.setInt(1, werkplaatsInformatie.getWerkplaatsId());
            result = stmt.executeUpdate();

            System.out.println("deleted all records");

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

    public void insertOneRecord(WerkplaatsInformatie werkplaatsInformatie) {
        int insert = 0;
        try {
            // insert into werkplaats_informatie set id = ? , persoon_id = ?, afdeling_id = ?

            String sql = "insert into werkplaats_informatie (id, persoon_id, afdeling_id)" +
                     " values (? , ? , ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, werkplaatsInformatie.getWerkplaatsId());
            statement.setInt(2, werkplaatsInformatie.getPersoonId());
            statement.setInt(3, werkplaatsInformatie.getAfdelingId());


            insert = statement.executeUpdate();
            System.out.println("resultset: " + insert);

        } catch (SQLException e) {

        } finally {

        }
    }
    public int updateOneRecord(WerkplaatsInformatie werkplaatsInformatie) {
        PreparedStatement stmt = null;
        int update = 0;
        try {
            String sql = "update werkplaats_informatie wi " +
                    "set wi.persoon_id = ?, wi.afdeling_id = ? " +
                    "where wi.id = ?";
            stmt = connection.prepareStatement(sql);

            stmt.setInt(1, werkplaatsInformatie.getPersoonId());
            stmt.setInt(2, werkplaatsInformatie.getAfdelingId());
            stmt.setInt(3,  werkplaatsInformatie.getId());

            update = stmt.executeUpdate();
            System.out.println("resultset: " + update);

        } catch (SQLException e) {

        } finally {

        }
        return update;
    }
}


/*SQL
Xremoves fk+ deletes recordX
ALTER TABLE contact_informatie
DROP FOREIGN KEY werkplaats_fk;
DELETE FROM werkplaats_informatie WHERE werkplaats_informatie.id = ?;

xplaces werkplaats info fkx
ALTER TABLE contact_informatie
ADD CONSTRAINT werkplaats_fk
FOREIGN KEY (werkplaats_id) REFERENCES werkplaats_informatie(id);

insert into werkplaats_informatie
set  id = ?, persoon_id = ? , afdeling_id = ?;

insert into werkplaats_informatie (id, persoon_id, afdeling_id)
                      values (1 , 1 , 2),
                             (2,2,4),
                             (3,3,1),
                             (4,4,3);

delete from werkplaats_informatie
where id > 6;

UPDATE contact_informatie SET werkplaats_id = 4 WHERE id = 4;

    select wi.id, p.id pid, p.naam pnaam, a.id aid, a.afdeling afdeling_naam
                     from werkplaats_informatie wi
                     join persoon p
                     on p.id = wi.persoon_id
                     join afdeling a
                     on a.id = wi.afdeling_id
                 where wi.id = ? ;

delete  from contact_informatie
where contact_informatie.werkplaats_id > 0;

  insert into werkplaats_informatie
set  id = ?, persoon_id = ? , afdeling_id = ?;

insert into werkplaats_informatie (id, persoon_id, afdeling_id)
                      values (1 , 1 , 2),
                             (2,2,4),
                             (3,3,1),
                             (4,4,3);


-- does not work while fk is active
delete from werkplaats_informatie
where id > 6;


UPDATE contact_informatie SET werkplaats_id = 4 WHERE id = 4;

--select specific record
    select wi.id, p.id pid, p.naam pnaam, a.id aid, a.afdeling afdeling_naam
                     from werkplaats_informatie wi
                     join persoon p
                     on p.id = wi.persoon_id
                     join afdeling a
                     on a.id = wi.afdeling_id
                 where wi.id = ? ;

-- deletes all records
delete  from contact_informatie
where contact_informatie.werkplaats_id > 0;

--does not work at same time
UPDATE contact_informatie SET werkplaats_id = null WHERE werkplaats_id > 0;
        delete from werkplaats_informatie
        where id > 0                                                */
