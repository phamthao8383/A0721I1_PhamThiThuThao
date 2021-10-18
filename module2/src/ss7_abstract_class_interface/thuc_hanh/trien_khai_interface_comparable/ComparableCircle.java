package ss7_abstract_class_interface.thuc_hanh.trien_khai_interface_comparable;

import ss6_ke_thua.bai_tap.lop_circle_va_cylinder.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle>{

    public ComparableCircle(double radius, String color) {
        super(radius, color);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()) return 1;
        else if (getRadius() < o.getRadius()) return -1;
        else return 1;
    }
}
