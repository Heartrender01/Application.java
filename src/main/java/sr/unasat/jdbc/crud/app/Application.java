package sr.unasat.jdbc.crud.app;

import sr.unasat.jdbc.crud.entities.*;
import sr.unasat.jdbc.crud.repositories.*;

import java.util.List;

public class Application {

    public static void main(String[] args) {

            //ContactInformatieRepository ciRepo = new ContactInformatieRepository();
            // List<ContactInformatie> contactList = ciRepo.findAllRecords();
            // for (ContactInformatie contact : contactList) {
            //     System.out.println(contact);
            // }


            // LandRepository landRepo = new LandRepository();
            // List<Land> landList = landRepo.findAllRecords();
            // for (Land land : landList) {
            //    System.out.println(land);

            // GeslachtRepository geslachtRepo = new GeslachtRepository();
            // List<Geslacht> geslachtList = geslachtRepo.findAllRecords();
            //for (Geslacht geslacht : geslachtList) {
            //    System.out.println(geslacht);
            // }

            // AfdelingRepository afdelingRepo = new AfdelingRepository();

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
            //   for (Persoon persoon : persoonList) {
            //     System.out.println(persoon);
            // }

            WerkplaatsInformatieRepository wi = new WerkplaatsInformatieRepository();

                    // WerkplaatsInformatie delete = new WerkplaatsInformatie(2);
                    //  wi.deleteAllRecords(delete);

            List<WerkplaatsInformatie> infoList = wi.findAllRecords();
             for (WerkplaatsInformatie werkplaatsInformatie : infoList) {
                 System.out.println(infoList);
             }

    }

}


