package ss12_java_collecion_framework.baitap.luyen_tap_su_dung_arraylissh_linkedlist;

public class Product {
    private static int id;
    // protected int id;
    protected String name;
    protected double price;

    public Product(String name, double price) {
        Product.id++;
        this.name = name;
        this.price = price;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Product.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", price=" + price;
    }
}
