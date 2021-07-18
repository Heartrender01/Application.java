package sr.unasat.jdbc.crud.entities;

public class WerkplaatsInformatie {
    private Integer id;
    private Persoon persoon;
    private Afdeling afdeling;



    public WerkplaatsInformatie(Integer id) {
        this.id = id;
        this.persoon = persoon;
        this.afdeling = afdeling;

    }

    public WerkplaatsInformatie(Persoon persoon, Afdeling afdeling) {
        this.persoon = persoon;
        this.afdeling = afdeling;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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


    @Override
    public String toString() {
        return "WerkplaatsInformatie{" +
                "id=" + id +
                ", persoon=" + persoon +
                ", afdeling=" + afdeling +

                '}';
    }
}
