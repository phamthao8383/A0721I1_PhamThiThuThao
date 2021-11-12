package ss17_binary_file_serialization.bai_tap.quanlysanpham;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private int price;
    private String origin;
    private static int nextId = 0;
    private int id;

    public Product(String name, int price, String origin) {
        this.name = name;
        this.price = price;
        this.origin = origin;
        this.id = ++nextId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + " " + price + " " + id;
    }
}
