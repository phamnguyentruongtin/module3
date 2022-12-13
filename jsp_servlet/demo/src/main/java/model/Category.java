package model;

public class Category {
   private int idCategory;
   private String nameCategory;

    public Category(int idCategory, String nameCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
    }

    public Category() {
    }

    public Category(int idCategory) {
        this.idCategory = idCategory;
    }



    public int getIdCategory() {
        return idCategory;
    }

    public void setCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

}
