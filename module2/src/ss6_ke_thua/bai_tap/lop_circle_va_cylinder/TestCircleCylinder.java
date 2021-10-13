package ss6_ke_thua.bai_tap.lop_circle_va_cylinder;

import ss6_ke_thua.bai_tap.lop_circle_va_cylinder.Cylinder;

public class TestCircleCylinder {
    public static void main(String[] args) {
        Cylinder cylinder=new Cylinder(2.0,"red",4.0);
        System.out.println(cylinder.getVolume());
        System.out.println(cylinder.getHeight());
        System.out.println(cylinder.toString());

    }

}
