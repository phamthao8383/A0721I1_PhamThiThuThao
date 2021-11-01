package ss12_java_collecion_framework.baitap.luyen_tap_su_dung_arraylissh_linkedlist;


public  class Product  {
    protected  int id;
    protected String name;
    protected double price;

    public Product(int id,String name, double price) {
        this.id=id;
        this.name = name;
        this.price = price;
    }
    public void setId(int id) {
        this.id = id;
    }
    public  int getId() {
        return id;
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
        return "id=" +id+
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}


