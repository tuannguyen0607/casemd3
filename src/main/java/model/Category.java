package model;

public class Category {
    private int id_Category;
    private String style;
    private double categoryAmount;

    public Category() {
    }

    public Category(int id_Category, String style, double categoryAmount) {
        this.id_Category = id_Category;
        this.style = style;
        this.categoryAmount = categoryAmount;
    }

    public int getId_Category() {
        return id_Category;
    }

    public void setId_Category(int id_Category) {
        this.id_Category = id_Category;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public double getCategoryAmount() {
        return categoryAmount;
    }

    public void setCategoryAmount(double categoryAmount) {
        this.categoryAmount = categoryAmount;
    }
}
