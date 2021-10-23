package ss10_danh_sach.bai_tap.trien_khai_phuong_thuc_arraylist;

import java.util.Arrays;

public class MyList<T> {
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private T[] elements;

    public MyList() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
        // Tạo mảng mới với độ dài gấp đôi mảng elements cũ
//        T[] newElements = (T[]) new Object[newSize];
        // Copy dữ liệu từ mảng elements sang mảng newElements
//        for (int i = 0; i < elements.length; i++) {
//            newElements[i] = elements[i];
//        }
        // Gán mảng elements trỏ sang mảng mới
//        elements = newElements;
    }

    public void add(T element) {
        if (size == elements.length) {
            ensureCapacity();
        }
        // Thêm phần tử element vào cuối danh sách (mảng)
        elements[size] = element;
        // Tăng độ dài của danh sách lên 1;
        size++;
    }

    public T get(int i) {
        if (i >= 0 && i <= size) {
            return elements[i];
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Size " + (size - 1));
    }

    public int size() {
        return size;
    }
}

