package sr.unasat.jdbc.crud.entities;

public class WerkplaatsInformatie {
    private int id;
    private Persoon persoon;
    private Afdeling afdeling;
    private int werkplaatsId;
    private int persoonId;
    private int afdelingId;


    public WerkplaatsInformatie(Integer werkplaatsId, Persoon persoon, Afdeling afdeling) {
        this.werkplaatsId = werkplaatsId;
        this.persoon = persoon;
        this.afdeling = afdeling;
    }

    public WerkplaatsInformatie(int id, int persoonId, int afdelingId) {
        this.id = id;
        this.persoonId = persoonId;
        this.afdelingId = afdelingId;
    }

    public void WerkplaatsInformatie2 (int persoonId, int afdelingId, int werkplaatsId) {
        this.persoonId = persoonId;
        this.afdelingId =  afdelingId;
        this.werkplaatsId = werkplaatsId;
    }

    public void werkplaatsInformatie (Integer werkplaatsId, int persoonId, int afdelingId) {
        this.werkplaatsId = werkplaatsId;
        this.persoonId = persoonId;
        this.afdelingId = afdelingId;
    }

    public WerkplaatsInformatie(int werkplaatsid) {
        this.id = werkplaatsid;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

    public Afdeling getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(Afdeling afdeling) {
        this.afdeling = afdeling;
    }

    public int getWerkplaatsId() {
        return werkplaatsId;
    }

    public void setWerkplaatsId(int werkplaatsId) {
        this.werkplaatsId = werkplaatsId;
    }

    public int getAfdelingId() {
        return afdelingId;
    }

    public void setAfdelingId(int afdelingId) {
        this.afdelingId = afdelingId;
    }

    public int getPersoonId() {
        return persoonId;
    }

    public void setPersoonId(int persoonId) {
        this.persoonId = persoonId;
    }

    @Override
    public String toString() {
        return "WerkplaatsInformatie{" +
                "id=" + werkplaatsId +
                ", persoon=" + persoon +
                ", afdeling=" + afdeling +
                '}';
    }
}