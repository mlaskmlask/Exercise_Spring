package root.model;

public class Product {

    String name;
    int pieces;
    String color;
    String brand;
    Category category;
    int price;

    public Product(String name, int pieces, String color, String brand, Category category, int price) {
        this.name = name;
        this.pieces = pieces;
        this.color = color;
        this.brand = brand;
        this.category = category;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public enum Category {
        RTV,
        AGD,
    }

    @Override
    public String toString() {
        return "Nazwa produktu: " + name +
                ", Ilość: " + pieces +
                ", Kolor: " + color +
                ", Marka: " + brand +
                ", Kategoria: " + category +
                ", Cena: " + price;
    }
}
