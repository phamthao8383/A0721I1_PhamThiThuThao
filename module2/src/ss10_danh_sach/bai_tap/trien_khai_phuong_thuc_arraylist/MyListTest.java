package ss10_danh_sach.bai_tap.trien_khai_phuong_thuc_arraylist;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.add(2);
        list.add(6);
        list.add(9);
        System.out.println("Danh sach integer da nhap la: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

