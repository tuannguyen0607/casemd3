package model;

public class Product {
    private int id_product;
    private String nameproduct;
    private String img;
    private double price;
    private int amountTotal;
    private String detail;

    public Product() {
    }

    public Product(int id_product, String nameproduct, String img, double price, int amountTotal, String detail) {
        this.id_product = id_product;
        this.nameproduct = nameproduct;
        this.img = img;
        this.price = price;
        this.amountTotal = amountTotal;
        this.detail = detail;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(int amountTotal) {
        this.amountTotal = amountTotal;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
