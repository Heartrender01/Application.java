package sr.unasat.jdbc.crud.entities;

public class Afdeling {
    private int id;
    private String afdeling;

    public Afdeling(int id, String afdeling){
        this.id = id;
        this.afdeling = afdeling;
    }

    public Afdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    public Afdeling(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
