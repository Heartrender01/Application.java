package sr.unasat.jdbc.crud.entities;

public class ContactInformatie {
    private Integer id;
    private String adres;
    private Integer telefoonNummer;
    private Persoon persoon;
    private Land land;
    private Geslacht geslacht;
    private WerkplaatsInformatie werkplaatsInformatie;


    public ContactInformatie(Integer id, String adres, Integer telefoonNummer, Persoon persoon, Land land, Geslacht geslacht, WerkplaatsInformatie werkplaatsInformatie ) {
        this.id = id;
        this.adres = adres;
        this.telefoonNummer = telefoonNummer;
        this.persoon = persoon;
        this.land = land;
        this.geslacht = geslacht;
        this.werkplaatsInformatie = werkplaatsInformatie;

    }

    public ContactInformatie(String adres, Integer telefoonNummer, Persoon persoon, Land land, Geslacht geslacht, WerkplaatsInformatie werkplaatsInformatie) {
        this.adres = adres;
        this.telefoonNummer = telefoonNummer;
        this.persoon = persoon;
        this.land = land;
        this.geslacht = geslacht;
        this.werkplaatsInformatie = werkplaatsInformatie;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Integer getTelefoonNummer() {
        return telefoonNummer;
    }

    public void setTelefoonNummer(Integer telefoonNummer) {
        this.telefoonNummer = telefoonNummer;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(Geslacht geslacht) {
        this.geslacht = geslacht;
    }

    public void setWerkplaatsInformatie(WerkplaatsInformatie werkplaatsInformatie) {
        this.werkplaatsInformatie = werkplaatsInformatie;
    }

    public WerkplaatsInformatie getWerkplaatsInformatie() {
        return werkplaatsInformatie;
    }

    @Override
    public String toString() {
        return "ContactInformatie{" +
                "id=" + id +
                ", adres='" + adres + '\'' +
                ", telefoonNummer=" + telefoonNummer +
                ", persoon=" + persoon +
                ", land=" + land +
                ", geslacht=" + geslacht +
                ", werkplaats=" + werkplaatsInformatie +

                '}';
    }
}