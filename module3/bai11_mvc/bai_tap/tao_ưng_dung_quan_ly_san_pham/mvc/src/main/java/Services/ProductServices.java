package Services;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServices {
    private static Map<Integer, Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product(1, "iPhone 11", 799.0, 12, "Red", "Phone"));
        productMap.put(2, new Product(2, "iPhone 11 Pro", 799.0, 12, "Red", "Phone"));
        productMap.put(3, new Product(3, "iPhone X", 799.0, 12, "Red", "Phone"));
        productMap.put(4, new Product(4, "Sam sung", 799.0, 12, "Red", "samsung"));
    }
    public static List<Product> getListProduct(){
        return new ArrayList<>(productMap.values());
    }

    public static void save(Product product) {
        productMap.put(product.getId(),product);
    }

    public static Product findById(Integer id) {
        return productMap.get(id);
    }

    public static Product deleteId(Integer id) {
        return productMap.remove(id) ;
    }
}