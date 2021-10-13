package ss6_ke_thua.thuc_hanh;

public class Shape {
    private String color="green";
    private boolean filled=true;

    public Shape() {

    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return " A Shape with color of " + getColor()+" and "+(isFilled()?" filled ":" not filled ");
    }

    public static class Circle extends Shape{
        private double radius=1.0;

        public Circle(){
        }
        public Circle(double radius){
            this.radius=radius;
        }

        public Circle (double radius,String color,boolean filled){
            super(color, filled);
            this.radius=radius;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }
        public double getArea(){
            return Math.pow(radius,2)*Math.PI;
        }
        public double getPerimeter(){
            return 2*radius*Math.PI;
        }

        @Override
        public String toString() {
            return "A Circle with radius="
                    + getRadius()
                    + ", which is a subclass of "
                    + super.toString();
        }
    }

}
