package ss6_ke_thua.thuc_hanh;

import ss5_access_modifier_static_method_property.bai_tap.Circle;

public class TestShape {
    public static void main(String[] args) {
        Shape shape=new Shape("red",true);
        System.out.println(shape.toString());
        Shape.Circle circle=new Shape.Circle(3.5);
        System.out.println(circle);

        Shape.Circle circle1=new Shape.Circle(3.5,"blue",false);
        System.out.println(circle1.getArea());

    }

}
