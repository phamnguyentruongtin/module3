package Model;

public class KieuThue {
    private int id_kieuThue;
    private String kieuThue;

    public KieuThue(int id_kieuThue, String kieuThue) {
        this.id_kieuThue = id_kieuThue;
        this.kieuThue = kieuThue;
    }

    public KieuThue(int id_kieuThue) {
        this.id_kieuThue = id_kieuThue;
    }

    public KieuThue() {
    }

    public int getId_kieuThue() {
        return id_kieuThue;
    }

    public void setId_kieuThue(int id_kieuThue) {
        this.id_kieuThue = id_kieuThue;
    }

    public String getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(String kieuThue) {
        this.kieuThue = kieuThue;
    }
}
