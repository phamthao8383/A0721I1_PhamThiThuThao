package ss7_abstract_class_interface.bai_tap.trien_khai_interface_resizeable;

public class Circle implements Resizeable{
   private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    public double getArea(){
        return radius*radius*3.14;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void resize(double percent) {
        System.out.println("A Circle with radius="
                + getRadius()
                +"Area = "
                +getArea()
                + ", resize "
                + percent
                + " percent, has area "
                + (getArea() + (getArea() *percent/100))
        );
    }
}
