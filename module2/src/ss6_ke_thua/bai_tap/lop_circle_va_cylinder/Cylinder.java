package ss6_ke_thua.bai_tap.lop_circle_va_cylinder;

public class Cylinder extends Circle {
    private double height;
    public Cylinder(double radius, String color) {
        super(radius, color);
    }
    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }
    public double getVolume(){
        return getArea()*height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                '}'+super.toString();
    }
}
