package model;



public class KhachHang {
    private String name;
    private String dateOfbirth;
    private String address;
    private String image;


    public KhachHang() {
    }

    public KhachHang(String name, String dateOfbirth, String address, String image) {
        this.name = name;
        this.dateOfbirth = dateOfbirth;
        this.address = address;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(String dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
