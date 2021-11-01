package ss12_java_collecion_framework.baitap.luyen_tap_su_dung_arraylissh_linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Product> productList;

    public ProductManager() {
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void displayProduct() {
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

    public void searchByName(String name) {
        // boolean res= false;
        for (int i = 0; i < productList.size(); i++) {
            if (name.equals(productList.get(i).getName())) {
                System.out.println(productList.get(i).toString());
                break;
            }
            // System.out.println("Không tìm thấy");
        }
    }

    public void update(Product p, String nameEdit, double priceEdit) {
        p.setName(nameEdit);
        p.setPrice(priceEdit);
    }

    public void sort() {
    Collections.sort(productList, new CompareProduct());
    }

}



