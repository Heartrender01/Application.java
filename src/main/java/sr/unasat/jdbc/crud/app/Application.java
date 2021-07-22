package sr.unasat.jdbc.crud.app;

import sr.unasat.jdbc.crud.entities.*;
import sr.unasat.jdbc.crud.repositories.*;

import java.util.List;

public class Application {

    public static void main(String[] args) {


            //*** findAllRecords T3
            WerkplaatsInformatieRepository wiRepo = new WerkplaatsInformatieRepository();

                //** deleteOneRecord T3 WORKS
                //WerkplaatsInformatie result = new WerkplaatsInformatie(1);
                //wiRepo.deleteOneRecord(result);

                //** deleteAllRecords T3 WORKS
                //WerkplaatsInformatie gone = new WerkplaatsInformatie(1);
                //wiRepo.deleteAllRecords(gone);

                //--------------------------------------------------------------------------
                //** insertRecords T3  DOES NOT WORK :)
                //1.
                WerkplaatsInformatie insert = new WerkplaatsInformatie (1,1,2);
                wiRepo.insertOneRecord(insert);

                //2.
                // WerkplaatsInformatie newRecord = new WerkplaatsInformatie(4, 4, 1);
                //wiRepo.insertRecords(newRecord);

                //3.
                //WerkplaatsInformatie werkplaatsInformatie = new WerkplaatsInformatie();
                //werkplaatsInformatie.setId(5);
                //werkplaatsInformatie.setPersoon(5);
                //werkplaatsInformatie.setAfdeling(5);


                //------------------------------------------------------------------------

                        //**select a specific record T3 with T3_ID WORKS
                        //WerkplaatsInformatie onerecord = wiRepo.findOneRecord(1);
                        //System.out.println( "Single record:" + onerecord);

            //List<WerkplaatsInformatie> infoList = wiRepo.findAllRecords();
            //for (WerkplaatsInformatie info : infoList) {
            //System.out.println(info);
            //}

            //ContactInformatieRepository ciRepo = new ContactInformatieRepository();

            //List<ContactInformatie> contactList = ciRepo.findAllRecords();
            //for (ContactInformatie contact : contactList) {
            //  System.out.println(contact);
            // }

             //LandRepository landRepo = new LandRepository();

                    //Land uruguay = new Land("");
                    //landRepo.deleteOneRecord(uruguay);

            // List<Land> landList = landRepo.findAllRecords();
            //for (Land land : landList) {
            // System.out.println(land);
            // }

            //GeslachtRepository geslachtRepo = new GeslachtRepository();
            //List<Geslacht> geslachtList = geslachtRepo.findAllRecords();
            //for (Geslacht geslacht : geslachtList) {
            //   System.out.println(geslacht);
            // }

            //AfdelingRepository afdelingRepo = new AfdelingRepository();

                    // Afdeling products = new Afdeling("Products");
                    // afdelingRepo.insertOneRecord(products);

            // List<Afdeling> afdelingList = afdelingRepo.findAllRecords();
            //for (Afdeling afdeling : afdelingList) {
            //   System.out.println(afdeling);
            //  }


            //PersoonRepository persoonRepo = new PersoonRepository();

                    //Persoon emma = new Persoon("Emma");
                    //persoonRepo.insertOneRecord(emma);

                    //Persoon emma = new Persoon(8);
                    // persoonRepo.deleteOneRecord(emma);

            // List<Persoon> persoonList = persoonRepo.findAllRecords();
            //for (Persoon persoon : persoonList) {
            //    System.out.println(persoon);
            // }

    }

}


