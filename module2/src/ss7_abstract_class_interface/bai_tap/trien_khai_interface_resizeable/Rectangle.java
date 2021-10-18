package ss7_abstract_class_interface.bai_tap.trien_khai_interface_resizeable;

import ss6_ke_thua.thuc_hanh.Shape;

public class Rectangle extends Shape implements Resizeable{
        private int width;
        private int length;

    public Rectangle(int width, int height) {
        this.width = width;
        this.length = height;
    }

    public Rectangle(String color, boolean filled, int width, int height) {
        super(color, filled);
        this.width = width;
        this.length = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getArea(){
            return width* length;
        }
    @Override
    public void resize(double percent) {
        System.out.println("A Rectangle with width="
                + getWidth()
                + " and length = "
                + getLength()
                +"Area = "
                +getArea()
                + ", resize "

                + percent
                + " percent, has area "
                + + (getArea() + (getArea() *percent/100))
        );
    }
}
