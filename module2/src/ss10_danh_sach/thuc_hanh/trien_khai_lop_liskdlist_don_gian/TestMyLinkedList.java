package ss10_danh_sach.thuc_hanh.trien_khai_lop_liskdlist_don_gian;

public class TestMyLinkedList {
    public static void main(String[] args) {
            System.out.println("/=/=/=/= TESTING /=/=/=/=");
            MyLinkedList ll = new MyLinkedList(10);
            ll.addFirst(11);
            ll.addFirst(12);
            ll.addFirst(13);

            ll.add(4,9);
            ll.add(4,9);
            ll.printList();
        }
    }

