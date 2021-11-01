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

    public void update(String oldName,String newName) {
        int indexValue = getProductIndexByName(oldName);
        if (indexValue != -1) {
            productList.get(indexValue).setName(newName);
        } else {
            System.out.println("there is no " + oldName);
        }
    }


    public void sort() {
    Collections.sort(productList, new CompareProduct());
    }
    private int getProductIndexByName(String productName) {
        int indexValue = -1;
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getName().equals(productName))
                indexValue = i;
        }
        return indexValue;
    }

}



