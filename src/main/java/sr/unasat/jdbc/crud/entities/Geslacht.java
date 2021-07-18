package sr.unasat.jdbc.crud.entities;

public class Geslacht {
    private Integer id;
    private String geslacht;

    public Geslacht(Integer id, String geslacht) {
        this.id = id;
        this.geslacht = geslacht;
    }

    public Geslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGeslacht() {
        return geslacht;
    }
    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    @Override
    public String toString() {
        return "Geslacht{" +
                "id=" + id +
                ", geslacht='" + geslacht + '\'' +
                '}';
    }

}
