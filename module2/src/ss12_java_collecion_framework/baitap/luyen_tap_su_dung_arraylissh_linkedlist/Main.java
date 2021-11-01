package ss12_java_collecion_framework.baitap.luyen_tap_su_dung_arraylissh_linkedlist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Product[] products = new p[100];
        ProductManager productManager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        String line;
        do {
            System.out.println("Quản lý sản phẩm");
            System.out.println(" 1: Thêm sản phẩm ");
            System.out.println(" 2: Sửa sản phẩm ");
            System.out.println(" 3: Hiển thị danh sách sản phẩm ");
            System.out.println(" 4: Tìm kiếm sản phầm ");
            System.out.println(" 5: Sắp xếp sản phẩm");
            System.out.println(" 6: Thoát chương trình ");
            line = scanner.nextLine();
            switch (line) {
                case "1": {
                    System.out.println(" nhập ten sp:");
                    String name = scanner.nextLine();
                    System.out.println("nhap giá sp :");
                    double price = Double.parseDouble(scanner.nextLine());
                    Product product = new Product(name, price);
                    productManager.addProduct(product);
                    break;
                }
                case "2": {

                }
                case "3": {
                    productManager.displayProduct();
                    break;
                }
                case "4": {
                    System.out.println("Nhâp name cần tìm ");
                    String newName = scanner.nextLine();
                    productManager.searchByName(newName);
                    break;
                }
                case "5": {
                    productManager.sort();
                    productManager.displayProduct();
                    break;
                }
                case "6": {
                    return;
                }
            }
        }
        while (true);
    }
}