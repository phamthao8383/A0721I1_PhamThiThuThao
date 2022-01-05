package dao;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private static List<Product> productList=new ArrayList<>();
    static {
        productList.add(new Product("Mai Van Toan","1983-08-20","Ha noi"));
        productList.add(new Product("Nguyen Van Nam","1983-08-21","Bac Giang"));
        productList.add(new Product("Nguyen Thai Hoa","1983-08-22","Nam Dinh"));
        productList.add(new Product("Tran Dang Khoa","1983-08-17","Hà Tay"));
        productList.add(new Product("Nguyen Dinh Thi","1983-08-29","Ha Noi"));

    }
    public static List<Product> getListProduct(){
        return productList;
    }

}
