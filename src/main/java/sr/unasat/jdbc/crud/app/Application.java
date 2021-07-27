package sr.unasat.jdbc.crud.app;

import sr.unasat.jdbc.crud.entities.*;
import sr.unasat.jdbc.crud.repositories.*;

import java.util.List;

public class Application {

    public static void main(String[] args) {


            //*** findAllRecords T3
            WerkplaatsInformatieRepository wiRepo = new WerkplaatsInformatieRepository();

                //** deleteOneRecord T3 WORKS
                //WerkplaatsInformatie result = new WerkplaatsInformatie(8);
                //wiRepo.deleteOneRecord(result);

                //** deleteAllRecords T3 WORKS
                //WerkplaatsInformatie delete = new WerkplaatsInformatie(1);
                //wiRepo.deleteAllRecords(delete);

                //** insertRecords T3
                //1. Works
                //WerkplaatsInformatie insert = new WerkplaatsInformatie (8,8,2);
                //wiRepo.insertOneRecord(insert);

                //** update persoonID + afdelingID voor T3_ID
                //WerkplaatsInformatie update = new WerkplaatsInformatie(5,2,3);
                //wiRepo.updateOneRecord(update);

                //**select a specific record T3 with T3_ID WORKS
                //WerkplaatsInformatie onerecord = wiRepo.findOneRecord(6);
                //System.out.println( "Single record:" + onerecord);

            List<WerkplaatsInformatie> infoList = wiRepo.findAllRecords();
            for (WerkplaatsInformatie info : infoList) {
           System.out.println(info);
            }

            //ContactInformatieRepository ciRepo = new ContactInformatieRepository();

            //List<ContactInformatie> contactList = ciRepo.findAllRecords();
            //for (ContactInformatie contact : contactList) {
            //  System.out.println(contact);
            // }

             //LandRepository landRepo = new LandRepository();

                    //Land uruguay = new Land("Italy");
                    //landRepo.insertOneRecord(uruguay);

             //List<Land> landList = landRepo.findAllRecords();
            //for (Land land : landList) {
             //System.out.println(land);
             //}

            //GeslachtRepository geslachtRepo = new GeslachtRepository();
            //List<Geslacht> geslachtList = geslachtRepo.findAllRecords();
            //for (Geslacht geslacht : geslachtList) {
            //   System.out.println(geslacht);
            // }

            //AfdelingRepository afdelingRepo = new AfdelingRepository();

                    // Afdeling products = new Afdeling("QAT");
                     //afdelingRepo.insertOneRecord(products);

             //List<Afdeling> afdelingList = afdelingRepo.findAllRecords();
            //for (Afdeling afdeling : afdelingList) {
              // System.out.println(afdeling);
             //}


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


