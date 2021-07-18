package sr.unasat.jdbc.crud.entities;

public class Afdeling {
    private Integer id;
    private String afdeling;

    public Afdeling(Integer id) {
        this.id = id;
    }

    public Afdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    @Override
    public String toString() {
        return "Afdeling{" +
                "id=" + id +
                ", afdeling='" + afdeling + '\'' +
                '}';
    }


}
