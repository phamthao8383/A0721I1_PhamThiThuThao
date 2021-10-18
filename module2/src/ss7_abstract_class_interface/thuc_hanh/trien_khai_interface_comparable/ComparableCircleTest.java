package ss7_abstract_class_interface.thuc_hanh.trien_khai_interface_comparable;

import java.util.Arrays;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(3.5, "indigo");
        circles[1] = new ComparableCircle(7.5, "blue");

        circles[2] = new ComparableCircle(5.5, "red");

        System.out.println("Pre-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }

        Arrays.sort(circles);

        System.out.println("After-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }

    }
}
