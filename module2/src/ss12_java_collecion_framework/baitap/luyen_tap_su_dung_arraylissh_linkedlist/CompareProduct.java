package ss12_java_collecion_framework.baitap.luyen_tap_su_dung_arraylissh_linkedlist;

import java.util.Comparator;

public class CompareProduct implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if(o1.getName().compareTo(o2.getName())==0){
            return (int)(o1.getPrice() - o2.getPrice());
        }

        return o1.getName().compareTo(o2.getName());
    }
}
