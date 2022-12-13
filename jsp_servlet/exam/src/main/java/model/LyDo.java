package model;

public class LyDo {
    private int idLyDo;
    private String tenlyDo;

    public LyDo(int idLyDo, String tenlyDo) {
        this.idLyDo = idLyDo;
        this.tenlyDo = tenlyDo;
    }

    public LyDo() {
    }

    public LyDo(int idLyDo) {
        this.idLyDo = idLyDo;
    }

    public int getIdLyDo() {
        return idLyDo;
    }

    public void setIdLyDo(int idLyDo) {
        this.idLyDo = idLyDo;
    }

    public String getLyDo() {
        return tenlyDo;
    }

    public void setLyDo(String lyDo) {
        this.tenlyDo = lyDo;
    }
}
