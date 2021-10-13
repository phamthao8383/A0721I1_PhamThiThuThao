package ss5_access_modifier_static_method_property.bai_tap;

public class Circle {
    private double radius =1.0;
    private String color ="red";
    public Circle(){
    };
    public Circle(double radius){
        this.radius=radius;
    }

    public double getRadius() {
        return radius;
    }
    public double getArea(){
        return Math.pow(radius,2)*Math.PI;
    }

    public static void main(String[] args) {
       Circle c=new Circle(2);
      System.out.println( c.getRadius());
      System.out.println(c.getArea());

    }
}
