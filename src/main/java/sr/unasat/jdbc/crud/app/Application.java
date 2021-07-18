package sr.unasat.jdbc.crud.app;

import sr.unasat.jdbc.crud.entities.*;
import sr.unasat.jdbc.crud.repositories.*;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        AfdelingRepository afdelingRepo = new AfdelingRepository();

       // Afdeling products = new Afdeling("Products");
       // afdelingRepo.insertOneRecord(products);

        List<Afdeling> afdelingList = afdelingRepo.findAllRecords();
        for (Afdeling afdeling : afdelingList) {
            System.out.println(afdeling);
        }

    }
}






