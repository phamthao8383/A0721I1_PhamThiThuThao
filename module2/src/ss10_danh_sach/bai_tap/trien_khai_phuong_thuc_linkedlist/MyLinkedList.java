package ss10_danh_sach.bai_tap.trien_khai_phuong_thuc_linkedlist;

public class MyLinkedList <T>{
    private Node head;
    private int numNodes = 0;

    public MyLinkedList() {
    }

    public MyLinkedList(T element) {
        head = new Node(element);
    }

    public void add(int index, T element) {
        Node temp = head;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        Node after = temp.next;
        temp.next = new Node(element);
        temp.next.next = after;
        numNodes++;
    }

    public void addFirst(T element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }

    public T get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (T) temp.getData();
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.next;
        }
    }

    public int size() {
        return numNodes;
    }

    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }
}
